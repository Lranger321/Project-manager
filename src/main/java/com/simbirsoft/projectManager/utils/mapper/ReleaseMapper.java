package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.request.ReleaseRequest;
import com.simbirsoft.projectManager.dto.response.ReleaseResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.Release;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Mapper
public abstract class ReleaseMapper {

    @Autowired
    ProjectRepository projectRepository;

    @Mapping(source = "version", target = "version")
    @Mapping(source = "dateStart", target = "dateStart", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "dateEnd", target = "dateEnd", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "projectId", target = "project")
    public abstract Release toReleaseEntity (ReleaseRequest request);

    public Project projectFromId (UUID value) {
        return projectRepository.findById(value)
                .orElseThrow(() -> new NotFoundException(Project.class, "id", value.toString()));
    }

    @Mapping(source = "version", target = "version")
    @Mapping(source = "dateStart", target = "dateStart", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "dateEnd", target = "dateEnd", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "project.id", target = "projectId")
    public abstract ReleaseResponse toDto (Release release);
}
