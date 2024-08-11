package com.themedia.iaamservice.authentication.service;

import com.themedia.iaamservice.authentication.model.AuthenticationRequest;
import com.themedia.iaamservice.authentication.model.AuthenticationResponse;
import com.themedia.iaamservice.common.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

public interface AuthenticationService {

    @Transactional
    AuthenticationResponse createUser(UserModel userModel);

    AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);
}
