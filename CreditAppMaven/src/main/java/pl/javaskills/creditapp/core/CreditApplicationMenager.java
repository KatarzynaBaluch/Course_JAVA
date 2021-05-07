package pl.javaskills.creditapp.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskills.creditapp.core.model.LoanApplication;
import pl.javaskills.creditapp.core.model.ProcessedCreditApplication;
import pl.javaskills.creditapp.di.Inject;
import pl.javaskills.creditapp.util.ObjectMapperService;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class CreditApplicationMenager {
    private static final Logger log = LoggerFactory.getLogger(LoanApplication.class);

    private Deque<LoanApplication> queue=new ArrayDeque<>();

    @Inject
    private CreditApplicationService creditApplicationService;

    @Inject
    private CreditApplicationDecisionFactory creditApplicationDecisionFactory;

    @Inject
    private FileManager fileManager;

    public CreditApplicationMenager() {
    }

    public CreditApplicationMenager(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    public void add(LoanApplication loanApplication) {
        log.info(String.format("Application %s is added to queue", loanApplication.getId()));

        queue.addFirst(loanApplication);

    }

    public void startProcessing() throws IOException {

        MDC.remove("id");
        while(!queue.isEmpty()) {
           LoanApplication loanApplication =queue.pollLast();
           log.info(String.format("Strarting processing application with id %s", loanApplication.getId()));

            CreditApplicationDecision decision=creditApplicationService.getDecision(loanApplication);
            log.info(creditApplicationDecisionFactory.getDecisionString(loanApplication, decision));
            fileManager.write(new ProcessedCreditApplication(loanApplication,decision));
            MDC.remove("id");


        }

    }

    public void loadApplication(String appId, String personId) throws IOException, ClassNotFoundException {
        final ProcessedCreditApplication read=fileManager.read(appId, personId);
        try {
            log.info(ObjectMapperService.OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(read));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public void init() throws IOException {
        fileManager.init();
    }
}
