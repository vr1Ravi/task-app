package com.vr1dev.task.service;

import com.vr1dev.task.domain.CreateTaskRequest;
import com.vr1dev.task.domain.UpdateTaskRequest;
import com.vr1dev.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);
    List<Task> listTasks();
    Task  updateTask(UUID taskId, UpdateTaskRequest request);
}
