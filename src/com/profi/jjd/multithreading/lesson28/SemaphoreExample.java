package com.profi.jjd.multithreading.lesson28;

import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        semaphore = new Semaphore(1, true);

        HashSet<String> set = new HashSet<>();
        // 0
        Semaphore finalSemaphore = semaphore;
        Runnable runnable = ()->{
            String threadName = Thread.currentThread().getName();
            try {
                Thread.sleep(3000);
                finalSemaphore.acquire(); // уменьшает количество разрешений на 1
                // semaphore.acquire(n); уменьшает количество разрешений на n
                set.add(threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finalSemaphore.release(); //
                // finalSemaphore.release(n);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}
