package com.michaelmarcal.todo.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void test_Task() {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task(TaskStatus.IN_PROGRESS, "TestName", null, null, now, null);

        assertAll(
                () -> assertEquals(TaskStatus.IN_PROGRESS, task.getTaskStatus()),
                () -> assertEquals("TestName", (task.getName())),
                () -> assertNull(task.getDescription()),
                () -> assertNull(task.getDueDate()),
                () -> assertEquals(now, task.getCreateDate()),
                () -> assertNull(task.getParentTask())
        );
    }
}
