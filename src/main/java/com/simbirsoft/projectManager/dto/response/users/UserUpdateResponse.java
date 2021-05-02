package com.simbirsoft.projectManager.dto.response.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об обновлении пользователя")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserUpdateResponse {

    @Schema(description = "Результат выполнения")
    private Boolean result;

    public UserUpdateResponse() {
    }

    public UserUpdateResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
