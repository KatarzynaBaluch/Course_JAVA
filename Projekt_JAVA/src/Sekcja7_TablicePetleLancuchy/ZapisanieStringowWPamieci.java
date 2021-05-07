package Sekcja7_TablicePetleLancuchy;

import java.util.Objects;

public class ZapisanieStringowWPamieci {
    public static void main(String args[])
    {
        String car1="Car";
        String car2="Car";
        String car3=new String("Car");
        String car4=new String("Car");

        System.out.println("1==2 "+(car1==car2));
        System.out.println("3==4 "+(car3==car4));
        System.out.println("1==3 "+(car1==car3));
        System.out.println("2==4.intern "+(car2==car4.intern()));

        //porównujemy przez equals
        String car5=null;
        //System.out.println("5==2 "+(car5.equals(car2))); // poleci NullPointerException bo porówbujemy do nulla

        //dlatego

        System.out.println("5==2 "+(Objects.equals(car5,car2)));


    }
}
