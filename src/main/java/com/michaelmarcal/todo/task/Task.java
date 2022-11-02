package com.michaelmarcal.todo.task;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Task {

    @Getter @NonNull
    private TaskStatus taskStatus;
    @Getter @Setter @NonNull
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private LocalDateTime dueDate;
    @Getter @Setter
    private LocalDateTime createDate;
    @Getter @Setter
    private Task parentTask;
}
