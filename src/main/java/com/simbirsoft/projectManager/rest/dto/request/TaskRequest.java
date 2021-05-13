package com.simbirsoft.projectManager.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Задача")
public class TaskRequest {

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Статус задачи")
    private String status;

    @Schema(description = "Приоритет задачи")
    private String priority;

    @Schema(description = "ID релиза")
    private UUID releaseId;

    @Schema(description = "ID проекта")
    private UUID projectId;

    @Schema(description = "ID пользователя")
    private UUID userId;

    public TaskRequest () {

    }

    public TaskRequest(String name, String description, String status, String priority,
                       UUID releaseId, UUID projectId, UUID userId) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.releaseId = releaseId;
        this.projectId = projectId;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public UUID getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(UUID releaseId) {
        this.releaseId = releaseId;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /*@Override
    public String toString() {
        return "TaskRequest{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }*/
}
