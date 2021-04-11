package com.profi.jjd.lesson12.types.parameters;

public class Train extends Transport {
    private int carCount;

    public Train(String departureSt, String destSt, String num, int carCount) {
        super(departureSt, destSt, num);
        this.carCount = carCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    @Override
    public void repair() {
        System.out.println("Ремонт поезда");
    }

}