package com.profi.jjd.lesson10.datetime.datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ZonedDateTimeExample {
    public static void getZonedDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        // Работа с временными зонами - класс ZonedDateTime (основные методы):
        // ZonedDateTime просто содержит внутри себя LocalDateTime и ZoneId
//        ZoneId - является представлением часового пояса , например Europe/Moscow

        // Все часовые пояса
        List<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        zones.forEach(System.out::println);

        // Допустим, есть объект LocalDateTime без привязки к временной зоне
        LocalDateTime someDateTime = LocalDateTime.now();

        // Чтобы привязать объект LocalDateTime к временной зоне (например, "Europe/Moscow") необходимо:
        ZonedDateTime msk = someDateTime.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println("в Москве сейчас " + formatter.format(msk)); // в Москве сейчас

        // Чтобы определить ZonedDateTime в другом часовом поясе (например, "America/New_York")
        // относительно существующего необходимо:
        ZonedDateTime ny = msk.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("в Нью-Йорке сейчас " + formatter.format(ny)); // в Нью-Йорке сейчас


        // получить зону можно следующим образом
        System.out.println(ny.getZone().getId());

        // с ZonedDateTime можно работать, как с LocalDateTime, например:
        System.out.println(ny.plusHours(8).plusMinutes(30));

    }
}
