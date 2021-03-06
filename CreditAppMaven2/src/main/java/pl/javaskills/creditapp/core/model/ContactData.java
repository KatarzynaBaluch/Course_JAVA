package pl.javaskills.creditapp.core.model;

public class ContactData {
    private final String email;
    private final String phoneNumber;

    public ContactData(String email, String phoneNumber)
    {
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
