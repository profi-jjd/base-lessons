package com.profi.jjd.lesson9;

import com.profi.jjd.lesson6.Climber;

public class Application {
    public static void main(String[] args) {
        Object o = new Climber();

        Point a = new Point(45, 12);
        Point b = new Point(45, 12);
        System.out.println(a.equals(b)); // true

        Point c = a.clone();
        System.out.println(c == a); // false
        System.out.println(c.equals(a)); // true

        Figure first = new Figure(2);
        first.addPoint(a);
        first.addPoint(b);

        Figure second = first.clone();

    }
}
