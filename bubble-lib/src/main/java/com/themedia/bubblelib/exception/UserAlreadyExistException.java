package com.themedia.bubblelib.exception;


import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends BubbleException {
    public UserAlreadyExistException(String username) {
        super("User " + username + " already exist", HttpStatus.BAD_REQUEST);
    }
}
