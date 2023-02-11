package com.lele.cnpm.ui.controller;

import com.lele.cnpm.src.utils.Preference;

import javafx.beans.value.ObservableValue;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class InputController {
  @FXML
  VBox root;

  @FXML
  private TextField serverField;
  @FXML
  private TextField userField;
  @FXML
  private PasswordField passField;
  @FXML
  private Label setupLabel;
  @FXML
  private Label errText;
  @FXML
  private Button confirmBtn;
  @FXML
  private Button exitBtn;
  @FXML
  private AnchorPane exitPane;

  public void initialize() {
    final ChangeListener<Boolean> listener = new ChangeListener<>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldVal, Boolean newVal) {
        if (newVal) {
          errText.setText("");
        }
      }
    };
    serverField.focusedProperty().addListener(listener);
    userField.focusedProperty().addListener(listener);
    passField.focusedProperty().addListener(listener);
    if (!Preference.checkInitial()) {
      serverField.setText(Preference.getValue("com.lele.db.servername"));
      userField.setText(Preference.getValue("com.lele.db.username"));
      passField.setText(Preference.getValue("com.lele.db.password"));
    }
    exitBtn.setOnMouseEntered(e -> {
      FadeTransition ft = new FadeTransition(Duration.millis(100), exitPane);
      ft.setFromValue(0);
      ft.setToValue(1);
      ft.setCycleCount(1);
      ft.setAutoReverse(false);
      ft.play();
    });
    exitBtn.setOnMouseExited(e -> {
      FadeTransition ft = new FadeTransition(Duration.millis(100), exitPane);
      ft.setFromValue(1);
      ft.setToValue(0);
      ft.setCycleCount(1);
      ft.setAutoReverse(false);
      ft.play();
    });
    setupLabel.setOnMouseClicked(e -> {
      try {
        AnchorPane aPane = FXMLLoader.load(getClass().getResource("/fxml/Instructions.fxml"));
        Scene s = new Scene(aPane);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.show();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });
    confirmBtn.setOnAction(e -> {
      String user = userField.getText();
      if (serverField.getText().isEmpty() || passField.getText().isEmpty()) {
        errText.setText("Vui lòng nhập đủ thông tin");
      } else {
        Preference.setValue("com.lele.db.servername", serverField.getText());
        Preference.setValue("com.lele.db.username", user.isEmpty() ? "sa" : user);
        Preference.setValue("com.lele.db.password", passField.getText());
        try {
          HBox hBox = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
          Scene s = new Scene(hBox);
          s.setFill(Color.TRANSPARENT);
          if (Stage.getWindows().size() == 1) {
            Stage oldStage = (Stage) root.getScene().getWindow();
            oldStage.close();
            Stage stage = new Stage();
            stage.setScene(s);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
            stage.show();
          } else {
            exit(e);
          }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
  }

  public void exit(ActionEvent e) {
    Stage stage = (Stage) root.getScene().getWindow();
    stage.close();
  }
}
