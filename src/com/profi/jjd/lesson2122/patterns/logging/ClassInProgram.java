package com.profi.jjd.lesson2122.patterns.logging;

import com.profi.jjd.lesson2122.patterns.logging.strategy.ILogger;

public class ClassInProgram {
    private ILogger logger;

    public ClassInProgram(ILogger logger) {
        this.logger = logger;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public void action(){
        logger.log("Логирование действий");
    }
}
