package com.profi.jjd.lesson9.people;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {
    private String num;
    private int[] marks;

    public Student() {
        marks = new int[8];
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getNum(), student.getNum()) &&
                Arrays.equals(getMarks(), student.getMarks()) &&
                getName().equals(student.getName()) &&
                getAge() == student.getAge();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNum());
        result = 31 * result + Arrays.hashCode(getMarks());
        return result;
    }
}
