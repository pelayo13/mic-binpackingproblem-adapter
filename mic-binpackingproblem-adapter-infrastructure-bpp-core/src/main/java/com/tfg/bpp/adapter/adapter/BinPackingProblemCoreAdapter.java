package com.tfg.bpp.adapter.adapter;

import com.tfg.bpp.adapter.client.BinPackingProblemCoreGrpcClient;
import com.tfg.bpp.adapter.mapper.BppAlgorithmGrpcMapper;
import com.tfg.bpp.adapter.mapper.BppAlgorithmServiceGrpcMapper;
import com.tfg.bpp.adapter.mapper.BppInstanceServiceGrpcMapper;
import com.tfg.bpp.adapter.mapper.GrpcMapper;
import com.tfg.bpp.adapter.model.BppAlgorithm;
import com.tfg.bpp.adapter.model.BppAlgorithmMetrics;
import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.BppInstanceMetrics;
import com.tfg.bpp.adapter.model.BppRandomInstancesGenerationParams;
import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.model.BppSolvableInstance;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import v1.service.CreateBppMetricsByBppInstancesProto;
import v1.service.CreateBppMetricsByBppRandomInstancesProto;
import v1.service.CreateBppSolutionsBySolvableInstancesProto;

@Service
@RequiredArgsConstructor
@Slf4j
public class BinPackingProblemCoreAdapter implements BinPackingProblemCoreAdapterPort {

  private final BinPackingProblemCoreGrpcClient binPackingProblemCoreGrpcClient;

  private final BppInstanceServiceGrpcMapper bppInstanceServiceGrpcMapper;

  private final BppAlgorithmServiceGrpcMapper bppAlgorithmServiceGrpcMapper;

  private final GrpcMapper grpcMapper;

  private final BppAlgorithmGrpcMapper bppAlgorithmGrpcMapper;

  @Override
  public List<BppSolution> createBppSolutionsByBppSolvableInstances(
      List<BppSolvableInstance> instances) {
    CreateBppSolutionsBySolvableInstancesProto.CreateBppSolutionsByBppSolvableInstancesResponse
        response =
            this.binPackingProblemCoreGrpcClient.createBppSolutionsByBppSolvableInstances(
                CreateBppSolutionsBySolvableInstancesProto
                    .CreateBppSolutionsByBppSolvableInstancesRequest.newBuilder()
                    .addAllSolvableInstances(
                        this.bppInstanceServiceGrpcMapper.toBppSolvableInstancesProto(instances))
                    .build());

    return this.bppInstanceServiceGrpcMapper.toBppSolutions(response.getSolutionsList());
  }

  @Override
  public List<BppInstanceMetrics> createBppMetricsByBppRandomInstances(
      BppRandomInstancesGenerationParams bppRandomInstancesGenerationParams) {
    CreateBppMetricsByBppRandomInstancesProto.CreateBppMetricsByBppRandomInstancesResponse
        response =
            this.binPackingProblemCoreGrpcClient.createBppMetricsByBppRandomInstances(
                this.bppAlgorithmServiceGrpcMapper.toCreateBppMetricsByBppRandomInstancesRequest(
                    bppRandomInstancesGenerationParams));

    return this.bppAlgorithmServiceGrpcMapper.toBppInstanceMetricsList(
        response.getInstancesMetricsList());
  }

  @Override
  public List<BppAlgorithmMetrics> createBppMetricsByBppInstances(
      List<BppInstance> instances, List<BppAlgorithm> algorithms, Integer numberRepetitions) {
    CreateBppMetricsByBppInstancesProto.CreateBppMetricsByBppInstancesResponse response =
        this.binPackingProblemCoreGrpcClient.createBppMetricsByBppInstances(
                this.bppAlgorithmServiceGrpcMapper.toCreateBppMetricsByBppInstancesRequest(instances, algorithms, numberRepetitions));

    return this.bppAlgorithmServiceGrpcMapper.toBppAlgorithmMetricsList(
        response.getAlgorithmsMetricsList());
  }
}
