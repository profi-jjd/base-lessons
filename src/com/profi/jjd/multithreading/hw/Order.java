package com.profi.jjd.multithreading.hw;

import java.util.UUID;

public class Order {
    private boolean ready;
    private UUID id;
    private boolean cooking;

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isCooking() {
        return cooking;
    }

    public void setCooking(boolean cooking) {
        this.cooking = cooking;
    }
}
