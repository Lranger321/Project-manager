package com.simbirsoft.projectManager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление пользователями")
@RestController
@RequestMapping("api/users")
public class UserController {

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/login")
    public ResponseEntity login(){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity register(){
        return null;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable String id){
        return null;
    }

}
