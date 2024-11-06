package com.tfg.bpp.adapter.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BppNeighborhoodStructureOperationType {
  BINS_DESTRUCTION,

  RECONSTRUCTION,

  BINS_INTERCHANGE,

  STORED_ITEMS_AND_FREE_ITEMS_INTERCHANGE,

  STORED_ITEMS_INTERCHANGE
}
