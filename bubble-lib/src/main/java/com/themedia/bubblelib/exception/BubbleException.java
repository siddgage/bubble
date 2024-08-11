package com.themedia.bubblelib.exception;


import com.themedia.bubblelib.model.ExceptionResponseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Slf4j
public class BubbleException extends RuntimeException {

    private String errMsg;
    private String timestamp = LocalDateTime.now().toString();
    private HttpStatus status;

    public BubbleException(String message, HttpStatus status) {
        super(message);
        this.errMsg = message;
        this.status = status;
        logError();
    }

    private void logError() {
        log.error(this.errMsg);
    }

    public ExceptionResponseModel getResponseModel() {
        return new ExceptionResponseModel(errMsg, timestamp);
    }

}
