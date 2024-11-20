package com.tfg.bpp.adapter.port.inbound.usecase;

import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.model.BppSolvableInstance;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateBppSolutionsByBppSolvableInstancesUseCasePort {

  CreateBppSolutionsByBppSolvableInstancesResponse execute(
      @Valid @NotNull
          CreateBppSolutionsByBppSolvableInstancesCommand
              createBppSolutionsByBppSolvableInstancesCommand);

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppSolutionsByBppSolvableInstancesResponse {

    @NotNull private final List<BppSolution> solutions;
  }

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppSolutionsByBppSolvableInstancesCommand {

    @NotNull private final List<BppSolvableInstance> solvableInstances;
  }
}
