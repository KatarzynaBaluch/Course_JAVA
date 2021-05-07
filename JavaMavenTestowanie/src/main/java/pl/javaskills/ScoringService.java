package pl.javaskills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import static java.util.UUID.randomUUID;

public class ScoringService {
    //private final AdditionalPointsService service;
    private static final Logger log= LoggerFactory.getLogger(ScoringService.class);
    private final AdditionalPointsService service;

    public ScoringService(AdditionalPointsService service) {
        this.service = service;
    }

    public int calculate(int age) {
        log.debug("Starting calculation");
        MDC.put("id",randomUUID().toString());

        if (age < 18) {
            log.info("User is underage, Age: {}", age);
            //log.debug("DEBUG");
            //log.error("ERROR");
            //log.warn("WARN");
            return -100;
        } else if (age > 60) {
            log.info("User >60 years");
            return -200;
        } else {
            log.info("User between 18 and 60 years old");
            return service.getAdditionalPoints();
        }
    }
}
