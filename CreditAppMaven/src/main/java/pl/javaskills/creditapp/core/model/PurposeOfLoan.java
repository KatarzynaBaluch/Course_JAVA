package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;

import java.io.Serializable;

public class PurposeOfLoan  implements Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    private  LoanType loanType;
    @JsonProperty
    private  double amount;
    @JsonProperty
    private  int period;

    public PurposeOfLoan() {
    }

    public PurposeOfLoan(LoanType loanType, double amount, int period) {
        this.loanType = loanType;
        this.amount = amount;
        this.period = period;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public double getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }
}
