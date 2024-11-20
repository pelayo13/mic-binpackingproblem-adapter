package com.tfg.bpp.adapter.port.inbound.usecase;

import com.tfg.bpp.adapter.model.BppAlgorithm;
import com.tfg.bpp.adapter.model.BppAlgorithmMetrics;
import com.tfg.bpp.adapter.model.BppInstance;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateBppMetricsByBppInstancesUseCasePort {

  CreateBppMetricsByBppInstancesResponse execute(
      @Valid @NotNull
          CreateBppMetricsByBppInstancesCommand createBppTestResultsByBppInstanceCommand);

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppMetricsByBppInstancesResponse {

    @NotNull private final List<BppAlgorithmMetrics> algorithmsMetrics;
  }

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppMetricsByBppInstancesCommand {

    @NotNull private final List<BppInstance> instances;
    @NotNull private final List<BppAlgorithm> algorithms;
    @Min(1) private final Integer numberRepetitions;
  }
}
