package com.simbirsoft.projectManager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashMap;

@Schema(description = "Ответ об изменение проекта")
public class ProjectUpdateResponse {

    @Schema(description = "Результат выполнения")
    boolean result;

    @Schema(description = "Ошибки")
    HashMap<String,String> errors;

    public ProjectUpdateResponse(boolean result, HashMap<String, String> errors) {
        this.result = result;
        this.errors = errors;
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

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }
}
