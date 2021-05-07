package pl.javaskills.creditapp.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.PersonalData;

import java.math.BigDecimal;

public class CreditApplicationDecision {

    private final DecisionType decisionType;
    private final PersonalData personalData;
    private final Double creditRating;
    private static final Logger log= LoggerFactory.getLogger(CreditApplicationDecision.class);


    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRating) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRating = creditRating;
    }

    public String getDecisionString(){

        log.info("Decision: {}", this.decisionType.toString());

        switch (decisionType){
            case POSITIVE:
                return "Congratulation "+personalData.getName()+" "+personalData.getLastName()+" decisions is positive";
            case CONTACT_REQUIRED:
                return "Sorry, "+ personalData.getName()+" "+personalData.getLastName()+", bank requires additional documents. Our Consultant will contact you.";
            case NEGATIVE_RATING:
                return "Sorry "+ personalData.getName()+" "+personalData.getLastName()+" decision is negative";
            case NEGATIVE_SCORING:
                BigDecimal roundedCreditRate=new BigDecimal(creditRating).setScale(2);
                return "Sorry, "+ personalData.getName()+" "+personalData.getLastName()+", decision is negative. Bank can borrow only "+roundedCreditRate;

        }
        return null;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }

}
