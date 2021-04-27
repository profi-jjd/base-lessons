package com.profi.jjd.lesson19.serialization.school;


public class Human {
    protected String name = "Человек";
    protected int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 5) this.age = age;
    }
}