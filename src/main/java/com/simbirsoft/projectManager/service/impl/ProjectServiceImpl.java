package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.ChangeProjectStatusRequest;
import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.ProjectResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.ProjectStatus;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.service.ProjectService;
import com.simbirsoft.projectManager.utils.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final TaskRepository taskRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public ProjectResponse getById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Project> projectOptional = projectRepository.findById(uuid);
        return projectOptional.map(projectMapper::toDto)
                .orElseThrow(() -> new NotFoundException(Project.class, "id", id));
    }

    @Transactional
    @Override
    public UUID addProject(ProjectRequest request) {
        Project project = projectMapper.toProjectEntity(request);
        return projectRepository.save(project).getId();
    }

    @Transactional
    @Override
    public boolean updateProject(String id, ProjectRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Project> projectOptional = projectRepository.findById(uuid);
        if (projectOptional.isEmpty()) {
            throw new NotFoundException(Project.class, "id", id);
        }
        Project newEntity = projectMapper.toProjectEntity(request);
        newEntity.setId(uuid);
        projectRepository.save(newEntity);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteById(String id) {
        UUID uuid = UUID.fromString(id);
        if (projectRepository.findById(uuid).isEmpty()) {
            throw new NotFoundException(Project.class, "id", id);
        }
        projectRepository.deleteById(uuid);
        return true;
    }

    @Transactional
    @Override
    public boolean changeStatus(ChangeProjectStatusRequest request) {
        Optional<Project> optionalProject = projectRepository.findById(request.getId());
        if (optionalProject.isEmpty()) {
            throw new NotFoundException(Project.class, "id", request.getId().toString());
        }
        Project project = optionalProject.get();
        if (request.getStatus().equals(ProjectStatus.DONE)) {
            if (taskRepository.countNotDoneTask(request.getId()) != 0) {
                return false;
            }
        }
        project.setStatus(request.getStatus());
        return true;
    }
}
