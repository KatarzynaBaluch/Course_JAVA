package Sekcja10_WyjatkiIAseracje.Niestandardowe;

public class ServiceLevel2 {
    private final ServiceLevel3 service=new ServiceLevel3();

    public double calculate(int var)
    {
        return (var+10)*service.calculate(var);
    }
}
