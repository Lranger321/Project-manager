package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.rest.dto.request.TaskRequest;
import com.simbirsoft.projectManager.rest.dto.response.ProjectResponse;
import com.simbirsoft.projectManager.rest.dto.response.ReleaseResponse;
import com.simbirsoft.projectManager.rest.dto.response.TaskResponse;
import com.simbirsoft.projectManager.rest.dto.response.UserResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.Release;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.repository.ReleaseRepository;
import com.simbirsoft.projectManager.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ReleaseRepository releaseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    ReleaseMapper releaseMapper;

    @Autowired
    UserMapper userMapper;

    @Mapping(source = "name", target = "name")
    @Mapping(source = "request.status", target = "status")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "projectId", target = "project")
    @Mapping(source = "releaseId", target = "release")
    @Mapping(source = "userId", target = "user")
    public abstract Task toTaskEntity(TaskRequest request);

    public Project projectFromId (UUID value) {
        return projectRepository.findById(value)
                .orElseThrow(() -> new NotFoundException(Project.class, "id", value.toString()));
    }

    public Release releaseFromId (UUID value) {
        return releaseRepository.findById(value)
                .orElseThrow(() -> new NotFoundException(Release.class, "id", value.toString()));
    }

    public User userFromId (UUID value) {
        return userRepository.findById(value)
                .orElseThrow(() -> new NotFoundException(User.class, "id", value.toString()));
    }

    @Mapping(source = "name", target = "name")
    @Mapping(source = "task.status", target = "status")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "project", target = "project")
    @Mapping(source = "release", target = "release")
    @Mapping(source = "user", target = "user")
    public abstract TaskResponse toDto(Task task);

    public ProjectResponse projectToDto(Project project) {
        return projectMapper.toDto(project);
    }

    public ReleaseResponse releaseToDto(Release release) {
        return releaseMapper.toDto(release);
    }

    public UserResponse userToDto(User user) {
        return userMapper.toDto(user);
    }
}
