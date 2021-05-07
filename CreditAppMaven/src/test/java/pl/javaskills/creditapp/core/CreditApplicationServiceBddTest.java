package pl.javaskills.creditapp.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.javaskills.creditapp.core.bik.BikApi;
import pl.javaskills.creditapp.core.bik.ScoringRequest;
import pl.javaskills.creditapp.core.bik.ScoringResponse;
import pl.javaskills.creditapp.core.exception.RequirementNotMetCause;
import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.core.validation.*;
import pl.javaskills.creditapp.core.validation.reflection.*;
import pl.javaskills.creditapp.util.AgeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class CreditApplicationServiceBddTest {

    private EducationCalculator educationCalculator = new EducationCalculator();
    private MaritalStatusCalculator maritalStatusCalculator = new MaritalStatusCalculator();
    private IncomeCalculator incomeCalculator = new IncomeCalculator();
    private GuarantorsCalculator guarantorsCalculator = new GuarantorsCalculator();

    private BikApi bikApimock= Mockito.mock(BikApi.class);
    private BikScoringCalculator bikScoringCalculator=new BikScoringCalculator(bikApimock);


    private List<FieldAnnotationProcessor> fieldProcessors=List.of(new NotNullAnnotationProcessor(), new RegexAnnotationProcessor());
    private List<ClassAnnotationProcessor> classProcessors=List.of(new ExactlyOneNotNullAnnotationProcessor());
    private ObjectValidator objectValidator=new ObjectValidator(fieldProcessors, classProcessors);
    private CreditApplicationValidator creditApplicationValidator=new CreditApplicationValidator(objectValidator);


    //Na naturalPersonScoringCalculator=new NaturalPersonScoringCalculator(new EducationCalculator(), new IncomeCalculator(), new MaritalStatusCalculator());
    private SelfEmployedScoringCalculator selfEmployedScoringCalculator = new SelfEmployedScoringCalculator();
    private PersonScoringCalculatorFactory personScoringCalculatorFactory = new PersonScoringCalculatorFactory(selfEmployedScoringCalculator, educationCalculator, incomeCalculator, maritalStatusCalculator, guarantorsCalculator,bikScoringCalculator);
    private CompoundPostValidator compoundPostValidator = new CompoundPostValidator(new PurposeOfLoanPostValidator(), new ExpensesPostValidator());

    private CreditApplicationService cut = new CreditApplicationService(personScoringCalculatorFactory, new CreditRatingCalculator(), creditApplicationValidator, compoundPostValidator);

    @BeforeEach
    public void init()
    {
        ScoringResponse response=new ScoringResponse();
        response.setScoring(0);
        BDDMockito.given(bikApimock.getScoring(any(ScoringRequest.class))).willReturn(response);
    }

    @Test
    @DisplayName(" NEGATIVE_REQUIREMENTS_NOT_MET")
    void Test1() {
        //given
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));


        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withPesel("12341234123")
                .withFamilyMembers(familyMembers)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("456456456")
                        .withHomeAddress(new Address("test", "test", "test", "test", "test"))
                        .withCorespondenceAddress(new Address("test", "test", "test", "test", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.00)))
                .built();


        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(LoanType.MORTGAGE, 50000.0, 30);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        System.out.println("get income per family mem: " + person.getIncomePerFamilyMember());
        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertEquals(600, decision.getScoring());
        assertEquals(360000, decision.getCreditRating());
    }

    @Test
    @DisplayName(" should return desision is negative when years since founded =1")
    void Test2() {
        //given
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));

       SelfEmployed person = SelfEmployed.Builder
                .create()
                .withNip("1234124")
                .withFamilyMembers(familyMembers)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("456456456")
                        .withHomeAddress(new Address("test", "test", "test", "test", "test"))
                        .withCorespondenceAddress(new Address("test", "test", "test", "test", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 7000.00)))
                .built();

        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(LoanType.MORTGAGE, 500000.0, 30);


        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        System.out.println("get income per family mem: " + person.getIncomePerFamilyMember());
        //then
        assertEquals(DecisionType.NEGATIVE_RATING, decision.getDecisionType());
        assertEquals(200, decision.getScoring());

    }

    @Test
    @DisplayName(" should return desision is contact_decision when years since founded= 3")
    void Test3() {
        //given
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));
        SelfEmployed person = SelfEmployed.Builder
                .create()
                .withNip("3245234")
                .withFamilyMembers(familyMembers)
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("456456456")
                        .withHomeAddress(new Address("test", "test", "test", "test", "test"))
                        .withCorespondenceAddress(new Address("test", "test", "test", "test", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 7000.00)))
                .withYearsSinceFounded(3)
                .built();


        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(LoanType.MORTGAGE, 500000.0, 30);


        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        System.out.println("get income per family mem: " + person.getIncomePerFamilyMember());
        //then
        assertEquals(DecisionType.CONTACT_REQUIRED, decision.getDecisionType());
        assertEquals(400, decision.getScoring());

    }

    @Test
    @DisplayName("Decision is negative requirements not met, cause too high personal expenses.")
    void Test4() {
        //given
        Set<Expense> expenses = Set.of(new Expense("1", ExpenseType.PERSONAL, 500),
                new Expense("2", ExpenseType.PERSONAL, 750));
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));

        final FinanceData financeData = new FinanceData(expenses, new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 2000.00));
        SelfEmployed person = SelfEmployed.Builder
                .create()
                .withNip("3245234")
                .withPersonalData(PersonalData.Builder.create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMaritalStatus(MaritalStatus.MARRIED)
                        .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("456456456")
                        .withHomeAddress(new Address("test", "test", "test", "test", "test"))
                        .withCorespondenceAddress(new Address("test", "test", "test", "test", "test"))
                        .build())
                .withFinanceData(financeData)
                .withYearsSinceFounded(3)
                .built();


        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(LoanType.MORTGAGE, 500000.0, 30);


        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan);

        //when
        CreditApplicationDecision decision = cut.getDecision(loanApplication);
        System.out.println("get income per family mem: " + person.getIncomePerFamilyMember());
        //then
        assertEquals(DecisionType.NEGATIVE_REQUIREMENTS_NOT_MET, decision.getDecisionType());
        assertTrue(decision.getRequirementNotMetCause().isPresent());
        assertEquals(RequirementNotMetCause.TOO_HIGH_PERSONAL_EXPENSES, decision.getRequirementNotMetCause().get());

    }

}