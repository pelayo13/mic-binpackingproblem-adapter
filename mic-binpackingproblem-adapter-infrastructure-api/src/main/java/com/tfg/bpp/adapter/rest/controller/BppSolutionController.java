package com.tfg.bpp.adapter.rest.controller;

import com.tfg.bpp.adapter.port.inbound.service.MessageServicePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort.CreateBppDetailedSolutionsByBppSolvableInstancesResponse;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesResponse;
import com.tfg.bpp.adapter.rest.mapper.BppSolutionRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.BppSolutionApi;
import org.openapitools.model.CreateBppDetailedSolutionsByBppSolvableInstancesRequest;
import org.openapitools.model.CreateByBppSolvableInstancesRequest;
import org.openapitools.model.CreateByBppSolvableInstancesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BppSolutionController implements BppSolutionApi {

  private static final String CLASS_NAME = BppSolutionController.class.getName();

  private final CreateBppSolutionsByBppSolvableInstancesUseCasePort
      createBppSolutionsByBppSolvableInstancesUseCasePort;

  private final CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort
      createBppDetailedSolutionsByBppSolvableInstancesUseCasePort;

  private final MessageServicePort messageServicePort;

  private final BppSolutionRestMapper bppSolutionRestMapper;

  @Override
  public ResponseEntity<CreateByBppSolvableInstancesResponse> createByBppSolvableInstances(
      CreateByBppSolvableInstancesRequest createByBppSolvableInstancesRequest,
      String acceptLanguage) {
    log.info("[start] {}.createByBppSolvableInstances", CLASS_NAME);

    CreateBppSolutionsByBppSolvableInstancesResponse response =
        this.createBppSolutionsByBppSolvableInstancesUseCasePort.execute(
            this.bppSolutionRestMapper.toCreateBppSolutionsByBppSolvableInstancesCommand(
                createByBppSolvableInstancesRequest));

    log.info("[end] {}.createByBppSolvableInstances", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppSolutionRestMapper.toCreateByBppSolvableInstancesResponse(response));
  }

  @Override
  public ResponseEntity<
          org.openapitools.model.CreateBppDetailedSolutionsByBppSolvableInstancesResponse>
      createBppDetailedSolutionByBppSolvableInstances(
          CreateBppDetailedSolutionsByBppSolvableInstancesRequest
              createBppDetailedSolutionsByBppSolvableInstancesRequest,
          String acceptLanguage) {
    log.info("[start] {}.createBppDetailedSolutionByBppSolvableInstances", CLASS_NAME);

    CreateBppDetailedSolutionsByBppSolvableInstancesResponse response =
        this.createBppDetailedSolutionsByBppSolvableInstancesUseCasePort.execute(
            this.bppSolutionRestMapper.toCreateBppDetailedSolutionsByBppSolvableInstancesCommand(
                createBppDetailedSolutionsByBppSolvableInstancesRequest));

    log.info("[end] {}.createBppDetailedSolutionByBppSolvableInstances", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppSolutionRestMapper.toCreateBppDetailedSolutionsByBppSolvableInstancesResponse(
            response));
  }
}
