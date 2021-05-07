package Sekcja10_WyjatkiIAseracje.Niestandardowe;

public class ServiceLevel3 {
    private final ServiceLevel4 service=new ServiceLevel4();

    public double calculate(int var)
    {
        return 10*service.calculate(var);
    }
}
