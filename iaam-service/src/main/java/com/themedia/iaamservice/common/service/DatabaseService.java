package com.themedia.iaamservice.common.service;

import com.themedia.iaamservice.common.entity.UserEntity;

import java.util.Optional;

public interface DatabaseService {

    Optional<UserEntity> getUser(String username);

    UserEntity saveUserDetails(UserEntity userEntity);
}
