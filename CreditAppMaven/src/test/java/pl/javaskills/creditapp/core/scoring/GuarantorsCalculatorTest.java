package pl.javaskills.creditapp.core.scoring;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.util.AgeUtils;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GuarantorsCalculatorTest {

    private GuarantorsCalculator cut=new GuarantorsCalculator();

    @Test
    public void test1()
    {
        //given
        NaturalPerson person = NaturalPerson.Builder.create()
                .withFamilyMembers(new ArrayList<>())
                .withPersonalData(
                        PersonalData.Builder.create()
                                .withLastName("Test")
                                .withName("Test")
                                .withMothersMaidenName("Test")
                                .withEducation(Education.MIDDLE)
                                .withMaritalStatus(MaritalStatus.MARRIED)
                                .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.0)))
                .built();

        Set<Guarantor> guarantors=Set.of(
                new Guarantor("12312312312", AgeUtils.generateBirthDate(45)),
                new Guarantor("98798798798", AgeUtils.generateBirthDate(25)));



        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(LoanType.MORTGAGE, 50000.0, 30);
        LoanApplication loanApplication = LoanApplicationTestFactory.create(person, purposeOfLoan, guarantors);

        //when
        int scoring=cut.calculate(loanApplication);

        //then
        assertEquals(75, scoring);

    }

}