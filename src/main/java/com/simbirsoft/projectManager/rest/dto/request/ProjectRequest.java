package com.simbirsoft.projectManager.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Проект")
public class ProjectRequest {

    @Schema(description = "Название проекта")
    private String name;

    @Schema(description = "Статус проекта")
    private String status;

    @Schema(description = "Время старта проекта")
    private String startTime;

    @Schema(description = "Время релиза проекта")
    private String releaseTime;

    public ProjectRequest() {
    }

    public ProjectRequest(String name, String status, String startTime, String releaseTime) {
        this.name = name;
        this.status = status;
        this.startTime = startTime;
        this.releaseTime = releaseTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
}
