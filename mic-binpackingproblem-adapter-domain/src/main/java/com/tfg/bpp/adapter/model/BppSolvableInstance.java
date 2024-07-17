package com.tfg.bpp.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BppSolvableInstance extends BppInstance {

  private BppGreedyAlgorithmType greedyAlgorithmType;

  private BppLocalSearchType localSearchType;
}
