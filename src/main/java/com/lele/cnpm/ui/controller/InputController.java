package com.lele.cnpm.ui.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
  private Button confirmBtn;

  public void initialize() {
    setupLabel.setOnMouseClicked(e -> {
    });
    confirmBtn.setOnAction(e -> {
      try (OutputStream output = new FileOutputStream(getClass().getResource("/config.properties").toString())) {
        Properties props = new Properties();
        String user = userField.getText();
        props.setProperty("com.lele.db.servername", serverField.getText());
        props.setProperty("com.lele.db.username", user.isEmpty() ? "sa" : user);
        props.setProperty("com.lele.db.password", passField.getText());
        props.store(output, null);
        output.close();
        HBox hBox = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene s = new Scene(hBox);
        s.setFill(Color.TRANSPARENT);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(s);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
        stage.show();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });
  }
}
