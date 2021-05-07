package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.ExactlyOneNotNull;
import pl.javaskills.creditapp.core.annotation.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExactlyOneNotNull({"nip", "regon"})
public class SelfEmployed extends Person implements Serializable {

    public static final long serialVersionID=1l;

    @JsonProperty
    private String nip;
    @JsonProperty
    private String regon;
    @NotNull
    @JsonProperty
    private int yearsSinceFounded;

    private SelfEmployed(){}

    private SelfEmployed(String nip, String regon, PersonalData personalData, ContactData contactData, FinanceData financeData, int yearsSinceFounded, List<FamilyMember> familyMembers)
    {
        super(personalData, contactData, financeData, familyMembers);
        this.nip=nip;
        this.regon=regon;
        this.yearsSinceFounded = yearsSinceFounded;

    }

    public String getNip() {
        return nip;
    }

    public int getYearsSinceFounded() {
        return yearsSinceFounded;
    }

    public static class Builder
    {
        private String nip;
        private String regon;
        private int yearsSinceFounded;
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;
        private List<FamilyMember> familyMembers= new ArrayList<>();


        public static Builder create()
        {
            return new Builder();
        }

        public Builder withNip(String nip)
        {
            this.nip=nip;
            return this;
        }

        public Builder withRegon(String regon)
        {
            this.regon=regon;
            return this;
        }
        public Builder withYearsSinceFounded(int yearsSinceFounded)
        {
            this.yearsSinceFounded=yearsSinceFounded;
            return this;
        }

        public Builder withPersonalData(PersonalData personalData)
        {
            this.personalData=personalData;
            return this;
        }
        public Builder withContactData(ContactData contactData)
        {
            this.contactData=contactData;
            return this;
        }

        public Builder withFinanceData(FinanceData financeData)
        {
            this.financeData=financeData;
            return this;
        }

        public Builder withFamilyMembers(List<FamilyMember> familyMembers)
        {
            this.familyMembers= familyMembers;
            return this;
        }
        public Builder() {}

        public SelfEmployed built()
        {
            return new SelfEmployed(nip, regon, personalData,contactData,financeData, yearsSinceFounded, familyMembers);
        }
    }

}
