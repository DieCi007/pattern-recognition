package com.welld.patternrecognition.exception;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> otherExceptions(Exception ex, WebRequest request) {
        ResponseStatus annotation = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
        if (null != annotation) {
            return fromException(ex, request, annotation.code());
        }
        return unhandledExceptions(ex, request);
    }

    @ExceptionHandler(value = PointExistsException.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> pointExistsException(Exception ex, WebRequest request) {
        return fromException(ex, request, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<Map<String, Object>> fromException(Exception ex, WebRequest request, HttpStatus httpStatus) {
        Map<String, Object> result = fromException(httpStatus, ex, request);
        return new ResponseEntity<>(result, httpStatus);
    }

    private static Map<String, Object> fromException(HttpStatus httpStatus, Exception ex, WebRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("timestamp", System.currentTimeMillis());
        result.put("status", httpStatus.value());
        result.put("error", httpStatus.getReasonPhrase());
        result.put("exception", ex.getClass().getSimpleName());
        result.put("message", ex.getMessage());
        result.put("path", getPath(request));

        return result;
    }

    private ResponseEntity<Map<String, Object>> unhandledExceptions(Exception ex, WebRequest request) {
        Map<String, Object> result = maskingException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "We cannot handle your request now. Please try again later",
                request);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static Map<String, Object> maskingException(HttpStatus httpStatus, String message, WebRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("timestamp", System.currentTimeMillis());
        result.put("status", httpStatus.value());
        result.put("error", httpStatus.getReasonPhrase());
        result.put("exception", "Undisclosed");
        result.put("message", message);
        result.put("path", getPath(request));
        return result;
    }

    private static String getPath(WebRequest request) {
        String path = request.getDescription(false);
        if (path.length() > 0) {
            path = path.replaceFirst("uri=", "");
        }
        return path;
    }
}
