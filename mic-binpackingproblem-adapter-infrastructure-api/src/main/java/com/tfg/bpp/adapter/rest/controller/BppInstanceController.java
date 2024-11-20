package com.tfg.bpp.adapter.rest.controller;

import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.exception.BppInstanceByBppFileException;
import com.tfg.bpp.adapter.model.exception.ErrorType;
import com.tfg.bpp.adapter.port.inbound.service.MessageServicePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppInstanceByBppFileUseCasePort;
import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppSolutionsByBppSolvableInstancesUseCasePort;
import com.tfg.bpp.adapter.rest.mapper.BppInstanceControllerRestMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.BppInstanceApi;
import org.openapitools.model.CreateByFilesErrorResponse;
import org.openapitools.model.CreateByFilesResponse;
import org.openapitools.model.CreateSolutionsByBppSolvableInstancesRequest;
import org.openapitools.model.CreateSolutionsByBppSolvableInstancesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BppInstanceController implements BppInstanceApi {

  private static final String CLASS_NAME = BppInstanceController.class.getName();

  private final CreateBppInstanceByBppFileUseCasePort createBppInstanceByBppFileUseCasePort;

  private final CreateBppSolutionsByBppSolvableInstancesUseCasePort
          createBppSolutionsByBppSolvableInstancesUseCasePort;

  private final MessageServicePort messageServicePort;

  private final BppInstanceControllerRestMapper bppInstanceControllerRestMapper;

  @Override
  public ResponseEntity<CreateByFilesResponse> createByFiles(
      List<MultipartFile> files, String acceptLanguage) {
    log.info("[start] {}.createByFiles", CLASS_NAME);

    List<BppInstance> bppInstances = new ArrayList<>();
    List<CreateByFilesErrorResponse> createBppInstanceByFileErrorResponses = new ArrayList<>();

    files.forEach(
        file -> {
          try {
            bppInstances.add(
                this.createBppInstanceByBppFileUseCasePort.execute(
                    this.bppInstanceControllerRestMapper.toCreateBppInstanceByBppFileCommand(
                        file.getOriginalFilename(), file.getInputStream())));
          } catch (IOException e) {
            log.error(
                "{}.createByFiles - Could not read file - filename: {}",
                CLASS_NAME,
                file.getOriginalFilename(),
                e);
            createBppInstanceByFileErrorResponses.add(
                CreateByFilesErrorResponse.builder()
                    .filename(Objects.requireNonNull(file.getOriginalFilename()))
                    .code(ErrorType.CANNOT_READ_BPP_FILE.getCode())
                    .title(ErrorType.CANNOT_READ_BPP_FILE.getKey())
                    .detail(
                        this.messageServicePort.getMessage(
                            ErrorType.CANNOT_READ_BPP_FILE.getMessageI18nLocation(),
                            Locale.forLanguageTag(acceptLanguage)))
                    .build());
          } catch (BppInstanceByBppFileException e) {
            log.error(
                "{}.createByFiles - Could not parse bpp instance by file - filename: {}",
                CLASS_NAME,
                file.getOriginalFilename(),
                e);
            createBppInstanceByFileErrorResponses.add(
                CreateByFilesErrorResponse.builder()
                    .filename(Objects.requireNonNull(file.getOriginalFilename()))
                    .code(e.getErrorConstant().getCode())
                    .title(e.getErrorConstant().getKey())
                    .detail(
                        this.messageServicePort.getMessage(
                            e.getErrorConstant().getMessageI18nLocation(),
                            Locale.forLanguageTag(acceptLanguage),
                            String.valueOf(e.getErrorLine())))
                    .build());
          }
        });

    log.info("[end] {}.createByFiles", CLASS_NAME);

    return ResponseEntity.ok(
        CreateByFilesResponse.builder()
            .instances(this.bppInstanceControllerRestMapper.toBppInstanceDtos(bppInstances))
            .filesWithErrors(createBppInstanceByFileErrorResponses)
            .build());
  }

  @Override
  public ResponseEntity<CreateSolutionsByBppSolvableInstancesResponse>
      createSolutionsByBppSolvableInstances(
          CreateSolutionsByBppSolvableInstancesRequest createByBppSolvableInstancesRequest,
          String view,
          String acceptLanguage) {
    log.info("[start] {}.createSolutionsByBppSolvableInstances", CLASS_NAME);

    CreateBppSolutionsByBppSolvableInstancesUseCasePort
            .CreateBppSolutionsByBppSolvableInstancesResponse
        response =
            this.createBppSolutionsByBppSolvableInstancesUseCasePort.execute(
                this.bppInstanceControllerRestMapper.toCreateBppSolutionsByBppSolvableInstancesCommand(
                    createByBppSolvableInstancesRequest));

    log.info("[end] {}.createSolutionsByBppSolvableInstances", CLASS_NAME);



    return ResponseEntity.ok(
        this.bppInstanceControllerRestMapper.toCreateSolutionsByBppSolvableInstancesResponse(response, view));
  }
}
