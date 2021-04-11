package com.profi.jjd.lesson12.types.parameters;

public class Bus extends Transport {
    private boolean wiFi;

    public Bus(String departureSt, String destSt, String num, boolean wiFi) {
        super(departureSt, destSt, num);
        this.wiFi = wiFi;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public void setWiFi(boolean wiFi) {
        this.wiFi = wiFi;
    }

    @Override
    public void repair() {
        System.out.println("Ремонт автобуса");
    }

}