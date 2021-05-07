package pl.javaskills.creditapp.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactDataTest {

    @Test
    @DisplayName("should set Optional correspondenceAdress when homeAddress is the same")
    public void test1()
    {
        //given
        Address address=new Address("Swierkowa", "Myslowice","18","41-400", "Slaskie");
        //when
        ContactData contactData = ContactData.Builder
                .create()
                .withCorespondenceAddress(address)
                .withHomeAddress(address)
                .build();
        //then
        assertTrue( contactData.getCorespondenceAddress().isEmpty());
    }


    @Test
    @DisplayName("should not set Optional correspondenceAdress when homeAddress isn't the same")
    public void test2()
    {
        //given
        Address address1=new Address("Swierkowa", "Myslowice","18","41-400", "Slaskie");
        Address address2=new Address("Jodlowa", "Myslowice","18","41-400", "Slaskie");
        //when
        ContactData contactData = ContactData.Builder
                .create()
                .withCorespondenceAddress(address1)
                .withHomeAddress(address2)
                .build();
        //then
        assertTrue(contactData.getCorespondenceAddress().isPresent());
    }
}