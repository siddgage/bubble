package com.themedia.iaamservice.authentication.controller;


import com.themedia.iaamservice.authentication.model.AuthenticationRequest;
import com.themedia.iaamservice.authentication.model.AuthenticationResponse;
import com.themedia.iaamservice.authentication.service.AuthenticationService;
import com.themedia.iaamservice.common.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.themedia.bubblelib.constant.URLConstant.V1;
import static com.themedia.iaamservice.common.constant.UserUrlConstant.*;

@RestController
@RequestMapping(V1 + USER_BASE_URL + AUTHENTICATION)
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserAuthController {

    private final AuthenticationService authenticationService;

    @PostMapping(value = SIGNUP, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<AuthenticationResponse> createUser(@ModelAttribute UserModel userModel) {
        log.debug("sign up user: {}", userModel.toString());
        return new ResponseEntity<>(authenticationService.createUser(userModel), HttpStatus.CREATED);
    }

    @PostMapping(value = LOGIN, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<AuthenticationResponse> loginUser(@ModelAttribute AuthenticationRequest request) {
        log.debug("logging in user: {}", request.getUsername());
        return new ResponseEntity<>(authenticationService.authenticateUser(request), HttpStatus.OK);
    }
}
