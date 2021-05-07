package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;

public class EducationCalculator {
    private static final Logger log= LoggerFactory.getLogger(EducationCalculator.class);

    public int calculate(Person person)
    {

        int scoreEducation=person.getPersonalData().getEducation().getScoringPoints();
        log.info("Education: {} >> {}", person.getPersonalData().getEducation().toString(),scoreEducation);
        return scoreEducation;
    }


}
