package com.simbirsoft.projectManager.dto.response.tasks;

public class TaskDeleteResponse {

    private Boolean result;

    public TaskDeleteResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
