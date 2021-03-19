package lesson2;

import java.util.Scanner;

public class LoopingStatements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Пользователь вводит целое число с клавиатуры,
        // необходимо вывести это число увеличенное на 2
        // Если пользователь ввел 0, цикл прерывает работу

        while (true){
            System.out.println("Введите число");
            int num = in.nextInt();
            System.out.println(num + 2);
            if (num == 0) break;
        }
        // вывести все четные числа от start до end
        int start = 1, end = 14;
        while (start <= end) {
            if (start % 2 == 0) System.out.println(start);
            start++;  // start = start + 1; start += 1;
        }

        // вывести все положительные элементы последовательности
        // 95 90 85 80 75 70 ...
        for (int num = 95; num > 0; num -= 5) {
            System.out.println(num);
        }

        // вывести на экран первые 20 элементов последовательности
        // 2 4 6 8 10 и тд

        for (int num = 2, i = 1; i <= 20; num += 2, i++) {
            System.out.println(num);
        }

        int a = 909; // объявление переменной

    }
}
