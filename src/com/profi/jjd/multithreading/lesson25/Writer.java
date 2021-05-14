package com.profi.jjd.multithreading.lesson25;

public class Writer extends Thread{
    @Override
    public void run() {
        System.out.println("Writer");
    }
}
