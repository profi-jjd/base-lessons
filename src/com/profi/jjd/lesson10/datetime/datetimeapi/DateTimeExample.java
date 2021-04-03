package com.profi.jjd.lesson10.datetime.datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

// статический импорт статического метода lastDayOfMonth из класса TemporalAdjusters позволит
// вызвать метод без обращения к классу
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class DateTimeExample {
    public static void getLocalDateTimeDescription(){

        // Работа с датой и временем - класс LocalDateTime (основные методы):
        // Получение текущей даты и времени
        LocalDateTime current = LocalDateTime.now();
        System.out.println("текущая дата и время" + current);

        // Установка определенной даты и времени (в описани класса посмотрите использование метода с разными парамертами  - ctrl + правая кнопка мыши)
        LocalDateTime some = LocalDateTime.of(2018, Month.OCTOBER, 20, 15, 45);
        // java.time.Month содержит все месяцы
        System.out.println("some " + some);

        // Получение даты и времени из строки
        String strWithDate = "2017-05-14T23:10:00";
        LocalDateTime parseDate = LocalDateTime.parse(strWithDate);
        System.out.println("объект LocalDateTime из строки " + parseDate);
        // По-умолчанию метод parse() может создать объект LocalDate из строки в формате yyyy-MM-ddTHH:mm:ss,
        // где yyyy - год, MM - месяц, dd - день, HH - часы, mm - минуты, ss - секунды
        // Если дата в строке имеет формат отличный от yyyy-MM-ddTHH:mm:ss, то в метод parse нужно передать еще один аргумент,
        // указывающий, как нужно считывать дату и время
        strWithDate =  "22 декабря 2009 в 15 00";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH mm"); // определяем формат даты,
        // где dd - день, MMMM - полное название месяца, yyyy - год, HH - часы, mm - минуты
        parseDate = LocalDateTime.parse(strWithDate, dtf);
        System.out.println("объект LocalDateTime из строки " + parseDate);

        // Посмотрите про синтаксис форматирования даты:
        // документация - пункт Date and Time Patterns https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        // в статье подробная таблица - https://divancoder.ru/2017/12/simpledateformat/

        // Дату (LocalDateTime) можно увеличивать/уменьшать на определенное количество дней, недель, месяцев, лет, часов, минут и тд
        // для этого необходимо использовать методы аналогичные тем, которые были рассмотрены в классах LocalTime и LocalDate
        // Каждый из этих методов возвращает обект LocalDateTime, соответственно, можно вызывать методы по цепочке:
        LocalDateTime ldt = parseDate.plusMinutes(22)
                .plusHours(10)
                .plusMonths(12)
                .plusWeeks(1)
                .minusYears(30);

        // Даты можно сравнивать (по аналогии с LocalDate)
        LocalDateTime first = LocalDateTime.of(1999, Month.JULY, 10, 10, 20); // 10 июля 1999 10:20
        LocalDateTime likeFirst = LocalDateTime.of(1999, Month.JULY, 10, 10, 20); // 10 июля 1999 10:20
        LocalDateTime second = LocalDateTime.of(2057, Month.APRIL, 1, 22, 30); // 1 апреля 2057 22:30

        // isEqual - возвращает true, если даты равны и false, если нет
        boolean isEqual = first.isEqual(likeFirst);
        System.out.println("isEqual: 10 июля 1999 10:20 / 10 июля 1999 10:20 " + isEqual);

        // isAfter - возвращает true, если вызывающая метод дата идет после той, что передается в аргументе и false, если нет
        boolean isAfter = second.isAfter(first);
        System.out.println("isAfter: 1 апреля 2057 22:30 / 10 июля 1999 10:20 " + isAfter);

        // isBefore - возвращает true, если вызывающая метод дата идет до той, что передается в аргументе и false, если нет
        boolean isBefore = first.isBefore(second);
        System.out.println("isBefore: 10 июля 1999 10:20 / 1 апреля 2057 22:30 " + isBefore);

        // Можно определить количество секунд, минут, часов, дней, недель, месяцев, лет и тд между датами
        //

        first = LocalDateTime.of(1999, Month.JULY, 10, 10, 20); // 10 июля 1999 10:20
        second = LocalDateTime.of(2057, Month.APRIL, 1, 22, 30); // 1 апреля 2057 22:30

        // ChronoUnit:
        System.out.println("использование ChronoUnit");
        long between = ChronoUnit.YEARS.between(first, second); // количество лет между 10 июля 1999 10:20 и 1 апреля 2057 22:30
        between = ChronoUnit.MONTHS.between(first, second);  // количество месяцев между 10 июля 1999 10:20 и 1 апреля 2057 22:30
        between = ChronoUnit.WEEKS.between(first, second);  // количество недель между 10 июля 1999 10:20 и 1 апреля 2057 22:30
        between = ChronoUnit.DAYS.between(first, second);  // количество дней между 10 июля 1999 10:20 и 1 апреля 2057 22:30
        between = ChronoUnit.HOURS.between(first, second);  // количество часов между 10 июля 1999 10:20 и 1 апреля 2057 22:30
        between = ChronoUnit.MINUTES.between(first, second);  // количество минут между 10 июля 1999 10:20 и 1 апреля 2057 22:30

        // Для использование Duration объект LocalDateTime необходимо привести к типу LocalDate - метод toLocalDate()
        // Для использование Period объект LocalDateTime необходимо привести к типу LocalTime - метод toLocalTime()
        // далее можно использовать соответствующие методы, которые были рассмотрены в классах LocalTime и LocalDate

        // Форматированный вывод даты и времени
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("currentDateTime " + currentDateTime);

        // для вывода в желаемом формате необходимо использовать DateTimeFormatter
        // устанавливаем шаблон, по которому дата будет преобразована к строке
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");

        // вызов метода format для форматированного вывода
        String dateTimeToStr = formatter.format(currentDateTime);
        System.out.println("dateTimeToStr " + dateTimeToStr);


        System.out.println(Month.APRIL); // месяцы
        System.out.println(DayOfWeek.SATURDAY); // дни недели
        System.out.println(LocalDateTime.now().getDayOfWeek());
        System.out.println(LocalDateTime.now().plus(45, ChronoUnit.CENTURIES));
        // System.out.println(LocalDateTime.now().plus(Period.ofWeeks(5)));
        System.out.println(LocalDateTime.now().minus(some.getDayOfMonth(), ChronoUnit.MONTHS));
        // System.out.println(LocalDateTime.now().minus(Duration.ofDays(4)));

        System.out.println(MonthDay.from(LocalDateTime.now()));
        System.out.println(DayOfWeek.from(LocalDateTime.now()));

        // TemporalAdjuster adjuster
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));

        System.out.println(LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        // статический импорт позволит вызвать метод без обращения к классу, те вместо
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()));
        // можно обратиться
        System.out.println(LocalDateTime.now().with(lastDayOfMonth()));

        System.out.println(LocalDateTime.now().toLocalDate());
        System.out.println(LocalDateTime.now().toLocalTime());
    }
}
