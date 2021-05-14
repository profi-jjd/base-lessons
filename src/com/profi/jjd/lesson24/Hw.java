package com.profi.jjd.lesson24;

import com.profi.jjd.lesson23.annotations.Component;
import com.profi.jjd.lesson23.annotations.Required;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Hw {
    public static void main(String[] args) {

    }

    public static Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = Hw.class.getClassLoader().getResourceAsStream(fileName)){
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Файл не удалось прочитать");
        }
        return properties;
    }

    public static <T> T getObject(Class<?> cl) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Object o = null;
        if (cl.isAnnotationPresent(Component.class)) {
            Component component = cl.getDeclaredAnnotation(Component.class);
            String fileName = component.fileName();
            Properties properties =  getProperties(fileName);
            o = cl.getDeclaredConstructor().newInstance();

            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Required.class)) {
                    Method method = cl.getDeclaredMethod("set" +
                            field.getName().substring(0,1).toUpperCase() +
                            field.getName().substring(1), field.getType());
                    //
                    method.invoke(o, Integer.parseInt((String) properties.get(field.getName()))); // Object -> String
                }
            }
        }
        return (T) o;
    }


}
