package com.profi.jjd.multithreading.lesson26.waitnotify;

public class PutThread implements Runnable{
    private Library library;

    public PutThread(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        while (true){
            try {
                library.putBook();
                Thread.sleep((long) (Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
