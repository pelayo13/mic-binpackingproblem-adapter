package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppRandomInstancesGenerationParams;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppMetricsByBppRandomInstancesUseCasePort.CreateBppMetricsByBppRandomInstancesCommand;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface BppMetricsMapper {

  BppRandomInstancesGenerationParams toBppRandomInstancesGenerationParams(
      CreateBppMetricsByBppRandomInstancesCommand command);
}
