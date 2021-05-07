package Sekcja8_ObiektyKlasy;

import java.util.Optional;

public class OpcjonalnoscZmiennych {
    public static void main(String[] args) {
        //new CalculatorOpcjonalnosc().calculate(10,10.0);
        //new CalculatorOpcjonalnosc().calculate(10, null); //jeśli nie zabezpieczymy przed nullem poleci NullPointerException
        new CalculatorOpcjonalnosc().calculate(10, Optional.empty());
        new CalculatorOpcjonalnosc().calculate(10, Optional.of(10.0));
        new CalculatorOpcjonalnosc().calculate(10, Optional.ofNullable(null));

        final Optional<Double> result=new CalculatorOpcjonalnosc().calculate(10, Optional.ofNullable(null));
        if(result.isPresent())
        {
            result.get().intValue();
        }

    }
}
