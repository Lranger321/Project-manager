package com.simbirsoft.projectManager.dto.response.projects;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Ответ о добавлении проекта")
public class ProjectAddResponse {

    @Schema(description = "ID проекта")
    private UUID id;

    @Schema(description = "Результат выполнения")
    private boolean result;

    public ProjectAddResponse() {

    }

    public ProjectAddResponse(UUID id, boolean result) {
        this.id = id;
        this.result = result;
    }

    public ProjectAddResponse(boolean result) {
        this.result = result;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

}
