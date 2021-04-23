package com.profi.jjd.lesson17;


import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // Edit Configuration ->
        // Program Arguments ->
        // параметры, с которыми запускается приложение
        // перечисляются через пробел.
        // При запуске собираются и передаются в массив args
        System.out.println(Arrays.toString(args)); // [arg1, arg2]

        // Базовый bootstrap загрузчик
        // Загрузчик расширений Extension
        // Системный загрузчик (system/application)
                 // java.lang.ClassLoader
        System.out.println(Application.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        System.gc();
        // Serial GC до j9
        // Parallel GC j9
        // G1 j11

        // -XX:+PrintFlagsFinal
        long used = Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory();
        System.out.println(used);
    }
}
