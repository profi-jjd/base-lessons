package com.profi.jjd.lesson2122.patterns.logging.decorator;

import com.profi.jjd.lesson2122.patterns.logging.strategy.ILogger;

import java.time.LocalDateTime;

public class DateDecorator extends BaseDecorator{
    public DateDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        String newMessage = message + " date: " + LocalDateTime.now();
        super.log(newMessage);
    }
}
