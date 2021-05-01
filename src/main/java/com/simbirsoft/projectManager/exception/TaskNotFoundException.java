package com.simbirsoft.projectManager.exception;

public class TaskNotFoundException extends RuntimeException {
    private final String field;
    private final String value;

    public TaskNotFoundException(String field, String value) {
        super(String.format("Cannot find task with %s = %s", field, value));
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
        return super.toString() + String.format("Cannot find task with %s = %s", field, value);
    }
}
