package Sekcja8_ObiektyKlasy;


import static java.util.Optional.*;
import static Sekcja8_ObiektyKlasy.GenderClass.MALE;

public class ImportOptional {
    public static void main(String[] args) {
        //CalculatorOpcjonalnosc.calculate(10, Optional.empty()); //bez importu
        CalculatorOpcjonalnosc.calculate(10, empty()); //po imporcie nie trzeba dawać Optional


        System.out.println(MALE); //po imporcie można używać statyczne bez nazwy klasy

    }
}
