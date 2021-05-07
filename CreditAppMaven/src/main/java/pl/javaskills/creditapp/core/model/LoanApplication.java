package pl.javaskills.creditapp.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.javaskills.creditapp.core.annotation.ExactlyOneNotNull;
import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.annotation.ValidateCollection;
import pl.javaskills.creditapp.core.annotation.ValidateObject;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@ExactlyOneNotNull({"naturalPerson", "selfEmployed" })
public class LoanApplication implements Serializable {
    public static final long serialVersionID = 1l;

    @JsonProperty
    @ValidateObject
    private NaturalPerson naturalPerson;

    @JsonProperty
    @ValidateObject
    private SelfEmployed selfEmployed;

    @NotNull
    @JsonProperty
    @ValidateObject
    private PurposeOfLoan purposeOfLoan;
    @NotNull
    @JsonProperty
    @ValidateCollection
    private Set<Guarantor> guarantors;
    @NotNull
    @JsonIgnore
    private UUID id;
    @JsonProperty
    private ZoneId clientTimeZone;
    @JsonIgnore
    private ZonedDateTime creationDateClientZone;
    @JsonProperty
    private Locale clientLocale;

    public LoanApplication() {
    }

    public LoanApplication(NaturalPerson person, PurposeOfLoan purposeOfLoan, ZoneId clientTimeZone, Locale clientLocale) {
        this.naturalPerson = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(this.clientTimeZone);
        this.clientLocale = clientLocale;
    }

    public LoanApplication(SelfEmployed person, PurposeOfLoan purposeOfLoan, ZoneId clientTimeZone, Locale clientLocale) {
        this.selfEmployed = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>();
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(this.clientTimeZone);
        this.clientLocale = clientLocale;
    }

    public LoanApplication(NaturalPerson person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors, ZoneId clientTimeZone, Locale clientLocale) {
        this.naturalPerson = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>(guarantors);
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(this.clientTimeZone);
        this.clientLocale = clientLocale;
    }

    public LoanApplication(SelfEmployed person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors, ZoneId clientTimeZone, Locale clientLocale) {
        this.selfEmployed = person;
        this.purposeOfLoan = purposeOfLoan;
        this.id = UUID.randomUUID();
        this.guarantors = new TreeSet<>(guarantors);
        this.clientTimeZone = clientTimeZone;
        this.creationDateClientZone = ZonedDateTime.now(this.clientTimeZone);
        this.clientLocale = clientLocale;
    }


    public Set<Guarantor> getGuarantors() {
        return guarantors;
    }

    @JsonIgnore
    public Person getPerson() {

        return naturalPerson!=null?naturalPerson:selfEmployed;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public UUID getId() {
        return id;
    }

    public ZoneId getClientTimeZone() {
        return clientTimeZone;
    }

    public ZonedDateTime getCreationDateClientZone() {
        return creationDateClientZone;
    }

    public Locale getClientLocale() {
        return clientLocale;
    }

    @JsonIgnore
    public boolean isNaturalPerson() {
        return naturalPerson!=null?true:false;
    }

    public void init() {
        this.id = UUID.randomUUID();
        this.creationDateClientZone = ZonedDateTime.now(this.clientTimeZone);
    }
}
