package com.profi.jjd.multithreading.lesson27.threadpool;

import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        // пул потоков [Thread thread1, Thread thread2]
        // task queue (Runnable/Callable) [task1, task2, task3, task4]

        // Runtime.getRuntime().availableProcessors()
        // n * ( 1 + w / s)
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 20; i++) {
            int iv = i;
            fixedPool.execute(()-> System.out.println("Task" + iv));
        }
        // завершает текущие
        // не принимает новые задачи
        // после вызова метода shutdown к пулу обращаться нельзя
        // fixedPool.shutdown();
        List<Runnable> runnables = fixedPool.shutdownNow();
        System.out.println(runnables);

        ExecutorService single = Executors.newSingleThreadExecutor();
        single.execute(()->{
            System.out.println("Task 1");
        });
        single.execute(()->{
            System.out.println("Task 2");
        });
        single.shutdown();

        ScheduledExecutorService service1 =
                Executors.newSingleThreadScheduledExecutor();
        service1.schedule(()->{
            System.out.println("service1");
        }, 5, TimeUnit.SECONDS);
        service1.shutdown();

        ScheduledExecutorService service2 =
                Executors.newSingleThreadScheduledExecutor();
        service2.scheduleAtFixedRate(()->{
            System.out.println("service2");
        }, 0, 5, TimeUnit.SECONDS);

        ScheduledExecutorService service3 =
                Executors.newSingleThreadScheduledExecutor();
        service3.scheduleWithFixedDelay(()->{
            System.out.println("service3");
        }, 0, 2, TimeUnit.SECONDS);

    }
}
