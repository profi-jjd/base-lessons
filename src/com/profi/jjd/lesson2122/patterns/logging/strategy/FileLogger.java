package com.profi.jjd.lesson2122.patterns.logging.strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileLogger implements ILogger{
    private String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        try {
            Files.writeString(Path.of(fileName), message + "\r\n",
                    StandardOpenOption.APPEND);
        } catch (IOException e) { }
    }
}
