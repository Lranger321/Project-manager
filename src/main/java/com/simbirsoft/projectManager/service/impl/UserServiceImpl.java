package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.users.UserDeleteResponse;
import com.simbirsoft.projectManager.dto.response.users.UserRegisterResponse;
import com.simbirsoft.projectManager.dto.response.users.UserUpdateResponse;
import com.simbirsoft.projectManager.entity.UserEntity;
import com.simbirsoft.projectManager.exception.EntityNotFoundException;
import com.simbirsoft.projectManager.exception.UserNotFoundException;
import com.simbirsoft.projectManager.repository.UserRepository;
import com.simbirsoft.projectManager.utils.Converter;
import com.simbirsoft.projectManager.service.UserService;
import com.simbirsoft.projectManager.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter converter;
    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, Converter converter, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<UserEntity> user = userRepository.findById(uuid);
        if (user.isPresent()) {
            return userMapper.toDTO(user.get());
        } else throw new EntityNotFoundException("User", "id", id);
    }

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        UserEntity user = converter.convertToUserEntity(request);
        userRepository.save(user);
        return new UserRegisterResponse(true);
    }

    @Override
    public UserDeleteResponse deleteUser(String id) {
        UUID uuid = UUID.fromString(id);
        if (userRepository.findById(uuid).isEmpty()) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(uuid);
        return new UserDeleteResponse(true);
    }

    @Override
    public UserUpdateResponse updateUser(String id, UserRegisterRequest request) {
        UUID uuid = UUID.fromString(id);
        Optional<UserEntity> oldUser = userRepository.findById(uuid);
        if (oldUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserEntity user = converter.convertToUserEntity(oldUser.get(), request);
        userRepository.save(user);
        return new UserUpdateResponse(true);
    }
}
