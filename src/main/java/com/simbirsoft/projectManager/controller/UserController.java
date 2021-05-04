package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.UserResponse;
import com.simbirsoft.projectManager.exception.BadRequestException;
import com.simbirsoft.projectManager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
        return ResponseEntity.ok(false);
    }

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/register")
    public ResponseEntity<UUID> register(@RequestBody UserRegisterRequest request) {
        if (!request.isNotEmpty()) {
            throw new BadRequestException("some of required fields are empty");
        }
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @Operation(summary = "Обновить информацию о пользователе")
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String id,
                                              @RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @Operation(summary = "Получить пользователя по Id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
