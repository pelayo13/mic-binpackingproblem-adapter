package com.tfg.bpp.adapter.port.inbound.usecase;

import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.exception.BppFileCannotBeParsedException;
import com.tfg.bpp.adapter.model.exception.BppFileCannotBeReadException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.io.InputStream;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateBppInstanceByBppFileUseCasePort {

  BppInstance execute(@Valid @NotNull CreateBppInstanceByBppFileCommand createBppInstanceByBppFileCommand)
      throws BppFileCannotBeReadException, BppFileCannotBeParsedException, IOException;

  @Builder
  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  final class CreateBppInstanceByBppFileCommand {

    @NotNull private final String filename;

    @NotNull private final InputStream fileData;
  }
}
