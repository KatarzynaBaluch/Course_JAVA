package Sekcja15_StrumieniePliki;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionID = 1;

    private final String name;
    private final int age;
    private final transient String lastName;

    public Person(String name, int age, String lastName) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + lastName + " " + name + ", " + age + '}';
    }
}
