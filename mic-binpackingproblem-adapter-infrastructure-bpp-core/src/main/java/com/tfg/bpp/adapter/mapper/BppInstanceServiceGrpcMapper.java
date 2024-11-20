package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.*;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import v1.model.BppBinProto;
import v1.model.BppDetailsOfSolutionProto;
import v1.model.BppInstanceProto;
import v1.model.BppItemProto;
import v1.model.BppSolutionProto;
import v1.model.BppSolvableInstanceProto;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {GrpcMapper.class, BppAlgorithmGrpcMapper.class})
public interface BppInstanceServiceGrpcMapper {

  List<BppSolution> toBppSolutions(List<BppSolutionProto.BppSolution> bppSolutionsProto);

  @Mapping(target = "recordInstances", source = "recordInstancesList")
  BppDetailsOfSolution toBppDetailsOfSolution(
          BppDetailsOfSolutionProto.BppDetailsOfSolution detailsOfSolutionProto);

  @Mapping(target = "bins", source = "binsList")
  BppSolution toBppSolution(BppSolutionProto.BppSolution bppSolution);

  List<BppSolvableInstanceProto.BppSolvableInstance> toBppSolvableInstancesProto(
      List<BppSolvableInstance> solvableInstances);

  @Mapping(target = "instance", source = ".")
  BppSolvableInstanceProto.BppSolvableInstance toBppSolvableInstanceProto(
      BppSolvableInstance solvableInstance);

  @Mapping(target = "itemsList", source = "items")
  @Mapping(target = "binsList", source = "bins")
  BppInstanceProto.BppInstance toBppInstanceProto(BppSolvableInstance solvableInstance);

  @Named("toBppInstanceProto")
  @Mapping(target = "itemsList", source = "items")
  @Mapping(target = "binsList", source = "bins")
  BppInstanceProto.BppInstance toBppInstanceProto(BppInstance solvableInstance);

  @Mapping(target = "items", source = "itemsList")
  @Mapping(target = "bins", source = "binsList")
  BppInstance toBppInstance(BppInstanceProto.BppInstance solvableInstance);

  BppItemProto.BppItem toBppItemProto(BppItem bppItem);

  BppItem toBppItem(BppItemProto.BppItem bppItem);

  @Mapping(target = "itemsList", source = "items")
  BppBinProto.BppBin toBppBinProto(BppBin bppBin);

  @Mapping(target = "items", source = "itemsList")
  BppBin toBppBin(BppBinProto.BppBin bppBin);
}
