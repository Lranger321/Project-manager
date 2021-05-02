package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {

    private final String field;
    private final String value;

    public ProjectNotFoundException(String field, String value) {
        super(String.format("Cannot find project with %s = %s", field, value));
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Cannot find project with %s = %s", field, value);
    }
}
