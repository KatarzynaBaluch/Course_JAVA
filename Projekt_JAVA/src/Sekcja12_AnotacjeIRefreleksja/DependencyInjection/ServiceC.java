package Sekcja12_AnotacjeIRefreleksja.DependencyInjection;

public class ServiceC {

    @Inject
    private ServiceE serviceE;

    public int getInt() {
        return serviceE.getInt() + 1;
    }
}
