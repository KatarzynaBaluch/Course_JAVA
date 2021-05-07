package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.model.*;
import pl.javaskills.creditapp.util.AgeUtils;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DummyCreditApplicationReader implements CreditApplicationReader {

    @Override
    public LoanApplication read()
    {

        final FamilyMember john = new FamilyMember("John", AgeUtils.generateBirthDate(18));
        final FamilyMember adam = new FamilyMember("Adam", AgeUtils.generateBirthDate(13));
        final FamilyMember jane = new FamilyMember("Jane", AgeUtils.generateBirthDate(3));


        List<FamilyMember> familyMembers = Arrays.asList(john, adam, jane);

        NaturalPerson person = NaturalPerson.Builder.create()
                .withFamilyMembers(familyMembers)
                .withPesel("12312312312")
                .withPersonalData(
                        PersonalData.Builder.create()
                                .withLastName("Test")
                                .withName("Test")
                                .withMothersMaidenName("Test")
                                .withEducation(Education.MIDDLE)
                                .withMaritalStatus(MaritalStatus.MARRIED)
                                .build())
                .withContactData(ContactData.Builder.create()
                        .withEmail("test@test")
                        .withPhoneNumber("456456456")
                        .withHomeAddress(new Address("test", "test", "test", "test", "test"))
                        .withCorespondenceAddress(new Address("test", "test", "test", "test", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10000.0)))
                .built();


        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(LoanType.MORTGAGE, 50000.0, 30);

        //System.out.println(person.getFamilyMembers());
        //System.out.println(person.getFamilyMembersSortedByName());

        Set<Guarantor> guarantors=Set.of(new Guarantor("12312312312", AgeUtils.generateBirthDate(45)),
                new Guarantor("11312312312", AgeUtils.generateBirthDate(45)));


        return new LoanApplication(person, new PurposeOfLoan(LoanType.MORTGAGE,100000,30),guarantors, ZoneId.of("Europe/Warsaw"), new Locale("pl", "PL"));
    }
}
