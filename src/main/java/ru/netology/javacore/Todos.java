package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> todos = new ArrayList<>();

    @Override
    public String toString() {
        return "Todos{" +
                "todos=" + todos + '}';
    }

    public void addTask(String task) {
        todos.add(task);
    }

    public void removeTask(String task) {
        todos.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        todos.stream().sorted().forEach(task -> sb.append(task).append(" "));
        return sb.toString().trim();
    }

}
