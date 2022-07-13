package ru.netology.javacore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {

    @Test
    public void testAddTask() {
        final Todos todos = new Todos();
        todos.addTask("Покормить детей");
        final String result = todos.getAllTasks();
        assertEquals(result, "Покормить детей");
    }

    @Test
    public void testSortingTodos() {
        final Todos todos = new Todos();
        todos.addTask("Покормить детей");
        todos.addTask("Погладить белье");
        todos.addTask("Поиграть с детьми");
        final String result = todos.getAllTasks();
        assertEquals(result, "Погладить белье Поиграть с детьми Покормить детей");
    }

    @Test
    public void testRemoveTask() {
        final Todos todos = new Todos();
        todos.addTask("Покормить детей");
        todos.addTask("Погладить белье");
        todos.addTask("Поиграть с детьми");
        todos.removeTask("Поиграть с детьми");
        final String result = todos.getAllTasks();
        assertEquals(result, "Погладить белье Покормить детей");
    }

}
