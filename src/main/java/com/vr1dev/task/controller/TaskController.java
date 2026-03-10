package com.vr1dev.task.controller;


import com.vr1dev.task.domain.CreateTaskRequest;
import com.vr1dev.task.domain.UpdateTaskRequest;
import com.vr1dev.task.domain.dto.CreateTaskRequestDto;
import com.vr1dev.task.domain.dto.TaskDto;
import com.vr1dev.task.domain.dto.UpdateTaskRequestDto;
import com.vr1dev.task.domain.entity.Task;
import com.vr1dev.task.mapper.TaskMapper;
import com.vr1dev.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController  {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
           @Valid  @RequestBody CreateTaskRequestDto createTaskRequestDto
    ){
       CreateTaskRequest createTaskRequest =  taskMapper.fromDto(createTaskRequestDto);
       Task task = taskService.createTask(createTaskRequest);
       TaskDto createdTaskDto =  taskMapper.toDto(task);
       return  new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks() {
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
            ){
       UpdateTaskRequest updateTaskRequest =  taskMapper.fromDto(updateTaskRequestDto);
       Task updatedTask = taskService.updateTask(taskId, updateTaskRequest);
       TaskDto taskDto = taskMapper.toDto(updatedTask);
       return ResponseEntity.ok(taskDto);
    }
}
