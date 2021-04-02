package com.profi.jjd.lesson6;

import java.util.Objects;
import java.util.UUID;

public class Climber {
    // свойсва (поля, атрибуты)
    private String fullName;
    private int age;
    private String email;
    private UUID uuid;

    // методы
    // сеттеры
    void setFullName(String fullName){
        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Значение fullName < 3");
        }
        this.fullName = fullName;
    }

    /* package-private доступ внутри пакета */
    void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Значение age < 18");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Это не email");
        }
        this.email = email;
    }

    public void setUuid() {
        uuid = UUID.randomUUID();
    }

    // методы
    // геттеры
    public String getFullName(){
        return fullName;
    }

    public int getAge(){
        return age;
    }

    public String getEmail() {
        return email;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Climber)) return false;
        Climber climber = (Climber) o;
        return age == climber.age &&
                Objects.equals(fullName, climber.fullName) &&
                Objects.equals(email, climber.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, email);
    }

    @Override
    public String toString() {
        return "Climber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
