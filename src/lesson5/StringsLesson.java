package lesson5;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class StringsLesson {
    public static void main(String[] args) {

        // char 16 бит - символ Unicode
        // от 0 до 65536 от '\u0000' до '\uffff'

        char char1 = 'J'; // символ в одинарных кавычках
        char char2 = 74; // номер символа
        char char3 = '\u0044'; // шеснадцатеричное представление
                               // в escape последовательности
        System.out.print(char1); // J
        System.out.print(char2); // J
        System.out.print(char3); // D

        // java.lang.String
        // Строки задаются либо в двойных кавычках: "строка",
        // либо с использованием одного из конструкторов
        // и оператора new: new String() (данным способом нужно
        // пользоваться только, если создание через "" невозможно)

        // Создание строки из char
        char[] jjdChars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(jjdChars);
        System.out.println(jjdString); // JJD

        jjdString = "\u004A\u004A\u0044";
        jjdString = "JJD";
        System.out.println(jjdString); // JJD

        // размер строки
        System.out.println(jjdString.length()); // JJD - 3
        System.out.println(jjdString.codePoints().count()); // 3

        char[] frogChars = {'\uD83D', '\uDC38'};
        String frogString = new String(frogChars);
        System.out.println(frogString);
        System.out.println(frogString.length()); // 🐸 - 2
        System.out.println(frogString.codePoints().count()); // 1

        // Пул строк
        String course1 = "Java";
        String course2 = "Java";
        String course3 = new String("Java");

        // сравнение ссылок
        System.out.println(course1 == course2); // true
        System.out.println(course1 == course3); // false

        // сравнение строк
        course1 = "Java junior Developer";
        course2 = "Java junior DEVELOPER";

        System.out.println(course1.equals(course2)); // false
        System.out.println(course1.equalsIgnoreCase(course2)); // true
        System.out.println(course1.compareTo(course2)); // 32 = 101 - 69
        System.out.println(course1.compareToIgnoreCase(course2)); // 0

        String userData = null;
        String exit = "exit";
        // userData = "exit";
        // ошибка времени выполнения java.lang.NullPointerException
        // System.out.println(userData.equals("exit"));
        System.out.println(exit.equals(userData));

        // вычисление строки во время компиляции
        String name1 = "Строки в Java";
        String name2 = "Строки" + " " + "в" + " " + "Java";  // Строки в Java
        System.out.println(name1 == name2); // true

        // вычисление в момент выполнения
        name1 = "Строки ";
        name2 = "в Java";
        System.out.println(name1 + name2 == name1 + name2); // false

        String start = "start";
        for (int i = 0; i < 4; i++) {
            start += " " + i;
        }
        System.out.println(start);

        // StringBuilder - для однопоточных программ
        // StringBuffer - для многопоточных программ

        StringBuilder sb = new StringBuilder("Start");
        sb.append(name1).append(name2);
        String res = sb.toString(); // создание объекта типа java.lang.String
        System.out.println(res);

        sb = new StringBuilder("Start");
        for (int i = 0; i < 4; i++) {
            sb.append(" ").append(i);
        }
        res = sb.toString();
        System.out.println(res);

        String[] animals = {"кот", "пес", "мышь"};
        // создать новый массив, размер которого будет в два
        // раза больше, чем у animals
        String[] newAnimals = new String[animals.length * 2];
        // [null, ... ]
        // в цикле заполнить новый массив рандомными значениями
        // из массива animals
        // Math.random()
        for (int i = 0; i < newAnimals.length; i++) {
            newAnimals[i] = animals[(int)(Math.random() * animals.length)];
        }
        System.out.println(Arrays.toString(newAnimals));

        // убрать пробелы: начало, конец строки
        // trim() убирает пространство меньшее или равно u0020
        String someStr = " Строка ";
        someStr = someStr.trim();
        // Java11: убирают любое пространство (например, u3000)
        // strip() - с двух сторон
        // stripLeading() - с начала строки
        // stripTrailing() - с конца строки

        // получить массив символов из строки
        char[] formStr = someStr.toCharArray();
        System.out.println(Arrays.toString(formStr));


        String names = "Java, Kotlin, Python";
        String[] namesArr = names.split(", ");
        System.out.println(Arrays.toString(namesArr));

        names = String.join("! ", namesArr);
        // names = String.join("! ", "строка", "строка");
        System.out.println(names);

    }
}



