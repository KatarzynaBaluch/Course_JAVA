package pl.javaskills.creditapp.core;

import pl.javaskills.creditapp.core.model.Person;

public class PersonScoringCalculator {
    public int calculate(Person person)
    {
        int scoreIncome;
        scoreIncome=(int)person.getPersonalData().getTotalMonthlyIncomePln()/
                person.getPersonalData().getNumOfFamilyDependends()/1000*100;

        int scoreMaritalStatus=person.getPersonalData().getMaritalStatus().getScoringPoints();

        int scoreEducation=person.getPersonalData().getEducation().getScoringPoints();

        return scoreIncome+scoreMaritalStatus+scoreEducation;

    }
}
