package com.profi.jjd.multithreading.lesson27;

import java.util.Random;

public class Signal {

    enum Priority {
        HIGH, MEDIUM, LOW;

        public static Priority getPriority(int ord) {
            for (Priority priority : values()) {
                if (ord == priority.ordinal()) {
                    return priority;
                }
            }
            throw new AssertionError("wrong ordinal");
        }
    }

    private Priority priority;
    private int code;

    public Signal(Priority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "priority=" + priority +
                ", code=" + code +
                '}';
    }

    public static Signal getSignal() {
        Random random = new Random();
        return new Signal(Priority.getPriority(random.nextInt(Priority.values().length)), random.nextInt(30));
    }
}