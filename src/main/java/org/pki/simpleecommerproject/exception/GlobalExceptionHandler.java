package org.pki.simpleecommerproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FieldIsNullException.class)
    public ResponseEntity<String> handleFieldIsNullException(final FieldIsNullException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
