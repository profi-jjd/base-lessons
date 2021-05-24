package com.profi.jjd.multithreading.lesson27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class ReadSignals implements Runnable{
    private ArrayBlockingQueue<Signal> signals;

    public ReadSignals(ArrayBlockingQueue<Signal> signals) {
        this.signals = Objects.requireNonNull(signals);
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(Thread.currentThread().getName() +
                        "Элемент получен " + signals.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
