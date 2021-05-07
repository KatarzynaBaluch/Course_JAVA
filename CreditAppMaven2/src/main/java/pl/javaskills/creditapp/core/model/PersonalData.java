package pl.javaskills.creditapp.core.model;

public class PersonalData {
    private final String name;
    private final String lastName;
    private final String mothersMaidenName;
    private final MaritalStatus maritalStatus;
    private final Education education;
    private final int numOfFamilyDependends;


    public PersonalData(String name, String lastname, String mothersMaidenName, MaritalStatus maritalStatus, Education education, int numOfFamilyDependends)
    {
        this.name=name;
        this.lastName=lastname;
        this.mothersMaidenName=mothersMaidenName;
        this.maritalStatus=maritalStatus;
        this.education=education;
        this.numOfFamilyDependends = numOfFamilyDependends;
    }

    public String getName() {return name;}

    public String getLastName() { return lastName;}

    public String getMothersMaidenName() {return mothersMaidenName; }

    public MaritalStatus getMaritalStatus() { return maritalStatus; }

    public Education getEducation() { return education; }

    public int getNumOfFamilyDependends() { return numOfFamilyDependends; }

}
