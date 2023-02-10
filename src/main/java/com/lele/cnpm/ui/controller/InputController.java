package com.lele.cnpm.ui.controller;

import com.lele.cnpm.src.utils.Preference;

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
      Preference.setValue("com.lele.db.servername", serverField.getText());
      Preference.setValue("com.lele.db.username", user.isEmpty() ? "sa" : user);
      Preference.setValue("com.lele.db.password", passField.getText());
      try {
        HBox hBox = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene s = new Scene(hBox);
        s.setFill(Color.TRANSPARENT);
        Stage oldStage = (Stage) root.getScene().getWindow();
        oldStage.close();
        Stage stage = new Stage();
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

  public void exit(ActionEvent e) {
    Stage stage = (Stage) root.getScene().getWindow();
    stage.close();
  }
}
