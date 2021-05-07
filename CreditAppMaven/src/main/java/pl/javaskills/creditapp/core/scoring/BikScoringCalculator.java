package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.bik.BikApi;
import pl.javaskills.creditapp.core.bik.ScoringRequest;
import pl.javaskills.creditapp.core.bik.ScoringResponse;
import pl.javaskills.creditapp.core.model.NaturalPerson;
import pl.javaskills.creditapp.core.model.Person;
import pl.javaskills.creditapp.core.model.SelfEmployed;

public class BikScoringCalculator implements  ScoringCalculator {
    private static final Logger log= LoggerFactory.getLogger(IncomeCalculator.class);
    private  final BikApi bikApi;

    public BikScoringCalculator(BikApi bikApi) {
        this.bikApi = bikApi;
    }

    @Override
    public int calculate(Person person)
    {
        ScoringRequest scoringRequest=new ScoringRequest();
        if(person instanceof SelfEmployed)
        {
            scoringRequest.setNip(((SelfEmployed)person).getNip());
        }
        if(person instanceof NaturalPerson)
        {
            scoringRequest.setPesel(((NaturalPerson)person).getPesel());
        }

        final ScoringResponse response=bikApi.getScoring(scoringRequest);
        int scoring=100*response.getScoring()/600;
        log.info(String.format("Bik scoring: %s/600, scoring: %s/100, %s", response.getScoring(),scoring, ScoringUtils.getPointsString(scoring)));


        return scoring;
    }

}
