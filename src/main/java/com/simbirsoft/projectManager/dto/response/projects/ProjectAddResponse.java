package com.simbirsoft.projectManager.dto.response.projects;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashMap;

@Schema(description = "Ответ об добавление проекта")
public class ProjectAddResponse {

    @Schema(description = "Id проекта")
    private String id;

    @Schema(description = "Результат выполнения")
    boolean result;

    public ProjectAddResponse(String id, boolean result) {
        this.id = id;
        this.result = result;
    }

    public ProjectAddResponse(boolean result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

}
