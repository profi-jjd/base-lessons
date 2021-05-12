package com.profi.jjd.lesson23.reflection;

import com.profi.jjd.lesson23.Text;

public class ReflectionLesson {
    public static void main(String[] args) {
        /* Рефлексия - механизм, с помощью которого можно получать
        * информацию о классах, интерфейсах, полях и методах
        * во время выполнения программы.
        * Reflection API дает возможность создавать новые экземпляры классов,
        * получать и устанавливать значения свойств, вызывать методы. */

        Class<String> stringClass = String.class; // ссылка на класс String
        System.out.println(stringClass);

        Class<Integer> intClass = int.class;
        System.out.println(intClass);

        Class<Text> textClass = Text.class;
        System.out.println(textClass);

        Text text = new Text("Reflection");
        text.setText("Reflection API дает возможность создавать новые экземпляры классов");

        // ввиду полиморфизма объект text может быть экземпляром
        // подкласса Text
        Class<? extends Text> textClass2 = text.getClass();
        System.out.println(textClass2);

        textClass = Text.class;
        System.out.println(textClass.getName());
        System.out.println(textClass.getSimpleName());
        System.out.println(textClass.getPackageName());

        // интерфейсы


    }
}
