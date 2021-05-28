package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.NotFoundException;
import com.simbirsoft.projectManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserAuthService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = repository.findByEmail(email);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(user.get().getFullName(),
                    user.get().getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
        }
        throw new NotFoundException(User.class, "fullName", email);
    }
    //if we will keep the role in user table new SimpleGrantedAuthority(user.get().getRole()))
}
