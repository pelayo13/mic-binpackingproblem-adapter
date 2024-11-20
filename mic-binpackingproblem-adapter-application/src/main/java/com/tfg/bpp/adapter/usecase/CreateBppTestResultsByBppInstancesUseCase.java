package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.model.BppTestResults;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestResultsByBppInstanceUseCasePort;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBppTestResultsByBppInstancesUseCase
    implements CreateBppTestResultsByBppInstanceUseCasePort {

  private static final String CLASS_NAME =
      CreateBppTestResultsByBppInstancesUseCase.class.getName();

  private final BinPackingProblemCoreAdapterPort binPackingProblemCoreAdapterPort;

  @Override
  public CreateBppTestResultsByBppInstancesResponse execute(
      CreateBppTestResultsByBppInstancesCommand createBppTestResultsByBppInstanceCommand) {
    List<BppTestResults> testResults =
        this.binPackingProblemCoreAdapterPort.createBppTestResultsByBppInstances(
            createBppTestResultsByBppInstanceCommand.getInstances(),
            createBppTestResultsByBppInstanceCommand.getAlgorithms());

    return CreateBppTestResultsByBppInstancesResponse.builder()
        .testResults(testResults)
        .instancesWithErrors(new ArrayList<>())
        .build();
  }
}
