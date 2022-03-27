package com.welld.patternrecognition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidPointNumberException extends RuntimeException {
    public InvalidPointNumberException(String message) {
        super(message);
    }
}
