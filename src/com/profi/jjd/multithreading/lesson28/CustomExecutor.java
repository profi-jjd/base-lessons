package com.profi.jjd.multithreading.lesson28;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomExecutor extends ThreadPoolExecutor {

    public CustomExecutor(int corePoolSize, /* изначальное количество потоков */
                          int maximumPoolSize, /* максимальное количество потоков в пуле */
                          /* сколько времени поток будет простаивать перед удалением из пула */
                          long keepAliveTime, TimeUnit unit,
                          /* очередь для задач пула */
                          BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        // super.beforeExecute(t, r);
    }


}
