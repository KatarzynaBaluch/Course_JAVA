package pl.javaskills.creditapp.core.model;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Set;

public class LoanApplicationTestFactory {

    public static LoanApplication create(NaturalPerson person, PurposeOfLoan purposeOfLoan, Set<Guarantor> guarantors)
    {
        return new LoanApplication(person, purposeOfLoan,guarantors, ZoneId.of("Europe/Warsaw"), Locale.US);
    }

    public static LoanApplication create(NaturalPerson person, PurposeOfLoan purposeOfLoan)
    {
        return new LoanApplication(person, purposeOfLoan, ZoneId.of("Europe/Warsaw"), Locale.US);
    }

    public static LoanApplication create(SelfEmployed person, PurposeOfLoan purposeOfLoan)
    {
        return new LoanApplication(person, purposeOfLoan, ZoneId.of("Europe/Warsaw"), Locale.US);
    }

    public static LoanApplication create(double expectedLoanAmount)
    {
        NaturalPerson person =PersonTestFactory.create(5000.0,1,Education.TERTIARY,MaritalStatus.MARRIED);
        PurposeOfLoan purposeOfLoan=new PurposeOfLoan(LoanType.MORTGAGE,expectedLoanAmount,(byte)2);
        LoanApplication loanApplication=new LoanApplication(person,purposeOfLoan, ZoneId.of("Europe/Warsaw"), Locale.US);
        return loanApplication;
    }

    public static LoanApplication create()
    {
        NaturalPerson person =PersonTestFactory.create(5000.0,1,Education.TERTIARY,MaritalStatus.MARRIED);
        PurposeOfLoan purposeOfLoan=new PurposeOfLoan(LoanType.MORTGAGE,100.0, (byte)25);
        LoanApplication loanApplication=new LoanApplication(person,purposeOfLoan, ZoneId.of("Europe/Warsaw"), Locale.US);
        return loanApplication;
    }

}
