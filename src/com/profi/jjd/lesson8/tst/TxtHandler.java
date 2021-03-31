package com.profi.jjd.lesson8.tst;

import com.profi.jjd.lesson8.tst.logger.FileLogger;
import com.profi.jjd.lesson8.tst.logger.ILogger;

import java.io.File;
import java.util.Properties;

public class TxtHandler implements IHandler{
    private File file;
    private Properties properties;
    private ILogger logger;

    public TxtHandler(File file, ILogger fileLogger) {
        this.file = file;
        properties = new Properties();
        this.logger = fileLogger;
    }

    @Override // void read();
    public void read() {
        System.out.println("Реализация метода read TxtHandler");
        logger.printMessage("Метод read отработал");
    }

    @Override
    public void write() {
        System.out.println("Реализация метода write TxtHandler");
    }
}
