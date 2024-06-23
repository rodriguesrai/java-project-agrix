package com.betrybe.agrix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handleResourceNotFoundException(FarmNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CropNotFoundException.class)
  public ResponseEntity<String> handleResourceNotFoundException(CropNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(FertilizerNotFoundException.class)
  public ResponseEntity<String> handleResourceNotFoundException(FertilizerNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

}
