package com.betrybe.agrix.exception;

/**
 * The type Resource not found exception.
 */
public class FarmNotFoundException extends RuntimeException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }

  public FarmNotFoundException(String message) {
    super(message);
  }


}
