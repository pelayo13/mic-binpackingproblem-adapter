package com.tfg.bpp.adapter.model.exception;

public abstract class BppException extends RuntimeException {

  protected BppException(final String message) {
    super(message);
  }

  protected BppException(final String message, final Exception exception) {
    super(message, exception);
  }

  public abstract ErrorType getErrorConstant();
}
