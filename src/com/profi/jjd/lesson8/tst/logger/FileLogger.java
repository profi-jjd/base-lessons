package com.profi.jjd.lesson8.tst.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLogger implements ILogger{
    @Override
    public void printMessage(String message) {
        try {
            Path path = Files.createTempFile("log", ".txt");
            Files.write(path, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
