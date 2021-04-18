package com.profi.jjd.lesson15;

import com.profi.jjd.lesson15.education.Course;
import com.profi.jjd.lesson15.education.University;

public class LambdaWithCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));
    }
}
