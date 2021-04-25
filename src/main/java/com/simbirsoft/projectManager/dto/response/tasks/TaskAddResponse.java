package com.simbirsoft.projectManager.dto.response.tasks;

public class TaskAddResponse {

    private Boolean result;

    public TaskAddResponse(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
