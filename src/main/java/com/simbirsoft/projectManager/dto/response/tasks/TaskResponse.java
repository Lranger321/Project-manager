package com.simbirsoft.projectManager.dto.response.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;

import java.util.List;

public class TaskResponse {

    private String name;

    private String description;

    private List<UserResponse> users;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("end_date")
    private String endDate;

}
