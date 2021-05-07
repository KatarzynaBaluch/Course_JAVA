package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;

import java.io.Serializable;

public class SourceOfIncome  implements Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    private IncomeType incomeType;
    @NotNull
    @JsonProperty
    private double netMonthlyIncome;

    public SourceOfIncome() {
    }

    public double getNetMonthlyIncome() {
        return netMonthlyIncome;
    }
    public SourceOfIncome(IncomeType incomeType, double netMonthlyIncome) {
        this.incomeType = incomeType;
        this.netMonthlyIncome = netMonthlyIncome;
    }


}
