package Sekcja12_AnotacjeIRefreleksja;

@ExactlyOneNotNull({"nip", "pesel"})
public class Person {
    @Regex(value = "[a-zA-Z]*", message = "Field name has invalid regex") //jak jest jedna wlasciwosc nie trzeba jej nazwy pisać, jak więcej trzeba nazwę i wartośc
    @NotNull(message = "Field name must be not null")
    private String name;
    private String nip;
    private String pesel;

    public Person(String name, String nip, String pesel) {
        this.name = name;
        this.nip = nip;
        this.pesel = pesel;
    }
}
