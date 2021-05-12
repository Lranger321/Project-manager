package com.simbirsoft.projectManager.dto.request;

import com.simbirsoft.projectManager.entity.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Запрос на изменение статуса задачи")
public class ChangeTaskStatusRequest {

    @Schema(description = "Id задачи")
    private UUID id;

    @Schema(description = "Статус задачи")
    private TaskStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
