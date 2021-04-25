package com.simbirsoft.projectManager.dto.response.users;

import java.time.LocalDateTime;

public class UserResponse {

    private String name;

    private String login;

    private String password;

    private LocalDateTime date;

    public UserResponse() {
    }

    public UserResponse(String name, String login, String password, LocalDateTime date) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
