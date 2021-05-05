package com.profi.jjd.lesson2122.innerclasses;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Exam> exams;

    public Student(String name) {
        this.name = name;
        exams = new ArrayList<>();
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    // вложенный класс (nested static class)
    // класс верхнего уровня не мб static
    // вложенный класс не может обращаться к не static свойствам и
    // методам внешнего класса
    // область видимости вложенных классов - согласно модификатору доступа
    public static class Exam {
        private static final int MAX_MARK = 5;
        private int mark;
        private String examName;

        public Exam(int mark, String examName) {
            this.mark = mark;
            this.examName = examName;
        }
    }
}
