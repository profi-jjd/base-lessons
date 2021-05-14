package com.profi.jjd.multithreading.lesson25;

public class Base {
    public static void main(String[] args) {
        // Жизненный цикл потока:
        // 1. NEW (создание экземпляра Thread)
        // 2. RUNNABLE (вызов метода start() объекта Thread)
        // 3. RUNNING (поток запущен)
        // 4. NON-RUNNING - поток находится в состоянии ожидания
        // 5. TERMINATED - поток завершил свою работу

        Writer writer = new Writer(); // NEW
        writer.start(); // RUNNABLE

        Reader reader = new Reader();
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
