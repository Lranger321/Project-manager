package com.simbirsoft.projectManager.dto.response.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об удалении проекта")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDeleteResponse {

    @Schema(description = "Результат выполнения")
    private boolean result;

    public ProjectDeleteResponse() {

    }

    public ProjectDeleteResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
