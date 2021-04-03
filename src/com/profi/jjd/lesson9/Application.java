package com.profi.jjd.lesson9;

import com.profi.jjd.lesson9.figures.Figure;
import com.profi.jjd.lesson9.figures.Point;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

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
        System.out.println(second == first); // false
        System.out.println(second.equals(first)); // true
        System.out.println(second.getPoints() == first.getPoints()); // false
        System.out.println(Arrays.equals(second.getPoints(), first.getPoints())); // true

    }
}
