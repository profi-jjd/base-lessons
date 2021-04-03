package com.profi.jjd.lesson10.datetime.datetimeapi;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateExample {

    public static void getLocalDateDescription() {
        // Работа только с датой - класс LocalDate (основные методы):
        // Получение текущей даты
        LocalDate currentDate = LocalDate.now(); //
        System.out.println("текущая дата " + currentDate);

        // Установка определенной даты
        LocalDate someDate = LocalDate.of(2018, Month.OCTOBER, 20);
        // java.time.Month содержит все месяцы
        System.out.println("someDate " + someDate);

        // Получение даты из строки
        String strWithDate = "2017-05-14";
        LocalDate parseDate = LocalDate.parse(strWithDate);
        System.out.println("объект LocalDate из строки " + parseDate);
        // По-умолчанию метод parse() может создать объект LocalDate из строки в формате yyyy-MM-dd,
        // где yyyy - год, MM - месяц, dd - день
        // Если дата в строке имеет формат отличный от yyyy-MM-dd, то в метод parse нужно передать еще один аргумент,
        // указывающий, как нужно считывать дату
        strWithDate =  "14 декабря 2017";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy"); // определяем формат даты,
        // где dd - день, MMMM - полное название месяца, yyyy - год
        parseDate = LocalDate.parse(strWithDate, dtf);
        System.out.println("объект LocalDate из строки " + parseDate);

        // Посмотрите про синтаксис форматирования даты:
        // документация - пункт Date and Time Patterns https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        // в статье подробная таблица - https://divancoder.ru/2017/12/simpledateformat/

        // Дату можно увеличивать/уменьшать на определенное количество дней, недель, месяцев или лет
        System.out.println(parseDate.minusYears(1)); // уменьшили на 1 год (увеличение, если значение отрицательное)
        System.out.println(parseDate.minusMonths(2)); // уменьшили на 2 месяца (увеличение, если значение отрицательное)
        System.out.println(parseDate.minusWeeks(1)); // уменьшили на 1 неделю (увеличение, если значение отрицательное)
        System.out.println(parseDate.minusDays(400)); // уменьшили на 400 дней (увеличение, если значение отрицательное)

        System.out.println(parseDate.plusDays(23)); // увеличили на 23 дня (уменьшение, если значение отрицательное)
        System.out.println(parseDate.plusWeeks(2)); // увеличили на 2 недели (уменьшение, если значение отрицательное)
        System.out.println(parseDate.plusMonths(7)); // увеличили на 7 месяцев (уменьшение, если значение отрицательное)
        System.out.println(parseDate.plusYears(4)); // увеличили на 4 года (уменьшение, если значение отрицательное)

        // Каждый из этих методов возвращает обект LocalDate, соответственно, можно вызывать методы по цепочке:
        System.out.println(parseDate.plusDays(46).minusMonths(1).plusYears(20));

        // Даты можно сравнивать
        LocalDate first = LocalDate.of(2018, Month.JANUARY, 2); // 2 января 2018
        LocalDate likeFirst = LocalDate.of(2018, Month.JANUARY, 2); // 2 января 2018
        LocalDate second = LocalDate.of(2022, Month.FEBRUARY, 12); // 12 февраля 2022

        // isEqual - возвращает true, если даты равны и false, если нет
        boolean isEqual = first.isEqual(likeFirst);
        System.out.println("isEqual: 2 января 2018 / 2 января 2018: " + isEqual);

        // isAfter - возвращает true, если вызывающая метод дата идет после той, что передается в аргументе и false, если нет
        boolean isAfter = second.isAfter(first);
        System.out.println("isAfter: 12 февраля 2022 / 2 января 2018: " + isAfter);

        // isBefore - возвращает true, если вызывающая метод дата идет до той, что передается в аргументе и false, если нет
        boolean isBefore = first.isBefore(second);
        System.out.println("isBefore: 2 января 2018 / 12 февраля 2022: " + isBefore);

        // Можно определить количество дней, недель, месяцев, лет между датами

        first = LocalDate.of(2018, Month.JANUARY, 2); // 2 января 2018
        second = LocalDate.of(2022, Month.FEBRUARY, 12); // 12 февраля 2022

        // Обязательно обратите внимание на разницу между ChronoUnit и Period!!!
        // ChronoUnit:
        long between = ChronoUnit.YEARS.between(first, second); // количество лет между 2 января 2018 и 12 февраля 2022
        System.out.println("количество лет между 2 января 2018 и 12 февраля 2022 = " + between);
        between = ChronoUnit.MONTHS.between(first, second);  // количество месяцев между 2 января 2018 и 12 февраля 2022
        System.out.println("количество месяцев между 2 января 2018 и 12 февраля 2022 = " + between);
        between = ChronoUnit.WEEKS.between(first, second);  // количество недель между 2 января 2018 и 12 февраля 2022
        System.out.println("количество недель между 2 января 2018 и 12 февраля 2022 = " + between);
        between = ChronoUnit.DAYS.between(first, second);  // количество дней между 2 января 2018 и 12 февраля 2022
        System.out.println("количество дней между 2 января 2018 и 12 февраля 2022 = " + between);

        // Period:
        between = Period.between(first, second).getYears(); // количество лет между 2 января 2018 и 12 февраля 2022
        System.out.println("количество лет между 2 января 2018 и 12 февраля 2022 = " + between);
        between = Period.between(first, second).getMonths();  // количество месяцев между 2 января и 12 февраля - учитываются только месяцы
        System.out.println("количество месяцев между 2 января 2018 и 12 февраля 2022 = " + between);
        between = Period.between(first, second).getDays();  // количество дней между 2  и 12 - учитываются только дни
        System.out.println("количество дней между 2 января 2018 и 12 февраля 2022 = " + between);

        // Форматированный вывод даты
        LocalDate dateNow = LocalDate.now();
        System.out.println("dateNow " + dateNow);

        // для вывода в желаемом формате необходимо использовать DateTimeFormatter
        // устанавливаем шаблон, по которому дата будет преобразована к строке
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyг.");

        // вызов метода format для форматированного вывода
        String dateToStr = formatter.format(dateNow);
        System.out.println("dateToStr " + dateToStr);


    }
}
