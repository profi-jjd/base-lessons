package com.profi.jjd.multithreading.lesson28;

import com.profi.jjd.multithreading.lesson27.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        CustomExecutor executor = new CustomExecutor(
                1, 6,
                1000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );
        // передать задачу на выполнение пулу
        // Runnable - execute()
        // Callable - submit()
        Callable<Signal> signalGenerator = new SignalGenerator();

        Future<Signal> container1 = executor.submit(signalGenerator);
        Future<Signal> container2 = executor.submit(signalGenerator);
        Future<Signal> container3 = executor.submit(signalGenerator);
        executor.shutdown();
      /*  try {
            System.out.println("Signal 1 " + container1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Signal 2 " + container2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Signal 3 " + container3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        try {
            System.out.println("Signal 1 " + container1.get(2, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("данные не появились");
        }



        CustomExecutor executor2 = new CustomExecutor(
                1, 6,
                1000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

        List<Callable<Signal>> callables = new ArrayList<>();
        callables.add(new SignalGenerator());
        callables.add(new SignalGenerator());
        callables.add(new SignalGenerator());

        List<Future<Signal>> futures = null;
        try {
            futures = executor2.invokeAll(callables);
            executor2.shutdown();
            for (Future<Signal> container : futures) {
                System.out.println(container.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Future:
        // .isDone() - true, если задача завершена
        // .cancel() - отменить задачу
        // .isCanceled() - true, если задача была отменена

    }
}
