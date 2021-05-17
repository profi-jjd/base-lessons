package com.profi.jjd.multithreading.lesson25;

public class DaemonThreads {
    public static void main(String[] args){
        Thread daemon = new Thread(()->{
            while (true){
//                System.out.println("фоновый (демон) поток");
            }
        });
        daemon.setDaemon(true); // поток завершится,
        // когда завершатся все не Daemon потоки
        daemon.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // прерывание потоков
        // Поток останавливается, если:
        // 1. завершил выполнение инструкций
        // 2. было выброшено необработанное исключение
        // 3. если поток был daemon потоком и все не daemon
        // потоки завершили свои инструкции


        // механизм прерывания потоков
        // (interrupted = false, interrupt(), isInterrupted())
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Some actions...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { // interrupted = false
                    Thread.currentThread().interrupt(); // interrupted = true
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // interrupted = true




    }
}
