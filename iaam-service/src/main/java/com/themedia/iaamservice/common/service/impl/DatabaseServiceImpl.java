package com.themedia.iaamservice.common.service.impl;

import com.themedia.iaamservice.common.entity.UserEntity;
import com.themedia.iaamservice.common.repository.UserDetailsRepo;
import com.themedia.iaamservice.common.service.DatabaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DatabaseServiceImpl implements DatabaseService {

    private final UserDetailsRepo userDetailsRepo;

    @Override
    public Optional<UserEntity> getUser(final String username) {
        return userDetailsRepo.findByUsername(username);
    }

    @Override
    public UserEntity saveUserDetails(UserEntity userEntity) {
        log.debug("saving user in database");
        return userDetailsRepo.save(userEntity);
    }
}
