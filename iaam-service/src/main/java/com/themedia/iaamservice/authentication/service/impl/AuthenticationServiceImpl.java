package com.themedia.iaamservice.authentication.service.impl;


import com.themedia.bubblelib.exception.HttpException;
import com.themedia.bubblelib.exception.UserCreationException;
import com.themedia.bubblelib.model.ResponseModel;
import com.themedia.iaamservice.authentication.model.AuthenticationRequest;
import com.themedia.iaamservice.authentication.model.AuthenticationResponse;
import com.themedia.iaamservice.authentication.service.AuthenticationService;
import com.themedia.iaamservice.authentication.service.JwtService;
import com.themedia.iaamservice.common.entity.UserEntity;
import com.themedia.iaamservice.common.enums.Role;
import com.themedia.bubblelib.exception.EntityNotFoundException;
import com.themedia.bubblelib.exception.UserAlreadyExistException;
import com.themedia.iaamservice.common.model.UserModel;
import com.themedia.iaamservice.common.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.themedia.iaamservice.common.constant.UserUrlConstant.USER_SERVICE_CREATE;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private RestTemplate restTemplate;

    private final DatabaseService databaseService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse createUser(UserModel userModel) {

        Optional<UserEntity> optionalUser = databaseService.getUser(userModel.getUsername());

        if (optionalUser.isPresent())
            throw new UserAlreadyExistException(userModel.getUsername());

        UserEntity userEntity = UserEntity.builder()
                .username(userModel.getUsername())
                .name(userModel.getFirstName())
                .email(userModel.getEmail())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .role(Role.USER)
                .build();

        databaseService.saveUserDetails(userEntity);

        return new AuthenticationResponse(jwtService.generateToken(userEntity), userEntity.getRole());
    }

    @Override
    public AuthenticationResponse authenticateUser(AuthenticationRequest request) {

        UserEntity userEntity = databaseService.getUser(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("Invalid username"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        log.debug("authenticated successfully");

        return new AuthenticationResponse(jwtService.generateToken(userEntity), userEntity.getRole());
    }
}
