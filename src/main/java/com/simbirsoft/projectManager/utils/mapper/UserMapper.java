package com.simbirsoft.projectManager.utils.mapper;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.UserResponse;
import com.simbirsoft.projectManager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    User toUserEntity(UserRegisterRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fullName", target = "name")
    @Mapping(source = "email", target = "login")
    @Mapping(source = "dateRegister", target = "date", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserResponse toDto(User user);
}

