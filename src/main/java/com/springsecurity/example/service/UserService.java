package com.springsecurity.example.service;

import com.springsecurity.example.entity.Authority;
import com.springsecurity.example.entity.User;
import com.springsecurity.example.repository.AuthorityRepository;
import com.springsecurity.example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private static final String AUTHORITY_USER = "ROLE_USER";

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    public User registerUser(User user) {
        Set<Authority> authorities = new HashSet<>(Arrays.asList(getAuthority(AUTHORITY_USER)));
        user.setAuthorities(authorities);
        return userRepository.save(user);
    }

    private Authority getAuthority(String authority) {
        return authorityRepository.findById(authority)
                .orElse(authorityRepository.save(new Authority(authority)));
    }
}
