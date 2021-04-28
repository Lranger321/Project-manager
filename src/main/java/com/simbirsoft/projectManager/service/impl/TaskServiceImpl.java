package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.exception.EntityNotFoundException;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.service.TaskService;
import com.simbirsoft.projectManager.utils.Converter;
import com.simbirsoft.projectManager.utils.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final Converter converter;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, Converter converter, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.converter = converter;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse getTaskById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> optionalTaskEntity = taskRepository.findById(uuid);
        if (optionalTaskEntity.isPresent()) {
            return taskMapper.toDTO(optionalTaskEntity.get());
        } else throw new EntityNotFoundException("Task", "id", id);
    }

    @Override
    public TaskAddResponse addTask(TaskRequest request) {
        Task project = converter.convertToTaskEntity(request);
        taskRepository.save(project);
        return new TaskAddResponse(true);
    }

    @Override
    public TaskUpdateResponse updateTask(String id, TaskRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> oldEntity = taskRepository.findById(uuid);
        if (oldEntity.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        Task newEntity = converter.convertToTaskEntity(oldEntity.get(), request);
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
