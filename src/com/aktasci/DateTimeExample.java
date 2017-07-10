package com.aktasci;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;

public class DateTimeExample {

    public static void main(String[] args) {

        DateTimeExample dtEx = new DateTimeExample();

        dtEx.testLocal();
        dtEx.testZoned();
        dtEx.testChronoUnits();
        dtEx.testPeriodAndDuration();
        dtEx.testTemporalAdjuster();
    }

    private void testTemporalAdjuster() {
        System.out.println("Testing temporal adjuster");
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        LocalDate nextTuesday = localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("nextTuesday = " + nextTuesday);
    }

    private void testChronoUnits() {
        //Chrono Units Enum
        System.out.println("Testing Chrono");
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        LocalDate nextWeek = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("nextWeek = " + nextWeek);

        LocalDate nextMonth = localDate.plus(1, ChronoUnit.MONTHS);
        System.out.println("nextMonth = " + nextMonth);

        LocalDate nextYear = localDate.plus(1, ChronoUnit.YEARS);
        System.out.println("nextYear = " + nextYear);

        LocalDate nextCentury = localDate.plus(1, ChronoUnit.CENTURIES);
        System.out.println("nextCentury = " + nextCentury);

        LocalDate nextMillenia = localDate.plus(1, ChronoUnit.MILLENNIA);
        System.out.println("nextMillenia = " + nextMillenia);
    }

    private void testPeriodAndDuration() {

        System.out.println("Testing Period and Duration");
        //Period − It deals with date based amount of time.
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.plus(1, ChronoUnit.MONTHS);
        Period period = Period.between(localDate1, localDate2);
        System.out.println("period = " + period);
        long totalMonths = period.toTotalMonths();
        System.out.println("totalMonths = " + totalMonths);

        //Duration −It deals with time based amount of time.
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.plus(5, ChronoUnit.HOURS);
        Duration duration = Duration.between(localTime, localTime1);
        System.out.println("duration = " + duration);
        long hours = duration.toHours();
        System.out.println("hours = " + hours);
    }

    private void testZoned() {

        System.out.println("Testing Zoned");
        //Zoned Date-Time API is used when time zone is to be consiedered
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2017-07-10T14:15:38.146+03:00");
        System.out.println("zonedDateTime1 = " + zonedDateTime1);

        ZoneId zoneId = ZoneId.of("Europe/Istanbul");
        System.out.println("zoneId = " + zoneId);

        ZoneId zoneId1 = ZoneId.systemDefault();
        System.out.println("zoneId1 = " + zoneId1);
    }

    private void testLocal() {

        System.out.println("Testing Local");
        //Local Date-Time API has no complexity of timezone handling
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("currentTime = " + currentTime);

        LocalDate localDate = currentTime.toLocalDate();
        System.out.println("localDate = " + localDate);

        LocalTime localTime = currentTime.toLocalTime();
        System.out.println("localTime = " + localTime);

        Month month = currentTime.getMonth();
        System.out.println("month = " + month);

        int dayOfMonth = currentTime.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        int second = currentTime.getSecond();
        System.out.println("second = " + second);

        LocalDateTime localDateTime = currentTime.withDayOfMonth(10).withMonth(6).withYear(2012);
        System.out.println("localDateTime = " + localDateTime);

        LocalDate localDate1 = LocalDate.of(2012, 6, 10);
        System.out.println("localDate1 = " + localDate1);

        LocalDate localDate2 = LocalDate.parse("2012-06-10");
        System.out.println("localDate2 = " + localDate2);

        LocalDate localDate3 = LocalDate.parse("10.06.2012", DateTimeFormatter.ofPattern("dd.MM.uuuu"));
        System.out.println("localDate3 = " + localDate3);

        LocalTime localTime1 = LocalTime.of(22, 5);
        System.out.println("localTime1 = " + localTime1);

        LocalTime localTime2 = LocalTime.parse("20:15:12");
        System.out.println("localTime2 = " + localTime2);
    }
}
