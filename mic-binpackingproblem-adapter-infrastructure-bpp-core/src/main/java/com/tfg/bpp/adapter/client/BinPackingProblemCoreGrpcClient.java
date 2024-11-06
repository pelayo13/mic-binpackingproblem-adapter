package com.tfg.bpp.adapter.client;

import v1.service.CreateBppDetailedSolutionBySolvableInstancesProto.CreateBppDetailedSolutionByBppSolvableInstancesRequest;
import v1.service.CreateBppDetailedSolutionBySolvableInstancesProto.CreateBppDetailedSolutionByBppSolvableInstancesResponse;
import v1.service.CreateByBppInstanceProto;
import v1.service.CreateByBppTestInstanceProto.CreateByBppTestInstanceRequest;
import v1.service.CreateByBppTestInstanceProto.CreateByBppTestInstanceResponse;
import v1.service.CreateBySolvableInstancesProto.CreateByBppSolvableInstancesRequest;
import v1.service.CreateBySolvableInstancesProto.CreateByBppSolvableInstancesResponse;

public interface BinPackingProblemCoreGrpcClient {

  CreateByBppSolvableInstancesResponse createByBppSolvableInstances(
      CreateByBppSolvableInstancesRequest createByBppSolvableInstancesRequest);

  CreateByBppTestInstanceResponse createByBppTestInstance(
      CreateByBppTestInstanceRequest createByBppTestInstanceRequest);

  CreateBppDetailedSolutionByBppSolvableInstancesResponse
      createBppDetailedSolutionByBppSolvableInstances(
          CreateBppDetailedSolutionByBppSolvableInstancesRequest
              createBppDetailedSolutionByBppSolvableInstancesRequest);

  CreateByBppInstanceProto.CreateByBppInstanceResponse createByBppInstances(
      CreateByBppInstanceProto.CreateByBppInstanceRequest createByBppInstanceRequest);
}
