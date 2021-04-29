package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.EntityNotFoundException;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.exception.UserNotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.repository.UserRepository;
import com.simbirsoft.projectManager.service.TaskService;
import com.simbirsoft.projectManager.utils.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final ProjectRepository projectRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository,
                           ProjectRepository projectRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse getTaskById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> optionalTaskEntity = taskRepository.findById(uuid);
        if (optionalTaskEntity.isPresent()) {
            System.out.println(taskMapper.toDTO(optionalTaskEntity.get()));
            return taskMapper.toDTO(optionalTaskEntity.get());
        } else throw new EntityNotFoundException("Task", "id", id);
    }

    @Override
    public TaskAddResponse addTask(TaskRequest request) {
        System.out.println(request.toString());
        Task task = taskMapper.toTaskEntity(request);
        User user = userRepository.findById(UUID.fromString(request.getUserId()))
                .orElseThrow(UserNotFoundException::new);
        Project project = projectRepository.findById(UUID.fromString(request.getProjectId()))
                .orElseThrow(ProjectNotFoundException::new);
        task.setUser(user);
        task.setProject(project);
        String taskId = taskRepository.save(task).getId().toString();
        return new TaskAddResponse(taskId, true);
    }

    @Override
    public TaskUpdateResponse updateTask(String id, TaskRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Task> oldEntity = taskRepository.findById(uuid);
        if (oldEntity.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        Task newEntity = taskMapper.toTaskEntity(request);
        newEntity.setId(oldEntity.get().getId());
        taskRepository.save(newEntity);
        return new TaskUpdateResponse(true);
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
