package com.simbirsoft.projectManager.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponse {

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Статус задачи")
    private String status;

    @Schema(description = "Приоритет задачи")
    private String priority;

    @Schema(description = "Релиз")
    private ReleaseResponse release;

    @Schema(description = "Проект")
    private ProjectResponse project;

    @Schema(description = "Ответственный пользователь")
    private UserResponse user;

    public TaskResponse() {

    }

    public TaskResponse(String name, String description, String status, String priority, ReleaseResponse release, ProjectResponse project, UserResponse user) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.release = release;
        this.project = project;
        this.user = user;
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

    public ReleaseResponse getRelease() {
        return release;
    }

    public void setRelease(ReleaseResponse release) {
        this.release = release;
    }

    public ProjectResponse getProject() {
        return project;
    }

    public void setProject(ProjectResponse project) {
        this.project = project;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
