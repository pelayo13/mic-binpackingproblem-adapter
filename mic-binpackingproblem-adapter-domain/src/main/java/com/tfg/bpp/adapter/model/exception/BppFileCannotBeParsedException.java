package com.tfg.bpp.adapter.model.exception;

import lombok.Getter;

@Getter
public class BppFileCannotBeParsedException extends BppInstanceByBppFileException {

  private static final ErrorType ERROR_CONSTANT = ErrorType.CANNOT_PARSE_BPP_FILE;

  public BppFileCannotBeParsedException(String message, int errorLine) {
    super(String.format("%s %s", ERROR_CONSTANT.getKey(), message), errorLine);
  }

  public BppFileCannotBeParsedException(String message, Exception exception, int errorLine) {
    super(String.format("%s %s", ERROR_CONSTANT.getKey(), message), exception, errorLine);
  }

  @Override
  public ErrorType getErrorConstant() {
    return ERROR_CONSTANT;
  }
}
