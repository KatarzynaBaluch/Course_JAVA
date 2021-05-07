package Sekcja13_InternacjonalizacjaLokalizacjaCzas;

import java.time.Duration;
import java.time.Instant;

public class Zadanie2 {
    public static void main(String[] args) {

        Instant start = Instant.now();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            int operation = 45 / 5;
        }
        Instant stop = Instant.now();
        long ms = Duration.between(start, stop).toMillis();

        System.out.println("Program took " + ms + " ms");
    }
}
