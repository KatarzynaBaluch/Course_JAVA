package Sekcja8_ObiektyKlasy;

import java.sql.SQLOutput;

public class MainPorownywanieInstancje {
    static class Person{
        private final String name;

        Person(String name) {
            this.name = name;
        }

        @Override //nie trzeba w nowych Javach deklarować @Override
        public boolean equals(Object obj)
        {
            //ale jak ktoś przy deklaracji instancji uzyje new Person(new String("Kasia") to bd false
            //dlatego trzeba też użyć equals na Stringu i wtedy porówna semantycznie
            return this.name.equals(((Person)obj).name); //rzutowanie Object do Person
        }
    }

    public static void main(String[] args) {
        Person p1=new Person("Kasia");
        Person p2=new Person("Kasia");
        System.out.println("p1==p2: "+(p1==p2));
        System.out.println("p1.equals(p2): "+p1.equals(p2)); //domyslna implementacja - ona używa ==, przed nadpisaniem @Override - zwróci FALSE

        System.out.println("p1.name==p2.name: "+(p1.name==p2.name));

        Person p3=p1;
        System.out.println("p1==p3: "+(p1==p3));
    }
}
