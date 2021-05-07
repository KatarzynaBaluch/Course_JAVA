package Sekcja10_WyjatkiIAseracje;

import java.io.IOException;

public class Calculator {

    public void calculate_unchecked()
    {
        //throw + coś co dziedziczy Throwable (nic innego nie może być)
        throw new NullPointerException();
    }

    //1 sposób obsługi wyjatkow
    public void calculate_checked(String input) {
        try {
            throw new IOException();
        }
        catch (IOException ioException)
        {
            System.out.println("Enexpected error, input: "+input);
            ioException.printStackTrace();
        }
    }

    //2 sposob obslugi wyjatkow
    public void calculate_checked2() throws IOException{

        throw new IOException();
    }
}
