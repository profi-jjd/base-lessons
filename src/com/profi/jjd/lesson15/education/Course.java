package com.profi.jjd.lesson15.education;

import com.profi.jjd.lesson7.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private double price;
    private int duration;
    private final String name;

    public Course(String name, int duration, int price) {
        this.price = price;
        this.duration = duration;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "price=" + price +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (price != course.price) return false;
        if (duration != course.duration) return false;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, duration, name);
    }

    public static Course getInstance() {
        String[] names = {"JJD", "Node js", "Python", "C++"};
        return new Course(
                names[Randoms.getRandomInt(names.length)],
                Randoms.getRandomInt(1, 6),
                Randoms.getRandomInt(8000, 60000)
        );
    }

    public static List<Course> getInstances(int count) {
        ArrayList<Course> courses = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            courses.add(getInstance());
        }
        return courses;
    }

}