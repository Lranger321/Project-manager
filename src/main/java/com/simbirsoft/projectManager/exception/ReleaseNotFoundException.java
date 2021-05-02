package com.simbirsoft.projectManager.exception;

public class ReleaseNotFoundException extends RuntimeException {
    private final String field;
    private final String value;

    public ReleaseNotFoundException(String field, String value) {
        super(String.format("Cannot find release with %s = %s", field, value));
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
        return super.toString() + String.format("Cannot find release with %s = %s", field, value);
    }
}
