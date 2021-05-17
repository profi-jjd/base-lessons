package com.profi.jjd.multithreading.lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer extends Thread{
    private CopyOnWriteArrayList<Course> courses;

    public Writer(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
    }
//    private int price;
//    private int duration;
//    private final String name;
    @Override
    public void run() {
        System.out.println("Writer");
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                System.out.println(Thread.currentThread().getName() + ": Введите данные");
                System.out.println("Введите название курса");
                String name = reader.readLine();
                System.out.println("Введите стоимость");
                int price = Integer.parseInt(reader.readLine());
                System.out.println("Введите продолжительность");
                int duration = Integer.parseInt(reader.readLine());
                if (courses.addIfAbsent(new Course(name, duration, price))) {
                    System.out.println("Курс успешно добавлен");
                } else {
                    System.out.println("Курс не был добавлен");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
