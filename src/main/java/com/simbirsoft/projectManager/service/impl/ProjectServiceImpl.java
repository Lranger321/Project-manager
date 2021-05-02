package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectUpdateResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.service.ProjectService;
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
        Optional<Project> projectOptional = projectRepository.findById(uuid);
        return projectOptional.map(projectMapper::toDto)
                .orElseThrow(() -> new ProjectNotFoundException("id", id));
    }

    @Override
    public ProjectAddResponse addProject(ProjectRequest request) {
        Project project = projectMapper.toProjectEntity(request);
        UUID id = projectRepository.save(project).getId();
        return new ProjectAddResponse(id,true);
    }

    @Override
    public ProjectUpdateResponse updateProject(String id, ProjectRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<Project> projectOptional = projectRepository.findById(uuid);
        if (projectOptional.isEmpty()) {
            throw new ProjectNotFoundException("id", id);
        }
        Project newEntity = projectMapper.toProjectEntity(request);
        newEntity.setId(uuid);
        projectRepository.save(newEntity);
        return new ProjectUpdateResponse(true);
    }

    @Override
    public ProjectDeleteResponse deleteById(String id) {
        UUID uuid = UUID.fromString(id);
        if (projectRepository.findById(uuid).isEmpty()) {
            throw new ProjectNotFoundException("id", uuid.toString());
        }
        projectRepository.deleteById(uuid);
        return new ProjectDeleteResponse(true);
    }
}
