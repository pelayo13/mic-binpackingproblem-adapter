package com.tfg.bpp.adapter.rest.config;

import com.tfg.bpp.adapter.config.MessageConfig;
import com.tfg.bpp.adapter.port.inbound.service.PropertiesLoaderServicePort;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;

@Configuration
@RequiredArgsConstructor
public class MessageApiConfig {

  public static final String API_MESSAGE_ROUTE = "classpath:i18n/messages";
  public static final String API_MESSAGES_ENCODING = "UTF-8";
  public static final List<String> API_MESSAGES_FORMAT = List.of(".yml", ".yaml");

  private final PropertiesLoaderServicePort propertiesLoaderServicePort;

  private final MessageConfig messageConfig;

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();

    messageSource.setBasename(API_MESSAGE_ROUTE);
    messageSource.setDefaultEncoding(API_MESSAGES_ENCODING);
    messageSource.setUseCodeAsDefaultMessage(true);
    messageSource.setPropertiesPersister(this.propertiesLoaderServicePort);
    messageSource.setFileExtensions(API_MESSAGES_FORMAT);

    return messageSource;
  }

  @Bean
  public AcceptHeaderLocaleContextResolver acceptHeaderLocaleContextResolver() {
    AcceptHeaderLocaleContextResolver acceptHeaderLocaleContextResolver =
        new AcceptHeaderLocaleContextResolver();

    acceptHeaderLocaleContextResolver.setDefaultLocale(this.messageConfig.getDefaultLocale());
    LocaleContextHolder.setDefaultLocale(acceptHeaderLocaleContextResolver.getDefaultLocale());
    Locale.setDefault(this.messageConfig.getDefaultLocale());

    return acceptHeaderLocaleContextResolver;
  }
}
