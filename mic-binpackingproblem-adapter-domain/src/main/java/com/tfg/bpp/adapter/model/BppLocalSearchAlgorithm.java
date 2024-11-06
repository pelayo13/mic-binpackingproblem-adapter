package com.tfg.bpp.adapter.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BppLocalSearchAlgorithm {

  private List<BppNeighborhoodStructure> bppNeighborhoodStructures;

  private BppStrategyControl bppStrategyControl;

  private BppEvaluationFunction bppEvaluationFunction;

  private BppStoppingCriteria bppStopCriteria;
}
