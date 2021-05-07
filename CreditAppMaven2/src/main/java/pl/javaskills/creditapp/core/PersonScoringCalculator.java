package pl.javaskills.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.scoring.EducationCalculator;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;
import pl.javaskills.creditapp.core.scoring.MaritalStatusCalculator;


public class PersonScoringCalculator {
    private static final Logger log= LoggerFactory.getLogger(IncomeCalculator.class);

    private final EducationCalculator educationCalculator;
    private final IncomeCalculator incomeCalculator;
    private final MaritalStatusCalculator maritalStatusCalculator;

    public PersonScoringCalculator(EducationCalculator educationCalculator, IncomeCalculator incomeCalculator, MaritalStatusCalculator maritalStatusCalculator) {
        this.educationCalculator = educationCalculator;
        this.incomeCalculator = incomeCalculator;
        this.maritalStatusCalculator = maritalStatusCalculator;
    }


    public int calculate(Person person)
    {
        int scoring=educationCalculator.calculate(person)+incomeCalculator.calculate(person)+maritalStatusCalculator.calculate(person);

        log.info("Total scoring: {} points", scoring);

        return scoring;
    }
}
