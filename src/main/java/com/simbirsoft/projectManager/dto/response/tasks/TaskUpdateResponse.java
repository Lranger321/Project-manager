package com.simbirsoft.projectManager.dto.response.tasks;

public class TaskUpdateResponse {

    private Boolean result;

    public TaskUpdateResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
