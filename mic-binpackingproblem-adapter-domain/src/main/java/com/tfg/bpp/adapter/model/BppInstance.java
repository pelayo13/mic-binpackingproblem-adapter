package com.tfg.bpp.adapter.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BppInstance {

  private List<BppItem> items;

  private List<BppBin> bins;

  private int binsCapacity;
}
