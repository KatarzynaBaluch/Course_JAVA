package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.Guarantor;
import pl.javaskills.creditapp.core.model.NaturalPerson;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.SelfEmployed;
import pl.javaskills.creditapp.core.scoring.*;
import pl.javaskills.creditapp.di.Inject;

public class PersonScoringCalculatorFactory {

    @Inject
    private SelfEmployedScoringCalculator selfEmployedScoringCalculator;
    @Inject
    private EducationCalculator educationCalculator;
    @Inject
    private IncomeCalculator incomeCalculator;
    @Inject
    private MaritalStatusCalculator maritalStatusCalculator;
    @Inject
    private GuarantorsCalculator guarantorsCalculator;
    @Inject
    private BikScoringCalculator bikScoringCalculator;

    public PersonScoringCalculatorFactory() {
    }

    public PersonScoringCalculatorFactory(SelfEmployedScoringCalculator selfEmployedScoringCalculator, EducationCalculator educationCalculator, IncomeCalculator incomeCalculator, MaritalStatusCalculator maritalStatusCalculator, GuarantorsCalculator guarantorsCalculator, BikScoringCalculator bikScoringCalculator) {
        this.selfEmployedScoringCalculator = selfEmployedScoringCalculator;
        this.educationCalculator = educationCalculator;
        this.incomeCalculator = incomeCalculator;
        this.maritalStatusCalculator = maritalStatusCalculator;
        this.guarantorsCalculator = guarantorsCalculator;
        this.bikScoringCalculator=bikScoringCalculator;

    }


    public ScoringCalculator getCalculator(Person person)
    {
        if(person instanceof SelfEmployed)
        {
            return new CompaundScoringCalculator(selfEmployedScoringCalculator,educationCalculator, maritalStatusCalculator, incomeCalculator,guarantorsCalculator, bikScoringCalculator);
        }
        else if(person instanceof NaturalPerson) {
            return new CompaundScoringCalculator(educationCalculator, maritalStatusCalculator, incomeCalculator,guarantorsCalculator,bikScoringCalculator);
        }
        else return null;
    }
}
