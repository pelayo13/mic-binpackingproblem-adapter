package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBppSolutionsByBppSolvableInstancesUseCase
    implements CreateBppSolutionsByBppSolvableInstancesUseCasePort {

  private final BinPackingProblemCoreAdapterPort binPackingProblemCoreAdapterPort;

  @Override
  public CreateBppSolutionsByBppSolvableInstancesResponse execute(
      CreateBppSolutionsByBppSolvableInstancesCommand
          createBppSolutionsByBppSolvableInstancesCommand) {
    List<BppSolution> solutions =
        this.binPackingProblemCoreAdapterPort.createBppSolutionsByBppSolvableInstances(
            createBppSolutionsByBppSolvableInstancesCommand.getSolvableInstances());

    return CreateBppSolutionsByBppSolvableInstancesResponse.builder().solutions(solutions).build();
  }
}
