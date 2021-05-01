package com.simbirsoft.projectManager.dto.response.tasks;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об удалении задачи")
public class TaskDeleteResponse {

    @Schema(description = "Результат выполнения")
    private Boolean result;

    public TaskDeleteResponse() {
    }

    public TaskDeleteResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
