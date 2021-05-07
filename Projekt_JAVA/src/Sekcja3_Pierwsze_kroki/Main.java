package Sekcja3_Pierwsze_kroki;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello" + "world"); //KONKATYNACJA "suma stringów
        System.out.println(args[2]);


        //klasy o obiekty
        Person person=new Person("Jerry");
        person.setAge(22);
        System.out.println(person);

        Car car=new Car("Honda", 2020);
        car.setMileage(2222.2);
        car.setOwner(person);

        System.out.println(car);

        //odczyt danych z konsoli
        System.out.println("Podaj Imię: ");
        Scanner in=new Scanner(System.in);
        String name = in.next();
        System.out.println("Nazywasz się "+name);



    }
}
