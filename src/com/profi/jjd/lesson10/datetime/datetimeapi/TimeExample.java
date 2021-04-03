package com.profi.jjd.lesson10.datetime.datetimeapi;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeExample {
    public static void getLocalTimeDescription(){
        // Работа только со временем - класс LocalTime (основные методы):
        // Получение текущего времени
        LocalTime currentTime = LocalTime.now(); //
        System.out.println("текущее время " + currentTime);

        // Установка определенного времени
        LocalTime someTime = LocalTime.of(20, 50);
        someTime = LocalTime.of(20, 50, 44);
        System.out.println("someTime " + someTime);

        // Получение времени из строки
        String strWithTime = "23:56:05"; //hour:minute:second
        LocalTime parseTime = LocalTime.parse(strWithTime);
        System.out.println("объект LocalTime из строки " + parseTime);
        // По-умолчанию метод parse() может создать объект LocalTime из строки в формате HH:mm:ss,
        // где HH - часы, mm - минуты, ss - секунды
        // Если время в строке имеет формат отличный от HH:mm:ss, то в метод parse нужно передать еще один аргумент,
        // указывающий, как нужно считывать время
        strWithTime =  "в 23 часа 45 минут и 49 секунд";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("в HH часа mm минут и ss секунд"); // определяем формат времени,
        parseTime = LocalTime.parse(strWithTime, dtf);
        System.out.println("объект LocalDate из строки " + parseTime);

        // Посмотрите про синтаксис форматирования времени:
        // документация - пункт Date and Time Patterns https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        // в статье подробная таблица - https://divancoder.ru/2017/12/simpledateformat/

        // Время можно увеличивать/уменьшать на определенное количество часов, минут, секунд или наносекунд
        System.out.println(parseTime.minusHours(1)); // уменьшили на 1 час (увеличение, если значение отрицательное)
        System.out.println(parseTime.minusMinutes(40)); // уменьшили на 40 минут (увеличение, если значение отрицательное)
        System.out.println(parseTime.minusSeconds(1465)); // уменьшили на 1465 секунд (увеличение, если значение отрицательное)
        System.out.println(parseTime.minusNanos(20)); // уменьшили на 20 наносекунд (увеличение, если значение отрицательное)

        System.out.println(parseTime.plusHours(10)); // увеличили на 10 часов (уменьшение, если значение отрицательное)
        System.out.println(parseTime.plusMinutes(55)); // увеличили на 55 минут (уменьшение, если значение отрицательное)
        System.out.println(parseTime.plusSeconds(72)); // увеличили на 72 секунды (уменьшение, если значение отрицательное)
        System.out.println(parseTime.plusNanos(43299)); // увеличили на 43299 наносекунд (уменьшение, если значение отрицательное)

        // Каждый из этих методов возвращает объект LocalTime, соответственно, можно вызывать методы по цепочке:
        System.out.println(parseTime.minusHours(2).plusMinutes(22)); // и тд

        // Время можно сравнивать
        LocalTime first = LocalTime.of(20, 30, 10); // 20 часов 30 минут 10 секунд
        LocalTime likeFirst = LocalTime.of(20, 30, 10); // 20 часов 30 минут 10 секунд
        LocalTime second = LocalTime.of(23, 10, 56); // 23 часа 10 минут 56 секунд

        // equals - возвращает true, если объекты времени равны и false, если нет
        boolean equals = first.equals(likeFirst);
        System.out.println("equals: 20:30:10 / 20:30:10 " + equals);

        // isAfter - возвращает true, если вызывающий метод объект времени идет после того, что передается в аргументе и false, если нет
        boolean isAfter = second.isAfter(first);
        System.out.println("isAfter: 23:10:56 / 20:30:10 " + isAfter);

        // isBefore - возвращает true, если вызывающая метод объект времени идет до того, что передается в аргументе и false, если нет
        boolean isBefore = first.isBefore(second);
        System.out.println("isBefore: 20:30:10 / 23:10:56 " + isBefore);

        // Можно определить количество часов, минут, секунд и тд между объектами времени

        first = LocalTime.of(20, 30, 10); // 20 часов 30 минут 10 секунд
        second = LocalTime.of(23, 10, 56); // 23 часа 10 минут 56 секунд

        // Вариант 1 - ChronoUnit:
        long between = ChronoUnit.HOURS.between(first, second); // количество часов между 20:30:10 и 23:10:56
        System.out.println("количество часов между 20:30:10 и 23:10:56 = " + between);
        between = ChronoUnit.MINUTES.between(first, second);  // количество минут между 20:30:10 и 23:10:56
        System.out.println("количество минут между 20:30:10 и 23:10:56 = " + between);
        between = ChronoUnit.SECONDS.between(first, second);  // количество секунд между 20:30:10 и 23:10:56
        System.out.println("количество секунд между 20:30:10 и 23:10:56 = " + between);
        between = ChronoUnit.MILLIS.between(first, second);  // количество миллисекунд между 20:30:10 и 23:10:56
        System.out.println("количество миллисекунд между 20:30:10 и 23:10:56 = " + between);

        // Вариант 2 - Duration:
        between = Duration.between(first, second).toHours(); // количество часов между 20:30:10 и 23:10:56
        System.out.println("количество часов между 20:30:10 и 23:10:56 = " + between);
        between = Duration.between(first, second).toMinutes();  // количество минут между 20:30:10 и 23:10:56
        System.out.println("количество минут между 20:30:10 и 23:10:56 = " + between);
        between = Duration.between(first, second).toSeconds(); // количество секунд между 20:30:10 и 23:10:56
        System.out.println("количество секунд между 20:30:10 и 23:10:56 = " + between);

        // Форматированный вывод времени
        LocalTime timeNow = LocalTime.now();
        System.out.println("timeNow " + timeNow);

        // для вывода в желаемом формате необходимо использовать DateTimeFormatter
        // устанавливаем шаблон, по которому время будет преобразовано к строке
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("в H ч. и mm мин.");

        // вызов метода format для форматированного вывода
        String timeToStr = formatter.format(timeNow);
        System.out.println("timeToStr " + timeToStr);

    }
}

