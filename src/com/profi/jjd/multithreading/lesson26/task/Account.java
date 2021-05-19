package com.profi.jjd.multithreading.lesson26.task;

import java.util.UUID;

public class Account {
    private UUID uuid;
    private int balance;

    public Account(int balance) {
        this.balance = balance;
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
