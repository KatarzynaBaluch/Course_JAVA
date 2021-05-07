package pl.javaskills.creditapp;

import pl.javaskills.creditapp.client.ConsoleReader;
import pl.javaskills.creditapp.core.CreditApplicationDecision;
import pl.javaskills.creditapp.core.CreditApplicationService;
import pl.javaskills.creditapp.core.PersonScoringCalculator;
import pl.javaskills.creditapp.core.model.CreditRatingCalculator;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;

public class Main {
    public static void main (String[] args){
        LoanApplication loanApplication=new ConsoleReader().readInputParameters();
        CreditApplicationService service=new CreditApplicationService(new PersonScoringCalculator(new EducationCalculator(), new IncomeCalculator(), new MaritalStatusCalculator()), new CreditRatingCalculator());
        CreditApplicationDecision decision=service.getDecision(loanApplication);
        System.out.println(decision.getDecisionString());
    }
}
