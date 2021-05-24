package com.profi.jjd.multithreading.lesson27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class WriteSignals implements Runnable{
    private ArrayBlockingQueue<Signal> signals;

    public WriteSignals(ArrayBlockingQueue<Signal> signals) {
        this.signals = Objects.requireNonNull(signals);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            Signal signal = Signal.getSignal();
            try {
                Thread.sleep(5000);
                signals.put(signal);
                System.out.println(Thread.currentThread().getName() + "Элемент добавлен");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
