package com.profi.jjd.lesson15;

import com.profi.jjd.lesson15.education.Calculators;
import com.profi.jjd.lesson15.education.Operation;

public class Lambda {
    public static void main(String[] args) {
        // Лямбда выражения
        // double execute(double a, double b);
        Operation minus = (x, y) -> x - y;
        Operation div = (a, b) -> {
            if (b == 0){
                System.out.println("Деление на 0 невозможно");
                return 0;
            }
            return a / b;
        };
        System.out.println(minus.execute(5, 7));
        System.out.println(div.execute(10, minus.execute(5, 7)));

        System.out.println(Calculators.simpleOperation(1, 1, minus));
        System.out.println(
                Calculators.simpleOperation(1, 1, (a, b) -> a * b));

    }
}
