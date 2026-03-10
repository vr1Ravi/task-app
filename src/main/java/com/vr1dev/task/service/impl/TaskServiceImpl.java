package com.vr1dev.task.service.impl;

import com.vr1dev.task.domain.CreateTaskRequest;
import com.vr1dev.task.domain.UpdateTaskRequest;
import com.vr1dev.task.domain.entity.Task;
import com.vr1dev.task.domain.entity.TaskStatus;
import com.vr1dev.task.exception.TaskNotFoundException;
import com.vr1dev.task.repository.TaskRepository;
import com.vr1dev.task.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private  final TaskRepository taskRepository;

    public  TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository =taskRepository;
    }
    @Override
    public Task createTask(CreateTaskRequest request) {

        Instant now = Instant.now();
        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
       return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException((taskId)));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());
        task.setPriority(request.priority());
        task.setDueDate(request.dueDate());
        task.setUpdated(Instant.now());

        return taskRepository.save(task);
    }
}
