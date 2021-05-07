package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.io.Serializable;
import java.util.*;

public class FinanceData implements Serializable {
    public static final long serialVersionID=1l;


    @NotNull
    @JsonProperty
    @ValidateCollection
    private List<SourceOfIncome> sourceOfIncomes;
    @NotNull
    @JsonProperty
    @ValidateCollection
    private Set<Expense> expenses;

    public FinanceData() {
    }
    public FinanceData(SourceOfIncome... sourceOfIncomes) {
        this.sourceOfIncomes= Arrays.asList(sourceOfIncomes);
        this.expenses=new HashSet<>();

    }

    public FinanceData(Set<Expense> expenses, SourceOfIncome... sourceOfIncomes) {
        this.sourceOfIncomes= Arrays.asList(sourceOfIncomes);
        this.expenses=new HashSet<>(expenses);
    }

    public List<SourceOfIncome> getSourceOfIncomes() {
        return sourceOfIncomes;
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
        return sourceOfIncomes.size();
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    private Map<ExpenseType, Set<Expense>> getExpenseMap()
    {
        Map<ExpenseType, Set<Expense>> result=new HashMap<>();
        for(Expense expense: expenses)
        {
            if(result.containsKey(expense.getType()))
            {
                result.get(expense.getType()).add(expense);
            }
            else {
                Set<Expense> set=new HashSet<>();
                set.add(expense);
                result.put(expense.getType(),set);
            }
        }
        return result;
    }

    public double getSumOfExpenses(ExpenseType type)
    {
        double sum=0.0;
        Map<ExpenseType, Set<Expense>> map=getExpenseMap();
        if(map.isEmpty())
        {
            return sum;
        }
       for (Expense expense: map.get(type))
       {
           sum+=expense.getAmount();
       }
       return sum;
    }

    public double getSumOfExpenses()
    {
        double sum=0.0;
        if(expenses.isEmpty())
        {
            return sum;
        }
        for (Expense expense: expenses)
        {
            sum+=expense.getAmount();
        }
        return sum;
    }
}
