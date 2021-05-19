package com.profi.jjd.multithreading.lesson26.waitnotify;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public synchronized void putBook() throws InterruptedException { // 5
//        if (books.size() ==  5) wait();
        while (books.size() > 5){
            System.out.println(Thread.currentThread().getName() +
                    " пока хранилище переполнено, поток находится" +
                    "в состоянии ожидания");
            wait();
        }
        books.add(new Book());
        System.out.println("Книга добавлена. Всего " + books.size());
        notify();
    }
    public synchronized Book getBook() throws InterruptedException { // 0
        while (books.size() == 0){
            System.out.println(Thread.currentThread().getName() +
                    " пока в хранилище пусто, поток находится" +
                    "в состоянии ожидания");
            wait();
        }
        Book book = books.remove(0);
        System.out.println("Книга удалена. Всего " + books.size());
        notify();
        return book;
    }

    public static class Book{}
}
