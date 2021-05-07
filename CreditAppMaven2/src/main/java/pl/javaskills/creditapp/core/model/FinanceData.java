package pl.javaskills.creditapp.core.model;

public class FinanceData {
    private final SourceOfIncome[] sourceOfIncomes;

    public FinanceData(SourceOfIncome[] sourceOfIncomes) {
        this.sourceOfIncomes = sourceOfIncomes;
    }

    public double getSumOfMonthlyIncome()
    {
        double sum=0;
        for (SourceOfIncome element : sourceOfIncomes)
        {
            sum+=element.getNetMonthlyIncome();
        }
        return sum;
    }

    public int getNumberOfIncomeSources()
    {
        return sourceOfIncomes.length;
    }
}
