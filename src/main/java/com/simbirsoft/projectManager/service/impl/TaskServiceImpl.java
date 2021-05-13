package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.rest.dto.request.TaskRequest;
import com.simbirsoft.projectManager.rest.dto.response.TaskResponse;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.service.TaskService;
import com.simbirsoft.projectManager.utils.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public TaskResponse getTaskById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> taskOptional = taskRepository.findById(uuid);
        return taskOptional.map(taskMapper::toDto)
                .orElseThrow(() -> new NotFoundException(Task.class, "id", id));
    }

    @Transactional
    @Override
    public UUID addTask(TaskRequest request) {
        Task task = taskMapper.toTaskEntity(request);
        return taskRepository.save(task).getId();
    }

    @Transactional
    @Override
    public boolean updateTask(String id, TaskRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> taskOptional = taskRepository.findById(uuid);
        if (taskOptional.isEmpty()) {
            throw new NotFoundException(Task.class, "id", id);
        }
        Task newTask = taskMapper.toTaskEntity(request);
        newTask.setId(taskOptional.get().getId());
        taskRepository.save(newTask);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteTask(String id) {
        UUID uuid = UUID.fromString(id);
        if (taskRepository.findById(uuid).isEmpty()) {
            throw new NotFoundException(Task.class, "id", id);
        }
        taskRepository.deleteById(uuid);
        return true;
    }
}
