package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesCommand;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.CreateSolutionByBppSolvableInstancesRequest;
import org.openapitools.model.CreateSolutionByBppSolvableInstancesResponse;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {BppAlgorithmRestMapper.class})
public interface BppSolutionRestMapper {

  @Mapping(target = "solvableInstances", source = "instances")
  CreateBppSolutionsByBppSolvableInstancesCommand toCreateBppSolutionsByBppSolvableInstancesCommand(
      CreateSolutionByBppSolvableInstancesRequest request);

  CreateSolutionByBppSolvableInstancesResponse toCreateByBppSolvableInstancesResponse(
      CreateBppSolutionsByBppSolvableInstancesResponse solutions);
}
