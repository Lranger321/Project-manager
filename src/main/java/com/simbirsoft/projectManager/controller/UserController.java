package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.users.UserDeleteResponse;
import com.simbirsoft.projectManager.dto.response.users.UserRegisterResponse;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.users.UserUpdateResponse;
import com.simbirsoft.projectManager.exception.BadRequest;
import com.simbirsoft.projectManager.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление пользователями")
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;

    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/login")
    public ResponseEntity login() {
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
    public UserRegisterResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (!userRegisterRequest.isNotEmpty()) {
            throw new BadRequest("some of required fields are empty");
        }
        return userService.registerUser(userRegisterRequest);
    }

    @Operation(summary = "Обновить информацию пользователя")
    @PutMapping("/update/{id}")
    public UserUpdateResponse updateUser(@PathVariable String id, UserRegisterRequest request) {
        return userService.updateUser(id, request);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public UserDeleteResponse deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(id);
    }

    @Operation(summary = "")
    @GetMapping(value = "/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

}
