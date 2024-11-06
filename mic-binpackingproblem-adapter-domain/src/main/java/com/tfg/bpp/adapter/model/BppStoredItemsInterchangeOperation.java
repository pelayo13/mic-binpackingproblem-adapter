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
public class BppStoredItemsInterchangeOperation extends BppNeighborhoodStructureOperation {

  private int numberItemsToInterchangeFrom;

  private int numberItemsToInterchangeTo;

  private BppItemsInterchangeFunction itemsInterchangeFunction;
}
