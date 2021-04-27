package com.simbirsoft.projectManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Задача")
public class TaskRequest {

    @Schema(description = "Название задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String description;

    @Schema(description = "Время старта задачи")
    private Date startDate;

    @Schema(description = "Время релиза задачи")
    private Date endDate;

    TaskRequest() {
    }

    TaskRequest(String name, String description, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
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

}
