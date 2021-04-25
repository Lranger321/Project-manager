package com.simbirsoft.projectManager.dto.response.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashMap;

@Schema(description = "Ответ об удаление проекта")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDeleteResponse {

    @Schema(description = "Результат выполнения")
    boolean result;

    @Schema(description = "Ошибки")
    HashMap<String,String> errors;

    public ProjectDeleteResponse(boolean result, HashMap<String, String> errors) {
        this.result = result;
        this.errors = errors;
    }

    public ProjectDeleteResponse(boolean result) {
        this.result = result;
    }

}
