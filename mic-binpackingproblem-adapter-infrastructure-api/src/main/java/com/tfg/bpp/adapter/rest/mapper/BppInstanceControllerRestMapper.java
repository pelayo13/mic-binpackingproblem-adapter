package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppInstanceByBppFileUseCasePort.CreateBppInstanceByBppFileCommand;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesCommand;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort.CreateBppSolutionsByBppSolvableInstancesResponse;
import java.io.InputStream;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.openapitools.model.BppInstanceDto;
import org.openapitools.model.BppSolutionDto;
import org.openapitools.model.CreateSolutionsByBppSolvableInstancesRequest;
import org.openapitools.model.CreateSolutionsByBppSolvableInstancesResponse;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {BppAlgorithmRestMapper.class})
public interface BppInstanceControllerRestMapper {

  final static String DETAILS_FIELD = "details";

  CreateBppInstanceByBppFileCommand toCreateBppInstanceByBppFileCommand(
      String filename, InputStream fileData);

  List<BppInstanceDto> toBppInstanceDtos(List<BppInstance> bppInstances);

  @Mapping(target = "solvableInstances", source = "instances")
  CreateBppSolutionsByBppSolvableInstancesCommand toCreateBppSolutionsByBppSolvableInstancesCommand(
      CreateSolutionsByBppSolvableInstancesRequest request);

  CreateSolutionsByBppSolvableInstancesResponse toCreateSolutionsByBppSolvableInstancesResponse(
      final CreateBppSolutionsByBppSolvableInstancesResponse response, @Context String view);

  @Mapping(target = "details", conditionExpression = "java(DETAILS_FIELD.equals(view))")
  BppSolutionDto toBppSolutionDto(final BppSolution solution, @Context String view);
}
