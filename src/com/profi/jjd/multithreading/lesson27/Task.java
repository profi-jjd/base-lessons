package com.profi.jjd.multithreading.lesson27;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {
    private final Runnable action;
    private final LocalDateTime time;

    public Task(Runnable action, LocalDateTime time) {
        this.action = action;
        this.time = time;
    }

    public Runnable getAction() {
        return action;
    }
    // положительное - элемент нельзя извлечь из очереди
    // 0, отрицательное - можно извлечь из очереди методом take
    @Override
    public long getDelay(TimeUnit unit) {
        //return unit.convert(Duration.between(LocalDateTime.now(), time));
        // return unit.convert(Duration.between(LocalDateTime.now(), time).getNano(), TimeUnit.NANOSECONDS);
        return unit.convert(Duration.between(LocalDateTime.now(), time).getSeconds(), TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        LocalDateTime otherTime = ((Task) o).time; // time
        return time.compareTo(otherTime);
    }
}
