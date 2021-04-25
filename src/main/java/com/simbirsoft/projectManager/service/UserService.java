package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.users.UserDeleteResponse;
import com.simbirsoft.projectManager.dto.response.users.UserRegisterResponse;
import com.simbirsoft.projectManager.dto.response.users.UserUpdateResponse;

public interface UserService {

    UserResponse getUserById(String id);

    UserRegisterResponse registerUser(UserRegisterRequest request);

    UserDeleteResponse deleteUser(String id);

    UserUpdateResponse updateUser(String id, UserRegisterRequest request);

}
