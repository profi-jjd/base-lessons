package com.profi.jjd.lesson10.datetime.datetimeapi;


public class TstDateTime {
    public static void main(String[] args) {
        // DateTime API - работа с датой и временем java 8
        // Классы для работы с датой и временем находятся в пакете java.time:
        // LocalDate –  дата без времени и временных зон;
        // LocalTime – время без даты и временных зон;
        // LocalDateTime – дата и время без временных зон;
        // ZonedDateTime – дата и время с временной зоной;
        // DateTimeFormatter – форматирует даты в строки и наоборот, только для классов java.time;
        // Instant – количество секунд с Unix epoch time (полночь 1 января 1970);
        // Duration – продолжительность в секундах и наносекундах;
        // Period – период времени в годах, месяцах и днях;
        // TemporalAdjusters – набор статических методов для получения даты на основе существующей, например: dayOfWeekInMonth, firstDayOfNextMonth, firstDayOfYear и тп;

        // Использование классов LocalDate, LocalTime и LocalDateTime очень схожи!

        // работа с датой LocalDate (примеры):
//        DateExample.getLocalDateDescription();


        // работа со временем LocalTime (примеры):
//        TimeExample.getLocalTimeDescription();

        // работа с датой и временем LocalDateTime (примеры):
        DateTimeExample.getLocalDateTimeDescription();

        // работа с временными зонами ZonedDateTime (примеры):
//        ZonedDateTimeExample.getZonedDescription();

    }
}
