package Sekcja13_InternacjonalizacjaLokalizacjaCzas;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class Zadanie1 {
    public static void main(String[] args) {
        Date now = new Date();
        final LocalDateTime startDate = LocalDateTime.of(2020, 2, 1, 20, 0);
        final LocalDateTime endDate = LocalDateTime.of(2025, 10, 30, 12, 0);

        System.out.println(isBetween(startDate, endDate, now));
    }

    private static boolean isBetween(LocalDateTime startDate, LocalDateTime endDate, Date dateToCompare) {

        final LocalDateTime localDateTime = LocalDateTime.ofInstant(dateToCompare.toInstant(), ZoneId.systemDefault());

        return (startDate.isBefore(localDateTime) || startDate.isEqual(localDateTime))
                && (endDate.isAfter(localDateTime) || endDate.isEqual(localDateTime));

    }
}
