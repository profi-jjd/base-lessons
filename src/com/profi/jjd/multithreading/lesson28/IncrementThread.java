package com.profi.jjd.multithreading.lesson28;

import java.util.concurrent.locks.ReentrantLock;

public class IncrementThread extends Thread{
    private final Account account;
    private ReentrantLock lock;

    public IncrementThread(Account account, ReentrantLock lock) {
        this.account = account;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            account.changeBalance(10);
        } finally {
            lock.unlock();
        }

    }
}
