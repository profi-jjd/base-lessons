package com.profi.jjd.lesson8.tst;


import com.profi.jjd.lesson8.tst.logger.ConsoleLogger;

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
        System.out.println("Реализация метода read BinHandler");
    }

    public void write() {
        System.out.println("Реализация метода write BinHandler");
    }
}
