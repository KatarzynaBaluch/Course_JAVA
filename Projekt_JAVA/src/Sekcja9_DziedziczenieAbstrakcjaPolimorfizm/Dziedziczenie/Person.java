package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public abstract class Person implements Walkable, Eatable{
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void whoAmI()
    {
        System.out.println("I'm Person");
    }

}
