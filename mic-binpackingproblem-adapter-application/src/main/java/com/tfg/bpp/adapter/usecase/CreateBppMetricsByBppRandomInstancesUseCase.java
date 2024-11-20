package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.mapper.BppMetricsMapper;
import com.tfg.bpp.adapter.model.BppInstanceMetrics;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppRandomInstancesUseCasePort;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBppMetricsByBppRandomInstancesUseCase
    implements CreateBppMetricsByBppRandomInstancesUseCasePort {

  private final BinPackingProblemCoreAdapterPort binPackingProblemCoreAdapterPort;

  private final BppMetricsMapper bppMetricsMapper;

  @Override
  public CreateBppMetricsByBppRandomInstancesResponse execute(
      CreateBppMetricsByBppRandomInstancesCommand createBppMetricsByBppRandomInstancesCommand) {
    List<BppInstanceMetrics> testInstanceResults =
        this.binPackingProblemCoreAdapterPort.createBppMetricsByBppRandomInstances(
            this.bppMetricsMapper.toBppRandomInstancesGenerationParams(
                createBppMetricsByBppRandomInstancesCommand));

    return CreateBppMetricsByBppRandomInstancesResponse.builder()
        .instancesMetrics(testInstanceResults)
        .build();
  }
}
