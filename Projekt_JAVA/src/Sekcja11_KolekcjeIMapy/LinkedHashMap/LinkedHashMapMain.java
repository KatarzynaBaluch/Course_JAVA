package Sekcja11_KolekcjeIMapy.LinkedHashMap;

import java.util.Map;

public class LinkedHashMapMain {
    public static void main(String[] args) {

        Map<String, String> map = new java.util.LinkedHashMap<>(10, 0.75f, true); //taki konstruktor uporządkuje mapę od najczęściej do najrzadziej używanych

        map.put("Blue", null);
        map.put("Red", null);
        map.put("Black", null);

        System.out.println(map); //{Blue=null, Red=null, Black=null}

        map.get("Red");
        System.out.println(map); //{Blue=null, Black=null, Red=null} - używaliśmy "Red", więc idzie na koniec

        //____________________________________________________________

        Cache cache = new Cache(2);

        cache.put("Blue", null);
        cache.put("Red", null);
        cache.put("Black", null);

        System.out.println(cache); //{Red=null, Black=null}, bo zadeklarowano pojemność =2, czyli najstarszy - "Blue" został usunięty

    }
}
