package com.themedia.bubblelib.exception;

import org.springframework.http.HttpStatus;

public class HttpException extends BubbleException {

    public HttpException(String message) {
        super(message, HttpStatus.FAILED_DEPENDENCY);
    }
}
