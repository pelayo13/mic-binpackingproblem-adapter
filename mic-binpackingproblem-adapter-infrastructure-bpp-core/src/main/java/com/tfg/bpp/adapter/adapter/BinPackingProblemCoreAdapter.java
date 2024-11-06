package com.tfg.bpp.adapter.adapter;

import com.tfg.bpp.adapter.client.BinPackingProblemCoreGrpcClient;
import com.tfg.bpp.adapter.mapper.BppSolutionServiceGrpcMapper;
import com.tfg.bpp.adapter.mapper.BppTestInstanceResultsServiceGrpcMapper;
import com.tfg.bpp.adapter.model.BppDetailedSolution;
import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.model.BppSolvableInstance;
import com.tfg.bpp.adapter.model.BppTestInstance;
import com.tfg.bpp.adapter.model.BppTestInstanceResults;
import com.tfg.bpp.adapter.model.BppTestResults;
import com.tfg.bpp.adapter.port.outbound.BinPackingProblemCoreAdapterPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import v1.service.CreateBppDetailedSolutionBySolvableInstancesProto;
import v1.service.CreateByBppInstanceProto;
import v1.service.CreateByBppTestInstanceProto;
import v1.service.CreateBySolvableInstancesProto;

@Service
@RequiredArgsConstructor
@Slf4j
public class BinPackingProblemCoreAdapter implements BinPackingProblemCoreAdapterPort {

  private final BinPackingProblemCoreGrpcClient binPackingProblemCoreGrpcClient;

  private final BppSolutionServiceGrpcMapper bppSolutionServiceGrpcMapper;

  private final BppTestInstanceResultsServiceGrpcMapper bppTestInstanceResultsServiceGrpcMapper;

  @Override
  public List<BppSolution> createBppSolutionsByBppSolvableInstances(
      List<BppSolvableInstance> instances) {
    CreateBySolvableInstancesProto.CreateByBppSolvableInstancesResponse
        createByBppSolvableInstancesResponse =
            this.binPackingProblemCoreGrpcClient.createByBppSolvableInstances(
                CreateBySolvableInstancesProto.CreateByBppSolvableInstancesRequest.newBuilder()
                    .addAllSolvableInstances(
                        this.bppSolutionServiceGrpcMapper.toBppSolvableInstancesProto(instances))
                    .build());

    return this.bppSolutionServiceGrpcMapper.toBppSolutions(
        createByBppSolvableInstancesResponse.getSolutionsList());
  }

  @Override
  public BppTestInstanceResults createBppTestInstanceResultsByBppTestInstance(
      BppTestInstance bppTestInstance) {
    CreateByBppTestInstanceProto.CreateByBppTestInstanceResponse createByBppTestInstanceResponse =
        this.binPackingProblemCoreGrpcClient.createByBppTestInstance(
            CreateByBppTestInstanceProto.CreateByBppTestInstanceRequest.newBuilder()
                .setTestInstance(
                    this.bppTestInstanceResultsServiceGrpcMapper.toBppTestInstanceProto(
                        bppTestInstance))
                .build());

    return this.bppTestInstanceResultsServiceGrpcMapper.toBppTestInstanceResults(
        createByBppTestInstanceResponse.getTestInstanceResults());
  }

  @Override
  public List<BppDetailedSolution> createBppDetailedSolutionsByBppSolvableInstances(
      List<BppSolvableInstance> instances) {
    CreateBppDetailedSolutionBySolvableInstancesProto
            .CreateBppDetailedSolutionByBppSolvableInstancesResponse
        createBppDetailedSolutionByBppSolvableInstancesResponse =
            this.binPackingProblemCoreGrpcClient.createBppDetailedSolutionByBppSolvableInstances(
                CreateBppDetailedSolutionBySolvableInstancesProto
                    .CreateBppDetailedSolutionByBppSolvableInstancesRequest.newBuilder()
                    .addAllSolvableInstances(
                        this.bppSolutionServiceGrpcMapper.toBppSolvableInstancesProto(instances))
                    .build());

    return this.bppSolutionServiceGrpcMapper.toBppDetailedSolutions(
        createBppDetailedSolutionByBppSolvableInstancesResponse.getDetailedSolutionsList());
  }

  @Override
  public List<BppTestResults> createBppTestResultsByBppInstances(List<BppSolvableInstance> instances) {
    CreateByBppInstanceProto.CreateByBppInstanceResponse createByBppInstanceResponse =
        this.binPackingProblemCoreGrpcClient.createByBppInstances(
                CreateByBppInstanceProto.CreateByBppInstanceRequest.newBuilder()
                .addAllInstances(
                    this.bppSolutionServiceGrpcMapper.toBppSolvableInstancesProto(instances))
                .build());

    return this.bppTestInstanceResultsServiceGrpcMapper.toBppTestResultsList(
            createByBppInstanceResponse.getTestResultsList());
  }
}
