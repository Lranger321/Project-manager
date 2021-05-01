package com.simbirsoft.projectManager.dto.response.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ об удалении пользователя")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDeleteResponse {

    @Schema(description = "Результат выполнения")
    private Boolean result;

    public UserDeleteResponse() {
    }

    public UserDeleteResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
