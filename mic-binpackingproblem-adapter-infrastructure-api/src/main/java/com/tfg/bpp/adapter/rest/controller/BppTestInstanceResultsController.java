package com.tfg.bpp.adapter.rest.controller;

import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort.CreateBppTestInstanceResultsByBppTestInstanceResponse;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestResultsByBppInstanceUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestResultsByBppInstanceUseCasePort.CreateBppTestResultsByBppInstancesResponse;
import com.tfg.bpp.adapter.rest.mapper.BppTestInstanceResultsRestMapper;
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
public class BppTestInstanceResultsController implements BppAlgorithmApi {

  private static final String CLASS_NAME = BppTestInstanceResultsController.class.getName();

  private final CreateBppTestInstanceResultsByBppTestInstanceUseCasePort
      createBppTestInstanceResultsByBppTestInstanceUseCasePort;

  private final CreateBppTestResultsByBppInstanceUseCasePort
      createBppTestResultsByBppInstanceUseCasePort;

  private final BppTestInstanceResultsRestMapper bppTestInstanceResultsRestMapper;

  @Override
  public ResponseEntity<CreateMetricsByBppInstancesResponse> createMetricsByBppInstances(
      CreateMetricsByBppInstancesRequest createMetricsByBppInstancesRequest,
      String acceptLanguage) {
    log.info("[start] {}.createMetricsByBppInstances", CLASS_NAME);

    CreateBppTestResultsByBppInstancesResponse response =
        this.createBppTestResultsByBppInstanceUseCasePort.execute(
            this.bppTestInstanceResultsRestMapper.toCreateBppTestResultsByBppInstancesCommand(
                createMetricsByBppInstancesRequest));

    log.info("[end] {}.createMetricsByBppInstances", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppTestInstanceResultsRestMapper.toCreateMetricsByBppInstancesResponse(response));
  }

  @Override
  public ResponseEntity<CreateMetricsByBppRandomInstancesResponse>
      createMetricsByBppRandomInstances(
          CreateMetricsByBppRandomInstancesRequest createMetricsByBppRandomInstancesRequest,
          String acceptLanguage) {
    log.info("[start] {}.createMetricsByBppRandomInstances", CLASS_NAME);

    CreateBppTestInstanceResultsByBppTestInstanceResponse response =
        this.createBppTestInstanceResultsByBppTestInstanceUseCasePort.execute(
            this.bppTestInstanceResultsRestMapper.toCreateBppTestResultsByBppTestInstanceCommand(
                createMetricsByBppRandomInstancesRequest));

    log.info("[end] {}.createMetricsByBppRandomInstances", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppTestInstanceResultsRestMapper.toCreateMetricsByBppRandomInstancesResponse(
            response));
  }
}
