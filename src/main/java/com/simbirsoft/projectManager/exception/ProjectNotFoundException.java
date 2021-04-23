package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return super.toString() +
                "Project not found";
    }
}
