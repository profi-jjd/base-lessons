package com.profi.jjd.lesson12.types.parameters;

class BusGarage extends Garage {
    void checkBus(){
        System.out.println(this.getCarOnService().getNum()); // Transport
    }
}

class TrainGarage extends Garage<Train> {
    void checkTrain(){
        System.out.println(this.getCarOnService().getCarCount()); // Train
    }
}

class TransportGarage extends Garage<Transport> {
    void checkTrain(){
        System.out.println(this.getCarOnService().getNum()); // Transport
    }
}
