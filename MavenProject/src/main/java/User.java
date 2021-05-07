import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("name") //jeśli pole ma inną nazwę, a my chcemy w klasie inny opis tego pola
    private String n;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getN() {
        return n;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User(" + id + "): " + n;
    }
}
