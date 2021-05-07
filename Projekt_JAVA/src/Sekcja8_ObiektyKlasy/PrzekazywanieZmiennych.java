package Sekcja8_ObiektyKlasy;

public class PrzekazywanieZmiennych {

    class Car{
        private int a=5;
        private String b="ford";
    }


    public void passingVariablesToMethod()
    {
        int i=10;
        String s="fiat";
        Car car=new Car();

        System.out.println("Przed wywołaniem method()");
        System.out.println("i: "+i);
        System.out.println("s: "+s);
        System.out.println("car.a: "+car.a);
        System.out.println("car.b: "+car.b);

        method(i, s, car);

        System.out.println("Po wywołaniu method()");
        System.out.println("i: "+i);
        System.out.println("s: "+s);
        System.out.println("car.a: "+car.a);
        System.out.println("car.b: "+car.b);
    }

    //pass-by-value
    public void method(int x, String y, Car c)
    {
        x=1;
        y="bmw";
        c.a=10;
        c.b="kia";
    }
}
