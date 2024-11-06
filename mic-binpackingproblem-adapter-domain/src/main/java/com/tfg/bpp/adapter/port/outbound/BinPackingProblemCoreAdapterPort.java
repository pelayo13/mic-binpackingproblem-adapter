package com.tfg.bpp.adapter.port.outbound;

import com.tfg.bpp.adapter.model.BppDetailedSolution;
import com.tfg.bpp.adapter.model.BppSolution;
import com.tfg.bpp.adapter.model.BppSolvableInstance;
import com.tfg.bpp.adapter.model.BppTestInstance;
import com.tfg.bpp.adapter.model.BppTestInstanceResults;
import com.tfg.bpp.adapter.model.BppTestResults;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface BinPackingProblemCoreAdapterPort {

    List<BppSolution> createBppSolutionsByBppSolvableInstances(@NotNull List<BppSolvableInstance> instances);

    BppTestInstanceResults createBppTestInstanceResultsByBppTestInstance(@NotNull BppTestInstance bppTestInstance);

    List<BppDetailedSolution> createBppDetailedSolutionsByBppSolvableInstances(@NotNull List<BppSolvableInstance> instances);

    List<BppTestResults> createBppTestResultsByBppInstances(@NotNull List<BppSolvableInstance> instances);
}
