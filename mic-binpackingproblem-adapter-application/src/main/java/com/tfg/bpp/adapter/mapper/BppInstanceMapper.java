package com.tfg.bpp.adapter.mapper;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import com.tfg.bpp.adapter.model.BppBin;
import com.tfg.bpp.adapter.model.BppInstance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CentralMapperConfig.class)
public interface BppInstanceMapper {

  BppInstance toBppInstance(List<BppBin> bins, int binCapacity);
}
