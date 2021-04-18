package com.profi.jjd.lesson15.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }
    public boolean addCourses(List<Course> courses) {
        return courses.addAll(Objects.requireNonNull(courses));
    }

    public List<Course> getCourses() {
        return courses;
    }


}