package com.profi.jjd.lesson2122.patterns.builder;

public class NutritionFacts {
    // обязательные параметры
    private final int servings;
    // необязательные параметры
    private final int calories;
    private final int fat;

    private NutritionFacts(Builder builder) {
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

    public static class Builder {
        // final - обязательные параметры
        private final int servings;
        // необязательные параметры инициализируются
        // со значениями по умолчанию
        private int calories = 1;
        private int fat; // 0
        // значение обязательных параметров
        public Builder(int servings) {
            this.servings = servings;
        }
        // для остальных сеттеры
        public Builder calories(int count) {
            calories = count;
            return this;
        }
        public Builder fat(int count){
            fat = count;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }


}
