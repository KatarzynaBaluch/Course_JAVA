package Sekcja13_InternacjonalizacjaLokalizacjaCzas;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String date1 = "2020-03-11 10:00";
        System.out.println(date1); //2020-03-11 10:00

        long now = System.currentTimeMillis();
        System.out.println(now); //1609324899396

        Date date2 = new Date(); //stare API
        System.out.println(date2); //Wed Dec 30 11:41:39 CET 2020

        Date date3 = new Date(Long.MAX_VALUE); //na jak długo wystarczy longa
        System.out.println(date3); //Sun Aug 17 08:12:55 CET 292278994

        //_______________________________________________________________

        //Time API
        Month month = Month.DECEMBER;
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;

        LocalDate localDate = LocalDate.of(2020, 03, 11);
        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDate nextFridayFromLocalDate = localDate.with(adj);
        System.out.println(nextFridayFromLocalDate); //2020-03-13

        LocalDate localDateMinus5Months = localDate.minus(5, ChronoUnit.MONTHS);
        System.out.println(localDateMinus5Months); //2019-10-11

        YearMonth yearMonth = YearMonth.of(2010, Month.FEBRUARY);
        System.out.println(yearMonth.lengthOfMonth()); //28 (ile dni miał luty)

        LocalDate date4 = LocalDate.of(2010, 2, 5);
        LocalTime time = LocalTime.of(12, 20);
        System.out.println(time); //12:20

        LocalDateTime localDateTime1 = LocalDateTime.of(date4, time);
        System.out.println(localDateTime1); //2010-02-05T12:20

        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 12, 31, 12, 34);
        System.out.println(localDateTime2); //2020-12-31T12:34

        //System.out.println(ZoneId.getAvailableZoneIds()); //[Asia/Aden, America/Cuiaba, Etc/GMT+9 ... Europe/Warsaw, America/Chicago, ...]
        ZoneId warsawZone = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime1, warsawZone);
        System.out.println(zonedDateTime); //2010-02-05T12:20+01:00[Europe/Warsaw]

        ZoneOffset zoneOffset = ZoneOffset.of("+01:00"); //musi być poprawny!, nie można wpisać np. "+111:00"
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime1, zoneOffset);
        System.out.println(offsetDateTime); //2010-02-05T12:20+01:00

        Instant instant = Instant.now();
        LocalDate localDateOfInstant = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateOfInstant); //2020-12-30

        Instant instant2 = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
        System.out.println(instant2); //2020-03-11T00:00:00Z

        //_______________________________________________________________

        String dateStr = "2020/12-10";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM-dd");
        LocalDate localDateFromStr = LocalDate.parse(dateStr, dateTimeFormatter);
        System.out.println(localDateFromStr); //2020-12-10

        //_______________________________________________________________

        long duration = Duration.between(localDateFromStr.atStartOfDay().toInstant(ZoneOffset.UTC), Instant.now()).toDays();
        System.out.println(duration); //20

        //_______________________________________________________________

        Period period = Period.ofMonths(2);
        LocalDate dateFromStrMinusPeriod = localDateFromStr.minus(period);
        System.out.println(dateFromStrMinusPeriod); //2020-10-10

        Period periodBetween = Period.between(localDateFromStr, LocalDate.now());
        System.out.println(periodBetween.getDays()); //20

    }
}
