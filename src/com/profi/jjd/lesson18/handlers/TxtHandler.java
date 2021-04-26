package com.profi.jjd.lesson18.handlers;

import java.io.*;
import java.util.Scanner;

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

    public boolean writeFromConsole(){
        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file, true);
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutput)){
            // new BufferedOutputStream(fileOutput, размер буфера)

            // программа -> decorator(outputStream) -> outputStream
            // программа <- decorator(inputStream) <- inputStream
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите данные или stop для выхода");
                String userInput = scanner.nextLine();
                if (userInput.equals("stop")) break;
                buffer.write((userInput+"\r\n").getBytes());
            }
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не удалось найти");
        } catch (IOException e){
            System.out.println("Ошиба записи в файл");
        }
        return result;
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
        byte[] result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){

            byte[] buf = new byte[512];
            int readCount;
            while ((readCount = fileInput.read(buf)) != -1) {
                byteArray.write(buf, 0, readCount);
            }
            result = byteArray.toByteArray();
        } catch (FileNotFoundException e){
            System.out.println("Файл не был найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла");
        }
        return result;
    }
}
