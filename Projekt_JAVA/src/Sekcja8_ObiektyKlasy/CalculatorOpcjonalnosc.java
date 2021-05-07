package Sekcja8_ObiektyKlasy;

import java.util.Optional;

public class CalculatorOpcjonalnosc {
    public static Optional<Double> calculate(Integer factor1, Optional<Double> factor2)
    {
        //1 sposób
        if(factor2.isPresent()) {
            return Optional.of(factor1 * factor2.get());
        }
        return Optional.empty();

        //2 sposób
        //return Optional.of(factor1*factor2.orElse(1.0));

    }
}
