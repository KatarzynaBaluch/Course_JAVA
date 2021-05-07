package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public class Amateur extends SoccerFun {
    protected String playSpot;

    public Amateur(String name, int age) {
        super(name, age);
    }


    @Override
    protected void whoAmI()
    {
        System.out.println("I'm Amateur");
    }

    public void amateur()
    {
        System.out.println("amateur void");
    }

    @Override
    public void eat() {
        System.out.println("I'm eating. Amateur");
    }

    @Override
    public void walk() {
        System.out.println("I'm walking. Amateur");
    }
}
