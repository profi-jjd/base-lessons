package com.profi.jjd.lesson7;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
       /* Knight knight = new Knight(20, 12);
        Infantry infantry = new Infantry(34, 5);

        BattleUnit bUnit1 = new Knight(8, 3);
        BattleUnit bUnit2 = new Infantry(10, 7);

        // Knight bKnight = (Knight) bUnit1;

        Unit unit = new King();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип юнита");
        String type = scanner.nextLine();

        BattleUnit battleUnit;

        if ("knight".equals(type)) {
            battleUnit = new Knight(8, 3);
        } else {
            battleUnit = new Infantry(10, 7);
        }

        battleUnit.attack(infantry);

        System.out.println(battleUnit.getAttackScore());
*/
        King king1 = new King();
        King king2 = new King();

        king1.startBattle(king2);
        king2.startBattle(king1);

        System.out.println(king1.getBattleResult());
        System.out.println(king2.getBattleResult());

    }
}
