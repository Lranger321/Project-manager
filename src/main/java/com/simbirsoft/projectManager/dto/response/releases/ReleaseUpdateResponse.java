package com.simbirsoft.projectManager.dto.response.releases;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об обновлении релиза")
public class ReleaseUpdateResponse {

    @Schema(description = "Результат выполнения")
    boolean result;

    public ReleaseUpdateResponse() {

    }

    public ReleaseUpdateResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
