package Sekcja11_KolekcjeIMapy.LinkedHashSet;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class WebinarManager {

    private final Set<String> list = new LinkedHashSet<>();

    public void signUp(String emailAddress) {
        list.add(emailAddress);
        System.out.println(emailAddress + "zapisany");
    }

    public void resign(String emailAddress) {
        if (list.contains(emailAddress)) {
            list.remove(emailAddress);
            System.out.println(emailAddress + "wypisany");
        }
    }

    public void printFirstFive() {
        Set<String> top5 = new LinkedHashSet<>();
        int i = 0;
        for (String email : list) {
            i++;
            top5.add(email);
            if (i >= 5) {
                break;
            }
        }
        System.out.println("Top5: " + top5);
    }

}
