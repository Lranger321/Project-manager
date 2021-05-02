package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.users.UserDeleteResponse;
import com.simbirsoft.projectManager.dto.response.users.UserRegisterResponse;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.users.UserUpdateResponse;
import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.UserNotFoundException;
import com.simbirsoft.projectManager.repository.UserRepository;
import com.simbirsoft.projectManager.service.UserService;
import com.simbirsoft.projectManager.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;


  public UserServiceImpl(UserRepository userRepository,
                         UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserResponse getUserById(String id) {
    UUID uuid = UUID.fromString(id);
    Optional<User> userOptional = userRepository.findById(uuid);
    return userOptional.map(userMapper::toDto)
            .orElseThrow(() -> new UserNotFoundException("id", id));
  }


  @Override
  public UserRegisterResponse registerUser(UserRegisterRequest request) {
    User user = userMapper.toUserEntity(request);
    user.setDateRegister(LocalDateTime.now());
    String id = userRepository.save(user).getId().toString();
    return new UserRegisterResponse(id,true);
  }

  @Override
  public UserUpdateResponse updateUser(String id, UserRegisterRequest request) {
    UUID uuid = UUID.fromString(id);
    Optional<User> userOptional = userRepository.findById(uuid);
    if (userOptional.isEmpty()) {
      throw new UserNotFoundException("id", id);
    }
    User user = userMapper.toUserEntity(request);
    user.setId(uuid);
    userRepository.save(user);
    return new UserUpdateResponse(true);
  }

  @Override
  public UserDeleteResponse deleteUser(String id) {
    UUID uuid = UUID.fromString(id);
    if (userRepository.findById(uuid).isEmpty()) {
      throw new UserNotFoundException("id", id);
    }
    userRepository.deleteById(uuid);
    return new UserDeleteResponse(true);
  }
}
