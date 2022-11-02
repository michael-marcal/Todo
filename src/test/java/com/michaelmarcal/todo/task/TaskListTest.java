package com.michaelmarcal.todo.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    private static TaskList taskList;
    private static LocalDateTime now;
    private static LocalDateTime later;

    @BeforeAll
    public static void setup() {
        now = LocalDateTime.now();
        taskList = new TaskList();
        later = LocalDateTime.now();
        taskList.addTask( new Task(TaskStatus.IN_PROGRESS, "TestName1", null, null, now, null));
        taskList.addTask( new Task(TaskStatus.IN_PROGRESS, "TestName2", "desc2", null, now, null));
        taskList.addTask( new Task(TaskStatus.IN_PROGRESS, "TestName3", "desc3", later, now, null));
        taskList.addTask( new Task(TaskStatus.NOT_STARTED, "TestName4", "desc4", later, now, null));
        taskList.addTask( new Task(TaskStatus.NOT_STARTED, "TestName5", "desc5", null, now, null));
        taskList.addTask( new Task(TaskStatus.COMPLETED, "TestName6", "desc6", later, now, null));
        taskList.addTask( new Task(TaskStatus.COMPLETED, "TestName7", "desc7", null, now, null));
        taskList.addTask( new Task(TaskStatus.COMPLETED, "TestName8", null, later, now, null));
        taskList.addTask( new Task(TaskStatus.DELETED, "TestName9", null, null, now, null));
    }

    @Test
    public void test_getAllTasks() {
        List<Task> tasks = taskList.getAllTasks();
        assertEquals(9, tasks.size());
    }

    @Test
    public void test_getInProgressTasks() {
        List<Task> inProgressTasks = taskList.getAllInProgressTasks();
        assertEquals(3, inProgressTasks.size());
    }

    @Test
    public void test_getCompletedTasks() {
        List<Task> completedTasks = taskList.getAllCompletedTasks();
        assertEquals(3, completedTasks.size());
    }

    @Test
    public void test_getNotStartedTasks() {
        List<Task> notStartedTasks = taskList.getAllNotStartedTasks();
        assertEquals(2, notStartedTasks.size());
    }

    @Test
    public void test_getDeletedTasks() {
        List<Task> deletedTasks = taskList.getAllDeletedTasks();
        assertEquals(1, deletedTasks.size());
    }
}
