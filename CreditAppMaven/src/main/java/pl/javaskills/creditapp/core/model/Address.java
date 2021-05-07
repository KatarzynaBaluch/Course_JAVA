package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.io.Serializable;
import java.util.Objects;

public class Address  implements Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    private String street;
    @NotNull
    @JsonProperty
    private String city;
    @NotNull
    @JsonProperty
    private String houseNumber;
    @NotNull
    @JsonProperty
    private String zipCode;
    @NotNull
    @JsonProperty
    private String state;

    public Address() {
    }

    public Address(String street, String city, String houseNumber, String zipCode, String state) {
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {

        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(houseNumber, address.houseNumber) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(state, address.state);
    }


}
