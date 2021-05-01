package com.simbirsoft.projectManager.dto.response.releases;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Ответ о добавлении релиза")
public class ReleaseAddResponse {

    @Schema(description = "ID релиза")
    private UUID id;

    @Schema(description = "Ответ о добавлении релиза")
    private boolean result;

    public ReleaseAddResponse() {

    }

    public ReleaseAddResponse(UUID id, boolean result) {
        this.id = id;
        this.result = result;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
