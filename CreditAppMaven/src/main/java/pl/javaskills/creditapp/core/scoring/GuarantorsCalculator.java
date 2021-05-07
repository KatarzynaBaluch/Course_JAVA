package pl.javaskills.creditapp.core.scoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.model.Guarantor;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class GuarantorsCalculator implements ScoringCalculator {

    private static final Logger log=LoggerFactory.getLogger(GuarantorsCalculator.class);

    @Override
    public int calculate(LoanApplication loanApplication) {

        int scoringAgeUnder40 = 0;
        int scoringAgeOthers = 0;
        for (Guarantor g : loanApplication.getGuarantors()) {
            //System.out.println(g);
            if (g.getAge() > 40) {
                scoringAgeUnder40 += 50;
            }
            else
            {
                scoringAgeOthers+=25;
            }
        }
        log.info("Scoring guarantors under 40: "+scoringAgeUnder40);
        log.info("Scoring guarantors others: "+scoringAgeOthers);
        return scoringAgeOthers+scoringAgeUnder40;
    }
}
