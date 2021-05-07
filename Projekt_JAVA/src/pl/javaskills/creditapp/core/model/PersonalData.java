package pl.javaskills.creditapp.core.model;

import javax.naming.ldap.PagedResultsControl;

public class PersonalData {
    private final String name;
    private final String lastName;
    private final String mothersMaidenName;
    private final MaritalStatus maritalStatus;
    private final Education education;
    private final double totalMonthlyIncomePln;
    private final int numOfFamilyDependends;


    public PersonalData(String name, String lastname, String mothersMaidenName, MaritalStatus maritalStatus, Education education, double totalMonthlyIncomePln, int numOfFamilyDependends)
    {
        this.name=name;
        this.lastName=lastname;
        this.mothersMaidenName=mothersMaidenName;
        this.maritalStatus=maritalStatus;
        this.education=education;
        this.totalMonthlyIncomePln = totalMonthlyIncomePln;
        this.numOfFamilyDependends = numOfFamilyDependends;
    }

    public String getName() {return name;}

    public String getLastName() { return lastName;}

    public String getMothersMaidenName() {return mothersMaidenName; }

    public MaritalStatus getMaritalStatus() { return maritalStatus; }

    public Education getEducation() { return education; }

    public double getTotalMonthlyIncomePln() { return totalMonthlyIncomePln; }

    public int getNumOfFamilyDependends() { return numOfFamilyDependends; }

}
