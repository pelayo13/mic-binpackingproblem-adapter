package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import v1.model.BppBinProto;
import v1.model.BppDetailedSolutionProto;
import v1.model.BppGreedyAlgorithmTypeProto;
import v1.model.BppInstanceProto;
import v1.model.BppItemProto;
import v1.model.BppLocalSearchTypeProto;
import v1.model.BppSolutionProto;
import v1.model.BppSolvableInstanceProto;
import v1.model.BppStoredItemProto;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {GrpcMapper.class})
public interface BppSolutionServiceGrpcMapper {

  List<BppSolution> toBppSolutions(List<BppSolutionProto.BppSolution> bppSolutionsProto);

  List<BppDetailedSolution> toBppDetailedSolutions(List<BppDetailedSolutionProto.BppDetailedSolution> bppDetailedSolutionsProto);

  @Mapping(target = "recordInstances", source = "recordInstancesList")
  BppDetailedSolution toBppDetailedSolutions(BppDetailedSolutionProto.BppDetailedSolution bppDetailedSolutionsProto);

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

  @Mapping(target = "items", source = "itemsList")
  @Mapping(target = "bins", source = "binsList")
  BppInstance toBppInstance(BppInstanceProto.BppInstance solvableInstance);

  BppItemProto.BppItem toBppItemProto(BppItem bppItem);

  BppItem toBppItem(BppItemProto.BppItem bppItem);

  @Mapping(target = "itemsList", source = "items")
  BppBinProto.BppBin toBppBinProto(BppBin bppBin);

  @Mapping(target = "items", source = "itemsList")
  BppBin toBppBin(BppBinProto.BppBin bppBin);

  @Mapping(target = "item", source = ".")
  BppStoredItemProto.BppStoredItem toBppStoredItemProto(BppStoredItem bppStoredItem);

  @Mapping(target = ".", source = "item")
  BppStoredItem toBppStoredItem(BppStoredItemProto.BppStoredItem bppStoredItem);

  @ValueMapping(target = "BPP_GREEDY_ALGORITHM_TYPE_RANDOM", source = "RANDOM")
  @ValueMapping(
      target = "BPP_GREEDY_ALGORITHM_TYPE_FIRST_FIT_DECREASING",
      source = "FIRST_FIT_DECREASING")
  @ValueMapping(
      target = "BPP_GREEDY_ALGORITHM_TYPE_BEST_FIT_DECREASING",
      source = "BEST_FIT_DECREASING")
  @ValueMapping(
      target = "BPP_GREEDY_ALGORITHM_TYPE_UNSPECIFIED",
      source = MappingConstants.ANY_REMAINING)
  BppGreedyAlgorithmTypeProto.BppGreedyAlgorithmType toBppGreedyAlgorithmTypeProto(
      BppGreedyAlgorithmType bppGreedyAlgorithmType);

  @ValueMapping(target = "BPP_LOCAL_SEARCH_TYPE_ALVIN_ET_AL", source = "ALVIN_ET_AL")
  @ValueMapping(
      target = "BPP_LOCAL_SEARCH_TYPE_UNSPECIFIED",
      source = MappingConstants.ANY_REMAINING)
  BppLocalSearchTypeProto.BppLocalSearchType toBppLocalSearchTypeProto(
      BppLocalSearchType bppLocalSearchType);
}
