package com.themedia.bubblelib.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponseModel {
    private String message;
    private String timestamp;
}
