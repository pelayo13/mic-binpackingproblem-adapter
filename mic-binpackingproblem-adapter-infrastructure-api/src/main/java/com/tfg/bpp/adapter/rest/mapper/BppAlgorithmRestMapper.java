package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppBinsDestructionOperation;
import com.tfg.bpp.adapter.model.BppBinsInterchangeOperation;
import com.tfg.bpp.adapter.model.BppLocalSearchAlgorithm;
import com.tfg.bpp.adapter.model.BppNeighborhoodStructure;
import com.tfg.bpp.adapter.model.BppNeighborhoodStructureOperation;
import com.tfg.bpp.adapter.model.BppNeighborhoodStructureOperationType;
import com.tfg.bpp.adapter.model.BppReconstructionOperation;
import com.tfg.bpp.adapter.model.BppStoredItemsAndFreeItemsInterchangeOperation;
import com.tfg.bpp.adapter.model.BppStoredItemsInterchangeOperation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapitools.model.BppNeighborhoodStructureDto;
import org.openapitools.model.BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner;
import org.openapitools.model.LocalSearchAlgorithmDto;

@Mapper(
    config = CentralMapperConfig.class,
    imports = {BppNeighborhoodStructureOperationType.class})
public interface BppAlgorithmRestMapper {

  BppLocalSearchAlgorithm toBppLocalSearchAlgorithm(
      LocalSearchAlgorithmDto localSearchAlgorithmDto);

  @Mapping(
          target = "bppNeighborhoodStructureOperations",
          source = "bppNeighborhoodStructureOperations",
          qualifiedByName = "toBppNeighborhoodStructureOperation")
  BppNeighborhoodStructure toBppNeighborhoodStructure(BppNeighborhoodStructureDto bppNeighborhoodStructureDto);

  @Named("toBppNeighborhoodStructureOperation")
  default BppNeighborhoodStructureOperation toBppNeighborhoodStructureOperation(
      BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
          bppNeighborhoodStructureOperationDto) {
    switch (bppNeighborhoodStructureOperationDto.getType()) {
      case BINS_DESTRUCTION -> {
        return this.toBppBinsDestructionOperation(bppNeighborhoodStructureOperationDto);
      }
      case RECONSTRUCTION -> {
        return this.toBppReconstructionOperation(bppNeighborhoodStructureOperationDto);
      }
      case BINS_INTERCHANGE -> {
        return this.toBppBinsInterchangeOperation(bppNeighborhoodStructureOperationDto);
      }
      case STORED_ITEMS_AND_FREE_ITEMS_INTERCHANGE -> {
        return this.toBppStoredItemsAndFreeItemsInterchangeOperation(
            bppNeighborhoodStructureOperationDto);
      }
      case STORED_ITEMS_INTERCHANGE -> {
        return this.toBppStoredItemsInterchangeOperation(bppNeighborhoodStructureOperationDto);
      }
      default -> {
        return null;
      }
    }
  }

  BppBinsDestructionOperation toBppBinsDestructionOperation(
      BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
          bppNeighborhoodStructureOperationDto);

  BppReconstructionOperation toBppReconstructionOperation(
      BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
          bppNeighborhoodStructureOperationDto);

  BppBinsInterchangeOperation toBppBinsInterchangeOperation(
      BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
          bppNeighborhoodStructureOperationDto);

  BppStoredItemsAndFreeItemsInterchangeOperation toBppStoredItemsAndFreeItemsInterchangeOperation(
      BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
          bppNeighborhoodStructureOperationDto);

  BppStoredItemsInterchangeOperation toBppStoredItemsInterchangeOperation(
      BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
          bppNeighborhoodStructureOperationDto);

  default BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
      toBppNeighborhoodStructureOperationDto(
          BppNeighborhoodStructureOperation bppNeighborhoodStructureOperation) {
    switch (bppNeighborhoodStructureOperation.getType()) {
      case BINS_DESTRUCTION -> {
        return this.toBppBinsDestructionOperationDto(
            (BppBinsDestructionOperation) bppNeighborhoodStructureOperation);
      }
      case RECONSTRUCTION -> {
        return this.toBppReconstructionOperationDto(
            (BppReconstructionOperation) bppNeighborhoodStructureOperation);
      }
      case BINS_INTERCHANGE -> {
        return this.toBppBinsInterchangeOperationDto(
            (BppBinsInterchangeOperation) bppNeighborhoodStructureOperation);
      }
      case STORED_ITEMS_AND_FREE_ITEMS_INTERCHANGE -> {
        return this.toBppStoredItemsAndFreeItemsInterchangeOperationDto(
            (BppStoredItemsAndFreeItemsInterchangeOperation) bppNeighborhoodStructureOperation);
      }
      case STORED_ITEMS_INTERCHANGE -> {
        return this.toBppStoredItemsInterchangeOperationDto(
            (BppStoredItemsInterchangeOperation) bppNeighborhoodStructureOperation);
      }
      default -> {
        return null;
      }
    }
  }

  BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
      toBppBinsDestructionOperationDto(BppBinsDestructionOperation bppBinsDestructionOperation);

  BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
      toBppReconstructionOperationDto(BppReconstructionOperation bppReconstructionOperation);

  BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
      toBppBinsInterchangeOperationDto(BppBinsInterchangeOperation bppBinsInterchangeOperation);

  BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
      toBppStoredItemsAndFreeItemsInterchangeOperationDto(
          BppStoredItemsAndFreeItemsInterchangeOperation
              bppStoredItemsAndFreeItemsInterchangeOperation);

  BppNeighborhoodStructureDtoBppNeighborhoodStructureOperationsInner
      toBppStoredItemsInterchangeOperationDto(
          BppStoredItemsInterchangeOperation bppStoredItemsInterchangeOperation);
}
