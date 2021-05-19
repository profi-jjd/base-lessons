package com.profi.jjd.multithreading.lesson26.sync;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

//    public synchronized void changeBalance(int count){
    public void changeBalance(int count){
        balance += count;
    }
}
