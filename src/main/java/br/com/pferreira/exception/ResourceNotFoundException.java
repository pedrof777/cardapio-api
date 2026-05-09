package br.com.pferreira.exception;

/**
 * @author Pedro Ferreira
 */

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
