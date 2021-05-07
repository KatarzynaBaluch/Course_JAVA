package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.Regex;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Guarantor implements Comparable<Guarantor>, Serializable {
    public static final long serialVersionID=1l;
    @NotNull
    @JsonProperty
    @Regex(Constants.PESEL_REGEX)
    private String pesel;
    @NotNull
    @JsonProperty
    private LocalDate birthDate;

    public Guarantor() {
    }

    public Guarantor(String pesel, LocalDate birthDay) {
        this.pesel = pesel;
        this.birthDate = birthDay;
    }

    @Override
    public String toString() {
        return "Guarantor{" +
                "pesel='" + pesel + '\'' +
                ", age=" + getAge() +
                '}';
    }

    public String getPesel() {
        return pesel;
    }

    public Integer getAge() {

        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public int compareTo(Guarantor o) {
        if(o.pesel.compareTo(this.pesel)!=0)
        {
            return o.pesel.compareTo(this.pesel);
        }
        return this.birthDate.compareTo(o.birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guarantor guarantor = (Guarantor) o;
        return pesel.equals(guarantor.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    private static class Builder{

        private String pesel;
        private LocalDate birthDate;

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public Builder withBirthDate(LocalDate birthDate)
        {
            this.birthDate=birthDate;
            return this;
        }

        public Builder withPesel(String pesel)
        {
            this.pesel=pesel;
            return this;
        }


        public Guarantor build()
        {
            return new Guarantor(pesel, birthDate);
        }
    }
}
