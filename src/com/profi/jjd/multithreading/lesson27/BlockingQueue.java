package com.profi.jjd.multithreading.lesson27;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue {
    public static void main(String[] args) {
        //максимальное количество элементов Integer.MAX_VALUE
        LinkedBlockingQueue<String> stringLinked = new LinkedBlockingQueue<>();
        // можно задать максимальное количество элементов в очереди
        stringLinked = new LinkedBlockingQueue<>(10);

        ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(30);
        arrayQueue = new ArrayBlockingQueue<>(30, true);

        ArrayBlockingQueue<Signal> signals =
                new ArrayBlockingQueue<>(5, true);
//        new Thread(new ReadSignals(signals)).start();
//        new Thread(new WriteSignals(signals)).start();
//        new Thread(new ReadSignals(signals)).start();
//        new Thread(new ReadSignals(signals)).start();
//        new Thread(new ReadSignals(signals)).start();
//        new Thread(new ReadSignals(signals)).start();
//        new Thread(new ReadSignals(signals)).start();


        DelayQueue<Task> tasks = new DelayQueue<>();
        tasks.put(new Task(()-> System.out.println("Old task"),
                LocalDateTime.now().minusDays(1)));

        tasks.put(new Task(()-> System.out.println("Future 1 task"),
                LocalDateTime.now().plusMinutes(1)));

        tasks.put(new Task(()-> System.out.println("Future 3 task"),
                LocalDateTime.now().plusMinutes(3)));

        while (true){
            try {
                new Thread(tasks.take().getAction()).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
