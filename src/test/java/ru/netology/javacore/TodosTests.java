package ru.netology.javacore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TodosTests {
    Todos todos = new Todos();

    @Test
    public void addTaskTest() {
        String task = "RUN";  // given
        ArrayList<String> allTasks1 = new ArrayList<>();
        allTasks1.add(task);
        todos.addTask(task); // when
        assertTrue(allTasks1.equals(todos.allTasks)); // then
    }

    @Test
    public void removeTaskTest() {
        String task = "English";  // given
        ArrayList<String> listTasks = new ArrayList<>();
        listTasks.remove(task);
        todos.removeTask(task); // when
        assertTrue(listTasks.equals(todos.allTasks)); // then
    }

    @Test
    public void getAllTasksTest() {
        // given:
        ArrayList<String> listTasks = new ArrayList<>();
        String task1 = "Run";
        String task2 = "English";
        listTasks.add(task1);
        listTasks.add(task2);

        Collections.sort(listTasks);
        StringBuilder sb = new StringBuilder();
        for (String task : listTasks) {
            sb.append(task);
            sb.append(" ");
        }
        String result = sb.toString();
        // when:
        todos.addTask("Run");
        todos.addTask("English");
        todos.getAllTasks();

        //then:
        assertTrue(result.equals(todos.getAllTasks()));
    }
}
