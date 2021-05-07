package Sekcja10_WyjatkiIAseracje;

import Sekcja8_ObiektyKlasy.CalculatorOpcjonalnosc;

import java.io.IOException;

public class MainObslugaSytuacjiWyjatkowych {
    public static void main(String[] args) throws IOException {

        System.out.println(">> Checked Exception (1)");
        new Calculator().calculate_checked("*ERROR*");

        //System.out.println(">> Checked Exception (2)");
        //new Calculator().calculate_checked2();

        System.out.println(">> Unchecked Exception");
        new Calculator().calculate_unchecked();


    }
}
