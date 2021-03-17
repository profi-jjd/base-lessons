package lesson1;

// ctrl + alt + l
// однострочный комментарий ctrl + /
/* ctrl + shift + /
многострочный
комментарий
 */
public class FirstLesson {
    // точка входа psvm + Enter
    public static void main(String[] args) {
        // консольный вывод sout + Enter
        System.out.println("консольный вывод");

        // объявление переменых типДанных имяПеременной;
        int count = 98234;
        int length = 122,
                width = 301, height = 501;
        int size, page;
        size = 20;
        page = 6;

        // обращение к переменной происходит по ее имени
        System.out.println(size);

        // byte data = 500;
        int bill = 1_000_000; // для удобства можно использовать _

        //incompatible types: conversion from double to float
        float pi = 3.14F; // нужно явно указать на float: f/F

        // integer number too large
        long veryBig = 67_000_000_00L; // нужно явно указать на long: l/L

        // деление на 0
        // целых чисел приведет к ошибке выполнения:
        // java.lang.ArithmeticException
        // System.out.println(bill / 0);

        // чисел с плавающей точкой Infinity
        System.out.println(pi / 0);

        // Приведение типов
        double price = bill; // автоматическое приведение
        System.out.println(price);

        byte miniPrice = (byte) bill; // явное приведение
        System.out.println(miniPrice);

        byte a = 12, b = 90;
        byte ab = (byte) (a + b);

        boolean isActive = false;
        boolean closed = true;

        // Операторы
        height = 9;
        width = 2;

        // взятие остатка %
        System.out.println(height % width); // 1
        //  0.5 + 0.5 = 1

        height = 7;
        width = 4;
        System.out.println(height % width); // 3
        // 0.75 + 0.75 + 0.75 + 0.75

        height = 8;
        width = 2;
        System.out.println(height % width); // 0

        // конкатенация строк
        System.out.println("строка" + "строка");

        // присваивание
        height = height * 2; // height *= 2;
        System.out.println(height);

        width -= height; // width = width - height;
        System.out.println(width);

        // Операторы сравнения
        height = 8;
        width = 2;
        boolean res = height != width;
        System.out.println(height != width); // true
        System.out.println(height > width); // true
        System.out.println(height <= width); // false

        // тернарный оператор ?
        // переменная = логическое выражение/условие ? выражение1 : выражение2;

        double sum = bill > 1000 ? bill - bill * 0.1 : bill;
        System.out.println(sum);

        //
        boolean cancelled = false;
        // || или
        System.out.println(bill > 0 || cancelled); // true

        int start = 3, end = 10;
        // && и
        System.out.println(start < end && end < 100_000); // true

        // ! не
        System.out.println(!cancelled); // true
        System.out.println(!(bill > 0 || cancelled)); // false

        // ^ исключающее или (xor)
        System.out.println(bill > 0 ^ !cancelled); // false

        // инкремент ++ - увеличивает значение переменной на 1
        // декремент -- - уеньшает значение переменной на 1

        height = 2;
        int result = height++ - ++height + height-- - ++height *
                ++height + --height;
        // 2 - 4 + 4 - 4 * 5 + 4 = -14
        // --i сначала изменяет значение, потом возвращает ее значение
        // i-- сначала возвращает значение переменной, потом изменяет
        System.out.println(result);


        // byte n = 34;
        // int m = n;

        // int n = 608;
        // byte m = (byte) n;

    }
}
