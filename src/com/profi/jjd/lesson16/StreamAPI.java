package com.profi.jjd.lesson16;

import com.profi.jjd.lesson15.education.Course;

import java.util.*;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        Stream<Integer> ints =
                Stream.of(8, -90, 12, -453, 0, 3321, 88, -90, 112);
        ints.filter(n -> n > 0)
                .map(n -> n * n)
                .limit(2)
                .forEach(System.out::println);

        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        ints.distinct()
                .sorted() // Comparable compareTo
                .forEach(System.out::println);
        // anyMatch - хотя бы один, allMatch - все, noneMatch - ни один
        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        System.out.println(ints.anyMatch(n -> n > 50)); // true

        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        System.out.println(ints.allMatch(n -> n > 0)); // false

        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        System.out.println(ints.noneMatch(n -> n > 100)); // true

        // findFirst - первый элемент потока,
        // findAny - произвольный элемент потока,
        // возвращают элементы в Optional контейнере
        String[] colors = {"red", "yellow", "blue", "black"};
        Optional<String> first = Arrays.stream(colors)
                .skip(10)
                .findFirst();
        // String elem = first.get(); // NoSuchElementException
        // System.out.println(elem);
        String  elem = first.orElse("white");
        System.out.println(elem);
        boolean isPresent = first.isPresent();
        System.out.println(isPresent);

        Arrays.stream(colors)
                .skip(2)
                .filter(str -> str.endsWith("k"))
                .forEach(System.out::println);

        List<Course> courses = Course.getInstances(15);

        // min, max
        Course minByPrice = courses.stream() // Stream<Course>
                .min(Comparator.comparing(Course::getPrice)) // Optional<Course>
                .orElse(Course.getInstance()); // Course
        System.out.println(minByPrice);

        Course maxByDuration = courses.stream() // Stream<Course>
                .max(Comparator.comparing(Course::getDuration)) // Optional<Course>
                .orElse(Course.getInstance()); // Course
        System.out.println(maxByDuration);











    }
}
