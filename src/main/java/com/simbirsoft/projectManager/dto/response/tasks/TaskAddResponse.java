package com.simbirsoft.projectManager.dto.response.tasks;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об добавлении задачи")
public class TaskAddResponse {

    @Schema(description = "Результат выполнения")
    private Boolean result;

    public TaskAddResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
