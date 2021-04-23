package com.profi.jjd.lesson16.tasks.pupils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        // 2. Найти средний возраст учеников

        // 3. Найти самого младшего ученика

        // 4. Найти самого взрослого ученика

        // 5. Собрать учеников в группы по году рождения

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}