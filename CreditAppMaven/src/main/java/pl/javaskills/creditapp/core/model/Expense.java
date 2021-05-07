package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.io.Serializable;
import java.util.Objects;

public class Expense  implements Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    private String name;
    @NotNull
    @JsonProperty
    private ExpenseType type;
    @NotNull
    @JsonProperty
    private double amount;

    public Expense() {
    }

    public Expense(String name, ExpenseType type, double amount) {
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public ExpenseType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return name.equals(expense.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
