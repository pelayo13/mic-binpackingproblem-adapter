package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.model.BppDetailedSolution;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBppDetailedSolutionsByBppSolvableInstancesUseCase
    implements CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort {

  private final BinPackingProblemCoreAdapterPort binPackingProblemCoreAdapterPort;

  @Override
  public CreateBppDetailedSolutionsByBppSolvableInstancesResponse execute(
      CreateBppDetailedSolutionsByBppSolvableInstancesCommand
          createBppDetailedSolutionsByBppSolvableInstancesCommand) {
    List<BppDetailedSolution> solutions =
        this.binPackingProblemCoreAdapterPort.createBppDetailedSolutionsByBppSolvableInstances(
            createBppDetailedSolutionsByBppSolvableInstancesCommand.getSolvableInstances());

    return CreateBppDetailedSolutionsByBppSolvableInstancesResponse.builder()
        .detailedSolutions(solutions)
        .bppErrors(new ArrayList<>())
        .build();
  }
}
