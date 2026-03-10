package com.vr1dev.task.domain;

import com.vr1dev.task.domain.entity.TaskPriority;
import com.vr1dev.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {

}
