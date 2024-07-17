package com.tfg.bpp.adapter.port.inbound.usecase;

import com.tfg.bpp.adapter.model.BppDetailedSolution;
import com.tfg.bpp.adapter.model.BppSolvableInstance;
import com.tfg.bpp.adapter.model.exception.BppError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort {

  CreateBppDetailedSolutionsByBppSolvableInstancesResponse execute(
      @Valid @NotNull
          CreateBppDetailedSolutionsByBppSolvableInstancesCommand
              createBppSolutionsByBppSolvableInstancesCommand);

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppDetailedSolutionsByBppSolvableInstancesResponse {

    @NotNull private final List<BppDetailedSolution> detailedSolutions;

    @NotNull private final List<BppError<Integer>> bppErrors;
  }

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppDetailedSolutionsByBppSolvableInstancesCommand {

    @NotNull private final List<BppSolvableInstance> solvableInstances;
  }
}
