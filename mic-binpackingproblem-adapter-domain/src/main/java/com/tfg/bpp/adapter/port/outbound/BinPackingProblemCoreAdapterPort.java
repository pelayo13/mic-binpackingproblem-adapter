package com.tfg.bpp.adapter.port.outbound;

import com.tfg.bpp.adapter.model.BppAlgorithm;
import com.tfg.bpp.adapter.model.BppAlgorithmMetrics;
import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.BppInstanceMetrics;
import com.tfg.bpp.adapter.model.BppRandomInstancesGenerationParams;
import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.model.BppSolvableInstance;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public interface BinPackingProblemCoreAdapterPort {

  List<BppSolution> createBppSolutionsByBppSolvableInstances(
      @NotNull List<BppSolvableInstance> instances);

  List<BppInstanceMetrics> createBppMetricsByBppRandomInstances(
      @NotNull BppRandomInstancesGenerationParams bppRandomInstancesGenerationParams);

  List<BppAlgorithmMetrics> createBppMetricsByBppInstances(
      @NotNull List<BppInstance> instances, @NotNull List<BppAlgorithm> algorithms, Integer numberRepetitions);
}
