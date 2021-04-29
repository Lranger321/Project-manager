package com.simbirsoft.projectManager.dto.response.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegisterResponse {

    @Schema(description = "Id пользователя")
    private String id;

    private boolean result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserRegisterResponse(boolean result) {
        this.result = result;
    }

    public UserRegisterResponse(String id, boolean result) {
        this.id = id;
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
