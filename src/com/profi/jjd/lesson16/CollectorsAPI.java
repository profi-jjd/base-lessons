package com.profi.jjd.lesson16;

import com.profi.jjd.lesson15.education.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {
        // группировки
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(20));
        courses.forEach(System.out::println);
        Map<String, List<Course>> byName = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName()));

        Map<Integer, ArrayList<Course>> byDuration = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getDuration(),
                        Collectors.toCollection(ArrayList::new)));

        Map<String, Long> coursesCount = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName(),
                        Collectors.counting()));

        Map<String, Double> avgPrice = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName(),
                        Collectors.averagingDouble(course->course.getPrice())));

        Map<String, Map<Integer, List<Course>>> byNameDuration = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.groupingBy(Course::getDuration)
                ));
        System.out.println(byNameDuration);

        List<String> names = courses.stream()
                .map(course -> course.getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
