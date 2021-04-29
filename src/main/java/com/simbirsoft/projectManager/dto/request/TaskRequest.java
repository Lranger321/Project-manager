package com.simbirsoft.projectManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Задача")
public class TaskRequest {

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Id пользователя")
    private String userId;

    @Schema(description = "Id проекта")
    private String projectId;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Время старта задачи")
    private Date startDate;

    @Schema(description = "Время релиза задачи")
    private Date endDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "TaskRequest{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
