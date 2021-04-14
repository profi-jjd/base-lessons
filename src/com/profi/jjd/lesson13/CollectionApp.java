package com.profi.jjd.lesson13;

import java.util.*;

public class CollectionApp {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 29);
        Student student2 = new Student("Екатерина", "Еремина", 49);
        Student student3 = new Student("Олег", "Попов", 54);
        Student student4 = new Student("Алексей", "Попов", 54);

        // ArrayList
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList = new ArrayList<>(30);
        System.out.println(studentArrayList.size());  // 0
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(1, student3);
        studentArrayList.addAll(Arrays.asList(student3, student4));
        // урезает внутренний массив до количества элементов коллекции
        studentArrayList.trimToSize();

        studentArrayList.remove(student3);
        studentArrayList.remove(0);

        // обращение к несуществующему индексу приводит к java.lang.IndexOutOfBoundsException
        // System.out.println(studentArrayList.get(3));
        System.out.println(studentArrayList.get(0));

        for (Student student : studentArrayList) {
            student.setAge(student.getAge() + 1);
            //
        }

        // LinkedList
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(student1);
        studentLinkedList.addFirst(student3);
        studentLinkedList.addLast(student3);
        studentLinkedList.add(2, student2);

        for (Student student : studentLinkedList) {
            if (student.getAge() < 30) studentArrayList.add(student);
        }

        List<Student> sublist = studentLinkedList.subList(0, 2);

        studentLinkedList.remove(student4);
        studentLinkedList.remove(0);
        studentLinkedList.removeLast();
        studentLinkedList.removeFirst();

        // Set
        // HashSet
        // LinkedHashSet
        Student[] students = {student1, student3, student4, student4};
        HashSet<Student> studentHashSet = new HashSet<>(Arrays.asList(students));
        studentHashSet.add(student3);
        studentHashSet.add(student2);
        studentHashSet.remove(student2);

        // TreeSet
        // 1. implements Comparable либо
        // 2. объект Comparator в конструктор TreeSet
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student4);
        studentTreeSet.add(student3);

        Comparator<Student> comparator = new Student.AgeComparator()
                .thenComparing(new Student.NameComparator());
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(comparator);







    }
}
