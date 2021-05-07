package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.io.Serializable;
import java.util.*;

public abstract class Person implements Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    @ValidateObject
    private PersonalData personalData;
    @NotNull
    @JsonProperty
    @ValidateObject
    private ContactData contactData;
    @NotNull
    @JsonProperty
    @ValidateObject
    private FinanceData financeData;
    @NotNull
    @JsonProperty
    @ValidateCollection
    private List<FamilyMember> familyMembers;

    public Person() {
    }

    protected Person(PersonalData personalData, ContactData contactData, FinanceData financeData, List<FamilyMember> familyMembers) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financeData = financeData;
        this.familyMembers = familyMembers;
        Collections.sort(this.familyMembers);

    }


    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public FinanceData getFinanceData() {
        return financeData;
    }

    public double getIncomePerFamilyMember()
    {
        return getBalance()/this.getNumOfFamilyDependends();
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public List<FamilyMember> getFamilyMembersSortedByName() {
        List<FamilyMember> list=new ArrayList<>(this.familyMembers);
        Collections.sort(list, new FamilyMemberNameComparator());
        return list;
    }

    public int getNumOfFamilyDependends() { return familyMembers.size()+1; }

    public double getBalance()
    {
        double totalMonthlyIncome=financeData.getSumOfMonthlyIncome();
        double totalExpenses=financeData.getSumOfExpenses();

        return totalMonthlyIncome-totalExpenses;

    }

}
