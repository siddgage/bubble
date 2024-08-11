package com.themedia.iaamservice.authentication.service;

import com.themedia.iaamservice.common.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> getUser(String username);
}
