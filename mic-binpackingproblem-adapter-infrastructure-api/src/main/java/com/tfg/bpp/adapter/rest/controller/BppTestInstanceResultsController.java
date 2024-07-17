package com.tfg.bpp.adapter.rest.controller;

import com.tfg.bpp.adapter.port.inbound.service.MessageServicePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort.CreateBppTestInstanceResultsByBppTestInstanceResponse;
import com.tfg.bpp.adapter.rest.mapper.BppTestInstanceResultsRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.BppTestInstanceResultsApi;
import org.openapitools.model.CreateByBppTestInstancesRequest;
import org.openapitools.model.CreateByBppTestInstancesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BppTestInstanceResultsController implements BppTestInstanceResultsApi {

  private static final String CLASS_NAME = BppTestInstanceResultsController.class.getName();

  private final CreateBppTestInstanceResultsByBppTestInstanceUseCasePort
      createBppTestInstanceResultsByBppTestInstanceUseCasePort;

  private final MessageServicePort messageServicePort;

  private final BppTestInstanceResultsRestMapper bppTestInstanceResultsRestMapper;

  @Override
  public ResponseEntity<CreateByBppTestInstancesResponse> createByBppTestInstance(
      CreateByBppTestInstancesRequest createByBppTestInstancesRequest, String acceptLanguage) {
    log.info("[start] {}.createByBppTestInstance", CLASS_NAME);

    CreateBppTestInstanceResultsByBppTestInstanceResponse response =
        this.createBppTestInstanceResultsByBppTestInstanceUseCasePort.execute(
            this.bppTestInstanceResultsRestMapper.toCreateBppTestResultsByBppTestInstanceCommand(
                createByBppTestInstancesRequest));

    log.info("[end] {}.createByBppTestInstance", CLASS_NAME);

    return ResponseEntity.ok(
        this.bppTestInstanceResultsRestMapper.toCreateByBppTestInstancesResponse(response));
  }
}
