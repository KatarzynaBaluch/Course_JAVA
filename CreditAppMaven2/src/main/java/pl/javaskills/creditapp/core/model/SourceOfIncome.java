package pl.javaskills.creditapp.core.model;

public class SourceOfIncome {
    private final IncomeType incomeType;
    private final double netMonthlyIncome;

    public double getNetMonthlyIncome() {
        return netMonthlyIncome;
    }
    public SourceOfIncome(IncomeType incomeType, double netMonthlyIncome) {
        this.incomeType = incomeType;
        this.netMonthlyIncome = netMonthlyIncome;
    }


}
