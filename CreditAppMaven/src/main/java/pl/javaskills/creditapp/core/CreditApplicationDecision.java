package pl.javaskills.creditapp.core;


import com.sun.source.doctree.SeeTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.exception.RequirementNotMetCause;
import pl.javaskills.creditapp.core.model.PersonalData;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

public class CreditApplicationDecision implements Serializable {
    public static final long serialVersionID=1l;
    private final DecisionType decisionType;
    private final PersonalData personalData;
    private final Double creditRating;
    private static final Logger log = LoggerFactory.getLogger(CreditApplicationDecision.class);
    private final Integer scoring;
    private final transient Optional<RequirementNotMetCause> requirementNotMetCause;


    public Double getCreditRating() {
        return creditRating;
    }

    public int getScoring() {
        return scoring;
    }

    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRating, Integer scoring, RequirementNotMetCause requirementNotMetCause) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRating = creditRating;
        this.scoring = scoring;
        this.requirementNotMetCause = Optional.of(requirementNotMetCause);
    }

    public CreditApplicationDecision(DecisionType decisionType, PersonalData personalData, Double creditRating, Integer scoring) {
        this.decisionType = decisionType;
        this.personalData = personalData;
        this.creditRating = creditRating;
        this.scoring = scoring;
        this.requirementNotMetCause = Optional.empty();
    }


    public DecisionType getDecisionType() {
        return decisionType;
    }

    public Optional<RequirementNotMetCause> getRequirementNotMetCause() {
        return requirementNotMetCause;
    }
}
