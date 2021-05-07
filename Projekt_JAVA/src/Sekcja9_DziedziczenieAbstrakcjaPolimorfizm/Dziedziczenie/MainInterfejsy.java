package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

import org.checkerframework.checker.units.qual.C;

public class MainInterfejsy {

    public static void main(String[] args) {

        Amateur amateur=new Amateur("Jan", 23);
        Coach coach =new Coach("Adam", 43);
        Cat cat=new Cat();

        goToWalk(amateur);
        goToWalk(coach);
        goToWalk(cat);

    }

    public static void goToWalk(Walkable walkable)
    {
        walkable.walk();
    }
}
