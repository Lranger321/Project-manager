package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(source = "fullName", target = "name")
    @Mapping(source = "email", target = "login")
    UserResponse toDTO(User user);
}

