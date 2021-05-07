package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public class Soccer extends Proffessional{
    protected int numOfGoals;
    protected int numOfCards;

    public Soccer(String name, int age) {
        super(name, age);
    }

    @Override
    protected void whoAmI()
    {
        System.out.println("I'm Soccer");
    }

    @Override
    public void eat() {
        System.out.println("I'm eating. Soccer");
    }

    @Override
    public void walk() {
        System.out.println("I'm walking. Soccer");
    }
}
