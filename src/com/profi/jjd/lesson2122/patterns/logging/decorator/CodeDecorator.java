package com.profi.jjd.lesson2122.patterns.logging.decorator;

import com.profi.jjd.lesson2122.patterns.logging.strategy.ILogger;

import java.util.UUID;

public class CodeDecorator extends BaseDecorator{
    public CodeDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        String newMessage = message + " " + UUID.randomUUID();
        super.log(newMessage);
    }
}
