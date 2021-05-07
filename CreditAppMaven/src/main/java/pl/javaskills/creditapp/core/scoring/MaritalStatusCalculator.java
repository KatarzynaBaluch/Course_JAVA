package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;

public class MaritalStatusCalculator implements ScoringCalculator {

    private static final Logger log= LoggerFactory.getLogger(MaritalStatus.class);

    @Override
    public int calculate(Person person)
    {
        int scoreMaritalStatus=person.getPersonalData().getMaritalStatus().getScoringPoints();
        log.info("Marital status - {}: ", person.getPersonalData().getMaritalStatus().toString()+ ScoringUtils.getPointsString(scoreMaritalStatus));
        return scoreMaritalStatus;
    }
}
