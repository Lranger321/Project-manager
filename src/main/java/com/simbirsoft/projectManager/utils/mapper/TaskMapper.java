package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface TaskMapper {
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "id", ignore = true)
    TaskResponse toDTO(Task task);

    Task toTaskEntity(TaskRequest request);
}
