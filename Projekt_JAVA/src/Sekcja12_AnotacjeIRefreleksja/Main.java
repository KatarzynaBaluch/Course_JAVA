package Sekcja12_AnotacjeIRefreleksja;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Person person1 = new Person("Kasia", "123", null);
        ObjectValidator.validate(person1); //nic nie wyrzuci, bo regex pasuje, dodkladnie jeden nie jest nullem i name nie jest nullem

        Person person2 = new Person(null, null, null);
        ObjectValidator.validate(person2); //poleci pierwszy możliwy wyjątek, ale: regex nie pasuje, więcej niż jedno pole null i name jest null

    }
}
