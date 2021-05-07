package Sekcja12_AnotacjeIRefreleksja.DependencyInjection;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) throws Exception {

        ClassInitializer classInitializer = new ClassInitializer();
        ServiceA serviceA = (ServiceA) classInitializer.createInstance(ServiceA.class);
    }
}
