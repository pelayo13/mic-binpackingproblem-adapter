package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppInstancesUseCasePort.CreateBppMetricsByBppInstancesCommand;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppInstancesUseCasePort.CreateBppMetricsByBppInstancesResponse;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppRandomInstancesUseCasePort.CreateBppMetricsByBppRandomInstancesCommand;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppRandomInstancesUseCasePort.CreateBppMetricsByBppRandomInstancesResponse;
import org.mapstruct.Mapper;
import org.openapitools.model.CreateMetricsByBppInstancesRequest;
import org.openapitools.model.CreateMetricsByBppInstancesResponse;
import org.openapitools.model.CreateMetricsByBppRandomInstancesRequest;
import org.openapitools.model.CreateMetricsByBppRandomInstancesResponse;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {BppAlgorithmRestMapper.class})
public interface BppAlgorithmControllerRestMapper {

  CreateBppMetricsByBppRandomInstancesCommand toCreateBppMetricsByBppRandomInstancesCommand(
      CreateMetricsByBppRandomInstancesRequest request);

  CreateMetricsByBppRandomInstancesResponse toCreateMetricsByBppRandomInstancesResponse(
      CreateBppMetricsByBppRandomInstancesResponse response);

  CreateBppMetricsByBppInstancesCommand toCreateBppMetricsByBppInstancesCommand(
      CreateMetricsByBppInstancesRequest command);

  CreateMetricsByBppInstancesResponse toCreateMetricsByBppInstancesResponse(
      CreateBppMetricsByBppInstancesResponse response);
}
