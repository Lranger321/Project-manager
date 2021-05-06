package com.simbirsoft.projectManager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Релиз")
public class ReleaseResponse {

    @Schema(description = "Версия релиза")
    private String version;

    @Schema(description = "Дата начала работ")
    private LocalDateTime dateStart;

    @Schema(description = "Дата завершения работ")
    private LocalDateTime dateEnd;

    @Schema(description = "ID проекта")
    private UUID projectId;

    public ReleaseResponse() {

    }

    public ReleaseResponse(String version, LocalDateTime dateStart, LocalDateTime dateEnd, UUID projectId) {
        this.version = version;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.projectId = projectId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }
}
