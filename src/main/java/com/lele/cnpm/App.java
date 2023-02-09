package com.lele.cnpm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
  @Override
  public void start(Stage stage) {
    try (InputStream input = App.class.getClassLoader().getResourceAsStream("/config.properties")) {
      input.close();
      HBox hBox = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
      Scene s = new Scene(hBox);
      s.setFill(Color.TRANSPARENT);
      stage.setScene(s);
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.setResizable(false);
      stage.centerOnScreen();
      stage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
      stage.show();
    } catch (IOException e) {
      try {
        VBox vbox = FXMLLoader.load(getClass().getResource("/fxml/Input.fxml"));
        Scene s = new Scene(vbox);
        s.setFill(Color.TRANSPARENT);
        stage.setScene(s);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(getClass().getResource("/img/logo.png").toExternalForm()));
        stage.show();
      } catch (Exception ee) {
        ee.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
