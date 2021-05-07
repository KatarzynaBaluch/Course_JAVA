package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public abstract class Proffessional extends SoccerFun {
    protected int numofTrophies;
    protected String currentClub;
    protected double salary;

    public Proffessional(String name, int age) {
        super(name, age);
    }

    @Override
    protected void whoAmI()
    {
        System.out.println("I'm Proffessional");
    }


}
