package com.simbirsoft.projectManager.dto.response.tasks;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Ответ о добавлении задачи")
public class TaskAddResponse {

    @Schema(description = "Результат выполнения")
    private Boolean result;

    @Schema(description = "ID задачи")
    private UUID id;

    public TaskAddResponse(Boolean result) {
        this.result = result;
    }

    public TaskAddResponse(UUID id, Boolean result) {
        this.result = result;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
