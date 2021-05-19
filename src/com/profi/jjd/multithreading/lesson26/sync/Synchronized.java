package com.profi.jjd.multithreading.lesson26.sync;

import java.util.ArrayList;

public class Synchronized {
    public static void main(String[] args) {
        Account account = new Account(0);

        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new IncrementThread(account));
        }
        // threads.forEach(Thread::start);
        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Balance = " + account.getBalance()); // 100


        // th1 - account 10
        // th2 - account 10
    }
}
