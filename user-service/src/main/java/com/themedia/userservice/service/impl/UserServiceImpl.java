package com.themedia.userservice.service.impl;

import com.themedia.userservice.entity.User;
import com.themedia.userservice.repository.UserRepo;
import com.themedia.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public String createUser(final String username) {
        User user = User.builder()
                .username(username)
                .build();

        userRepo.save(user);

        return "Successfully created new user: " + username;
    }
}
