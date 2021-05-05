package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException {

    private String message;

    public UsernameNotFoundException() {
        this.message = "Пользователь не найден";
    }

    public UsernameNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

