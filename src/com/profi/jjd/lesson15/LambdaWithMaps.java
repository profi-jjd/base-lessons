package com.profi.jjd.lesson15;

import com.profi.jjd.lesson15.education.Task;

import java.util.HashMap;
import java.util.UUID;

public class LambdaWithMaps {
    public static void main(String[] args) {
        Task task1 = Task.getInstance();
        Task task2 = Task.getInstance();
        Task task3 = Task.getInstance();
        Task task4 = Task.getInstance();
        Task task5 = Task.getInstance();
        Task task6 = Task.getInstance();
        Task task7 = Task.getInstance();

        HashMap<UUID, Task> tasksMap = new HashMap<>();
        tasksMap.put(task1.getId(), task1);
        tasksMap.put(task2.getId(), task2);
        tasksMap.put(task3.getId(), task3);
        tasksMap.put(task4.getId(), task4);
        tasksMap.put(task5.getId(), task5);
        tasksMap.put(task6.getId(), task6);
        tasksMap.put(task7.getId(), task7);

    }
}
