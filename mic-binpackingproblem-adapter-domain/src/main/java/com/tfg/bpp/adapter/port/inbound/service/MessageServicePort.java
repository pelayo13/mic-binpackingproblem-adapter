package com.tfg.bpp.adapter.port.inbound.service;

import java.util.Locale;

public interface MessageServicePort {

  String getMessage(String messageKey);

  String getMessage(String messageKey, String... params);

  String getMessage(String messageKey, Locale locale);

  String getMessage(String messageKey, Locale locale, String... params);
}
