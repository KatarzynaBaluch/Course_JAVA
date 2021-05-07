package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.LoanType;
import pl.javaskills.creditapp.core.model.Person;

public class CreditApplicationService {
    public String getDecision(LoanApplication loanApplication)
    {

        double creditRating=loanApplication.getPerson().getIncomePerFamilyMember()*12*loanApplication.getPurposeOfLoan().getPeriod();
        switch (loanApplication.getPurposeOfLoan().getLoanType())
        {
            case PERSONAL_LOAN:
                creditRating*=Constants.PERSONAL_LOAN_LOAN_RATE;
                break;
            case MORTGAGE:
                creditRating*=Constants.PERSONAL_LOAN_LOAN_RATE;
                break;
        }

        int score=new PersonScoringCalculator().calculate(loanApplication.getPerson());
        if (score<300)
            return "Sorry "+ loanApplication.getPerson().getPersonalData().getName()+" "+loanApplication.getPerson().getPersonalData().getLastName()+" decision is negative";
        else if (score<=400)
            return "Sorry, "+ loanApplication.getPerson().getPersonalData().getName()+" "+loanApplication.getPerson().getPersonalData().getLastName()+", bank requires additional documents. Our Consultant will contact you.";
        else if (creditRating>loanApplication.getPurposeOfLoan().getAmount())
            return "Congratulation "+loanApplication.getPerson().getPersonalData().getName()+" "+loanApplication.getPerson().getPersonalData().getLastName()+" decisions is positive";
        else
            return "Sorry, "+ loanApplication.getPerson().getPersonalData().getName()+" "+loanApplication.getPerson().getPersonalData().getLastName()+", decision is negative. Bank can borrow only "+creditRating;
    }
}
