package com.profi.jjd.lesson24;

import com.profi.jjd.lesson23.Point;
import com.profi.jjd.lesson24.validation.Validator;

import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(1);
        point.setY(5);

        Validator<Point> validator = new Validator<>(point);
        try {
            validator.validate();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        validator.getErrors().forEach(System.out::println);
    }
}
