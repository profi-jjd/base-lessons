package com.profi.jjd.lesson2122.patterns;

import com.profi.jjd.lesson2122.FirstListener;
import com.profi.jjd.lesson2122.patterns.builder.NutritionFacts;
import com.profi.jjd.lesson2122.patterns.listener.Listener;
import com.profi.jjd.lesson2122.patterns.listener.StateClass;

import java.util.EventListener;
import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {
        // 1. Одиночка (Singleton)
        // 2. Прототип (Clone, Prototype) - описывает
        // логику клонирования объектов
        // 3. Строитель (Builder) - позволяет создавать объекты,
        // у которых боьшое количество свойств
        // 4. Фабричный метод (Factory Method)
        // 5. Абстрактная фабрика позволяет создавать семейства
        // связанных объектов

        // Структурные паттерны
        // 1. Декоратор (Decorator) позволяют добавлять объектам новую
        // функциональность
        // 2. Компоновщик (Composite)
        // 3. Адаптер (Adapter)

        // Поведенческие паттерны
        // 1. Наблюдатель (Observer)
        // 2. Итератор дает возможность последовательно обходить
        // элементы составных объектов
        // 3. Стратегия
        // 4. Команда (Command)

        // Builder
        NutritionFacts apple = new NutritionFacts.Builder(3)
                .fat(3).calories(100).build();

        NutritionFacts meat = new NutritionFacts.Builder(2)
                .calories(1000).build();

        // Listener
        // объекты наблюдателей
        Listener listener1 = new Listener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("listener1 greenEvent " + code);
            }
            @Override
            public void yellowEvent(int code) {
                System.out.println("listener1 yellowEvent " + code);
            }
            @Override
            public void redEvent(int code) {
                System.out.println("listener1 redEvent " + code);
            }
        };

        Listener listener2 = new Listener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("listener2 greenEvent " + code);
            }
            @Override
            public void yellowEvent(int code) {
                System.out.println("listener2 yellowEvent " + code);
            }
            @Override
            public void redEvent(int code) {
                System.out.println("listener2 redEvent " + code);
            }
        };

        StateClass stateClass = new StateClass();
        stateClass.addListener(listener1);
        stateClass.addListener(listener2);

        Scanner scanner = new Scanner(System.in);
        String state;
        while (true){
            System.out.println("Введите статус");
            state = scanner.nextLine();
            if ("exit".equals(state)) break;
            stateClass.changeState(state);
        }







    }
}













/*
interface Command {
    void execute();
}

class Help implements Command {

    @Override
    public void execute() {
        // список доступных команд
    }
}
class ClientCount implements Command {

    @Override
    public void execute() {
        // количество клиентов
    }
}*/

/*class Server {
    public void start(){
        Command command = Command.getCommand("count");
        command.execute();
    }
}*/














