package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    public String task;
    public String type;
    public List<String> allTasks;

    public Todos() {
        this.allTasks = new ArrayList<>();
    }

    public void addTask(String task) {
        allTasks.add(task);
    }

    public void removeTask(String task) {
        allTasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(this.allTasks);
        StringBuilder sb = new StringBuilder();

        for (String task : allTasks) {
            sb.append(task);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Cписок дел: { " +
                " allTasks = " + allTasks +
                " }";
    }
}
