package lesson2;

// alt + enter на имени класса для импорта
import java.util.Scanner;

public class DecisionMaking {
    // psvm
    public static void main(String[] args) {
        // консольный ввод
        Scanner in = new Scanner(System.in);
        System.out.println("введите номер");
        int userNum = in.nextInt();
        System.out.println(userNum);

        // if
        int state = 0;
        if (state == 0) {
            System.out.println("Закрытие приложения");
        } else if (state == 1) {
            System.out.println("Открытие приложения");
        } else {
            System.out.println("Ошибка статуса");
        }

       /*
       * Даны переменные age и exp
       * если значение перемнной age больше 100,
       * вывести "Мы Вам перезвоним"
       * В противном случае перейти к проверке exp:
       * если exp меньше 5, вывести "Вы подходите на должность стажера"
       * в противном случае вывести "Вы подходите на должность разработчика"
       */

        int sum = 1000, code = 5984;
        // 4692 - 30%
        // 7024, 5984 - 20%
        // 1235, 7351, 9835 - 10%

        // для замены alt + enter на switch
        switch (code) {
            case 4692:
                System.out.println(sum - sum * 0.3);
                break;
            case 7024:
            case 5984:
                System.out.println(sum - sum * 0.2);
                break;
            case 1235:
            case 7351:
            case 9835:
                System.out.println(sum - sum * 0.1);
                break;
            default:
                System.out.println(sum);
        }
        // дан номер месяца, в зависимоти от номера месяца
        // вывести время года

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

        System.out.println(Math.random());



    }
}
