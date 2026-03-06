package com.vr1dev.task.mapper.impl;

import com.vr1dev.task.domain.CreateTaskRequest;
import com.vr1dev.task.domain.dto.CreateTaskRequestDto;
import com.vr1dev.task.domain.dto.TaskDto;
import com.vr1dev.task.domain.entity.Task;
import com.vr1dev.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task .getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
