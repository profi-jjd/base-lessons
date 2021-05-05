package com.profi.jjd.lesson2122.patterns.listener;

import java.util.ArrayList;

public class StateClass {
    private ArrayList<Listener> listeners = new ArrayList<>();
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void lowNotify(int code){
        listeners.forEach(listener -> listener.greenEvent(code));
    }

    private void mediumNotify(int code){
        listeners.forEach(listener -> listener.yellowEvent(code));
    }

    private void highNotify(int code) {
        listeners.forEach(listener -> listener.redEvent(code));
    }

    public void changeState(String state){
        if ("ok".equals(state)) lowNotify(1);
        if ("warn".equals(state)) mediumNotify(5);
        if ("error".equals(state)) highNotify(10);
    }
}
