package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public class Cat implements Walkable, Eatable {
    @Override
    public void eat() {
        System.out.println("I'm eating. Cat");
    }

    @Override
    public void walk() {
        System.out.println("I'm walking. Cat");
    }
}
