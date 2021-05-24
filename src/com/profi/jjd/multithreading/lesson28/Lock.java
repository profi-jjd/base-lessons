package com.profi.jjd.multithreading.lesson28;


import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lock {
    public static void main(String[] args) {
        Account account = new Account(0);
        ReentrantLock lock = new ReentrantLock();

        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new IncrementThread(account, lock));
        }

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.writeLock().lock();
        // изменение состояния объекта потоком
        readWriteLock.writeLock().unlock();

        readWriteLock.readLock().lock();
        // получение данных
        readWriteLock.readLock().unlock();
    }
}
