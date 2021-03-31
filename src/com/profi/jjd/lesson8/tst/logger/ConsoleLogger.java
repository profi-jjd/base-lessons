package com.cool.java.lesson8.tst.logger;

public class ConsoleLogger implements ILogger{

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
