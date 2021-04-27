package com.simbirsoft.projectManager.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Регистрация пользователя")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegisterRequest {

    @Schema(description = "Полное имя пользователя")
    @JsonProperty("full_name")
    private String fullName;

    @Schema(description = "Электронная почта пользователя")
    private String email;

    @Schema(description = "Пароль пользователя")
    private String password;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
