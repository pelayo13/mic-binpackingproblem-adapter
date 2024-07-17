package com.tfg.bpp.adapter.model.exception;

import lombok.Getter;

@Getter
public class BppFileCannotBeReadException extends BppInstanceByBppFileException {

  private static final ErrorType ERROR_CONSTANT = ErrorType.CANNOT_READ_BPP_FILE;

  public BppFileCannotBeReadException(String message, int errorLine) {
    super(String.format("%s %s", ERROR_CONSTANT.getKey(), message), errorLine);
  }

  public BppFileCannotBeReadException(String message, Exception exception, int errorLine) {
    super(String.format("%s %s", ERROR_CONSTANT.getKey(), message), exception, errorLine);
  }

  @Override
  public ErrorType getErrorConstant() {
    return ERROR_CONSTANT;
  }
}
