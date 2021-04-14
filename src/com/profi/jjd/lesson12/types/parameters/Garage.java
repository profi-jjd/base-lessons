package com.profi.jjd.lesson12.types.parameters;

// public class Garage<T> // Object
// public class Garage<T extends Transport> // Transport и наследники
// public class Garage<T extends Bus> // Bus и наследники
// Transport и наследники, релизующие Cloneable интерфейс
// public class Garage<T extends Transport & Cloneable>
// реализующие Repairing и Cloneable интерфейсы
// public class Garage<T extends Repairing & Cloneable>

public class Garage<T extends Transport> {
    private T carOnService;

    public void service(){
        carOnService.repair();
    }

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }



}


