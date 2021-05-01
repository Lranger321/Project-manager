package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ProjectMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "request.status", target = "status")
    @Mapping(source = "startTime", target = "dateStart", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "releaseTime", target = "dateEnd", dateFormat = "yyyy-MM-dd HH:mm:ss")
    Project toProjectEntity(ProjectRequest request);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "project.status", target = "status")
    @Mapping(source = "dateStart", target = "startTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "dateEnd", target = "releaseTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ProjectResponse toDto(Project project);
}
