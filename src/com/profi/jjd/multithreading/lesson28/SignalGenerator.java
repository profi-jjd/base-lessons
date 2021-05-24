package com.profi.jjd.multithreading.lesson28;

import com.profi.jjd.multithreading.lesson27.Signal;

import java.util.concurrent.Callable;

public class SignalGenerator implements Callable<Signal> {
    @Override
    public Signal call() throws Exception {
        Thread.sleep((long)(Math.random()*3000));
        return Signal.getSignal();
    }
}
