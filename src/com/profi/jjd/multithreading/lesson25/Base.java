package com.profi.jjd.multithreading.lesson25;

import java.util.concurrent.CopyOnWriteArrayList;

public class Base {
    public static void main(String[] args) {

        // Жизненный цикл потока:
        // 1. NEW (создание экземпляра Thread)
        // 2. RUNNABLE (вызов метода start() объекта Thread)
        // 3. RUNNING (поток запущен)
        // 4. NON-RUNNING (TIME WAITING) - поток находится в состоянии ожидания
        // 5. TERMINATED - поток завершил свою работу
        CopyOnWriteArrayList<Course> courses = new CopyOnWriteArrayList<>();


        Writer writer = new Writer(courses); // NEW
        writer.setName("WRITER");
        writer.start(); // RUNNABLE

        Reader reader = new Reader(courses);
        Thread readerThread = new Thread(reader); // NEW
        readerThread.start(); // RUNNABLE

        // public abstract void run();
        Runnable runnable = ()->{
            System.out.println("lambdaThread");
        };
        Thread lambdaThread = new Thread(runnable); // NEW
        lambdaThread.start();






    }
}
