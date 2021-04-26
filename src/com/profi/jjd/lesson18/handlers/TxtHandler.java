package com.profi.jjd.lesson18.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TxtHandler extends FileHandler{ // .txt

    public TxtHandler(File file) {
        setFile(file);
    }

    public void setFile(File file){
        if (file == null || !file.getName().endsWith(".txt") || file.isDirectory()) {
            this.file = new File("default.txt");
        } else {
            this.file = file;
        }
        try {
            if (this.file.createNewFile()) {
                System.out.println(this.file.getName() + " создан");
            } else {
                System.out.println(this.file.getName() + " уже существует");
            }
        } catch (IOException e) {
            System.out.println("Файл не был создан " + e.getMessage());
        }
    }



    @Override
    public boolean writeToFile(byte[] data) {
        boolean result = false;
        // try with resources
        // AutoCloseable
        try (FileOutputStream outputStream = new FileOutputStream(file, true)){
            outputStream.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл для записи не был найден");
        } catch (IOException e){
            System.out.println("Ошибка записи в файл");
        }
        return result;
    }

    @Override
    public byte[] readFromFile() {
        return new byte[0];
    }
}
