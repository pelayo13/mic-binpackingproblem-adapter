package com.tfg.bpp.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BppTestCaseResults {

  private int numberBins;

  private double averageTardinessStoredItems;

  private double averageLatenessStoredItems;

  private double maximumLateness;

  private int availableCapacity;

  private int numberIterations;

  private int numberNeighborsGenerated;

  private Integer numberEvaluatedNeighbors;

  private double fitness;

  private List<Double> evaluationFunctionResultsRecords;

  private double seconds;
}
