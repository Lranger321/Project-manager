package com.simbirsoft.projectManager.dto.response.releases;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об удалении релиза")
public class ReleaseDeleteResponse {

    @Schema(description = "Результат выполнения")
    boolean result;

    public ReleaseDeleteResponse() {

    }

    public ReleaseDeleteResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
