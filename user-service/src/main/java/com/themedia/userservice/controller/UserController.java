package com.themedia.userservice.controller;

import com.themedia.bubblelib.model.ResponseModel;
import com.themedia.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/v1")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(name = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> createUser(@RequestBody String username) {
        try {
            return new ResponseEntity<>(
                    ResponseModel.builder().status(HttpStatus.CREATED).message(userService.createUser(username)).build(),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ResponseModel.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build()
            );
        }

    }
}
