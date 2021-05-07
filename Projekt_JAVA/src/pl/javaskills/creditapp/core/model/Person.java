package pl.javaskills.creditapp.core.model;

import Sekcja3_Pierwsze_kroki.Car;
import pl.javaskills.creditapp.core.model.ContactData;
import pl.javaskills.creditapp.core.model.PersonalData;

public class Person {

    private final PersonalData personalData;
    private final ContactData contactData;

    public Person(PersonalData personalData, ContactData contactData){
        this.personalData=personalData;
        this.contactData=contactData;

    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public double getIncomePerFamilyMember()
    {
        return this.personalData.getTotalMonthlyIncomePln()/this.getPersonalData().getNumOfFamilyDependends();
    }
}
