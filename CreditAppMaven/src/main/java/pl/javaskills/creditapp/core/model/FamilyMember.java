package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.NotNull;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class FamilyMember implements  Comparable<FamilyMember>, Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    private  String name;
    @NotNull
    @JsonProperty
    private LocalDate birthDate;

    public FamilyMember() {
    }

    public FamilyMember(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {

        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public int compareTo(FamilyMember o) {

        return o.getAge().compareTo(getAge()); //w odwrotnej kolejnosci
    }


    @Override
    public String toString() {
        return "Member{" +
               name + '\'' +
                birthDate +
                '}';
    }
}
