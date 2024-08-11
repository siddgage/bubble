package com.themedia.bubblelib.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BubbleException {
    public EntityNotFoundException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
