package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public abstract class SoccerFun extends Person{
    protected String favPlayer;
    protected String favClub;

    public SoccerFun(String name, int age) {
        super(name, age);
    }

    @Override
    protected void whoAmI()
    {
        System.out.println("I'm SoccerFun");
    }
}
