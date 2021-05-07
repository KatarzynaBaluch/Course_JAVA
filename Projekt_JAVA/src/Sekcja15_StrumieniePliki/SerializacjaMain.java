package Sekcja15_StrumieniePliki;


import java.io.*;

public class SerializacjaMain {
    public static void main(String[] args) {
        String projectPath = "C:\\Users\\User\\OneDrive - Politechnika Śląska\\Dokumenty\\JAVA\\Projekt_JAVA\\src";


        //aby móc serialozować, to obiekt musi implementować Seralizable

        //serializacja
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(projectPath + "\\person.dat"))
        ) {
            Person person = new Person("John", 23, "Smith");
            out.writeObject(person);
            System.out.println(person); //Person{Smith John, 23}
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //jesli pomiedzy zmienimy strukture klasy obiektu (np dodanie toString) to poleci wyjątek, bo serialVersionID bd inny, ID jest losowy, ale można ją samemu zdefiniować, aby samemu wersjonować obiekty. Wtedy można oczytać nawet po zmianach w klasie. Można też oznaczyć pole, które będzie ignorowane przy deserializacji transient


        //deserializacja
        try (ObjectInputStream out = new ObjectInputStream(new FileInputStream(projectPath + "\\person.dat"))
        ) {
            Object readedPerson = (Person) out.readObject();
            System.out.println(readedPerson); //Person{null John, 23} bo lastName jest transient
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }
}
