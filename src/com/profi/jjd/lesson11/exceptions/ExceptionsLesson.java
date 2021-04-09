package com.profi.jjd.lesson11.exceptions;


import java.io.IOException;

public class ExceptionsLesson {
    public static void main(String[] args) {
        int a = 33;
        int b = 0;
        // int res = a / b; // java.lang.ArithmeticException: / by zero

        int[] arr = new int[3];
        // arr[100] = 1; // java.lang.ArrayIndexOutOfBoundsException


        // java.lang.NullPointerException
        // System.out.println(string.equals("exceptions"));

        Object data = "123";
        // Integer integer = (Integer) data; // java.lang.ClassCastException

        // обработка исключений

        Integer integer = null;
        try {
            integer = (Integer) data;
        } catch (ClassCastException e) {
            System.out.println("Обработка ClassCastException");
        }
        // объединение блоков catch
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (ClassCastException e) {
            System.out.println("Обработка ClassCastException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обработка ArrayIndexOutOfBoundsException");
        }

        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Обработка ClassCast или ArrayIndexOutOf");
        } finally {
            System.out.println("Закрытие ресурсов, открытых try");
        }

        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Обработка RuntimeException");
        }

        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Обработка ClassCast или ArrayIndexOutOf");
        } catch (RuntimeException e) {
            System.out.println("Обработка RuntimeException");
        }

        withUnCheckedException(34);
        try {
            withCheckedException("some.bin");
        } catch (IOException ioException) {
            System.out.println("Обработка IOException");
            throw new IllegalArgumentException(ioException.getMessage());
        }

        try {
            withCheckedException("some.tx");
        } catch (IOException ignored) {}


        Message message = new Message();
        try {
            message.setTitle("Срочное сообщение");
            message.setText("Текст");
        } catch (AppException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Ошибка валидации", e);
        }

    }

    public static void withUnCheckedException(int age){
        if (age < 18) {
            throw new IllegalArgumentException("age < 18");
        }
        System.out.println("age = " + age);
    }

    public static void withCheckedException(String fileName) throws IOException {
        if (fileName.startsWith("txt")) {
            throw new IOException("Ошибка файла");
        }
        System.out.println("fileName = " + fileName);
    }

}
