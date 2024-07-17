package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesCommand;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.CreateBppDetailedSolutionsByBppSolvableInstancesRequest;
import org.openapitools.model.CreateBppDetailedSolutionsByBppSolvableInstancesResponse;
import org.openapitools.model.CreateByBppSolvableInstancesRequest;
import org.openapitools.model.CreateByBppSolvableInstancesResponse;

@Mapper(config = CentralMapperConfig.class)
public interface BppSolutionRestMapper {

  @Mapping(target = "solvableInstances", source = "instances")
  CreateBppSolutionsByBppSolvableInstancesCommand toCreateBppSolutionsByBppSolvableInstancesCommand(
      CreateByBppSolvableInstancesRequest request);

  @Mapping(target = "instancesWithErrors", source = "bppErrors")
  CreateByBppSolvableInstancesResponse toCreateByBppSolvableInstancesResponse(
      CreateBppSolutionsByBppSolvableInstancesResponse solutions);

  @Mapping(target = "solvableInstances", source = "instances")
  CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort
          .CreateBppDetailedSolutionsByBppSolvableInstancesCommand
      toCreateBppDetailedSolutionsByBppSolvableInstancesCommand(
          CreateBppDetailedSolutionsByBppSolvableInstancesRequest request);

  @Mapping(target = "instancesWithErrors", source = "bppErrors")
  CreateBppDetailedSolutionsByBppSolvableInstancesResponse
      toCreateBppDetailedSolutionsByBppSolvableInstancesResponse(
          CreateBppDetailedSolutionsByBppSolvableInstancesUseCasePort
                  .CreateBppDetailedSolutionsByBppSolvableInstancesResponse
              solutions);
}
