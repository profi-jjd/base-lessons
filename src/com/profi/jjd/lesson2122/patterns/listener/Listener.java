package com.profi.jjd.lesson2122.patterns.listener;

public interface Listener {
    void greenEvent(int code);
    void yellowEvent(int code);
    void redEvent(int code);
}
