package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.util.AgeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTestFactory {


    public static NaturalPerson create(int numOfDependands, SourceOfIncome... sourcesOfIncome) {
        List<FamilyMember> familyMembers=new ArrayList<>();
        for(int i=0;i<numOfDependands;i++)
        {
            familyMembers.add(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));
        }


        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("Test")
                .withLastName("Test")
                .withMothersMaidenName("Test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withFinanceData(new FinanceData(sourcesOfIncome))
                .withPersonalData(personalData)
                .withFamilyMembers(familyMembers)
                .built();
    }

    public static NaturalPerson create() {
        List<FamilyMember> familyMembers= Arrays.asList(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));

        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("Test")
                .withLastName("Test")
                .withMothersMaidenName("Test")
                .withEducation(Education.MIDDLE)
                .withMaritalStatus(MaritalStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withFamilyMembers(familyMembers)
                .built();
    }

    public static NaturalPerson create(double totalMonthlyIncomeInPln, int numOfDependants, Education education, MaritalStatus maritalStatus) {
        List<FamilyMember> familyMembers= Arrays.asList(new FamilyMember("Adam", AgeUtils.generateBirthDate(23)));

        PersonalData personalData = PersonalData
                .Builder
                .create()
                .withName("Test")
                .withLastName("Test")
                .withMothersMaidenName("Test")
                .withEducation(education)
                .withMaritalStatus(maritalStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomeInPln)))
                .withPersonalData(personalData)
                .withFamilyMembers(familyMembers)
                .built();
    }
}
