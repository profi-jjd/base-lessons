package com.profi.jjd.multithreading.lesson26.task;

public class Transaction implements Runnable{
    private final Account src;
    private final Account dst;
    private int money;

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

// (account1, account2, 300)
// (account2, account1, 340)
    @Override
    public void run() {
        // перевод с src на dst
        /*if (src.getUuid() < dst.getUuid()) {
            synchronized (src) {
                synchronized (dst){

                }
            }
        } else {
            synchronized (dst) {
                synchronized (src){

                }
            }
        }*/
        synchronized (src) {}
        synchronized (dst) {}


    }
}
