package com.profi.jjd.lesson6;

import java.util.Arrays;
import java.util.Objects;

public class ClimbingGroup {
    private Mountain mountain;
    private Climber[] climbers;

    public ClimbingGroup(Mountain mountain, int climbersCount) {
        // проверка на null + исключение
        this.mountain = Objects.requireNonNull(mountain, "mountain не может быть null");
        climbers = new Climber[climbersCount];
    }

    public void addClimber(Climber climber){
        Objects.requireNonNull(climber, "climber не может быть null");
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = climber;
                return; // в void методах используется для завершения
                        // работы метода
            }
        }
        System.out.println("Мест нет");
    }

    public void addClimber(Climber... climbers) { }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }
}
