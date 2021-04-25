package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectUpdateResponse;
import com.simbirsoft.projectManager.entity.ProjectEntity;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.service.Converter;
import com.simbirsoft.projectManager.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final Converter converter;

    public ProjectServiceImpl(ProjectRepository projectRepository, Converter converter) {
        this.projectRepository = projectRepository;
        this.converter = converter;
    }

    @Override
    public ProjectResponse getById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<ProjectEntity> optionalProjectService = projectRepository.findById(uuid);
        if (optionalProjectService.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return converter.convertToProjectResponse(optionalProjectService.get());
    }

    @Override
    public ProjectAddResponse addProject(ProjectRequest request) {
        ProjectEntity project = converter.convertToProjectEntity(request);
        projectRepository.save(project);
        return new ProjectAddResponse(true);
    }

    @Override
    public ProjectUpdateResponse updateProject(String id, ProjectRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<ProjectEntity> oldEntity =projectRepository.findById(uuid);
        if (oldEntity.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        ProjectEntity newEntity = converter.convertToProjectEntity(oldEntity.get(),request);
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
