package Sekcja10_WyjatkiIAseracje.Niestandardowe;

import java.rmi.UnexpectedException;

public class Main {
    public static void main(String[] args) {
        try {
            new ServiceLevel1().calculate(0);
        }
        catch (UncheckedException e) //Unchecked bardziej kokretny, więc musi być wyżej w catchu
        {
            System.out.println("I'm know about this Exception. "+e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Unexpected Error"+e.getMessage());
            e.printStackTrace(); //StackTrace tylko  w przypadku wyjkatkow ktorych sie nie spodziewamy
        }
    }
}
