package Sekcja11_KolekcjeIMapy.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends LinkedHashMap<String, Object> {

    private final int maxElements;

    public Cache(int maxElements) {
        this.maxElements = maxElements;
    }

    //wskazuje najrzadziej używane, wywoływana po każdym put
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
        return size() > maxElements;
    }
}
