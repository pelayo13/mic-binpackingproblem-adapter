package com.tfg.bpp.adapter.port.inbound.usecase;

import com.tfg.bpp.adapter.model.BppSolvableInstance;
import com.tfg.bpp.adapter.model.BppTestResults;
import com.tfg.bpp.adapter.model.exception.BppError;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateBppTestResultsByBppInstanceUseCasePort {

  CreateBppTestResultsByBppInstancesResponse execute(
      @Valid @NotNull
          CreateBppTestResultsByBppInstancesCommand createBppTestResultsByBppInstanceCommand);

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppTestResultsByBppInstancesResponse {

    @NotNull private final List<BppTestResults> testResults;

    @NotNull private final List<BppError<Integer>> instancesWithErrors;
  }

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppTestResultsByBppInstancesCommand {

    @NotNull private final List<BppSolvableInstance> instances;
  }
}
