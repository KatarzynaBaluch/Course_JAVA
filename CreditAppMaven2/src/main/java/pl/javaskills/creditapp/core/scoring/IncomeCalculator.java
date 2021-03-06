package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Person;

public class IncomeCalculator {
    private static final Logger log= LoggerFactory.getLogger(IncomeCalculator.class);

    public int calculate(Person person)
    {
        double incomePerFamilyMember=person.getIncomePerFamilyMember();

        int pointsForIncome=(int)(incomePerFamilyMember/1000)*100;

        log.info("Income per family member: {} >> {} points",incomePerFamilyMember, pointsForIncome);

        if (person.getFinanceData().getNumberOfIncomeSources()>1)
        {
            log.info("More than one income source >> 100 points");
            pointsForIncome+=100;
        }

        return pointsForIncome;
    }



}
