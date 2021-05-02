package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.users.UserDeleteResponse;
import com.simbirsoft.projectManager.dto.response.users.UserRegisterResponse;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.users.UserUpdateResponse;
import com.simbirsoft.projectManager.exception.BadRequest;
import com.simbirsoft.projectManager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление пользователями")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/login")
    public ResponseEntity<Boolean> login() {
        // TODO: complete login through Spring Security
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(UserRegisterRequest request) {
        if (!request.isNotEmpty()) {
            throw new BadRequest("some of required fields are empty");
        }
        return new ResponseEntity<>(userService.registerUser(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Обновить информацию о пользователе")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable String id,
                                         UserRegisterRequest request) {
        return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDeleteResponse> deleteUser(@PathVariable("id") String id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @Operation(summary = "Получить пользователя по Id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

}
