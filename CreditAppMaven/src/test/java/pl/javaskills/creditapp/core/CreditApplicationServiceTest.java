package pl.javaskills.creditapp.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaskills.creditapp.core.exception.RequirementNotMetException;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.LoanApplicationTestFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.ScoringCalculator;
import pl.javaskills.creditapp.core.validation.CompoundPostValidator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class CreditApplicationServiceTest {


    @InjectMocks
    private CreditApplicationService cut;

    @Mock
    private ScoringCalculator scoringCalculatorMock;

    @Mock
    private  PersonScoringCalculatorFactory personScoringCalculatorFactoryMock;

    @Mock
    private CreditApplicationValidator creditApplicationValidatorMoc;

    @Mock
    private CreditRatingCalculator creditRatingCalculator;

    @Mock
    private CompoundPostValidator compoundPostValidator;

    @BeforeEach
    public void init() throws ValidationException, RequirementNotMetException {
        BDDMockito.given(personScoringCalculatorFactoryMock.getCalculator(any(Person.class)))
                .willReturn(scoringCalculatorMock);

        BDDMockito.doNothing()
                .when(creditApplicationValidatorMoc)
                .validate(any(LoanApplication.class));

        BDDMockito.doNothing()
                .when(compoundPostValidator)
                .validate(any(LoanApplication.class), anyInt(),anyDouble());

    }


    @Test
    @DisplayName("NEGATIVE_RATING")
    void Test1()
    {
        //given
        LoanApplication loanApplication= LoanApplicationTestFactory.create();
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(100);
        //when
        CreditApplicationDecision decision=cut.getDecision(loanApplication);
        //then
        assertEquals(DecisionType.NEGATIVE_RATING,decision.getDecisionType());
    }

    @Test
    @DisplayName("CONTACT_REQUIRED")
    void Test2()
    {
        //given
        LoanApplication loanApplication=LoanApplicationTestFactory.create();
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(350);
        //then
        CreditApplicationDecision decision=cut.getDecision(loanApplication);
        //when
        assertEquals(DecisionType.CONTACT_REQUIRED,decision.getDecisionType());
    }

    @Test
    @DisplayName("NEGATIVE_SCORING")
    void Test3()
    {
        //given
        LoanApplication loanApplication=LoanApplicationTestFactory.create(300000.0);
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(450);
        BDDMockito.given(creditRatingCalculator.calculate(loanApplication)).willReturn(100000.0);
        //then
        CreditApplicationDecision decision= cut.getDecision(loanApplication);
        //when
        assertEquals(DecisionType.NEGATIVE_SCORING,decision.getDecisionType());
    }

    @Test
    @DisplayName("POSITIVE")
    void Test4()
    {
        //given
        LoanApplication loanApplication=LoanApplicationTestFactory.create(100000.0);
        BDDMockito.given(scoringCalculatorMock.calculate(eq(loanApplication))).willReturn(450);
        BDDMockito.given(creditRatingCalculator.calculate(loanApplication)).willReturn(110000.0);
        //then
        CreditApplicationDecision decision= cut.getDecision(loanApplication);
        //when
        assertEquals(DecisionType.POSITIVE,decision.getDecisionType());
    }
}