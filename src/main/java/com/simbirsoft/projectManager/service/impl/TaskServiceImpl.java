package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;
import com.simbirsoft.projectManager.entity.ProjectEntity;
import com.simbirsoft.projectManager.entity.TaskEntity;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.service.Converter;
import com.simbirsoft.projectManager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final Converter converter;

    public TaskServiceImpl(TaskRepository taskRepository, Converter converter) {
        this.taskRepository = taskRepository;
        this.converter = converter;
    }

    @Override
    public TaskResponse getTaskById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<TaskEntity> optionalTaskEntity = taskRepository.findById(uuid);
        if (optionalTaskEntity.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return converter.convertToTaskResponse(optionalTaskEntity.get());
    }

    @Override
    public TaskAddResponse addTask(TaskRequest request) {
        TaskEntity project = converter.convertToTaskEntity(request);
        taskRepository.save(project);
        return new TaskAddResponse(true);
    }

    @Override
    public TaskUpdateResponse updateTask(String id, TaskRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<TaskEntity> oldEntity = taskRepository.findById(uuid);
        if (oldEntity.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        TaskEntity newEntity = converter.convertToTaskEntity(oldEntity.get(),request);
        taskRepository.save(newEntity);
        return null;
    }

    @Override
    public TaskDeleteResponse deleteTask(String id) {
        UUID uuid = UUID.fromString(id);
        if (taskRepository.findById(uuid).isEmpty()) {
            throw new ProjectNotFoundException();
        }
        taskRepository.deleteById(uuid);
        return new TaskDeleteResponse(true);
    }
}
