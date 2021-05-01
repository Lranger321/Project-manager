package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.exception.TaskNotFoundException;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.service.TaskService;
import com.simbirsoft.projectManager.utils.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,
                           TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse getTaskById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> taskOptional = taskRepository.findById(uuid);
        return taskOptional.map(taskMapper::toDto)
                .orElseThrow(() -> new TaskNotFoundException("id", id));
    }

    @Override
    public TaskAddResponse addTask(TaskRequest request) {
        Task task = taskMapper.toTaskEntity(request);
        UUID uuid = taskRepository.save(task).getId();
        return new TaskAddResponse(uuid, true);
    }

    @Override
    public TaskUpdateResponse updateTask(String id, TaskRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> taskOptional = taskRepository.findById(uuid);
        if (taskOptional.isEmpty()) {
            throw new TaskNotFoundException("id", id);
        }
        Task newTask = taskMapper.toTaskEntity(request);
        newTask.setId(taskOptional.get().getId());
        taskRepository.save(newTask);
        return new TaskUpdateResponse(true);
    }

    @Override
    public TaskDeleteResponse deleteTask(String id) {
        UUID uuid = UUID.fromString(id);
        if (taskRepository.findById(uuid).isEmpty()) {
            throw new TaskNotFoundException("id", id);
        }
        taskRepository.deleteById(uuid);
        return new TaskDeleteResponse(true);
    }
}
