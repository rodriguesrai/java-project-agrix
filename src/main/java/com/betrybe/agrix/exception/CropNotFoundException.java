package com.betrybe.agrix.exception;

/**
 * The type Crop not found exception.
 */
public class CropNotFoundException extends RuntimeException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }

  public CropNotFoundException(String message) {
    super(message);
  }

}
