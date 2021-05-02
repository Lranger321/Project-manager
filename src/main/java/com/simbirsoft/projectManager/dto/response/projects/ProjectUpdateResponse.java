package com.simbirsoft.projectManager.dto.response.projects;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об изменении проекта")
public class ProjectUpdateResponse {

    @Schema(description = "Результат выполнения")
    boolean result;

    public ProjectUpdateResponse() {
    }

    public ProjectUpdateResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
