package com.simbirsoft.projectManager.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Проект")
class ProjectRequestDto {

    @Schema(description = "ID проекта")
    private Integer id;

    @Schema(description = "Название проекта")
    private String name;

    @Schema(description = "Статус проекта")
    private String status;

    @Schema(description = "Время старта проекта")
    private LocalDateTime startTime;

    @Schema(description = "Время релиза проекта")
    private LocalDateTime releaseTime;

    ProjectRequestDto() {
    }

    ProjectRequestDto(Integer id, String name, String status, LocalDateTime startTime, LocalDateTime releaseTime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startTime = startTime;
        this.releaseTime = releaseTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
