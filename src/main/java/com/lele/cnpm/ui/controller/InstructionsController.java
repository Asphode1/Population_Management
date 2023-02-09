package com.lele.cnpm.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class InstructionsController {
  @FXML
  private AnchorPane root;
  @FXML
  private WebView webView;
  private WebEngine webEngine;

  public void initialize() {
    webEngine = webView.getEngine();
    webEngine.load(getClass().getResource("/html/index.html").toExternalForm());
  }
}