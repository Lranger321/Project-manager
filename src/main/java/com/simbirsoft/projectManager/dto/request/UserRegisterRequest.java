package com.simbirsoft.projectManager.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegisterRequest {

    @JsonProperty("full_name")
    private String fullName;

    private String email;

    private String password;

}
