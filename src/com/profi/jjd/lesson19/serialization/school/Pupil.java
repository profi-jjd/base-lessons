package com.profi.jjd.lesson19.serialization.school;

import java.time.LocalDate;

public class Pupil extends Human implements LearnAble {
    private Group group;
    private int level;
    private LocalDate lastLesson;
    private final String info = "Ученик";

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void learn(int knowledgeCount) {
        lastLesson = LocalDate.now();
        level += knowledgeCount;
    }


    @Override
    public String toString() {
        return "Pupil{" +
                "group=" + group +
                ", level=" + level +
                ", lastLesson=" + lastLesson +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}