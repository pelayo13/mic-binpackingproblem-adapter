package com.tfg.bpp.adapter.service;

import com.tfg.bpp.adapter.port.inbound.service.PropertiesLoaderServicePort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;
import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

@Service
public class YamlPropertiesLoaderService implements PropertiesLoaderServicePort {

  @Override
  public void load(Properties properties, InputStream inputStream) {
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new InputStreamResource(inputStream));
    properties.putAll(yaml.getObject());
  }

  @Override
  public void load(Properties props, Reader reader) throws IOException {
    InputStream inputStream = ReaderInputStream.builder().setReader(reader).get();
    load(props, inputStream);
  }

  @Override
  public void store(Properties props, OutputStream os, String header) throws IOException {
    throw new UnsupportedEncodingException("Storing is not supported by YamlPropertiesLoader");
  }

  @Override
  public void store(Properties props, Writer writer, String header) throws IOException {
    throw new UnsupportedEncodingException("Storing is not supported by YamlPropertiesLoader");
  }

  @Override
  public void loadFromXml(Properties props, InputStream is) throws IOException {
    throw new UnsupportedEncodingException("Storing is not supported by YamlPropertiesLoader");
  }

  @Override
  public void storeToXml(Properties props, OutputStream os, String header) throws IOException {
    throw new UnsupportedEncodingException("Storing is not supported by YamlPropertiesLoader");
  }

  @Override
  public void storeToXml(Properties props, OutputStream os, String header, String encoding)
      throws IOException {
    throw new UnsupportedEncodingException("Storing is not supported by YamlPropertiesLoader");
  }
}
