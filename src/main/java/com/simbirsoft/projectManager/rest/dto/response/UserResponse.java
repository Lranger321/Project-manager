package com.simbirsoft.projectManager.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Пользователь")
public class UserResponse {

  @Schema(description = "ID пользователя")
  private UUID id;

  @Schema(description = "Имя пользователя")
  private String name;

  @Schema(description = "Логин (e-mail) пользователя")
  private String login;

  @Schema(description = "Дата регистрации")
  private LocalDateTime date;


  private String password;

  public UserResponse() {
  }

  public UUID getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public void setId(UUID id) {
    this.id = id;
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

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
