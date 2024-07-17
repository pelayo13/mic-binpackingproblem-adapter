package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import v1.model.BppAlgorithmProto;
import v1.model.BppGreedyAlgorithmTypeProto;
import v1.model.BppLocalSearchTypeProto;
import v1.model.BppTestCaseResultsProto;
import v1.model.BppTestInstanceProto;
import v1.model.BppTestInstanceResultsProto;
import v1.model.BppTestItemsResultsProto;
import v1.model.BppTestResultsProto;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {GrpcMapper.class})
public interface BppTestInstanceResultsServiceGrpcMapper {

  @Mapping(target = "numberItemsList", source = "numberItems")
  @Mapping(target = "algorithmsList", source = "algorithms")
  BppTestInstanceProto.BppTestInstance toBppTestInstanceProto(BppTestInstance bppTestInstance);

  @Mapping(target = "testItemsResults", source = "testItemsResultsList")
  BppTestInstanceResults toBppTestInstanceResults(
          BppTestInstanceResultsProto.BppTestInstanceResults testInstanceResultsProto);

  @Mapping(target = "testResults", source = "testResultsList")
  BppTestItemsResults toBppTestItemsResults(
          BppTestItemsResultsProto.BppTestItemsResults testItemsResults);

  @Mapping(target = "testCaseResults", source = "testCaseResultsList")
  BppTestResults toBppTestResults(BppTestResultsProto.BppTestResults bppTestResultsProto);

  BppTestCaseResults toBppTestCaseResults(BppTestCaseResultsProto.BppTestCaseResults bppTestCaseResultsProto);

  BppAlgorithmProto.BppAlgorithm toBppAlgorithmProto(BppAlgorithm bppAlgorithm);

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

  @ValueMapping(target = "RANDOM", source = "BPP_GREEDY_ALGORITHM_TYPE_RANDOM")
  @ValueMapping(
          target = "FIRST_FIT_DECREASING",
          source = "BPP_GREEDY_ALGORITHM_TYPE_FIRST_FIT_DECREASING")
  @ValueMapping(
          target = "BEST_FIT_DECREASING",
          source = "BPP_GREEDY_ALGORITHM_TYPE_BEST_FIT_DECREASING")
  @ValueMapping(target = MappingConstants.NULL, source = "BPP_GREEDY_ALGORITHM_TYPE_UNSPECIFIED")
  @ValueMapping(target = MappingConstants.THROW_EXCEPTION, source = "UNRECOGNIZED")
  BppGreedyAlgorithmType toBppGreedyAlgorithmType(
          BppGreedyAlgorithmTypeProto.BppGreedyAlgorithmType bppGreedyAlgorithmTypeProto);

  @ValueMapping(target = "ALVIN_ET_AL", source = "BPP_LOCAL_SEARCH_TYPE_ALVIN_ET_AL")
  @ValueMapping(target = MappingConstants.NULL, source = "BPP_LOCAL_SEARCH_TYPE_UNSPECIFIED")
  @ValueMapping(target = MappingConstants.THROW_EXCEPTION, source = "UNRECOGNIZED")
  BppLocalSearchType toBppLocalSearchType(
          BppLocalSearchTypeProto.BppLocalSearchType bppLocalSearchTypeProto);
}
