package com.simbirsoft.projectManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Проект")
public class ProjectRequest {

    private String id;

    @Schema(description = "Название проекта")
    private String name;

    @Schema(description = "Статус проекта")
    private String status;

    @Schema(description = "Время старта проекта")
    private LocalDateTime startTime;

    @Schema(description = "Время релиза проекта")
    private LocalDateTime releaseTime;

    ProjectRequest() {
    }

    ProjectRequest(Integer id, String name, String status, LocalDateTime startTime, LocalDateTime releaseTime) {
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }
}
