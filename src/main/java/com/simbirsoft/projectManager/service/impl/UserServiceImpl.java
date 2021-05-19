package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.rest.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.rest.dto.response.UserResponse;
import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.UserRepository;
import com.simbirsoft.projectManager.service.UserService;
import com.simbirsoft.projectManager.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                         UserMapper userMapper, PasswordEncoder passwordEncoder) {
      this.userRepository = userRepository;
      this.userMapper = userMapper;
      this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponse getUserById(String id) {
      UUID uuid = UUID.fromString(id);
      Optional<User> userOptional = userRepository.findById(uuid);
      return userOptional.map(userMapper::toDto)
              .orElseThrow(() -> new NotFoundException(User.class, "id", id));
    }

    @Transactional(readOnly = true)
    @Override
    public UserResponse findByEmail(String email) {
      Optional<User> userOptional = userRepository.findByEmail(email);
      return userOptional.map(userMapper::toDto)
              .orElseThrow(() -> new NotFoundException(User.class, "id", email));
    }

    @Transactional
    @Override
    public UUID registerUser(UserRegisterRequest request) {
      User user = userMapper.toUserEntity(request);
      user.setDateRegister(LocalDateTime.now());
      user.setPassword(passwordEncoder.encode(request.getPassword()));
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
