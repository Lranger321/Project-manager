package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectUpdateResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.EntityNotFoundException;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.service.ProjectService;
import com.simbirsoft.projectManager.utils.Converter;
import com.simbirsoft.projectManager.utils.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectResponse getById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<Project> optionalProjectService = projectRepository.findById(uuid);
        if (optionalProjectService.isPresent()) {
            return projectMapper.toDTO(optionalProjectService.get());
        } else throw new EntityNotFoundException("Project", "id", id);
    }

    @Override
    public ProjectAddResponse addProject(ProjectRequest request) {
        Project project = projectMapper.toProjectEntity(request);
        String id = projectRepository.save(project).getId().toString();
        return new ProjectAddResponse(id,true);
    }

    @Override
    public ProjectUpdateResponse updateProject(String id, ProjectRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Project> oldEntity = projectRepository.findById(uuid);
        if (oldEntity.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        Project newEntity = projectMapper.toProjectEntity(request);
        newEntity.setId(oldEntity.get().getId());
        projectRepository.save(newEntity);
        return new ProjectUpdateResponse(true);
    }

    @Override
    public ProjectDeleteResponse deleteById(String id) {
        UUID uuid = UUID.fromString(id);
        if (projectRepository.findById(uuid).isEmpty()) {
            throw new ProjectNotFoundException();
        }
        projectRepository.deleteById(uuid);
        return new ProjectDeleteResponse(true);
    }
}
