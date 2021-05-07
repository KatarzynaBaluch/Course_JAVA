package pl.javaskills.creditapp.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.LoanApplicationTestFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.PersonTestFactory;
import pl.javaskills.creditapp.core.scoring.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

class CompaundScoringCalculatorTest {


    private ScoringCalculator scoringCalculator1Mock = Mockito.mock(ScoringCalculator.class);
    private ScoringCalculator scoringCalculator2Mock =Mockito.mock(ScoringCalculator.class);
    private ScoringCalculator scoringCalculator3Mock =Mockito.mock(ScoringCalculator.class);

    private CompaundScoringCalculator cut=new CompaundScoringCalculator(scoringCalculator1Mock, scoringCalculator2Mock, scoringCalculator3Mock);

    @Test
    @DisplayName("Sum scorings")
    public void Test()
    {
        //given

        LoanApplication loanApplicationPerson = LoanApplicationTestFactory.create();
        BDDMockito.given(scoringCalculator1Mock.calculate(eq(loanApplicationPerson))).willReturn(100);
        BDDMockito.given(scoringCalculator2Mock.calculate(eq(loanApplicationPerson))).willReturn(200);
        BDDMockito.given(scoringCalculator3Mock.calculate(eq(loanApplicationPerson))).willReturn(50);

        //then
        int scoring=cut.calculate(loanApplicationPerson);


        //when
        assertEquals(350,scoring);

    }
}