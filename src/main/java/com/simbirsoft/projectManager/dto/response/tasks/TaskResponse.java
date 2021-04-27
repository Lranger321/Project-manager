package com.simbirsoft.projectManager.dto.response.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Задача")
public class TaskResponse {

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Назначенные сотрудники")
    private List<UserResponse> users;

    @Schema(description = "Время старта задачи")
    @JsonProperty("start_date")
    private String startDate;

    @Schema(description = "Время релиза задачи")
    @JsonProperty("end_date")
    private String endDate;

    public TaskResponse() {
    }

    public TaskResponse(String name, String description, List<UserResponse> users, String startDate, String endDate) {
        this.name = name;
        this.description = description;
        this.users = users;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
