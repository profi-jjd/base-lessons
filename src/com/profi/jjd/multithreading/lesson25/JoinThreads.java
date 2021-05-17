package com.profi.jjd.multithreading.lesson25;

import com.profi.jjd.lesson2122.patterns.listener.Listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JoinThreads {
    public static void main(String[] args) {
        List<Integer> results =
                Collections.synchronizedList(new ArrayList<>());

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " Введите число");
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(System.in))){
                results.add(Integer.parseInt(reader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " Обработал данные");
            results.add(100);
        });

        Thread thread3 = new Thread(()->{
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " Обработал данные");
            results.add(200);
        });

        thread1.start();
        thread2.start();
        thread3.start();


        try {
            thread1.join(10000);
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + results);
    }
}
