package com.profi.jjd.lesson13;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionApp {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 29);
        Student student2 = new Student("Екатерина", "Еремина", 49);
        Student student3 = new Student("Олег", "Попов", 54);
        Student student4 = new Student("Алексей", "Попов", 54);

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

        System.out.println(studentArrayList.get(3));

        for (Student student : studentArrayList) {
            student.setAge(student.getAge() + 1);
        }




    }
}
