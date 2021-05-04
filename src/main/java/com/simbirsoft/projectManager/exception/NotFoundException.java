package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private final String className;
    private final String field;
    private final String value;

    @Override
    public String toString() {
        return String.format("Cannot find %s with %s : %s", className, field, value);
    }

    public <E> NotFoundException(Class<E> entityClass, String field, String value) {
        super(String.format("Cannot find %s with %s : %s", entityClass.getSimpleName(), field, value));
        this.className = entityClass.getSimpleName();
        this.field = field;
        this.value = value;
    }
}
