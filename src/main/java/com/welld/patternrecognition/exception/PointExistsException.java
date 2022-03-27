package com.welld.patternrecognition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PointExistsException extends RuntimeException {
    public PointExistsException(String message) {
        super(message);
    }
}
