package Sekcja3_Pierwsze_kroki;

public class Person {
    private final String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
