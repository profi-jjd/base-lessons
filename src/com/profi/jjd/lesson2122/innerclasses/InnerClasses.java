package com.profi.jjd.lesson2122.innerclasses;

public class InnerClasses {
    public static void main(String[] args) {
        Student.Exam exam1 = new Student.Exam(5, "биология");
        Student.Exam exam2 = new Student.Exam(3, "физика");

        Student student = new Student("Иван");
        student.addExam(exam1);
        student.addExam(exam2);

        User user = new User(User.Level.HIGH, "qwerty");
        // объект внутреннего класса
        User.Account account = user.new Account(300);

        User.Account account2 = new User(User.Level.LOW, "asdf").new Account(100);
        System.out.println(account2.getUser());
    }
}
