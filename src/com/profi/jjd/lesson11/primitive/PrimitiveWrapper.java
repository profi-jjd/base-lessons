package com.profi.jjd.lesson11.primitive;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // byte - class Byte
        // short - class Short
        // int - class Integer
        // long - class Long
        // boolean - class Boolean
        // float - class Float
        // double - class Double
        // char - class Character

        int count = 3421;
        Integer age = 56; //вариант new Integer(56); не использовать

        // автоупаковка и автораспаковка
        // автоупаковка
        Integer i = 50342; // = count;
        // автораспаковка
        Double d = 67.9;
        double price = d;

        // автоупаковка и автораспаковка не работают с массивами
        double[] doubles = {45.78, 12.8, 22.6, 9.22};
        // printArr(doubles);


        // автоупаковка
        byte byteVar = 1;
        // Integer integerVar = byteVar; ошибка: тип данных примитива
        // не соответствует типу данных обертки
        Integer integerVar = (int) byteVar;

        // на автораспаковку данное правило не распростаняется

        // сравнение целоцисленных значений
        // значения [-127; 128]
        Long first = 45L;
        Long second = 45L;
        System.out.println(first == second); // true
        System.out.println(first.equals(second)); // true

        Long third = 200L;
        Long fourth = 200L;
        System.out.println(third == fourth); // false
        System.out.println(third.equals(fourth)); // true

        Integer a = 78;
        Integer b = 78;
        System.out.println(a.compareTo(b));
        // (a < b) ? -1 : ((a == b) ? 0 : 1);
        System.out.println(Integer.compare(a, b));

        System.out.println(Integer.hashCode(a)); // 78

        // методы Byte, Short, Integer, Long и тд,
        // возвращающие примитивы
        System.out.println(a.longValue());
        System.out.println(a.intValue());
        System.out.println(a.shortValue());
        System.out.println(a.floatValue());
        System.out.println(a.doubleValue());
        System.out.println(a.byteValue());

        // преобразования строки с числом к числу
        // parseXXX(строка_с_числом); возвращают примитив
        // valueOf(строка_с_числом); возвращают объект
        long l = Long.parseLong("45");
        Short s = Short.valueOf("22");
        Float f = Float.valueOf("113.89");
        // NumberFormatException, если строка содержит не только число

        System.out.println(Integer.max(4, 90));
        System.out.println(Integer.min(4, 90));
        System.out.println(Integer.sum(6, 0));


        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.isInfinite(9/0));

    }



    private static void printArr(Double[] doubles) {
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
}
