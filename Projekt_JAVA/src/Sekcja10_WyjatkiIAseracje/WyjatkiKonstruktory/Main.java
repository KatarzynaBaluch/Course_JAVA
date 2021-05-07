package Sekcja10_WyjatkiIAseracje.WyjatkiKonstruktory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Calculator();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
