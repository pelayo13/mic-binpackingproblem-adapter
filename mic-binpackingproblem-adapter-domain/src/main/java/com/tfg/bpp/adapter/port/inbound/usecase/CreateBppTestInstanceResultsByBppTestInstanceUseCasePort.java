package com.tfg.bpp.adapter.port.inbound.usecase;

import com.tfg.bpp.adapter.model.BppAlgorithm;
import com.tfg.bpp.adapter.model.BppTestInstance;
import com.tfg.bpp.adapter.model.BppTestInstanceResults;
import com.tfg.bpp.adapter.model.exception.BppError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public interface CreateBppTestInstanceResultsByBppTestInstanceUseCasePort {

  CreateBppTestInstanceResultsByBppTestInstanceResponse execute(
      @Valid @NotNull
          CreateBppTestInstanceResultsByBppTestInstanceCommand
              createBppSolutionsByBppSolvableInstancesCommand);

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppTestInstanceResultsByBppTestInstanceResponse {

    @NotNull private final BppTestInstanceResults testInstanceResults;

    @NotNull private final List<BppError<BppAlgorithm>> bppErrors;
  }

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppTestInstanceResultsByBppTestInstanceCommand {

    @NonNull private Integer binsCapacity;

    @NonNull private Integer minItemsSize;

    @NonNull private Integer maxItemsSize;

    @NonNull private Integer minItemsDueDate;

    @NonNull private Integer maxItemsDueDate;

    @NonNull @Valid private List<@Min(0)Integer> numberItems;

    @NonNull private Integer numberRepetitions;

    @NonNull @Valid private List<@Valid BppAlgorithm> algorithms;
  }
}
