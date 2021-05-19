package com.profi.jjd.multithreading.lesson26.waitnotify;

public class GetThread implements Runnable{
    private Library library;

    public GetThread(Library library) {
        this.library = library;
    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("получена книга " + library.getBook());
                Thread.sleep((long)(Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
