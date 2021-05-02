package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Deprecated
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private String entityName;
    private String field;
    private String value;

    public String getEntityName() {
        return entityName;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("There is no %s with %s : %s", entityName, field, value);
    }

    public EntityNotFoundException(String entityName, String field, Object value) {
        super(String.format("There is no %s with %s : %s", entityName, field, value));
        this.entityName = entityName;
        this.field = field;
    }
}
