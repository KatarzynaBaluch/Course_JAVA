package Sekcja12_AnotacjeIRefreleksja;

public class Main2 {
    public static void main(String[] args) {
        ICalculator iCalculator = ProxyCreator.createProxy(new Calculator());

        iCalculator.calculate(10.0, 10.0);
        iCalculator.calculate2(20.0, 20.0);
    }
}
