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

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(final UserNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(UserOperationException.class)
    public ResponseEntity<String> handleUserOperationException(final UserOperationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(LogOperationException.class)
    public ResponseEntity<String> handleLogOperationException(final LogOperationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(final RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NoResultFoundException.class)
    public ResponseEntity<String> handleNoResultFoundException(final NoResultFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<String> handleInvalidFieldException(final InvalidFieldException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ProductOperationException.class)
    public ResponseEntity<String> handleProductOperationException(final ProductOperationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(FailedToMapException.class)
    public ResponseEntity<String> handleFailedToMapException(final FailedToMapException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
