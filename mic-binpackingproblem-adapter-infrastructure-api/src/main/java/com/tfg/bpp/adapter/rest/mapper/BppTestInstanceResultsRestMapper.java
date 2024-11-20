package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort.CreateBppTestInstanceResultsByBppTestInstanceResponse;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestResultsByBppInstanceUseCasePort;
import org.mapstruct.Mapper;
import org.openapitools.model.CreateMetricsByBppInstancesRequest;
import org.openapitools.model.CreateMetricsByBppInstancesResponse;
import org.openapitools.model.CreateMetricsByBppRandomInstancesRequest;
import org.openapitools.model.CreateMetricsByBppRandomInstancesResponse;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {BppAlgorithmRestMapper.class})
public interface BppTestInstanceResultsRestMapper {

  CreateBppTestInstanceResultsByBppTestInstanceUseCasePort
          .CreateBppTestInstanceResultsByBppTestInstanceCommand
      toCreateBppTestResultsByBppTestInstanceCommand(
          CreateMetricsByBppRandomInstancesRequest createMetricsByBppRandomInstancesRequest);

  CreateMetricsByBppRandomInstancesResponse toCreateMetricsByBppRandomInstancesResponse(
      CreateBppTestInstanceResultsByBppTestInstanceResponse
          createBppTestInstanceResultsByBppTestInstanceResponse);

  CreateBppTestResultsByBppInstanceUseCasePort.CreateBppTestResultsByBppInstancesCommand
      toCreateBppTestResultsByBppInstancesCommand(
          CreateMetricsByBppInstancesRequest createMetricsByBppInstancesRequest);

  CreateMetricsByBppInstancesResponse toCreateMetricsByBppInstancesResponse(
      CreateBppTestResultsByBppInstanceUseCasePort.CreateBppTestResultsByBppInstancesResponse
          createBppTestResultsByBppInstancesResponse);
}
