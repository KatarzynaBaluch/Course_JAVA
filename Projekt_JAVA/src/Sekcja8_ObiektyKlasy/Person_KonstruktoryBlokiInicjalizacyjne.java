package Sekcja8_ObiektyKlasy;

import java.math.BigDecimal;

public class Person_KonstruktoryBlokiInicjalizacyjne {
    //statycznego pola nie można dekklarować
    private static  BigDecimal RATE;
    //wyjątkiem jest inicjalizacja static CONST
    private static  BigDecimal RATE_CONST=BigDecimal.valueOf(1.1);
    //inicjalizacja bezpośrednio przy deklaracji
    private String name ="John";
    private Integer age;

    static {
        System.out.println("Static Initializer 2");
    }

    {
        System.out.println("Instance Initializer 2");
    }

    //inicjalizacja w bloku inicjalizacyjnym - pola i pola statyczne
    {
        name="John";
        RATE = BigDecimal.valueOf(10.0);
        System.out.println("Instance Initializer 1");
    }

    //inicjalizacja w statycznym bloku inicjalizacyjnym - tylko pola statyczne
    static
    {
        RATE=BigDecimal.valueOf(10.0);
        System.out.println("Static Initializer 1");
    }

    //konsktuktor niestandardowy
    public Person_KonstruktoryBlokiInicjalizacyjne(String name)
    {
        this.name=name;
        System.out.println("Konsruktor(name)");
    }


    public Person_KonstruktoryBlokiInicjalizacyjne(String name, Integer age)
    {
        //wywołanie innego konstruktora, zawsze jako pierwsza linijka
        this(name);
        this.age=age;
        System.out.println("Konsruktor(name, age)");
    }
}
