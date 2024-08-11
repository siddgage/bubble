package com.themedia.bubblelib.exception;

import org.springframework.http.HttpStatus;

public class UserCreationException extends BubbleException {
    public UserCreationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
