package com.simbirsoft.projectManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return "Пользователь не найден";
    }
}

