package com.tfg.bpp.adapter.config;

import java.util.Locale;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("tfg.mic-bppadapter.message")
@Data
public class MessageConfig {

  private String defaultLocale = "en";

  public Locale getDefaultLocale() {
    return Locale.forLanguageTag(this.defaultLocale);
  }
}
