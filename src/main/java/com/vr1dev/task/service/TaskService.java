package com.vr1dev.task.service;

import com.vr1dev.task.domain.CreateTaskRequest;
import com.vr1dev.task.domain.entity.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);
}
