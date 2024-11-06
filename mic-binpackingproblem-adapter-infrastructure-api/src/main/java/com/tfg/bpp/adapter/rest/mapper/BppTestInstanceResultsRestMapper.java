package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort.CreateBppTestInstanceResultsByBppTestInstanceResponse;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestResultsByBppInstanceUseCasePort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.CreateByBppInstancesRequest;
import org.openapitools.model.CreateByBppInstancesResponse;
import org.openapitools.model.CreateByBppTestInstancesRequest;
import org.openapitools.model.CreateByBppTestInstancesResponse;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {BppAlgorithmRestMapper.class})
public interface BppTestInstanceResultsRestMapper {

  @Mapping(target = "bppTestInstance", source = "instance")
  CreateBppTestInstanceResultsByBppTestInstanceUseCasePort
          .CreateBppTestInstanceResultsByBppTestInstanceCommand
      toCreateBppTestResultsByBppTestInstanceCommand(
          CreateByBppTestInstancesRequest createByBppTestInstancesRequest);

  @Mapping(target = "testInstancesWithErrors", source = "bppErrors")
  CreateByBppTestInstancesResponse toCreateByBppTestInstancesResponse(
      CreateBppTestInstanceResultsByBppTestInstanceResponse
          createBppTestInstanceResultsByBppTestInstanceResponse);

  CreateBppTestResultsByBppInstanceUseCasePort.CreateBppTestResultsByBppInstancesCommand
      toCreateBppTestResultsByBppInstancesCommand(
          CreateByBppInstancesRequest createByBppInstancesRequest);

  CreateByBppInstancesResponse toCreateByBppInstancesResponse(
      CreateBppTestResultsByBppInstanceUseCasePort.CreateBppTestResultsByBppInstancesResponse
          createBppTestResultsByBppInstancesResponse);
}
