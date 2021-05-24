package com.profi.jjd.multithreading.lesson28;

public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int count){
        balance += count;
    }
}
