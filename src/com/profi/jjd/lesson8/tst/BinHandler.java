package com.cool.java.lesson8.tst;

import com.cool.java.lesson8.tst.logger.ConsoleLogger;

import java.io.File;
import java.util.Properties;

public class BinHandler {
    private File file;
    private Properties properties;
    private ConsoleLogger logger;

    public BinHandler(File file, ConsoleLogger logger) {
        this.file = file;
        properties = new Properties();
        this.logger = logger;
    }

    public void read() {

    }

    public void write() {

    }
}
