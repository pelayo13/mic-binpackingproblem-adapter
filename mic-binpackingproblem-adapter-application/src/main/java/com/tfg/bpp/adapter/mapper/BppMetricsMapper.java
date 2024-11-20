package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppTestInstance;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppTestInstanceResultsByBppTestInstanceUseCasePort;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface BppMetricsMapper {

  BppTestInstance toBppTestInstance(
      CreateBppTestInstanceResultsByBppTestInstanceUseCasePort
              .CreateBppTestInstanceResultsByBppTestInstanceCommand
          command);
}
