package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.CreditRatingCalculator;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CreditApplicationService {
    private final PersonScoringCalculator personScoringCalculator;
    private final CreditRatingCalculator creditRatingCalculator;

    public CreditApplicationService(PersonScoringCalculator personScoringCalculator, CreditRatingCalculator creditRatingCalculator) {
        this.personScoringCalculator = personScoringCalculator;
        this.creditRatingCalculator = creditRatingCalculator;
    }

    public CreditApplicationDecision getDecision(LoanApplication loanApplication) {

        Person person = loanApplication.getPerson();
        int score = personScoringCalculator.calculate(person);

        double creditRating = creditRatingCalculator.calculate(loanApplication);

        if (score < 300) {
            return new CreditApplicationDecision(DecisionType.NEGATIVE_RATING, person.getPersonalData(), null);
        } else if (score <= 400) {
            return new CreditApplicationDecision(DecisionType.CONTACT_REQUIRED, person.getPersonalData(), null);
        } else if (creditRating >= loanApplication.getPurposeOfLoan().getAmount()) {
            return new CreditApplicationDecision(DecisionType.POSITIVE, person.getPersonalData(), null);
        } else {
            return new CreditApplicationDecision(DecisionType.NEGATIVE_SCORING, person.getPersonalData(), creditRating);
        }
    }


}
