package com.profi.jjd.lesson13;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private String surname;
    private int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        // отрицательное - текущий объект меньше
        // 0 - если объекты равны
        // положительное - текущий объект больше
        return Integer.compare(this.age, o.age);
    }

    public static class AgeComparator implements Comparator<Student> {
        // отрицательное - o1 меньше
        // 0 - если объекты равны
        // положительное - o1 больше
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }

    public static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }


}
