package Sekcja12_AnotacjeIRefreleksja.DependencyInjection;

public class ServiceA {

    @Inject
    private ServiceD serviceD;
    @Inject
    private ServiceB serviceB;

    public int getInt() {
        return serviceB.getInt() + serviceD.getInt();
    }
}
