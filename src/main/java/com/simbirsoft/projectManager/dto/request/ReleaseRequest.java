package com.simbirsoft.projectManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Релиз")
public class ReleaseRequest {

    @Schema(description = "Версия релиза")
    private String version;

    @Schema(description = "Дата начала работ")
    private String dateStart;

    @Schema(description = "Дата завершения работ")
    private String dateEnd;

    @Schema(description = "ID проекта")
    private UUID projectId;

    public ReleaseRequest() {

    }

    public ReleaseRequest(String version, String dateStart, String dateEnd, UUID projectId) {
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

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }
}
