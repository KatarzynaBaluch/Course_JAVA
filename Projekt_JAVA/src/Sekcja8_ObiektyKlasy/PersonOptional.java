package Sekcja8_ObiektyKlasy;

import java.util.Optional;

public class PersonOptional {
    String name;

    @Override
    public boolean equals(Object obj)
    {
        if (Optional.ofNullable(this.name).isEmpty())
        {
            return false;
        }
        final String name=((PersonOptional)obj).name;
        if(Optional.ofNullable(name).isEmpty())
        {
            return false;
        }

        return (this.name.equals(name));
    }
}
