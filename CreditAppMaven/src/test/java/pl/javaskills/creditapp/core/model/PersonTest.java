package pl.javaskills.creditapp.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.javaskills.creditapp.util.AgeUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("FamilyMemeber should be sorted by age descent")
    public void test() {
        //given
        final FamilyMember john = new FamilyMember("John", AgeUtils.generateBirthDate( 18));
        final FamilyMember adam = new FamilyMember("Adam", AgeUtils.generateBirthDate(13));
        final FamilyMember jane = new FamilyMember("Jane", AgeUtils.generateBirthDate(3));


        List<FamilyMember> familyMembers = Arrays.asList(john, adam, jane);
        //when
        Person person = NaturalPerson.Builder.create()
                .withFamilyMembers(familyMembers)
                .built();

        //then
        assertNotNull(person.getFamilyMembers());
        assertTrue(person.getFamilyMembers().size() == 3);
        assertEquals(john, person.getFamilyMembers().get(0));
        assertEquals(adam, person.getFamilyMembers().get(1));
        assertEquals(jane, person.getFamilyMembers().get(2));
    }

}