package com.lele.cnpm.src.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.util.StringConverter;

public class Utils {
  public static StringConverter<LocalDate> converter() {
    return new StringConverter<LocalDate>() {
      private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

      @Override
      public String toString(LocalDate d) {
        if (d == null)
          return "";
        return dtf.format(d);
      }

      @Override
      public LocalDate fromString(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
          return null;
        }
        return LocalDate.parse(dateString, dtf);
      }
    };
  }
}
