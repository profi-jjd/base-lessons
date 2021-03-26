package com.profi.jjd.lesson6;

public class Mountain {
    private String name;
    private int height;

    public Mountain(){
        // вызов конструктора
        this("Гора по умолчанию", 300);
    }
    // конструктор
    public Mountain(String name, int height){
        setName(name);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("name < 2");
        }
        this.name = name;
    }

    private void setHeight(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("height < 100");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
