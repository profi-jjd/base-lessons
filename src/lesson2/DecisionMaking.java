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
        // switch Java 12 - экспериментальная!!! опция, которая выключена по умолчанию, поэтому ее нужно включать:
        // добавить --enable-preview в File->Settings->Build,... ->Java Compiler->Additional command line parameters
        /*
        double discountSum;
        switch (code) {
            case 4692 -> discountSum = sum - sum * 0.3;
            case 7024, 5984 -> discountSum = sum - sum * 0.2;
            case 1235, 7351, 9835 -> discountSum = sum - sum * 0.1;
            default -> {
                System.out.println("Вам не повезло");
                discountSum = sum;
            }
        }
        System.out.println(discountSum);
        */
        // switch Java 13 - экспериментальная!!! опция, которая выключена по умолчанию, поэтому ее нужно включать:
        // добавить --enable-preview в File->Settings->Build,... ->Java Compiler->Additional command line parameters
        /*
        double discountSum = switch (code) {
            case 4692 -> sum - sum * 0.3;
            case 7024, 5984 -> sum - sum * 0.2;
            case 1235, 7351, 9835 -> sum - sum * 0.1;
            default -> {
                System.out.println("Вам не повезло");
                yield sum; // yield используется вместо break
            }
        };
        System.out.println(discountSum);
         */

        // Задача: дан номер месяца, в зависимости от номера месяца вывести время года

    }
}
