package com.tfg.bpp.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BppEvaluationFunction {
  BINS_NUMBER,
  TARDINESS,
  LATENESS,
  MAXIMUM_LATENESS,
  AVAILABLE_CAPACITY,
  FITNESS
}
