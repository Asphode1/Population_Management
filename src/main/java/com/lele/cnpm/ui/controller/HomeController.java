package com.lele.cnpm.ui.controller;

import java.util.ArrayList;
import java.util.Objects;

import com.lele.cnpm.src.models.NguoiDung;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class HomeController {
  @FXML
  private AnchorPane root;

  //startup
  @FXML
  private AnchorPane startup;
  @FXML
  private ImageView logo;
  @FXML
  private Label helloText;
  @FXML
  private Pane movePane;

  // include
  @FXML
  private VBox dashboard;
  @FXML
  private AnchorPane household;
  @FXML
  private AnchorPane people;
  @FXML
  private AnchorPane reward;
  @FXML
  private DashboardController dashboardController;
  @FXML
  private PeopleController peopleController;
  @FXML
  private HouseholdController householdController;

  @FXML
  private VBox main;
  @FXML
  private VBox navBar;

  @FXML
  private HBox navHBtn;
  @FXML
  private HBox lgoHBtn;
  @FXML
  private HBox ppHBtn;
  @FXML
  private HBox dshHBtn;
  @FXML
  private HBox hhHBtn;
  @FXML
  private HBox rwHBtn;

  @FXML
  private Button navBtn;
  @FXML
  private Button ppBtn;
  @FXML
  private Button lgoBtn;
  @FXML
  private Button dshBtn;
  @FXML
  private Button hhBtn;
  @FXML
  private Button rwBtn;
  @FXML
  private Button exitBtn;
  @FXML
  private Button minBtn;

  @FXML
  private Pane grayBar;

  private ArrayList<HBox> hBoxs = new ArrayList<>();
  private ArrayList<Label> labels = new ArrayList<>();

  private NguoiDung user = null;

  public void init(NguoiDung usr) {
    user = usr;
    helloText.setText("Hello, " + user.getUserName());
  }

  public void initialize() {
    PauseTransition pauset0 = new PauseTransition(Duration.seconds(0.75));
    Timeline logoTransition = new Timeline(
        new KeyFrame(Duration.seconds(0), new KeyValue(logo.opacityProperty(), logo.opacityProperty().getValue())),
        new KeyFrame(Duration.seconds(0.75), new KeyValue(logo.opacityProperty(), 1)));
    logoTransition.setAutoReverse(false);
    logoTransition.setCycleCount(1);
    PauseTransition pauset1 = new PauseTransition(Duration.seconds(0.5));
    Interpolator itp = Interpolator.SPLINE(.34, .7, .54, 1);
    TranslateTransition ttlogo = new TranslateTransition(Duration.seconds(1), logo);
    ttlogo.setByX(-260);
    ttlogo.setAutoReverse(false);
    ttlogo.setCycleCount(1);
    ttlogo.setInterpolator(itp);
    TranslateTransition ttPane = new TranslateTransition(Duration.seconds(1), movePane);
    ttPane.setByX(-260);
    ttPane.setAutoReverse(false);
    ttPane.setCycleCount(1);
    ttPane.setInterpolator(itp);
    TranslateTransition ttText = new TranslateTransition(Duration.seconds(1), helloText);
    ttText.setByX(260);
    ttText.setAutoReverse(false);
    ttText.setCycleCount(1);
    ttText.setInterpolator(itp);
    ParallelTransition pt = new ParallelTransition(ttPane, ttlogo, ttText);
    PauseTransition pauset2 = new PauseTransition(Duration.seconds(0.75));
    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), startup);
    ft.setFromValue(1.0);
    ft.setToValue(0.0);
    ft.setAutoReverse(false);
    ft.setCycleCount(1);
    SequentialTransition st = new SequentialTransition(pauset0, logoTransition, pauset1, pt, pauset2, ft);
    st.play();
    ObservableList<Node> children = navBar.getChildren();
    for (Node c : children) {
      if (c instanceof HBox && !c.equals(navHBtn)) {
        hBoxs.add((HBox) c);
      }
    }
    for (HBox h : hBoxs) {
      h.setMouseTransparent(false);
      if (!h.equals(navHBtn)) {
        labels.add((Label) h.getChildren().get(1));
      }
    }
    navBtn.addEventFilter(MouseEvent.MOUSE_ENTERED, ev -> {
      ColorAdjust ca = new ColorAdjust();
      ca.setBrightness(0);
      navBtn.setEffect(ca);
      Timeline mouseOnEnter = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(ca.brightnessProperty(), ca.brightnessProperty().getValue(), Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25), new KeyValue(ca.brightnessProperty(), -0.25, Interpolator.EASE_BOTH)));
      mouseOnEnter.setAutoReverse(false);
      mouseOnEnter.setCycleCount(1);
      mouseOnEnter.play();
    });
    navBtn.addEventFilter(MouseEvent.MOUSE_EXITED, ev -> {
      ColorAdjust ca = new ColorAdjust();
      ca.setBrightness(0);
      navBtn.setEffect(ca);
      Timeline mouseOnExit = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(ca.brightnessProperty(), ca.brightnessProperty().getValue(), Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25), new KeyValue(ca.brightnessProperty(), 0, Interpolator.EASE_BOTH)));
      mouseOnExit.setAutoReverse(false);
      mouseOnExit.setCycleCount(1);
      mouseOnExit.play();
    });
    ColorAdjust exitButtonCA = new ColorAdjust();
    exitButtonCA.setBrightness(0);
    ColorAdjust minButtonCA = new ColorAdjust();
    minButtonCA.setBrightness(0);
    exitBtn.setEffect(exitButtonCA);
    exitBtn.setOnMouseEntered(e -> {
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
    exitBtn.setOnMouseExited(e -> {
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
    minBtn.setEffect(minButtonCA);
    minBtn.setOnMouseEntered(e -> {
      Timeline onExitEnter = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(minButtonCA.brightnessProperty(), minButtonCA.brightnessProperty().getValue(),
                  Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(minButtonCA.brightnessProperty(), -0.3, Interpolator.EASE_BOTH)));
      onExitEnter.setAutoReverse(false);
      onExitEnter.setCycleCount(1);
      onExitEnter.play();
    });
    minBtn.setOnMouseExited(e -> {
      Timeline onExitOut = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(minButtonCA.brightnessProperty(), minButtonCA.brightnessProperty().getValue(),
                  Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(minButtonCA.brightnessProperty(), 0, Interpolator.EASE_BOTH)));
      onExitOut.setAutoReverse(false);
      onExitOut.setCycleCount(1);
      onExitOut.play();
    });
    minBtn.setOnAction(e -> {
      ((Stage) ((Button) e.getSource()).getScene().getWindow()).setIconified(true);
    });
  }

  public void navOpen(ActionEvent e) {
    for (HBox h : hBoxs) {
      h.setMouseTransparent(false);
    }
    lgoHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, logout);
    ppHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openPeople);
    dshHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openDashboard);
    hhHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openHousehold);
    rwHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openReward);
    setOnHover(hBoxs);
    if (navBar.getPrefWidth() == 88) {
      Timeline navOpen = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(navBar.prefWidthProperty(), navBar.prefWidthProperty().getValue(), Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25), new KeyValue(navBar.prefWidthProperty(), 284, Interpolator.EASE_BOTH)));
      navOpen.setAutoReverse(false);
      navOpen.setCycleCount(1);
      navOpen.play();
      grayBar.setMouseTransparent(false);
      grayBar.setVisible(true);
      grayBar.addEventFilter(MouseEvent.MOUSE_CLICKED, ev -> navShrink(ev));
      for (Label l : labels) {
        l.setPadding(new Insets(0, 0, 0, 5));
        Timeline labelOpen = new Timeline(
            new KeyFrame(Duration.seconds(0),
                new KeyValue(l.prefWidthProperty(), l.prefWidthProperty().getValue(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(0.25),
                new KeyValue(l.prefWidthProperty(), 150, Interpolator.EASE_BOTH)));
        labelOpen.setCycleCount(1);
        labelOpen.setAutoReverse(false);
        labelOpen.play();
      }
    } else
      navShrink(e);
  }

  private void navShrink(ActionEvent e) {
    Timeline navShrink = new Timeline(new KeyFrame(Duration.seconds(0),
        new KeyValue(navBar.prefWidthProperty(), navBar.prefWidthProperty().getValue(), Interpolator.EASE_BOTH)),
        new KeyFrame(Duration.seconds(0.25), new KeyValue(navBar.prefWidthProperty(), 88, Interpolator.EASE_BOTH)));
    navShrink.setAutoReverse(false);
    navShrink.setCycleCount(1);
    navShrink.play();
    /* for (HBox h : hBoxs) {
      h.setMouseTransparent(true);
    } */
    grayBar.setMouseTransparent(true);
    grayBar.setVisible(false);
    for (Label l : labels) {
      Timeline labelClose = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(l.paddingProperty(), l.paddingProperty().getValue(), Interpolator.EASE_BOTH),
              new KeyValue(l.prefWidthProperty(), l.prefWidthProperty().getValue(), Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(l.paddingProperty(), new Insets(0, 0, 0, 0), Interpolator.EASE_BOTH),
              new KeyValue(l.prefWidthProperty(), 0, Interpolator.EASE_BOTH)));
      labelClose.setCycleCount(1);
      labelClose.setAutoReverse(false);
      labelClose.play();
    }
  }

  private void navShrink(MouseEvent e) {
    Timeline navShrink = new Timeline(new KeyFrame(Duration.seconds(0),
        new KeyValue(navBar.prefWidthProperty(), navBar.prefWidthProperty().getValue(), Interpolator.EASE_BOTH)),
        new KeyFrame(Duration.seconds(0.25), new KeyValue(navBar.prefWidthProperty(), 88, Interpolator.EASE_BOTH)));
    navShrink.setAutoReverse(false);
    navShrink.setCycleCount(1);
    navShrink.play();
    for (HBox h : hBoxs) {
      h.setMouseTransparent(true);
    }
    grayBar.setMouseTransparent(true);
    grayBar.setVisible(false);
    for (Label l : labels) {
      Timeline labelClose = new Timeline(
          new KeyFrame(Duration.seconds(0),
              new KeyValue(l.paddingProperty(), l.paddingProperty().getValue(), Interpolator.EASE_BOTH),
              new KeyValue(l.prefWidthProperty(), l.prefWidthProperty().getValue(), Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.seconds(0.25),
              new KeyValue(l.paddingProperty(), new Insets(0, 0, 0, 0), Interpolator.EASE_BOTH),
              new KeyValue(l.prefWidthProperty(), 0, Interpolator.EASE_BOTH)));
      labelClose.setCycleCount(1);
      labelClose.setAutoReverse(false);
      labelClose.play();
    }
  }

  private void setOnHover(ArrayList<HBox> hBoxes) {
    for (HBox h : hBoxes) {
      h.addEventFilter(MouseEvent.MOUSE_ENTERED, ev -> {
        ColorAdjust ca = new ColorAdjust();
        ca.setBrightness(0);
        h.setEffect(ca);
        Timeline mouseOnEnter = new Timeline(
            new KeyFrame(Duration.seconds(0),
                new KeyValue(ca.brightnessProperty(), ca.brightnessProperty().getValue(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(0.25), new KeyValue(ca.brightnessProperty(), -0.25, Interpolator.EASE_BOTH)));
        mouseOnEnter.setAutoReverse(false);
        mouseOnEnter.setCycleCount(1);
        mouseOnEnter.play();
      });
      h.addEventFilter(MouseEvent.MOUSE_EXITED, ev -> {
        ColorAdjust ca = new ColorAdjust();
        ca.setBrightness(0);
        h.setEffect(ca);
        Timeline mouseOnExit = new Timeline(
            new KeyFrame(Duration.seconds(0),
                new KeyValue(ca.brightnessProperty(), ca.brightnessProperty().getValue(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(0.25), new KeyValue(ca.brightnessProperty(), 0, Interpolator.EASE_BOTH)));
        mouseOnExit.setAutoReverse(false);
        mouseOnExit.setCycleCount(1);
        mouseOnExit.play();
      });
      h.addEventFilter(MouseEvent.MOUSE_CLICKED, ev -> {
        navShrink(ev);
        if (!h.equals(lgoHBtn) && !h.getStyleClass().contains("onFocus"))
          h.getStyleClass().add("onFocus");
        for (HBox hOther : hBoxes) {
          if (!hOther.equals(h) && h.getStyleClass().contains("onFocus")) {
            hOther.getStyleClass().remove("onFocus");
          }
        }
      });
    }
  }

  EventHandler<MouseEvent> openPeople = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
      people.setManaged(true);
      people.setVisible(true);
      dashboard.setManaged(false);
      dashboard.setVisible(false);
      household.setManaged(false);
      household.setVisible(false);
      reward.setManaged(false);
      reward.setVisible(false);
    }
  };

  EventHandler<MouseEvent> openDashboard = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
      people.setManaged(false);
      people.setVisible(false);
      dashboard.setManaged(true);
      dashboard.setVisible(true);
      household.setManaged(false);
      household.setVisible(false);
      reward.setManaged(false);
      reward.setVisible(false);
    }
  };

  EventHandler<MouseEvent> openHousehold = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
      people.setManaged(false);
      people.setVisible(false);
      dashboard.setManaged(false);
      dashboard.setVisible(false);
      household.setManaged(true);
      household.setVisible(true);
      reward.setManaged(false);
      reward.setVisible(false);
    }
  };

  EventHandler<MouseEvent> openReward = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
      people.setManaged(false);
      people.setVisible(false);
      dashboard.setManaged(false);
      dashboard.setVisible(false);
      household.setManaged(false);
      household.setVisible(false);
      reward.setManaged(true);
      reward.setVisible(true);
    }
  };

  EventHandler<MouseEvent> logout = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent ev) {
      Stage stage = (Stage) root.getScene().getWindow();
      try {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  };

  public void logout(MouseEvent ev) {
    Stage stage = (Stage) root.getScene().getWindow();
    try {
      Parent root = FXMLLoader
          .load(Objects.requireNonNull(getClass().getClassLoader().getResource("/fxml/Login.fxml")));
      Scene scene = new Scene(root);
      scene.setFill(Color.TRANSPARENT);
      stage.setScene(scene);
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.setResizable(false);
      stage.centerOnScreen();
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void exit(ActionEvent e) {
    Stage stage = (Stage) root.getScene().getWindow();
    stage.close();
  }
}
