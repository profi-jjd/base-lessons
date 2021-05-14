package com.profi.jjd.lesson24;

import com.profi.jjd.lesson23.Point;
import com.profi.jjd.lesson24.validation.Validator;

public class Application {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(4);
        point.setY(5);

        Validator<Point> validator = new Validator<>(point);
        validator.validate();
        validator.getErrors().forEach(System.out::println);
    }
}
