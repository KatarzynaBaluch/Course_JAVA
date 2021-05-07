package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public abstract interface Walkable {

    //wyszarzone - nie trzeba ich pisać

    public static final String name = "hello";

    public abstract void walk();

    public default void doIt() //od Java 8, prywatnych domyslnych nie mozna
    {
        System.out.println("Do it");
    }

    private void privMethod() //od Java 9
    {
        System.out.println("privMethod()");
    }

    public static int staticInt() //protected static nie mozna
    {
        return 1;
    }

    private static int privateStaticInt() {
        return 1;
    }
}
