package com.tfg.bpp.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BppAlgorithm {

  private BppGreedyAlgorithmType greedyAlgorithmType;

  private BppLocalSearchType localSearchType;
}
