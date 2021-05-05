package com.simbirsoft.projectManager.service.impl;

import com.simbirsoft.projectManager.entity.User;
import com.simbirsoft.projectManager.exception.UsernameNotFoundException;
import com.simbirsoft.projectManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserAuthService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserAuthService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = repository.findByFullName(username);
//
//        if (user.isPresent()) {
//            return new org.springframework.security.core.userdetails.User(user.get().getFullName(), user.get().getPassword(),
//                    Collections.singletonList(new SimpleGrantedAuthority("USER")));
//        }
//        throw new UsernameNotFoundException("Invalid username or password.");
        return new org.springframework.security.core.userdetails.User("babur", "asasa",
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
