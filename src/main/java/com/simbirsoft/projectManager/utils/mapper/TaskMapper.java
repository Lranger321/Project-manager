package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.entity.TaskEntity;
import org.mapstruct.Mapper;


@Mapper
public interface TaskMapper {
    TaskResponse toDTO(TaskEntity task);
}
