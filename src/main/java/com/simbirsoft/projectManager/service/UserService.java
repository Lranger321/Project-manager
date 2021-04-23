package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.GetUserResponse;
import com.simbirsoft.projectManager.dto.response.UserDeleteResponse;
import com.simbirsoft.projectManager.dto.response.UserRegisterResponse;
import com.simbirsoft.projectManager.dto.response.UserUpdateResponse;

public interface UserService {

    GetUserResponse getUserById(String id);

    UserRegisterResponse registerUser(UserRegisterRequest request);

    UserDeleteResponse deleteUser(String id);

    UserUpdateResponse updateUser(String id, UserRegisterRequest request);

}
