package com.profi.jjd.lesson15.education;

import com.profi.jjd.lesson7.utils.Randoms;

import java.time.LocalDateTime;
import java.util.*;

public class Task {
    private final UUID id;
    private String title;
    private List<String> participants;
    private LocalDateTime finishTo;

    public Task(UUID id, String title, LocalDateTime finishTo) {
        this.id = id;
        this.title = title;
        this.finishTo = finishTo;
        participants = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public LocalDateTime getFinishTo() {
        return finishTo;
    }

    public void setFinishTo(LocalDateTime finishTo) {
        this.finishTo = finishTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(finishTo, task.finishTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, finishTo);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", participants=" + participants +
                ", finishTo=" + finishTo +
                '}';
    }

    public static Task getInstance() {
        String[] names = {"Глеб", "Таисия", "Владимир", "Иван", "Елена", "Михаил"};
        String[] titles = {"Задачи по Map", "Задачи по Lambda", "Курсовая 'Многопоточность'", "Задачи по Enum", "Курсовая 'Паттерны'", "Курсовая 'БД'"};
        Task task = new Task(UUID.randomUUID(), titles[Randoms.getRandomInt(titles.length)], LocalDateTime.now().plusDays(Randoms.getRandomInt(15)));
        task.setParticipants(Arrays.asList(names).subList(0, Randoms.getRandomInt(names.length+1)));
        System.out.println(task);
        return task;
    }
}