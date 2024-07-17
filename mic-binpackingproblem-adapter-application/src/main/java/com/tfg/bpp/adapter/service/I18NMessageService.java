package com.tfg.bpp.adapter.service;

import com.tfg.bpp.adapter.config.MessageConfig;
import com.tfg.bpp.adapter.port.inbound.service.MessageServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class I18NMessageService implements MessageServicePort {

  public static final String MESSAGE_NOT_FOUND_I18N_LOCATION = "bpp-adapter.message.not-found";
  private static final String CLASS_NAME = I18NMessageService.class.getName();
  private final MessageSource messageSource;
  private final MessageConfig messageConfig;

  @Override
  public String getMessage(String messageKey) {
    try {
      return this.messageSource.getMessage(messageKey, null, this.messageConfig.getDefaultLocale());
    } catch (Exception e) {
      log.error(
          "{}.getMessage - Could not get the message - messageKey: {}, locale: {}",
          CLASS_NAME,
          messageKey,
          this.messageConfig.getDefaultLocale(),
          e);
      return this.messageSource.getMessage(
          MESSAGE_NOT_FOUND_I18N_LOCATION, null, this.messageConfig.getDefaultLocale());
    }
  }

  @Override
  public String getMessage(String messageKey, String... params) {
    try {
      return this.messageSource.getMessage(
          messageKey, params, this.messageConfig.getDefaultLocale());
    } catch (Exception e) {
      log.error(
          "{}.getMessage - Could not get the message - messageKey: {}, params: {}, locale: {}",
          CLASS_NAME,
          messageKey,
          params,
          this.messageConfig.getDefaultLocale(),
          e);
      return this.messageSource.getMessage(
          MESSAGE_NOT_FOUND_I18N_LOCATION, null, this.messageConfig.getDefaultLocale());
    }
  }

  @Override
  public String getMessage(String messageKey, Locale locale) {
    final Locale localeToUse =
            Optional.ofNullable(locale).orElse(this.messageConfig.getDefaultLocale());

    try {
      return this.messageSource.getMessage(messageKey, null, localeToUse);
    } catch (Exception e) {
      log.error(
              "{}.getMessage - Could not get the message - messageKey: {}, locale: {}",
              CLASS_NAME,
              messageKey,
              localeToUse,
              e);
      return this.messageSource.getMessage(MESSAGE_NOT_FOUND_I18N_LOCATION, null, localeToUse);
    }
  }

  @Override
  public String getMessage(String messageKey, Locale locale, String... params) {
    final Locale localeToUse =
            Optional.ofNullable(locale).orElse(this.messageConfig.getDefaultLocale());

    try {
      return this.messageSource.getMessage(messageKey, params, localeToUse);
    } catch (Exception e) {
      log.error(
              "{}.getMessage - Could not get the message - messageKey: {}, params: {}, locale: {}",
              CLASS_NAME,
              messageKey,
              params,
              localeToUse,
              e);
      return this.messageSource.getMessage(MESSAGE_NOT_FOUND_I18N_LOCATION, null, localeToUse);
    }
  }
}
