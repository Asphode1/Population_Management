package com.lele.cnpm.src.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class Utils {
  public static StringConverter<LocalDate> DATE_VN_CONVERTER = converter();

  private static StringConverter<LocalDate> converter() {
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

  public static ChangeListener<String> numberOnly(TextField t) {
    return new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> ob, String oldVal, String newVal) {
        if (!newVal.matches("\\d*")) {
          t.setText(newVal.replaceAll("[^\\d]", ""));
        }
      }
    };
  };

  public static void clearTextInput(Pane parent) {
    if (parent.getChildren().isEmpty())
      return;
    for (Node child : parent.getChildren()) {
      if (child instanceof TextField)
        ((TextField) child).setText("");
      if (child instanceof TextArea)
        ((TextArea) child).setText("");
      if (child instanceof DatePicker)
        ((DatePicker) child).setValue(null);
      if (child instanceof VBox || child instanceof HBox || child instanceof AnchorPane) {
        clearTextInput((Pane) child);
      }
    }
  }
}
