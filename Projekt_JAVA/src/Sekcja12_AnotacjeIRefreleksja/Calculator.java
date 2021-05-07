package Sekcja12_AnotacjeIRefreleksja;

public class Calculator implements ICalculator {

    @Author(name = "Kasia Baluch")
    public Calculator() {
    }

    @Override
    @Author
    @LogInutParams
    public double calculate(double income, double debt) {

        return income - debt;
    }

    @Override
    public double calculate2(double income, double debt) {

        return income - debt;
    }
}
