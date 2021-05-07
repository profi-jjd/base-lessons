package com.profi.jjd.lesson2122.patterns.logging;

import com.profi.jjd.lesson2122.patterns.logging.decorator.DateDecorator;
import com.profi.jjd.lesson2122.patterns.logging.strategy.ConsoleLogger;
import com.profi.jjd.lesson2122.patterns.logging.strategy.FileLogger;

public class Application {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogger());
        inProgram.action();

        inProgram.setLogger(new DateDecorator(new FileLogger("log.txt")));
        inProgram.action();

        inProgram.setLogger(new ConsoleLogger());
        inProgram.action();
    }
}
