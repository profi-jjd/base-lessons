package com.profi.jjd.multithreading.lesson26.sync;

public class IncrementThread extends Thread{
    private final Account account;

    public IncrementThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (account){
            // синхронизированный блок
            account.changeBalance(10);
        }
    }
}
