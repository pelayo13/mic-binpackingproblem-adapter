package com.tfg.bpp.adapter.model.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BppError<T> {

  private ErrorType errorType;
  
  private T elementId;
}
