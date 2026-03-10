package com.vr1dev.task.mapper;

import com.vr1dev.task.domain.CreateTaskRequest;
import com.vr1dev.task.domain.UpdateTaskRequest;
import com.vr1dev.task.domain.dto.CreateTaskRequestDto;
import com.vr1dev.task.domain.dto.TaskDto;
import com.vr1dev.task.domain.dto.UpdateTaskRequestDto;
import com.vr1dev.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
    TaskDto toDto(Task task);
}
