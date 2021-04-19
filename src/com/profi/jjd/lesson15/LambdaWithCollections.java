package com.profi.jjd.lesson15;

import com.profi.jjd.lesson15.education.Course;
import com.profi.jjd.lesson15.education.University;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaWithCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        // перебор коллекции - метод foreach
        // принимает на вход Consumer - void accept(T t);
        Consumer<Course> courseConsumer = course -> System.out.println(course);

        courseConsumer = System.out::println;

        university.getCourses().forEach(courseConsumer);
        /*for (Course cours : university.getCourses()) {
            courseConsumer.accept(cours);
        }*/
        university.getCourses()
                .forEach(course -> course.setPrice(course.getPrice() * 1.1));
        university.getCourses().forEach(course -> System.out.println(course.getName()));

        // удаление из коллекции - метод removeIf
        // принимает на вход Predicate - boolean test(T t);
        // удалить курсы, стоимость которых меньше 15000
        university.getCourses().removeIf(course -> course.getPrice() < 15000);

        //в классе University написать реализацию
        // метода getFilteredCourses(Predicate<Course> condition)
        // который принимает на вход Predicate и возвращает новый список (List),
        // в который войдут курсы, удовлетворяющие условию condition

        // курсы дешевле 20000
        // курсы продолжительностью 3 и менее месяцев
        // курсы с названием "JJD"
        Predicate<Course> cheaperTw = course -> course.getPrice() < 20000;
        Predicate<Course> lessTh = course -> course.getDuration() <= 3;
        Predicate<Course> jjd = course -> "JJD".equals(course.getName());

        // получить список курсов продолжительностью
        // 3 и менее месяцев и стоимостью менее 20000
        List<Course> filtered = university.getFilteredCourses(
                                                    cheaperTw.and(lessTh));

        // получить список курсов продолжительностью
        // 3 и менее месяцев или с названием JJD
        filtered = university.getFilteredCourses(lessTh.or(jjd));

        // Компараторы
        // int compare(T o1, T o2);
        Comparator<Course> byName = (course1, course2) ->
                course1.getName().compareToIgnoreCase(course2.getName());
        Comparator<Course> byPrice = (course1, course2) ->
                Double.compare(course1.getPrice(), course2.getPrice());
        university.getCourses().sort(byName.thenComparing(byPrice));

        // метод Comparator.comparing
        // принимает на вход Function - R apply(T t)
        byName = Comparator.comparing(course -> course.getName()); // compareTo
        byPrice = Comparator.comparing(course -> course.getPrice());
        // Function<Course, String>
        byName = Comparator.comparing(Course::getName);
        // Function<Course, Double>
        byPrice = Comparator.comparing(Course::getPrice);

        Comparator<Course> courseComparator = Comparator.comparing(Course::getName)
                .thenComparing(Course::getPrice)
                .thenComparing(Course::getDuration);

        university.getCourses().sort(courseComparator);








    }
}
