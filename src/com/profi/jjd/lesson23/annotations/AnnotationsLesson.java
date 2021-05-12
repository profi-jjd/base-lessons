package com.profi.jjd.lesson23.annotations;

import com.profi.jjd.lesson23.Point;
import com.profi.jjd.lesson23.Text;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class AnnotationsLesson {
    public static void main(String[] args) {
        Class<Point> pointClass = Point.class;

        Annotation[] annotations = pointClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        if (pointClass.isAnnotationPresent(Component.class)) {
            Component component = pointClass.getDeclaredAnnotation(Component.class);
            System.out.println(component.fileName());
            System.out.println(component.version());
        }
        // import java.lang.reflect.Field;
        Field[] fields = pointClass.getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println(field.getType());
                System.out.println(field.getName());
            }
        }

        // если класс аннотирован Component:
        // создать объект данного класса
        // если поле отмечено аннотацией Required,
        // установить значение (из properties файла) данного поля,
        // используя сеттер!!!
        // int x setX(int x)
        // String name setName(String name)



        /*Set<Class<?>> classSet = new HashSet<>();
        classSet.add(Point.class);
        classSet.add(Text.class);*/

        // import java.util.Properties;
        Properties properties = new Properties();
        properties.setProperty("ip", "127.0.0.1");
        properties.setProperty("port", "8090");
        System.out.println(properties.getProperty("ip")); // "127.0.0.1"
        System.out.println(properties.getProperty("port")); // "8090"

        try (InputStream input = AnnotationsLesson.class
                .getClassLoader()
                .getResourceAsStream("point.properties")){
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }
        System.out.println(properties.get("x"));
        System.out.println(properties.get("y"));

    }
}
