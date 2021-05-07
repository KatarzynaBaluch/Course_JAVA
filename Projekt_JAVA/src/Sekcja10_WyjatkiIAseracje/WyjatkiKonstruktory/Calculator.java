package Sekcja10_WyjatkiIAseracje.WyjatkiKonstruktory;

import java.io.IOException;

public class Calculator {
    int x=5;

    {
        if (x == 4)
        {
            throw  new RuntimeException();
        }
    }

    public Calculator() throws IOException {
        throw new IOException();
    }
}

