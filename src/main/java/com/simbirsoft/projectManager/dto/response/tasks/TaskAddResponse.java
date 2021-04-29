package com.simbirsoft.projectManager.dto.response.tasks;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об добавлении задачи")

public class TaskAddResponse {

    @Schema(description = "Результат выполнения")
    private Boolean result;

    @Schema(description = "Id задачи")
    private String id;

    public TaskAddResponse(Boolean result) {
        this.result = result;
    }

    public TaskAddResponse(String id, Boolean result) {
        this.result = result;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
