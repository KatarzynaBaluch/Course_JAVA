package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.exception.*;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.validation.CompoundPostValidator;
import pl.javaskills.creditapp.core.validation.CreditApplicationValidator;
import pl.javaskills.creditapp.di.Inject;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;

import static pl.javaskills.creditapp.core.DecisionType.*;

public class CreditApplicationService {

    private static final Logger log = LoggerFactory.getLogger(CreditApplicationService.class);
    @Inject
    private PersonScoringCalculatorFactory personScoringCalculatorFactory;
    @Inject
    private CreditRatingCalculator creditRatingCalculator;
    @Inject
    private CreditApplicationValidator creditApplicationValidator;
    @Inject
    private CompoundPostValidator compoundPostValidator;

    public CreditApplicationService() {
    }

    public CreditApplicationService(PersonScoringCalculatorFactory personScoringCalculatorFactory, CreditRatingCalculator creditRatingCalculator, CreditApplicationValidator creditApplicationValidator, CompoundPostValidator compoundPostValidator) {
        this.personScoringCalculatorFactory = personScoringCalculatorFactory;
        this.creditRatingCalculator = creditRatingCalculator;
        this.creditApplicationValidator = creditApplicationValidator;
        this.compoundPostValidator = compoundPostValidator;
    }

    public CreditApplicationDecision getDecision(LoanApplication loanApplication) {

        String id = loanApplication.getId().toString();
        MDC.put("id", id);
        Instant start=Instant.now();
        try {
            Person person = loanApplication.getPerson();

            //step1
            creditApplicationValidator.validate(loanApplication);
            //step2
            int score = personScoringCalculatorFactory.getCalculator(person).calculate(loanApplication);
            //step3
            double creditRating = creditRatingCalculator.calculate(loanApplication);
            //step4
            try {
                compoundPostValidator.validate(loanApplication, score, creditRating);
            } catch (RequirementNotMetException reqEx) {
                return new CreditApplicationDecision(NEGATIVE_REQUIREMENTS_NOT_MET, person.getPersonalData(), creditRating, score, reqEx.getRequirementNotMetException());
            }
            CreditApplicationDecision decision = getCreditApplicationDecision(loanApplication, person, score, creditRating);
            log.info("Decision: " + decision.getDecisionType());
            return decision;
        } catch (RegexException | NotNullException | MinValueException | MaxValueException validationException) {
            log.error(validationException.getMessage());
            throw new IllegalStateException();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new IllegalStateException();
        } finally {
            long ms1= Duration.between(start, Instant.now()).toMillis();
            long ms2=Duration.between(loanApplication.getCreationDateClientZone(),ZonedDateTime.now(loanApplication.getClientTimeZone())).toMillis();
            log.info("Application processing is finished. Took {}/{} ms", ms1, ms2);
        }

    }


    private CreditApplicationDecision getCreditApplicationDecision(LoanApplication loanApplication, Person person, int score, double creditRating) {
        CreditApplicationDecision decision;

        if (score < 300) {
            decision = new CreditApplicationDecision(NEGATIVE_RATING, person.getPersonalData(), null, score);
        } else if (score <= 400) {
            decision = new CreditApplicationDecision(CONTACT_REQUIRED, person.getPersonalData(), null, score);
        } else {
            if (creditRating >= loanApplication.getPurposeOfLoan().getAmount()) {
                decision = new CreditApplicationDecision(POSITIVE, person.getPersonalData(), null, score);
            } else {
                decision = new CreditApplicationDecision(NEGATIVE_SCORING, person.getPersonalData(), creditRating, score);
            }
        }
        return decision;
    }
}



