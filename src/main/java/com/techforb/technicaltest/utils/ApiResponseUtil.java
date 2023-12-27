package com.techforb.technicaltest.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {

    public static ResponseEntity<String> success(String message) {
        return formatResponse(message, HttpStatus.OK);
    }

    public static ResponseEntity<String> badRequest(String message) {
        return formatResponse(message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<String> internalServerError(String message) {
        return formatResponse(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ResponseEntity<String> formatResponse(String message, HttpStatus status) {
        String jsonResponse = "{\"message\": \"" + message + "\"}";
        return new ResponseEntity<>(jsonResponse, status);
    }
      public static ResponseEntity<String> created(String message) {
        return formatResponse(message, HttpStatus.CREATED);
    }
}
