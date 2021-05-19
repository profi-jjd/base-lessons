package com.profi.jjd.multithreading.lesson26.sync;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Synchronized {
    public static void main(String[] args) {
        Account account = new Account(0);

        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new IncrementThread(account));
        }
        // threads.forEach(Thread::start);
        threads.forEach(thread -> thread.start());
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Balance = " + account.getBalance()); // 100


        // th1 - account 10
        // th2 - account 10

        // List<String>  Files.readAllLines(Path.of("путь к файлу"));
        // читает из файла в список, где элемент списка - строа из файла

        System.out.println(Runtime.getRuntime().availableProcessors());

        // HashMap<String, Integer> words

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // main: words

    }
}
