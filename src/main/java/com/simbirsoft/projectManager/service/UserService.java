package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.UserResponse;

import java.util.UUID;

public interface UserService {

    UserResponse getUserById(String id);

    UUID registerUser(UserRegisterRequest request);

    boolean deleteUser(String id);

    boolean updateUser(String id, UserRegisterRequest request);

}
