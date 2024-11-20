package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppAlgorithm;
import com.tfg.bpp.adapter.model.BppAlgorithmMetrics;
import com.tfg.bpp.adapter.model.BppBin;
import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.BppInstanceMetrics;
import com.tfg.bpp.adapter.model.BppRandomInstancesGenerationParams;
import com.tfg.bpp.adapter.model.BppTestCaseMetrics;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import v1.model.BppAlgorithmMetricsProto;
import v1.model.BppBinProto;
import v1.model.BppInstanceMetricsProto;
import v1.model.BppInstanceProto;
import v1.model.BppTestCaseMetricsProto;
import v1.service.CreateBppMetricsByBppInstancesProto.CreateBppMetricsByBppInstancesRequest;
import v1.service.CreateBppMetricsByBppRandomInstancesProto.CreateBppMetricsByBppRandomInstancesRequest;

@Mapper(
    config = CentralMapperConfig.class,
    uses = {GrpcMapper.class, BppAlgorithmGrpcMapper.class, BppInstanceServiceGrpcMapper.class})
public interface BppAlgorithmServiceGrpcMapper {

  @Mapping(target = "numberItemsList", source = "numberItems")
  @Mapping(target = "algorithmsList", source = "algorithms")
  CreateBppMetricsByBppRandomInstancesRequest toCreateBppMetricsByBppRandomInstancesRequest(
      BppRandomInstancesGenerationParams randomInstancesGenerationParams);

  @Mapping(target = "algorithmsList", source = "algorithms")
  @Mapping(target = "instancesList", source = "instances")
  CreateBppMetricsByBppInstancesRequest toCreateBppMetricsByBppInstancesRequest(
      List<BppInstance> instances, List<BppAlgorithm> algorithms, Integer numberRepetitions);

  List<BppInstanceMetrics> toBppInstanceMetricsList(
      List<BppInstanceMetricsProto.BppInstanceMetrics> instanceMetricsProto);

  @Mapping(target = "algorithmsMetrics", source = "algorithmsMetricsList")
  BppInstanceMetrics toBppInstanceMetrics(
      BppInstanceMetricsProto.BppInstanceMetrics instanceMetricsProto);

  List<BppAlgorithmMetrics> toBppAlgorithmMetricsList(
      List<BppAlgorithmMetricsProto.BppAlgorithmMetrics> algorithmMetricsProto);

  @Mapping(target = "testCasesMetrics", source = "testCasesMetricsList")
  BppAlgorithmMetrics toBppAlgorithmMetrics(
      BppAlgorithmMetricsProto.BppAlgorithmMetrics algorithmMetricsProto);

  @Mapping(
      target = "evaluationFunctionResultsRecords",
      source = "evaluationFunctionResultsRecordsList")
  BppTestCaseMetrics toBppTestCaseMetrics(
      BppTestCaseMetricsProto.BppTestCaseMetrics testCaseMetricsProto);

  @Mapping(target = "itemsList", source = "items")
  @Mapping(target = "binsList", source = "bins")
  BppInstanceProto.BppInstance toBppInstanceProto(BppInstance instances);
}
