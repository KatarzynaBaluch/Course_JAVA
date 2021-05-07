package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.CreditApplicationDecision;

import java.io.Serializable;
import java.nio.file.Path;

public class ProcessedCreditApplication implements Serializable {

    public static final long serialVersionID=1l;
    @JsonProperty
    private LoanApplication loanApplication;
    @JsonProperty
    private CreditApplicationDecision creditApplicationDecision;

    public ProcessedCreditApplication() {
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public CreditApplicationDecision getCreditApplicationDecision() {
        return creditApplicationDecision;
    }

    public ProcessedCreditApplication(LoanApplication loanApplication, CreditApplicationDecision creditApplicationDecision) {
        this.loanApplication = loanApplication;
        this.creditApplicationDecision = creditApplicationDecision;


    }


}
