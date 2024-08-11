package com.themedia.iaamservice.common.handler;

import com.themedia.bubblelib.exception.BubbleException;
import com.themedia.bubblelib.model.ExceptionResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(BubbleException.class)
    public ResponseEntity<ExceptionResponseModel> handleEntityNotFoundException(BubbleException ex) {
        return new ResponseEntity<>(ex.getResponseModel(), ex.getStatus());
    }
}
