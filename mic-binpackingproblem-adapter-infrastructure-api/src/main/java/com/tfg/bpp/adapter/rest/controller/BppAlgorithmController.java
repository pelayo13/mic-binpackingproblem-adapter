package com.tfg.bpp.adapter.rest.controller;

import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppInstancesUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppRandomInstancesUseCasePort;
import com.tfg.bpp.adapter.rest.mapper.BppAlgorithmControllerRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.BppAlgorithmApi;
import org.openapitools.model.CreateMetricsByBppInstancesRequest;
import org.openapitools.model.CreateMetricsByBppInstancesResponse;
import org.openapitools.model.CreateMetricsByBppRandomInstancesRequest;
import org.openapitools.model.CreateMetricsByBppRandomInstancesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BppAlgorithmController implements BppAlgorithmApi {

  private static final String CLASS_NAME = BppAlgorithmController.class.getName();

  private final CreateBppMetricsByBppRandomInstancesUseCasePort
          createBppMetricsByBppRandomInstancesUseCasePort;

  private final CreateBppMetricsByBppInstancesUseCasePort
          createBppMetricsByBppInstancesUseCasePort;

  private final BppAlgorithmControllerRestMapper bppAlgorithmControllerRestMapper;

  @Override
  public ResponseEntity<CreateMetricsByBppInstancesResponse> createMetricsByBppInstances(
      CreateMetricsByBppInstancesRequest createMetricsByBppInstancesRequest,
      String acceptLanguage) {
    log.info("[start] {}.createMetricsByBppInstances", CLASS_NAME);

    CreateBppMetricsByBppInstancesUseCasePort.CreateBppMetricsByBppInstancesResponse response =
        this.createBppMetricsByBppInstancesUseCasePort.execute(
            this.bppAlgorithmControllerRestMapper.toCreateBppMetricsByBppInstancesCommand(
                createMetricsByBppInstancesRequest));

    log.info("[end] {}.createMetricsByBppInstances", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppAlgorithmControllerRestMapper.toCreateMetricsByBppInstancesResponse(response));
  }

  @Override
  public ResponseEntity<CreateMetricsByBppRandomInstancesResponse>
      createMetricsByBppRandomInstances(
          CreateMetricsByBppRandomInstancesRequest createMetricsByBppRandomInstancesRequest,
          String acceptLanguage) {
    log.info("[start] {}.createMetricsByBppRandomInstances", CLASS_NAME);

    CreateBppMetricsByBppRandomInstancesUseCasePort.CreateBppMetricsByBppRandomInstancesResponse response =
        this.createBppMetricsByBppRandomInstancesUseCasePort.execute(
            this.bppAlgorithmControllerRestMapper.toCreateBppMetricsByBppRandomInstancesCommand(
                createMetricsByBppRandomInstancesRequest));

    log.info("[end] {}.createMetricsByBppRandomInstances", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppAlgorithmControllerRestMapper.toCreateMetricsByBppRandomInstancesResponse(
            response));
  }
}
