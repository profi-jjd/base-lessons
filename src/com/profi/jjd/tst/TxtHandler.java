package com.cool.java.lesson8.tst;

import com.cool.java.lesson8.tst.logger.FileLogger;

import java.io.File;
import java.util.Properties;

public class TxtHandler implements IHandler{
    private File file;
    private Properties properties;
    private FileLogger logger;

    public TxtHandler(File file, FileLogger fileLogger) {
        this.file = file;
        properties = new Properties();
        this.logger = fileLogger;
    }

    @Override
    public void read() {

    }

    @Override
    public void write() {

    }
}
