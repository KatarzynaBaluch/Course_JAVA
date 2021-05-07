package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

import static pl.javaskills.creditapp.core.Constants.*;

public class CreditRatingCalculator {
    private static final Logger log= LoggerFactory.getLogger(CreditRatingCalculator.class);

    public double calculate(LoanApplication loanApplication) {
        Person person=loanApplication.getPerson();
        double creditRating = person.getIncomePerFamilyMember() * 12 * loanApplication.getPurposeOfLoan().getPeriod();
        System.out.println("creditRating " +loanApplication.getPurposeOfLoan().getPeriod());

        switch (loanApplication.getPurposeOfLoan().getLoanType()) {
            case PERSONAL_LOAN:
                creditRating *= PERSONAL_LOAN_LOAN_RATE;
                break;
            case MORTGAGE:
                creditRating *= MORTGAGE_LOAN_RATE;
                break;
        }

        log.info("Calculated rating: {} pln",creditRating);

        return creditRating;
    }
}
