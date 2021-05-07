package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public class Coach extends Proffessional{
    protected String formation;

    public Coach(String name, int age) {
        super(name, age);
    }

    @Override
    protected void whoAmI()
    {
        System.out.println("I'm Coach");
    }

    @Override
    public void eat() {
        System.out.println("I'm eating. Coach");
    }

    @Override
    public void walk() {
        System.out.println("I'm walking. Coach");
    }
}
