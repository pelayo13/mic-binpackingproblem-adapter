package com.tfg.bpp.adapter.client;

import com.tfg.bpp.adapter.model.exception.ErrorType;
import com.tfg.bpp.adapter.model.exception.GrpcException;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import v1.service.BppSolutionServiceGrpc;
import v1.service.BppTestInstanceResultsServiceGrpc;
import v1.service.CreateBppDetailedSolutionBySolvableInstancesProto.CreateBppDetailedSolutionByBppSolvableInstancesRequest;
import v1.service.CreateBppDetailedSolutionBySolvableInstancesProto.CreateBppDetailedSolutionByBppSolvableInstancesResponse;
import v1.service.CreateByBppTestInstanceProto.CreateByBppTestInstanceRequest;
import v1.service.CreateByBppTestInstanceProto.CreateByBppTestInstanceResponse;
import v1.service.CreateBySolvableInstancesProto.CreateByBppSolvableInstancesRequest;
import v1.service.CreateBySolvableInstancesProto.CreateByBppSolvableInstancesResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class BinPackingProblemCoreGrpcClientImpl implements BinPackingProblemCoreGrpcClient {

  private static final String CLASS_NAME = BinPackingProblemCoreGrpcClientImpl.class.getName();

  @GrpcClient("mic-binpackingproblem-core")
  private BppSolutionServiceGrpc.BppSolutionServiceBlockingStub bppSolutionServiceStub;

  @GrpcClient("mic-binpackingproblem-core")
  private BppTestInstanceResultsServiceGrpc.BppTestInstanceResultsServiceBlockingStub
      bppTestInstanceResultsServiceStub;

  @Override
  public CreateByBppSolvableInstancesResponse createByBppSolvableInstances(
      CreateByBppSolvableInstancesRequest request) {
    log.info("[start] {}.createByBppSolvableInstances", CLASS_NAME);

    try {
      CreateByBppSolvableInstancesResponse response =
          this.bppSolutionServiceStub.createByBppSolvableInstances(request);

      log.info("[end] {}.createByBppSolvableInstances", CLASS_NAME);

      return response;
    } catch (StatusRuntimeException e) {
      log.error(
          "{}.createByBppSolvableInstances - error calling grpc server - request: {}",
          CLASS_NAME,
          request,
          e);
      throw new GrpcException(
          "There has been an error calling mic-binpackignproblem-core for creating the solutions",
          e,
          ErrorType.ERR_CREATING_SOLUTION);
    }
  }

  @Override
  public CreateByBppTestInstanceResponse createByBppTestInstance(
      CreateByBppTestInstanceRequest request) {
    log.info("[start] {}.createByBppTestInstance", CLASS_NAME);

    try {
      CreateByBppTestInstanceResponse response =
          this.bppTestInstanceResultsServiceStub.createByBppTestInstance(request);

      log.info("[end] {}.createByBppTestInstance", CLASS_NAME);

      return response;
    } catch (StatusRuntimeException e) {
      log.error(
          "{}.createByBppTestInstance - error calling grpc server - request: {}",
          CLASS_NAME,
          request,
          e);
      throw new GrpcException(
          "There has been an error calling mic-binpackignproblem-core for getting the test instance results",
          e,
          ErrorType.ERR_CREATING_SOLUTION);
    }
  }

  @Override
  public CreateBppDetailedSolutionByBppSolvableInstancesResponse
      createBppDetailedSolutionByBppSolvableInstances(
          CreateBppDetailedSolutionByBppSolvableInstancesRequest request) {
    log.info("[start] {}.createBppDetailedSolutionByBppSolvableInstances", CLASS_NAME);

    try {
      CreateBppDetailedSolutionByBppSolvableInstancesResponse response =
          this.bppSolutionServiceStub.createBppDetailedSolutionByBppSolvableInstances(request);

      log.info("[end] {}.createBppDetailedSolutionByBppSolvableInstances", CLASS_NAME);

      return response;
    } catch (StatusRuntimeException e) {
      log.error(
          "{}.createBppDetailedSolutionByBppSolvableInstances - error calling grpc server - request: {}",
          CLASS_NAME,
          request,
          e);
      throw new GrpcException(
          "There has been an error calling mic-binpackignproblem-core for creating the detailed solutions",
          e,
          ErrorType.ERR_CREATING_SOLUTION);
    }
  }
}
