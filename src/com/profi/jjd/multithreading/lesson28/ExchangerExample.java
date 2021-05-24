package com.profi.jjd.multithreading.lesson28;

import java.util.concurrent.Exchanger;


public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            try {
                System.out.println("Первый поток получил данные " + exchanger.exchange("Первый"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("Второй поток получил данные " +
                        exchanger.exchange("Второй"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
