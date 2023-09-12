package ru.netology.TaskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testWhenSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Подготовить изменения к выкатке");

        boolean actual = simpleTask.matches("Подготовить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testWhenSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Подготовить изменения к выкатке");

        boolean actual = simpleTask.matches("Не подготовил");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Task epic = new Epic(5, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("изменения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {
                "Подготовить изменения к выкатке",
                "Выкатка на предпродакшн",
                "Выкатка на продакшн",
                "Промониторить и проанализировать",
                "Задокументировать изменения"
        };
        Task epic = new Epic(5, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Подготовить изменения к выкатке ко вторнику");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(5);

        boolean expected = false;
        boolean actual = task.matches("Задокументировать изменения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTrue() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInFalse() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Во вторник");

        Assertions.assertEquals(expected, actual);
    }
}
