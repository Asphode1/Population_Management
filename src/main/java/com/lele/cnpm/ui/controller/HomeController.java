package com.lele.cnpm.ui.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import com.lele.cnpm.src.models.NguoiDung;
import com.lele.cnpm.src.services.LoginManage;
import com.lele.cnpm.src.utils.Password;
import com.lele.cnpm.src.utils.Utils;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
  @FXML
  private AnchorPane exitPane;
  @FXML
  private AnchorPane settingsPane;
  @FXML
  private AnchorPane confirmSettingsPane;
  @FXML
  private AnchorPane confirmedSettingsPane;

  //startup
  @FXML
  private AnchorPane startup;
  @FXML
  private ImageView logo;
  @FXML
  private Label helloText;
  @FXML
  private Pane movePane;
  @FXML
  private Pane mainLabelPane;
  @FXML
  private Pane nkLabelPane;
  @FXML
  private Pane hkLabelPane;
  @FXML
  private Pane rwLabelPane;

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
  private VBox reBox;
  @FXML
  private VBox newBox;

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
  private HBox sttHBtn;

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
  private Button reBtn;
  @FXML
  private Button newBtn;
  @FXML
  private Button reSave;
  @FXML
  private Button reReturn;
  @FXML
  private Button newSave;
  @FXML
  private Button newReturn;
  @FXML
  private Button confirmChange;
  @FXML
  private Button cancelChange;
  @FXML
  private Button confirmedChange;

  @FXML
  private PasswordField oldPass;
  @FXML
  private PasswordField newPass;
  @FXML
  private PasswordField rePass;
  @FXML
  private TextField username;
  @FXML
  private PasswordField pass;
  @FXML
  private PasswordField reNewPass;

  @FXML
  private Label reErr;
  @FXML
  private Label newErr;
  @FXML
  private Label text;
  @FXML
  private Label confirmText;

  @FXML
  private Pane grayBar;

  private ArrayList<HBox> hBoxs = new ArrayList<>();
  private ArrayList<Label> labels = new ArrayList<>();

  private NguoiDung user = null;

  public void init(NguoiDung usr) {
    user = usr;
    helloText.setText("Xin ch??o, " + user.getUserName());
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
    ttlogo.setByX(-285);
    ttlogo.setAutoReverse(false);
    ttlogo.setCycleCount(1);
    ttlogo.setInterpolator(itp);
    TranslateTransition ttPane = new TranslateTransition(Duration.seconds(1), movePane);
    ttPane.setByX(-285);
    ttPane.setAutoReverse(false);
    ttPane.setCycleCount(1);
    ttPane.setInterpolator(itp);
    TranslateTransition ttText = new TranslateTransition(Duration.seconds(1), helloText);
    ttText.setByX(285);
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
    sttHBtn.setMouseTransparent(true);
    lgoHBtn.setMouseTransparent(true);
    ppHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openPeople);
    dshHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openDashboard);
    hhHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openHousehold);
    rwHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openReward);
    setOnHover(hBoxs);
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
    ColorAdjust minButtonCA = new ColorAdjust();
    minButtonCA.setBrightness(0);
    exitBtn.setOnMouseEntered(e -> {
      FadeTransition fft = new FadeTransition(Duration.millis(100), exitPane);
      fft.setFromValue(0);
      fft.setToValue(1);
      fft.setCycleCount(1);
      fft.setAutoReverse(false);
      fft.play();
    });
    exitBtn.setOnMouseExited(e -> {
      FadeTransition fft = new FadeTransition(Duration.millis(100), exitPane);
      fft.setFromValue(1);
      fft.setToValue(0);
      fft.setCycleCount(1);
      fft.setAutoReverse(false);
      fft.play();
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
    sttHBtn.setMouseTransparent(false);
    lgoHBtn.setMouseTransparent(false);
    sttHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, settings);
    lgoHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, logout);
    ppHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openPeople);
    dshHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openDashboard);
    hhHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openHousehold);
    rwHBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, openReward);
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
    sttHBtn.setMouseTransparent(true);
    lgoHBtn.setMouseTransparent(true);
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
    sttHBtn.setMouseTransparent(true);
    lgoHBtn.setMouseTransparent(true);
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
    final ArrayList<Pane> panes = new ArrayList<>();
    panes.addAll(Arrays.asList(mainLabelPane, nkLabelPane, hkLabelPane, rwLabelPane));
    for (int i = 0; i < hBoxes.size(); i++) {
      final int index = i;
      final HBox h = hBoxes.get(i);
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
        if (index < 4 && navBar.getPrefWidth() == 88) {
          final FadeTransition fft = new FadeTransition(Duration.millis(100), panes.get(index));
          fft.setFromValue(0);
          fft.setToValue(1);
          fft.setCycleCount(1);
          fft.setAutoReverse(false);
          fft.play();
        }
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
        if (index < 4 && navBar.getPrefWidth() == 88) {
          final FadeTransition fft = new FadeTransition(Duration.millis(100), panes.get(index));
          fft.setFromValue(1);
          fft.setToValue(0);
          fft.setCycleCount(1);
          fft.setAutoReverse(false);
          fft.play();
        }
      });
      h.addEventFilter(MouseEvent.MOUSE_CLICKED, ev -> {
        navShrink(ev);
        if (!h.equals(lgoHBtn) && !h.equals(sttHBtn) && !h.getStyleClass().contains("onFocus"))
          h.getStyleClass().add("onFocus");
        for (HBox hOther : hBoxes) {
          if (!hOther.equals(h) && !h.equals(sttHBtn) && h.getStyleClass().contains("onFocus")) {
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
      settingsPane.setVisible(false);
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
      settingsPane.setVisible(false);
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
      settingsPane.setVisible(false);
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
      settingsPane.setVisible(false);
    }
  };

  EventHandler<MouseEvent> settings = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent e) {
      settingsPane.setVisible(true);
      reReturn.setOnAction(ae -> settingsPane.setVisible(false));
      newReturn.setOnAction(ae -> settingsPane.setVisible(false));
      reBtn.setOnAction(ae -> {
        if (!reBtn.getStyleClass().contains("btnOnFocus")) {
          reBtn.getStyleClass().add("btnOnFocus");
          newBtn.getStyleClass().remove("btnOnFocus");
          reBox.setVisible(true);
          newBox.setVisible(false);
          text.setText("X??c nh???n ?????i m???t kh???u");
          confirmText.setText("?????i m???t kh???u th??nh c??ng");
        }
      });
      newBtn.setOnAction(ae -> {
        if (!newBtn.getStyleClass().contains("btnOnFocus")) {
          newBtn.getStyleClass().add("btnOnFocus");
          reBtn.getStyleClass().remove("btnOnFocus");
          reBox.setVisible(false);
          newBox.setVisible(true);
          text.setText("X??c nh???n th??m ng?????i d??ng");
          confirmText.setText("Th??m ng?????i d??ng th??nh c??ng");
        }
      });
      reSave.setOnAction(aee -> {
        String s1 = oldPass.getText();
        String s2 = newPass.getText();
        String s3 = rePass.getText();
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty())
          reErr.setText("Vui l??ng nh???p ????? th??ng tin");
        else if (!s2.equals(s3))
          reErr.setText("Vui l??ng nh???p l???i ????ng m???t kh???u");
        else if (s2.equals(s1))
          reErr.setText("Vui l??ng nh???p m???t kh???u m???i kh??c m???t kh???u c??");
        else {
          try {
            NguoiDung nd = LoginManage.checkUser(user.getUserName(), s1);
            if (nd == null)
              reErr.setText("Sai m???t kh???u c??");
            else {
              confirmSettingsPane.setVisible(true);
              confirmChange.setOnAction(aeee -> {
                try {
                  LoginManage.changePassword(user, s3);
                } catch (Exception ex) {
                  ex.printStackTrace();
                }
                confirmedSettingsPane.setVisible(true);
                confirmedChange.setOnAction(aeeee -> {
                  confirmedSettingsPane.setVisible(false);
                  confirmSettingsPane.setVisible(false);
                  settingsPane.setVisible(false);
                  Utils.clearTextInput(settingsPane);
                });
              });
              cancelChange.setOnAction(aeee -> {
                confirmSettingsPane.setVisible(false);
              });
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });
      newSave.setOnAction(aee -> {
        String s1 = username.getText();
        String s2 = pass.getText();
        String s3 = reNewPass.getText();
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty())
          newErr.setText("Vui l??ng nh???p ????? th??ng tin");
        else if (!s2.equals(s3))
          newErr.setText("Vui l??ng nh???p l???i ????ng m???t kh???u");
        else {
          try {
            if (!LoginManage.checkUsername(s1)) {
              newErr.setText("T??n ????ng nh???p ???? t???n t???i");
            } else {
              confirmSettingsPane.setVisible(true);
              confirmChange.setOnAction(aeee -> {
                try {
                  Password p = Password.newPassword(s2);
                  NguoiDung nd = new NguoiDung(0, s1, p, "T??? tr?????ng");
                  LoginManage.themNguoiDung(nd);
                } catch (Exception ex) {
                  ex.printStackTrace();
                }
                confirmedSettingsPane.setVisible(true);
                confirmedChange.setOnAction(aeeee -> {
                  confirmedSettingsPane.setVisible(false);
                  confirmSettingsPane.setVisible(false);
                  settingsPane.setVisible(false);
                  Utils.clearTextInput(settingsPane);
                });
              });
              cancelChange.setOnAction(aeeee -> {
                confirmSettingsPane.setVisible(false);
              });
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });
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
