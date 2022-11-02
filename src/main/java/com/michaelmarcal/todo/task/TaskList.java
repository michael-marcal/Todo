package com.michaelmarcal.todo.task;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {

    private List<Task> taskList = new LinkedList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    private List<Task> getTasksByStatus(TaskStatus taskStatus) {
        return taskList.stream().filter(task -> task.getTaskStatus().equals(taskStatus)).collect(Collectors.toList());
    }

    public List<Task> getAllCompletedTasks() {
        return getTasksByStatus(TaskStatus.COMPLETED);
    }

    public List<Task> getAllNotStartedTasks() {
        return getTasksByStatus(TaskStatus.NOT_STARTED);
    }

    public List<Task> getAllDeletedTasks() {
        return getTasksByStatus(TaskStatus.DELETED);
    }

    public List<Task> getAllInProgressTasks() {
        return getTasksByStatus(TaskStatus.IN_PROGRESS);
    }
}
