package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.model.BppAlgorithmMetrics;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppInstancesUseCasePort;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBppMetricsByBppInstancesUseCase
    implements CreateBppMetricsByBppInstancesUseCasePort {

  private final BinPackingProblemCoreAdapterPort binPackingProblemCoreAdapterPort;

  @Override
  public CreateBppMetricsByBppInstancesResponse execute(
      CreateBppMetricsByBppInstancesCommand createBppMetricsByBppInstancesCommand) {
    List<BppAlgorithmMetrics> algorithmMetrics =
        this.binPackingProblemCoreAdapterPort.createBppMetricsByBppInstances(
            createBppMetricsByBppInstancesCommand.getInstances(),
            createBppMetricsByBppInstancesCommand.getAlgorithms(),
            createBppMetricsByBppInstancesCommand.getNumberRepetitions());

    return CreateBppMetricsByBppInstancesResponse.builder()
        .algorithmsMetrics(algorithmMetrics)
        .build();
  }
}
