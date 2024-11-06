package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppAlgorithm;
import com.tfg.bpp.adapter.model.BppGreedyAlgorithmType;
import com.tfg.bpp.adapter.model.BppTestCaseResults;
import com.tfg.bpp.adapter.model.BppTestInstance;
import com.tfg.bpp.adapter.model.BppTestInstanceResults;
import com.tfg.bpp.adapter.model.BppTestItemsResults;
import com.tfg.bpp.adapter.model.BppTestResults;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import v1.model.BppAlgorithmProto;
import v1.model.BppGreedyAlgorithmTypeProto;
import v1.model.BppTestCaseResultsProto;
import v1.model.BppTestInstanceProto;
import v1.model.BppTestInstanceResultsProto;
import v1.model.BppTestItemsResultsProto;
import v1.model.BppTestResultsProto;

import java.util.List;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {GrpcMapper.class, BppAlgorithmGrpcMapper.class})
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

  List<BppTestResults> toBppTestResultsList(List<BppTestResultsProto.BppTestResults> bppTestResultsProto);

  @Mapping(target = "testCaseResults", source = "testCaseResultsList")
  BppTestResults toBppTestResults(BppTestResultsProto.BppTestResults bppTestResultsProto);

  @Mapping(target = "evaluationFunctionResultsRecords", source = "evaluationFunctionResultsRecordsList")
  BppTestCaseResults toBppTestCaseResults(BppTestCaseResultsProto.BppTestCaseResults bppTestCaseResultsProto);
}
