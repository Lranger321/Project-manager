package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.rest.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.rest.dto.response.UserResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface UserService {

    UserResponse getUserById(String id);

    @Transactional(readOnly = true)
    UserResponse findByEmail(String email);

    UUID registerUser(UserRegisterRequest request);

    boolean deleteUser(String id);

    boolean updateUser(String id, UserRegisterRequest request);
}
