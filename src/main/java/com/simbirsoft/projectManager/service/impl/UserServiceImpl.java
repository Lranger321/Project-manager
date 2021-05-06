package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.UserResponse;
import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.UserRepository;
import com.simbirsoft.projectManager.service.UserService;
import com.simbirsoft.projectManager.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public UserResponse getUserById(String id) {
      UUID uuid = UUID.fromString(id);
      Optional<User> userOptional = userRepository.findById(uuid);
      return userOptional.map(userMapper::toDto)
              .orElseThrow(() -> new NotFoundException(User.class, "id", id));
    }

    @Transactional
    @Override
    public UUID registerUser(UserRegisterRequest request) {
      User user = userMapper.toUserEntity(request);
      user.setDateRegister(LocalDateTime.now());
      return userRepository.save(user).getId();
    }

    @Transactional
    @Override
    public boolean updateUser(String id, UserRegisterRequest request) {
      UUID uuid = UUID.fromString(id);
      Optional<User> userOptional = userRepository.findById(uuid);
      if (userOptional.isEmpty()) {
        throw new NotFoundException(User.class, "id", id);
      }
      User user = userMapper.toUserEntity(request);
      user.setId(uuid);
      userRepository.save(user);
      return true;
    }

    @Transactional
    @Override
    public boolean deleteUser(String id) {
      UUID uuid = UUID.fromString(id);
      if (userRepository.findById(uuid).isEmpty()) {
        throw new NotFoundException(User.class, "id", id);
      }
      userRepository.deleteById(uuid);
      return true;
    }
}
