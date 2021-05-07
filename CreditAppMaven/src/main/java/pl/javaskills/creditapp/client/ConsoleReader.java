package pl.javaskills.creditapp.client;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.model.*;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleReader implements CreditApplicationReader {

    @Override
    public LoanApplication read(){
        Scanner in=new Scanner(System.in);

        String name = getName(in);
        String lastName = getLastName(in);
        String mothersMaidenName = getMothersMaidenName(in);
        MaritalStatus maritalStatus = getMaritalStatus(in);
        Education education = getEducation(in);
        String emailAddress=getEmailAddress(in);
        String phoneNumber=getPhoneNumber(in);

        String incomeSourcesNumber = getIncomeSourcesNumber(in);
        SourceOfIncome[] sourceOfIncome=new SourceOfIncome[Integer.parseInt(incomeSourcesNumber)];
        getSourceIncomes(in, incomeSourcesNumber, sourceOfIncome);

        String loanTypeInput =getLoanTypeInput(in);
        LoanType loanType=LoanType.valueOf(loanTypeInput);
        String amount = getAmount(in);
        String period=getPeriod(in);

        PersonalData personalData=PersonalData
                .Builder
                .create()
                .withName(name)
                .withLastName(lastName)
                .withMothersMaidenName(mothersMaidenName)
                .withMaritalStatus(maritalStatus)
                .withEducation(education)
                .build();
        ContactData contactData=ContactData
                .Builder
                .create()
                .withEmail(emailAddress)
                .withPhoneNumber(phoneNumber)
                .withCorespondenceAddress(null)
                .withHomeAddress(null)
                .build();
        FinanceData financeData=new FinanceData(sourceOfIncome);
        PurposeOfLoan purposeOfLoan=new PurposeOfLoan(loanType,Double.parseDouble(amount), Integer.parseInt(period));

        NaturalPerson person=NaturalPerson
                .Builder
                .create()
                .withPesel("12345678910")
                .withPersonalData(personalData)
                .withContactData(contactData)
                .withFinanceData(financeData)
                .built();

        return new LoanApplication(person,purposeOfLoan, ZoneId.of("Europe/Warsaw"), Locale.US);

    }

    private String getPeriod(Scanner in) {
        String period;
        do {
            System.out.println("Enter loan period (in years): ");
            period = in.next();
        }while (!NumberValidator.validateInteger(period,5,10,15,20,25,30));
        return period;
    }

    private String getAmount(Scanner in) {
        String amount;
        do {
            System.out.println("Enter loan amount: ");
            amount = in.next();
        }while (!NumberValidator.validateDouble(amount,0.0,Double.MAX_VALUE));
        return amount;
    }

    private String getLoanTypeInput(Scanner in) {
        String loanTypeInput;
        do {
            System.out.println("What is purpose of loan?"+loanTypeElements());
            loanTypeInput= in.next();
        }while(!EnumValidator.validateLoanType(loanTypeInput));
        return loanTypeInput;
    }

    private void getSourceIncomes(Scanner in, String incomeSourcesNumber, SourceOfIncome[] sourceOfIncome) {
        for(int i = 0; i<Integer.parseInt(incomeSourcesNumber); i++)
        {
            String incomeTypeInput;
            do {
                System.out.println("Enter type of source of income:"+incomeTypeElements());
                incomeTypeInput= in.next();
            }while(!EnumValidator.validateIncomeType(incomeTypeInput));
            IncomeType incomeType=IncomeType.valueOf(incomeTypeInput);

            String totalMonthlyIncomePln;
            do {
                System.out.println("Enter total monthly income in PLN: ");
                totalMonthlyIncomePln = in.next();
            }while (!NumberValidator.validateDouble(totalMonthlyIncomePln,0.0,Double.MAX_VALUE));

            sourceOfIncome[i]=new SourceOfIncome(incomeType,Double.parseDouble(totalMonthlyIncomePln));
        }
    }

    private String getIncomeSourcesNumber(Scanner in) {
        String incomeSourcesNumber;
        do {
            System.out.println("How many sources of income do you have?");
            incomeSourcesNumber = in.next();
        }while (!NumberValidator.validateInteger(incomeSourcesNumber, 0,Integer.MAX_VALUE));
        return incomeSourcesNumber;
    }

    private String getPhoneNumber(Scanner in) {
        String phoneNumber;
        do {
            System.out.println("Enter your phone number: ");
            phoneNumber = in.next();
        }while (!PhoneValidator.validatePhoneNumber(phoneNumber));
        return phoneNumber;
    }

    private String getEmailAddress(Scanner in) {
        String emailAddress;
        do {
            System.out.println("Enter your email address: ");
            emailAddress = in.next();
        }while (!StringValidator.validateEmailAddress(emailAddress));
        return emailAddress;
    }


    private Education getEducation(Scanner in) {
        String educationInput;
        do {
            System.out.println("What is your education level?"+educationElements());
            educationInput= in.next();
        }while(!EnumValidator.validateEducation(educationInput));
        Education education= Education.valueOf(educationInput);
        return education;
    }


    private MaritalStatus getMaritalStatus(Scanner in) {
        String maritalStatusInput;
        do{
        System.out.println("What is your marital status?"+maritalStatusElements());
            maritalStatusInput= in.next();
        }while (!EnumValidator.validateMaritelStatus(maritalStatusInput));
        MaritalStatus maritalStatus = MaritalStatus.valueOf(maritalStatusInput);
        return maritalStatus;
    }

    private String getMothersMaidenName(Scanner in) {
        String mothersMaidenName;
        do {
            System.out.println("Enter mother's maiden name: ");
            mothersMaidenName = in.next();
        }while (!StringValidator.validateString(mothersMaidenName, Constants.LAST_NAME_REGEX));
        return mothersMaidenName;
    }

    private String getLastName(Scanner in) {
        String lastName;
        do {
            System.out.println("Enter last name: ");
            lastName = in.next();
        }while (!StringValidator.validateString(lastName, Constants.LAST_NAME_REGEX));
        return lastName;
    }

    private String getName(Scanner in) {
        String name;
        do {
            System.out.println("Enter name: ");
            name = in.next();
        }while (!StringValidator.validateString(name, Constants.NAME_REGEX));
        return name;
    }


    private String maritalStatusElements() {
        String maritalStatusElements=" (";
        for (int i=0;i<MaritalStatus.values().length-1;i++)
        {
            maritalStatusElements+=MaritalStatus.values()[i];
            maritalStatusElements+=", ";
        }
        maritalStatusElements+=MaritalStatus.values()[MaritalStatus.values().length-1];
        maritalStatusElements+=")";
        return maritalStatusElements;
    }

    private String educationElements() {
        String educationStatusElements=" (";
        for (int i=0;i<Education.values().length-1;i++)
        {
            educationStatusElements+=Education.values()[i];
            educationStatusElements+=", ";
        }
        educationStatusElements+=Education.values()[Education.values().length-1];
        educationStatusElements+=")";
        return educationStatusElements;
    }


    private String incomeTypeElements() {
        String incomeTypeElements=" (";
        for (int i=0;i<IncomeType.values().length-1;i++)
        {
            incomeTypeElements+=IncomeType.values()[i];
            incomeTypeElements+=", ";
        }
        incomeTypeElements+=IncomeType.values()[IncomeType.values().length-1];
        incomeTypeElements+=")";
        return incomeTypeElements;
    }

    private String loanTypeElements() {
        String loanTypeElements=" (";
        for (int i=0;i<LoanType.values().length-1;i++)
        {
            loanTypeElements+=LoanType.values()[i];
            loanTypeElements+=", ";
        }
        loanTypeElements+=MaritalStatus.values()[LoanType.values().length-1];
        loanTypeElements+=")";
        return loanTypeElements;
    }
}
