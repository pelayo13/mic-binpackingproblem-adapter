package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.mapper.BppMetricsMapper;
import com.tfg.bpp.adapter.model.BppTestInstanceResults;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBppTestInstanceResultsByBppTestInstancesUseCase
    implements CreateBppTestInstanceResultsByBppTestInstanceUseCasePort {

  private static final String CLASS_NAME =
      CreateBppTestInstanceResultsByBppTestInstancesUseCase.class.getName();

  private final BinPackingProblemCoreAdapterPort binPackingProblemCoreAdapterPort;

  private final BppMetricsMapper bppMetricsMapper;

  @Override
  public CreateBppTestInstanceResultsByBppTestInstanceResponse execute(
      CreateBppTestInstanceResultsByBppTestInstanceCommand
          createBppSolutionsByBppSolvableInstancesCommand) {
    BppTestInstanceResults testInstanceResults =
        this.binPackingProblemCoreAdapterPort.createBppTestInstanceResultsByBppTestInstance(
            this.bppMetricsMapper.toBppTestInstance(
                createBppSolutionsByBppSolvableInstancesCommand));

    return CreateBppTestInstanceResultsByBppTestInstanceResponse.builder()
        .testInstanceResults(testInstanceResults)
        .bppErrors(new ArrayList<>())
        .build();
  }
}
