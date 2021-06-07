package com.simbirsoft.projectManager.rest.dto.request;

import com.simbirsoft.projectManager.entity.ProjectStatus;
import com.simbirsoft.projectManager.entity.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Запрос на изменение статуса проекта")
public class ChangeProjectStatusRequest {

    @Schema(description = "Id проекта")
    private UUID id;

    @Schema(description = "Статус проекта")
    private ProjectStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
