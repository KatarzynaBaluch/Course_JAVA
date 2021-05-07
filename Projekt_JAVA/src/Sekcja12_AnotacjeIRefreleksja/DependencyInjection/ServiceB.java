package Sekcja12_AnotacjeIRefreleksja.DependencyInjection;

public class ServiceB {

    @Inject
    private ServiceD serviceD;
    @Inject
    private ServiceC serviceC;

    public int getInt() {
        return serviceC.getInt() + serviceD.getInt();
    }
}
