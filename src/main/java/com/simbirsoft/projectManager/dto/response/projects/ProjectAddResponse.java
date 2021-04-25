package com.simbirsoft.projectManager.dto.response.projects;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashMap;

@Schema(description = "Ответ об добавление проекта")
public class ProjectAddResponse {

    @Schema(description = "Результат выполнения")
    boolean result;

    @Schema(description = "Ошибки")
    HashMap<String,String> errors;

    public ProjectAddResponse(boolean result, HashMap<String, String> errors) {
        this.result = result;
        this.errors = errors;
    }

    public ProjectAddResponse(boolean result) {
        this.result = result;
    }
}
