package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.MaritalStatus;
import pl.javaskills.creditapp.core.model.Person;

public class MaritalStatusCalculator {

    private static final Logger log= LoggerFactory.getLogger(MaritalStatus.class);

     public int calculate(Person person)
    {
        int scoreMaritalStatus=person.getPersonalData().getMaritalStatus().getScoringPoints();
        log.info("Marital status: {} >>  {} points", person.getPersonalData().getMaritalStatus().toString(),scoreMaritalStatus);
        return scoreMaritalStatus;
    }
}
