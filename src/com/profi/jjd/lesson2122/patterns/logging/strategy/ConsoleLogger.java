package com.profi.jjd.lesson2122.patterns.logging.strategy;

public class ConsoleLogger implements ILogger{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
