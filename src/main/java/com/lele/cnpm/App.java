package com.lele.cnpm;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
  @Override
  public void start(Stage stage) {
    try {
      HBox hBox = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
      Scene s = new Scene(hBox);
      s.setFill(Color.TRANSPARENT);
      stage.setScene(s);
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.setResizable(false);
      stage.centerOnScreen();
      stage.getIcons().add(new Image("/img/logo.png"));
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
