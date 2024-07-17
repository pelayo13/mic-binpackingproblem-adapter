package com.tfg.bpp.adapter.usecase;

import com.tfg.bpp.adapter.model.BppInstance;
import com.tfg.bpp.adapter.model.BppItem;
import com.tfg.bpp.adapter.model.exception.BppFileCannotBeParsedException;
import com.tfg.bpp.adapter.model.exception.BppFileCannotBeReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.tfg.bpp.adapter.port.inbound.usecase.CreateBppInstanceByBppFileUseCasePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateBppInstanceByBppFileUseCase implements CreateBppInstanceByBppFileUseCasePort {

  public static final String LINE_SPLITTER = ",";

  private static final String CLASS_NAME = CreateBppInstanceByBppFileUseCase.class.getName();

  @Override
  public BppInstance execute(CreateBppInstanceByBppFileCommand createBppInstanceByBppFileCommand)
      throws BppFileCannotBeReadException, BppFileCannotBeParsedException {
    log.trace(
        "{}.execute - filename: {}", CLASS_NAME, createBppInstanceByBppFileCommand.getFilename());

    BufferedReader file =
        new BufferedReader(new InputStreamReader(createBppInstanceByBppFileCommand.getFileData()));

    return this.buildBppInstance(file);
  }

  private BppInstance buildBppInstance(BufferedReader file)
      throws BppFileCannotBeReadException, BppFileCannotBeParsedException {
    int binCapacity;
    List<BppItem> items = new ArrayList<>();
    String line;
    int lineNumber = 1;

    try {
      binCapacity = this.getBinCapacity(file.readLine(), lineNumber);
      lineNumber++;
      while ((line = file.readLine()) != null) {
        items.addAll(this.getBppItemsByLine(line, lineNumber));
        lineNumber++;
      }
    } catch (IOException e) {
      log.error(
          "{}.buildBppInstance - Bpp file line could not be read - line: {}",
          CLASS_NAME,
          lineNumber,
          e);
      throw new BppFileCannotBeReadException("Bpp file line could not be read", e, lineNumber);
    }

    return BppInstance.builder().binsCapacity(binCapacity).items(items).build();
  }

  private int getBinCapacity(String line, int lineNumber) throws BppFileCannotBeParsedException {
    try {
      return Integer.parseInt(line.split(LINE_SPLITTER)[0].trim());
    } catch (Exception e) {
      log.error(
          "{}.getBinCapacity - Bin capacity could not be obtained by parsing bpp file - line: {}",
          CLASS_NAME,
          lineNumber,
          e);
      throw new BppFileCannotBeParsedException(
          "Bin capacity could not be parsed from bpp file", e, lineNumber);
    }
  }

  private List<BppItem> getBppItemsByLine(String line, int lineNumber)
      throws BppFileCannotBeParsedException {
    try {
      List<BppItem> items = new ArrayList<>();
      List<Integer> elements =
          Arrays.stream(line.split(LINE_SPLITTER))
              .map(String::trim)
              .map(Integer::parseInt)
              .toList();

      IntStream.range(0, elements.get(1))
          .forEach(
              index ->
                  items.add(
                      BppItem.builder().size(elements.get(0)).dueDate(elements.get(2)).build()));

      return items;
    } catch (Exception e) {
      log.error(
          "{}.getBppItemsByLine - Items could not be obtained by parsing bpp file - line: {}",
          CLASS_NAME,
          lineNumber,
          e);
      throw new BppFileCannotBeParsedException(
          "Bpp item could not be parsed from bpp file", e, lineNumber);
    }
  }
}
