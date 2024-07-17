package com.tfg.bpp.adapter.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorType {
  CANNOT_READ_BPP_FILE(400, "CANNOT_READ_BPP_FILE", "bpp-adapter.bpp-instance.error.cannot-read-bpp-file"),
  CANNOT_PARSE_BPP_FILE(400, "CANNOT_PARSE_BPP_FILE", "bpp-adapter.bpp-instance.error.cannot-parse-bpp-file"),
  ERR_CREATING_SOLUTION(500, "ERR_CREATING_SOLUTION", "bpp-adapter.bpp-solution.error.err-creating-solution");

  private final int code;

  private final String key;

  private final String messageI18nLocation;
}
