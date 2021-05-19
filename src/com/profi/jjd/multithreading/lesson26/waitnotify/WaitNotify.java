package com.profi.jjd.multithreading.lesson26.waitnotify;

public class WaitNotify {
    public static void main(String[] args) {
        // wait()
        // wait(mls)
        // notify()
        // notifyAll()
        Library library = new Library();
        new Thread(new PutThread(library)).start();
        new Thread(new GetThread(library)).start();
    }
}
