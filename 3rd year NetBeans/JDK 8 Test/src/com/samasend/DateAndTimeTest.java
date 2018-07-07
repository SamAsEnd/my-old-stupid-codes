package com.samasend;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateAndTimeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LocalDate current = LocalDate.now();
        LocalDate date = LocalDate.of(1993, Month.NOVEMBER, 30);

        System.out.println("Current: " + current);
        System.out.println("Date: " + date);
        System.out.println("Is Leap Year: " + date.isLeapYear());
        System.out.println("Length Of The Month: " + date.lengthOfMonth());
        System.out.println("Length Of The Yaar: " + date.lengthOfYear());

        //New Classes 
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);

        Duration duration = Duration.ofSeconds(50);
        Period period = Period.ofYears(1);

        System.out.println("LocalTime " + localTime);
        System.out.println("LocalDateTime " + localDateTime);
        System.out.println("ZoneId " + zoneId);
        System.out.println("ZonedDateTime " + zonedDateTime);
        System.out.println("Duration " + duration);
        System.out.println("Period " + period);
    }

}
