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
    Todos sut = new Todos();

    @org.junit.jupiter.api.Test
    public void addTaskTest() {
        // given:
        String task = "Run";
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(task);

        // when:
        sut.addTask(task);

        // then:
        assertTrue(list1.equals(sut.getListTasks()));
    }

    @org.junit.jupiter.api.Test
    public void removeTaskTest() {
        // given:
        String task = "Run";
        ArrayList<String> list1 = new ArrayList<>();
        list1.remove(task);

        // when:
        sut.removeTask(task);

        // then:
        assertTrue(list1.equals(sut.getListTasks()));
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
        sut.addTask("Run");
        sut.addTask("English");
        sut.getAllTasks();

        //then:
        assertTrue(result.equals(sut.getAllTasks()));
    }
}
