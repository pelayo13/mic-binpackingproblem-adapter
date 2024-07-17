package com.tfg.bpp.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BppTestCaseResults {

  private int numberBins;

  private double averageTardinessStoredItems;

  private double seconds;
}
