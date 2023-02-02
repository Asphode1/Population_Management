package com.lele.cnpm.ui.controller;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import com.lele.cnpm.src.models.NguoiDung;
import com.lele.cnpm.src.services.LoginManage;

public class LoginController {
  @FXML
  private HBox root;

  @FXML
  private Button exitBtn;
  @FXML
  private Button loginBtn;

  @FXML
  private Label errText;

  @FXML
  private TextField user;
  @FXML
  private PasswordField pass;

  public void initialize() {
    root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
      if (ev.getCode() == KeyCode.ENTER) {
        loginBtn.fire();
        ev.consume();
      }
    });
    ColorAdjust exitButtonCA = new ColorAdjust();
    exitButtonCA.setBrightness(0);
    loginBtn.setEffect(exitButtonCA);
    loginBtn.setOnMouseEntered(e -> {
      Timeline onExitEnter = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(exitButtonCA.brightnessProperty(), exitButtonCA.brightnessProperty().getValue(),
                  Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(exitButtonCA.brightnessProperty(), -0.3, Interpolator.EASE_BOTH)));
      onExitEnter.setAutoReverse(false);
      onExitEnter.setCycleCount(1);
      onExitEnter.play();
    });
    loginBtn.setOnMouseExited(e -> {
      Timeline onExitOut = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(exitButtonCA.brightnessProperty(), exitButtonCA.brightnessProperty().getValue(),
                  Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(exitButtonCA.brightnessProperty(), 0, Interpolator.EASE_BOTH)));
      onExitOut.setAutoReverse(false);
      onExitOut.setCycleCount(1);
      onExitOut.play();
    });
    ColorAdjust loginButtonCA = new ColorAdjust();
    loginButtonCA.setBrightness(0);
    exitBtn.setEffect(loginButtonCA);
    exitBtn.setOnMouseEntered(e -> {
      Timeline onExitEnter = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(loginButtonCA.brightnessProperty(), loginButtonCA.brightnessProperty().getValue(),
                  Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(loginButtonCA.brightnessProperty(), -0.3, Interpolator.EASE_BOTH)));
      onExitEnter.setAutoReverse(false);
      onExitEnter.setCycleCount(1);
      onExitEnter.play();
    });
    exitBtn.setOnMouseExited(e -> {
      Timeline onExitOut = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(loginButtonCA.brightnessProperty(), loginButtonCA.brightnessProperty().getValue(),
                  Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(loginButtonCA.brightnessProperty(), 0, Interpolator.EASE_BOTH)));
      onExitOut.setAutoReverse(false);
      onExitOut.setCycleCount(1);
      onExitOut.play();
    });
    Platform.runLater(() -> user.requestFocus());
  }

  public void login(ActionEvent e) {
    String id = user.getText().trim();
    String password = pass.getText().trim();
    if (id.length() == 0 || password.length() == 0) {
      loginFailed(2);
    }
    try {
      NguoiDung nd = LoginManage.checkUser(id, password);
      if (nd != null) {
        loginSucess(nd);
      } else
        loginFailed(1);
    } catch (Exception ex) {
      ex.printStackTrace();
      errText.setText("Lỗi kết nối csdl");
    }
  }

  private void loginSucess(NguoiDung nd) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
      Parent aPane = loader.load();
      HomeController hc = loader.<HomeController>getController();
      hc.init(nd);
      Scene scene = new Scene(aPane);
      scene.setFill(Color.TRANSPARENT);
      Stage stage = (Stage) root.getScene().getWindow();
      stage.close();
      Stage newStage = new Stage();
      newStage.setScene(scene);
      newStage.setResizable(false);
      newStage.initStyle(StageStyle.TRANSPARENT);
      newStage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
      newStage.show();
    } catch (Exception e) {
      e.printStackTrace();
      errText.setText("Lỗi kết nối csdl");
    }
  }

  private void loginFailed(int errid) {
    switch (errid) {
      case 1: {
        errText.setText("Tài khoản hoặc mật khẩu không đúng");
        break;
      }
      case 2:
        errText.setText("Vui lòng nhập đầy đủ");
        break;
    }
  }

  public void exit(ActionEvent e) {
    Stage stage = (Stage) root.getScene().getWindow();
    stage.close();
  }
}
