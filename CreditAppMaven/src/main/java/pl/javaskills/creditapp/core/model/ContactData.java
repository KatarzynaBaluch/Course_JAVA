package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Optional;

public class ContactData  implements Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    @Regex(Constants.EMAIL_ADDRESS_REGEX)
    private String email;
    @NotNull
    @JsonProperty
    @Regex(Constants.PHONE_NUMBER_REGEX)
    private String phoneNumber;

    @JsonIgnore
    private transient Optional<Address> corespondenceAddress=Optional.empty();
    @NotNull
    @JsonProperty
    @ValidateObject
    private Address homeAddress;

    public ContactData() {
    }

    public Optional<Address> getCorespondenceAddress() {
        return corespondenceAddress;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    private ContactData(String email, String phoneNumber, Optional<Address> corespondenceAddress, Address homeAddress)
    {
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.corespondenceAddress = corespondenceAddress;
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static class Builder{
        private String email;
        private String phoneNumber;
        private Address corespondenceAddress;
        private Address homeAddress;

        private Builder(){}

        public static Builder create()
        {
            return new Builder();
        }

        public Builder withEmail(String email)
        {
            this.email=email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber)
        {
            this.phoneNumber=phoneNumber;
            return this;
        }


        public Builder withHomeAddress(Address homeAddress)
        {
            this.homeAddress=homeAddress;
            return this;
        }


        public Builder withCorespondenceAddress(Address corespondenceAddress)
        {
            this.corespondenceAddress=corespondenceAddress;
            return this;
        }

        public ContactData build()
        {

            Optional<Address> corespondenceAddress=this.homeAddress.equals(this.corespondenceAddress)?
                    Optional.empty():Optional.of(this.corespondenceAddress);

            return new ContactData(this.email, this.phoneNumber,corespondenceAddress,this.homeAddress);
        }

    }
}
