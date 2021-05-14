package com.profi.jjd.lesson24;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    private static ApplicationProperties instance;
    private Properties properties;
    private String fileName = "config.properties";

    private ApplicationProperties(){
        properties = new Properties();
        readProperties();
    }
    public static ApplicationProperties getInstance(){
        // отложенная инициализация
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void readProperties(){
        try (InputStream input = ApplicationProperties.class.getClassLoader()
                                    .getResourceAsStream(fileName)){
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }
    }


}

