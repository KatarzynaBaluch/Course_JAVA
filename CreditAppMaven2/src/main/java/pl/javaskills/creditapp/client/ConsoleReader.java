package pl.javaskills.creditapp.client;
import pl.javaskills.creditapp.core.model.*;

import java.util.Scanner;

public class ConsoleReader {

    public LoanApplication readInputParameters(){
        Scanner in=new Scanner(System.in);

        System.out.println("Enter name: ");
        String name=in.next();

        System.out.println("Enter last name: ");
        String lastName=in.next();

        System.out.println("Enter mother's maiden name: ");
        String mothersMaidenName=in.next();

        System.out.println("What is your marital status? (SINGLE, MARRIED, DIVORCED, WIDOWED, SEPARATED)");
        MaritalStatus maritalStatus=MaritalStatus.valueOf(in.next());

        System.out.println("What is your education level? (NONE, PRIMARY, MIDDLE, SECONDARY, POST_SECONDARY, TERTIARY)");
        Education education= Education.valueOf(in.next());

        System.out.println("Enter your email address: ");
        String email=in.next();

        System.out.println("Enter your phone number: ");
        String phoneNumber=in.next();



        System.out.println("How many sources of income do you have?");
        int incomeSourcesNumber=in.nextInt();
        SourceOfIncome[] sourceOfIncome=new SourceOfIncome[incomeSourcesNumber];

        for(int i=0;i<incomeSourcesNumber;i++)
        {
            System.out.println("Enter type of source of income 1 (EMPLOYMENT_CONTRACT | SELF_EMPLOYMENT | RETIREMENT)");
            IncomeType incomeType=IncomeType.valueOf(in.next());

            System.out.println("Enter total monthly income in PLN: ");
            double totalMonthlyIncomePln= in.nextDouble();

            sourceOfIncome[1]=new SourceOfIncome(incomeType,totalMonthlyIncomePln);
        }

        System.out.println("Enter number of family dependends: ");
        int numOfFamilyDependends= in.nextInt();

        System.out.println("What is purpose of loan? (MORTGAGE | PERSONAL_LOAN):");
        LoanType loanType=LoanType.valueOf(in.next());

        System.out.println("Enter loan amount: ");
        double amount=in.nextDouble();

        System.out.println("Enter loan period (in years): ");
        byte period=in.nextByte();


        PersonalData personalData=new PersonalData(name, lastName, mothersMaidenName, maritalStatus, education, numOfFamilyDependends);
        ContactData contactData=new ContactData(phoneNumber, email);
        FinanceData financeData=new FinanceData(sourceOfIncome);
        PurposeOfLoan purposeOfLoan=new PurposeOfLoan(loanType,amount, period);


        Person person=new Person(personalData,contactData, financeData);

        return new LoanApplication(person,purposeOfLoan);

    }
}
