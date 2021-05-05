package com.profi.jjd.lesson2122.innerclasses;

import com.profi.jjd.lesson2122.patterns.listener.Listener;

public class User {
    private Level level;
    private String login;

    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    // внутренний класс (inner class)
    public class Account {
        public static final double MAX_BALANCE = 1000;
        private double balance;

        public Account(double balance) {
            // обращение к свойствам и меотдам внешнего класса:
            // имя внешнего класса.this.имя свойства (или метода)
            this.balance = User.this.level.getCount();
        }

        public User getUser() {
            // User.this - ссылка на объект внешнего класса
            return User.this;
        }
    }

    // вложенный
    public enum Level {
        HIGH(100), MEDIUM(50), LOW(10);

        private double count;

        Level(double count) {
            this.count = count;
        }

        public double getCount() {
            return count;
        }
    }
}
