package com.profi.jjd.lesson15.education;

public class Calculators {
    public static double simpleOperation(double a, double b, Operation operation) {
        return operation.execute(a, b);
    }
}
