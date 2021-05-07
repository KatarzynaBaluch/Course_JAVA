package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.Person;

public class CompaundScoringCalculator implements ScoringCalculator {

    private final ScoringCalculator[] scoringCalculators;
    private static Logger log=LoggerFactory.getLogger(CompaundScoringCalculator.class);

    public CompaundScoringCalculator(ScoringCalculator... scoringCalculators) {
        this.scoringCalculators = scoringCalculators;
    }

    @Override
    public int calculate(LoanApplication loanApplication)
    {
        int scoring =0;
        for (ScoringCalculator scoringCalculator : scoringCalculators) {
            scoring+= scoringCalculator.calculate(loanApplication);
        }
        log.info("Calculated scoring: "+scoring+" points");
        return scoring;
    }
}
