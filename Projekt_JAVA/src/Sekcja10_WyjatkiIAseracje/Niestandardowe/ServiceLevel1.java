package Sekcja10_WyjatkiIAseracje.Niestandardowe;

public class ServiceLevel1 {
    private final ServiceLevel2 service=new ServiceLevel2();

    public double calculate(int var)
    {
        return service.calculate(var*2);
    }
}
