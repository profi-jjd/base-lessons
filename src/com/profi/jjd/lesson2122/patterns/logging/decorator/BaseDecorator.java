package com.profi.jjd.lesson2122.patterns.logging.decorator;

import com.profi.jjd.lesson2122.patterns.logging.strategy.ILogger;

public class BaseDecorator implements ILogger {
    private ILogger logger;

    public BaseDecorator(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }
}
