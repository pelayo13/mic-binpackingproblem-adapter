package com.tfg.bpp.adapter.rest.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppInstanceByBppFileUseCasePort.CreateBppInstanceByBppFileCommand;
import java.io.InputStream;
import java.util.List;
import org.mapstruct.Mapper;
import org.openapitools.model.BppInstanceDto;

@Mapper(config = CentralMapperConfig.class)
public interface BppInstanceRestMapper {

  CreateBppInstanceByBppFileCommand toCreateBppInstanceByBppFileCommand(
      String filename, InputStream fileData);

  List<BppInstanceDto> toBppInstanceDtos(List<BppInstance> bppInstances);
}
