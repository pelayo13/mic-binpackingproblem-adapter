package com.tfg.bpp.adapter.mapper;

import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tfg.bpp.adapter.config.CentralMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = CentralMapperConfig.class)
public interface GrpcMapper {

  default Int32Value intToInt32(final Integer value) {
    return Optional.ofNullable(value).map(Int32Value::of).orElse(null);
  }

  default Integer int32ToInt(final Int32Value value) {
    return Optional.ofNullable(value).map(Int32Value::getValue).orElse(null);
  }

  default Double doubleValueToDouble(final DoubleValue value) {
    return value.getValue();
  }

  default DoubleValue doubleToDoubleValue(final Double value) {
    return DoubleValue.newBuilder().setValue(value).build();
  }
}
