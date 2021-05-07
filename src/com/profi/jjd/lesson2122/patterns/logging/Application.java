package com.profi.jjd.lesson2122.patterns.logging;

import com.profi.jjd.lesson2122.patterns.logging.strategy.ConsoleLogger;

public class Application {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogger());
        inProgram.action();


    }
}
