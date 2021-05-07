package Sekcja8_ObiektyKlasy; //0 lub 1 zadeklarowany

public class AnatomiaPlikuZrodlowego { //class, enum, interface, @interface - exact 1
    //fields - 0 to many
    private static int staticVar;
    private int instanceVar;

    //initializers - 0 to many - bloki inicjalizacyjne
    static {
        staticVar=0;
    }
    {
        instanceVar=1;
    }

    //constructors - 0 to many
    public AnatomiaPlikuZrodlowego(int intVar){}

    //methods - 0 to many
    public static void staticMethod()
    {
    }

    public void instanceMethod()
    {
    }


    class A{
        //klasy zagnieżdźone - można je deklatowac w klase, w metodzie, w konstruktorze itp
    }
}
