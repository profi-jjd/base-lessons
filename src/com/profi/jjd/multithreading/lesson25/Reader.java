package com.profi.jjd.multithreading.lesson25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable{
    private CopyOnWriteArrayList<Course> courses;

    public Reader(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void run() {
        System.out.println("Reader");
        while (true){
            Course course = courses.stream()
                    .min(Comparator.comparing(Course::getPrice))
                    .orElse(Course.getInstance());
            String forFile = "READER " + Thread.currentThread().getName() +
                    "выбрал курс " + course + "\n";
            /*Files.write(Paths.get("resources/courses.txt"), forFile.getBytes(),
                    StandardOpenOption.APPEND);*/
            try {
                Files.writeString(Path.of("resources/courses.txt"), forFile,
                        StandardOpenOption.APPEND);
                courses.remove(course);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
