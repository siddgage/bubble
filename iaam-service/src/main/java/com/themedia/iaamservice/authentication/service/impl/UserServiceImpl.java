package com.themedia.iaamservice.authentication.service.impl;


import com.themedia.iaamservice.authentication.service.UserService;
import com.themedia.iaamservice.common.entity.UserEntity;
import com.themedia.iaamservice.common.service.DatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final DatabaseService databaseService;

    @Override
    public Optional<UserEntity> getUser(String username) {
        return databaseService.getUser(username);
    }
}
