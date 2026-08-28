// src/main/java/com/frauddetect/docverify/exception/GlobalExceptionHandler.java

package com.frauddetect.docverify.exception;

import com.frauddetect.docverify.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Handles unexpected application errors.
     * More specific exception handlers can be added here in later modules.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(
            Exception exception
    ) {
        ApiResponse<Void> response = ApiResponse.error(
                "An unexpected error occurred."
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}