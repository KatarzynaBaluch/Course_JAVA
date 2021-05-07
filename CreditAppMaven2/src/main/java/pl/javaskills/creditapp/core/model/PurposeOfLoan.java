package pl.javaskills.creditapp.core.model;

public class PurposeOfLoan {
    private final LoanType loanType;
    private final double amount;
    private final byte period;

    public PurposeOfLoan(LoanType loanType, double amount, byte period) {
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

    public byte getPeriod() {
        return period;
    }
}
