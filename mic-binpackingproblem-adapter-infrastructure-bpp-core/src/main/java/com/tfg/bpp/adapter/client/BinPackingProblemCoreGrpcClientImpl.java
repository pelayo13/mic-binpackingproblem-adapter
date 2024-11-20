package com.tfg.bpp.adapter.client;

import com.tfg.bpp.adapter.model.exception.ErrorType;
import com.tfg.bpp.adapter.model.exception.GrpcException;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import v1.service.BppAlgorithmServiceGrpc;
import v1.service.BppInstanceServiceGrpc;
import v1.service.CreateBppMetricsByBppInstancesProto.CreateBppMetricsByBppInstancesRequest;
import v1.service.CreateBppMetricsByBppInstancesProto.CreateBppMetricsByBppInstancesResponse;
import v1.service.CreateBppMetricsByBppRandomInstancesProto.CreateBppMetricsByBppRandomInstancesRequest;
import v1.service.CreateBppMetricsByBppRandomInstancesProto.CreateBppMetricsByBppRandomInstancesResponse;
import v1.service.CreateBppSolutionsBySolvableInstancesProto.CreateBppSolutionsByBppSolvableInstancesRequest;
import v1.service.CreateBppSolutionsBySolvableInstancesProto.CreateBppSolutionsByBppSolvableInstancesResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class BinPackingProblemCoreGrpcClientImpl implements BinPackingProblemCoreGrpcClient {

  private static final String CLASS_NAME = BinPackingProblemCoreGrpcClientImpl.class.getName();

  @GrpcClient("mic-binpackingproblem-core")
  private BppInstanceServiceGrpc.BppInstanceServiceBlockingStub bppInstanceServiceBlockingStub;

  @GrpcClient("mic-binpackingproblem-core")
  private BppAlgorithmServiceGrpc.BppAlgorithmServiceBlockingStub bppAlgorithmServiceBlockingStub;

  @Override
  public CreateBppSolutionsByBppSolvableInstancesResponse createBppSolutionsByBppSolvableInstances(
      CreateBppSolutionsByBppSolvableInstancesRequest request) {
    log.info("[start] {}.createBppSolutionsByBppSolvableInstances", CLASS_NAME);

    try {
      CreateBppSolutionsByBppSolvableInstancesResponse response =
          this.bppInstanceServiceBlockingStub.createBppSolutionsByBppSolvableInstances(request);

      log.info("[end] {}.createBppSolutionsByBppSolvableInstances", CLASS_NAME);

      return response;
    } catch (StatusRuntimeException e) {
      log.error(
          "{}.createBppSolutionsByBppSolvableInstances - error calling grpc server - request: {}",
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
  public CreateBppMetricsByBppRandomInstancesResponse createBppMetricsByBppRandomInstances(
      CreateBppMetricsByBppRandomInstancesRequest request) {
    log.info("[start] {}.createBppMetricsByBppRandomInstances", CLASS_NAME);

    try {
      CreateBppMetricsByBppRandomInstancesResponse response =
          this.bppAlgorithmServiceBlockingStub.createBppMetricsByBppRandomInstances(request);

      log.info("[end] {}.createBppMetricsByBppRandomInstances", CLASS_NAME);

      return response;
    } catch (StatusRuntimeException e) {
      log.error(
          "{}.createBppMetricsByBppRandomInstances - error calling grpc server - request: {}",
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
  public CreateBppMetricsByBppInstancesResponse createBppMetricsByBppInstances(
      CreateBppMetricsByBppInstancesRequest request) {
    log.info("[start] {}.createBppMetricsByBppInstances", CLASS_NAME);

    try {
      CreateBppMetricsByBppInstancesResponse response =
          this.bppAlgorithmServiceBlockingStub.createBppMetricsByBppInstances(request);

      log.info("[end] {}.createBppMetricsByBppInstances", CLASS_NAME);

      return response;
    } catch (StatusRuntimeException e) {
      log.error(
          "{}.createBppMetricsByBppInstances - error calling grpc server - request: {}",
          CLASS_NAME,
          request,
          e);
      throw new GrpcException(
          "There has been an error calling mic-binpackignproblem-core for getting the test results",
          e,
          ErrorType.ERR_CREATING_SOLUTION);
    }
  }
}
