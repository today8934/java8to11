package me.wooksang.java8to11.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthDay = LocalDateTime.of(1989, Month.MARCH, 4, 0, 0, 0);
        System.out.println(birthDay);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = LocalDate.of(2023, Month.MARCH, 3);
        Period period = Period.between(today, nextBirthday);

        System.out.println(period.get(ChronoUnit.DAYS));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

        LocalDate parse = LocalDate.parse("03/04/1989", dateTimeFormatter);
        System.out.println(parse);
    }
}
