package com.profi.jjd.lesson16.tasks.pupils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {

        // Используя Stream API:
        List<Pupil> pupils = new ArrayList<>(Arrays.asList(
                new Pupil(UUID.randomUUID(), "Женя", Pupil.Gender.MALE, LocalDate.now().minusYears(10)),
                new Pupil(UUID.randomUUID(), "Олег", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(UUID.randomUUID(), "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Pupil(UUID.randomUUID(), "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(12)),
                new Pupil(UUID.randomUUID(), "Алексей", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(UUID.randomUUID(), "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(UUID.randomUUID(), "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(17)),
                new Pupil(UUID.randomUUID(), "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(5)),
                new Pupil(UUID.randomUUID(), "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Pupil(UUID.randomUUID(), "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(UUID.randomUUID(), "Григорий", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(UUID.randomUUID(), "Ирина", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));
        System.out.println(pupils);

        // 1. Разделить учеников на две группы: мальчиков и девочек.
        // Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        // Map<Pupil.Gender, ArrayList<Pupil>> Pupil::getGender
        // Pupil.Gender.MALE : ArrayList<Pupil>: "Женя", "Олег", "Иван"
        // Pupil.Gender.FEMALE : ArrayList<Pupil>: "Алена",
        Map<Pupil.Gender, ArrayList<Pupil>> byGender = pupils.stream()
                .collect(
                        Collectors.groupingBy(Pupil::getGender,
                                Collectors.toCollection(ArrayList::new))
                );

        // 2. Найти средний возраст учеников
        double avgAge = pupils.stream()
                .mapToInt(pupil-> LocalDate.now().getYear() - pupil.getBirth().getYear())
                .average().orElse(0);

        // 3. Найти самого младшего ученика
        Pupil minAge = pupils.stream()
                .max(Comparator.comparing(Pupil::getBirth))
                .get();

        // 4. Найти самого взрослого ученика

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Pupil>> byYear = pupils.stream()
                .collect(
                        Collectors.groupingBy(pupil -> pupil.getBirth().getYear())
                );

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.

        // 7. Отсортировать по полу, потом по дате рождения,
        // потом по имени (в обратном порядке), собрать в список (List)
        pupils.sort(
                Comparator.comparing(Pupil::getGender)
                    .thenComparing(Comparator.comparing(Pupil::getBirth))
                    .thenComparing(Comparator.comparing(Pupil::getName).reversed())
        );

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName
        String name = "Петр";
        List<Pupil> byName = pupils.stream()
                .filter(pupil -> pupil.getName().equals(name))
                .collect(Collectors.toList());

        // 10. Собрать Map<Pupil.Gender, Integer>,
        // где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        // Pupil.Gender, Integer
        // Pupil.Gender.MALE : 25
        // Pupil.Gender.FEMALE : 6
        Map<Pupil.Gender, Integer> genderAge =  pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.summingInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())));


        // IO API
        // Сериализация и десериализация
        // NIO API

        // Вложенные и анонимные классы
        // Паттерны













    }
}