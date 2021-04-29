package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ProjectMapper {
    @Mapping(source = "dateStart", target = "startTime")
    @Mapping(source = "dateEnd", target = "releaseTime")
    ProjectResponse toDTO(Project project);

    @Mapping(source = "startTime", target = "dateStart")
    @Mapping(source = "releaseTime", target = "dateEnd")
    Project toProjectEntity(ProjectRequest projectResponse);
}
