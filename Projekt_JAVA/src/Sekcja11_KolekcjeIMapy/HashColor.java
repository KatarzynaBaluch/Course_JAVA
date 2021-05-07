package Sekcja11_KolekcjeIMapy;

import java.util.Random;

public class HashColor {
    private final String value;

    public HashColor(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) //sprawdzenia "zwrotna"
        {
            return true;
        }
        if (o == null) {
            return false;
        }
        if(!(o instanceof HashColor))
        {
            return false;
        }
        return this.value.equals(((HashColor) o).value);


        //return new Random().nextBoolean(); //ZABRONIONE - musi być "spójne"
    }
}
