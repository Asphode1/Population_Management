package com.lele.cnpm.ui.controller;

import java.util.ArrayList;
import java.util.Arrays;

import com.lele.cnpm.src.models.ChiTietDipDacBiet;
import com.lele.cnpm.src.models.ChiTietDipHocSinhGioi;
import com.lele.cnpm.src.models.DipDacBiet;
import com.lele.cnpm.src.models.DipHSG;
import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.services.NhanKhauManage;
import com.lele.cnpm.src.services.TraoThuongDacBietManage;
import com.lele.cnpm.src.services.TraoThuongHSGManage;
import com.lele.cnpm.src.utils.Utils;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;

public class RewardController {

  @FXML
  private AnchorPane mainTablePane;
  @FXML
  private AnchorPane detailPane;
  @FXML
  private AnchorPane listPane;
  @FXML
  private AnchorPane confirmPane;
  @FXML
  private AnchorPane listConfirmPane;
  @FXML
  private AnchorPane listConfirmDeletePane;
  @FXML
  private AnchorPane listConfirmAddPane;
  @FXML
  private AnchorPane listConfirmedDeletePane;
  @FXML
  private AnchorPane listConfirmedAddPane;
  @FXML
  private AnchorPane listConfirmedPane;
  @FXML
  private AnchorPane deletePane;
  @FXML
  private AnchorPane confirmedDelPane;

  @FXML
  private TextField yearField;
  @FXML
  private TextField nameField;
  @FXML
  private TextField present1Field;
  @FXML
  private TextField money1Field;
  @FXML
  private TextField present2Field;
  @FXML
  private TextField money2Field;
  @FXML
  private TextField present3Field;
  @FXML
  private TextField money3Field;
  @FXML
  private TextField addNameField;
  @FXML
  private TextField addLField;
  @FXML
  private TextField addSField;
  @FXML
  private TextArea descField;

  @FXML
  private Button selectHSGBtn;
  @FXML
  private Button selectSPCBtn;
  @FXML
  private Button goodBtn;
  @FXML
  private Button specialBtn;
  @FXML
  private Button listBtn;
  @FXML
  private Button listAddBtn;
  @FXML
  private Button listAddNewBtn;
  @FXML
  private Button listAddAllBtn;
  @FXML
  private Button listConfirmBtn;
  @FXML
  private Button listCancelBtn;
  @FXML
  private Button editBtn;
  @FXML
  private Button saveBtn;
  @FXML
  private Button deleteBtn;
  @FXML
  private Button returnBtn;
  @FXML
  private Button listReturnBtn;
  @FXML
  private Button listConfirmedBtn;
  @FXML
  private Button editListReturnBtn;
  @FXML
  private Button editListSaveBtn;
  @FXML
  private Button confirmBtn;
  @FXML
  private Button cancelBtn;
  @FXML
  private Button listConfirmDeleteBtn;
  @FXML
  private Button listCancelDeleteBtn;
  @FXML
  private Button listConfirmedDeleteBtn;
  @FXML
  private Button listConfirmAddBtn;
  @FXML
  private Button listCancelAddBtn;
  @FXML
  private Button listConfirmedAddBtn;
  @FXML
  private Button confirmDelBtn;
  @FXML
  private Button cancelDelBtn;
  @FXML
  private Button returnDelBtn;

  @FXML
  private Label nameLabel;
  @FXML
  private Label present1Label;
  @FXML
  private Label present2Label;
  @FXML
  private Label present3Label;
  @FXML
  private Label title;
  @FXML
  private Label confirmLabel;
  @FXML
  private Label addSLabel;
  @FXML
  private Label errText;
  @FXML
  private Label listErrText;

  @FXML
  private VBox listBox;
  @FXML
  private HBox addListBox;
  @FXML
  private HBox addLBox;
  @FXML
  private HBox addSBox;
  @FXML
  private VBox addedListBox;
  @FXML
  private VBox addListDetailBox;
  @FXML
  private VBox editListSBox;
  @FXML
  private HBox detailBtn;
  @FXML
  private HBox comboBox;
  @FXML
  private HBox listBtnBox;
  @FXML
  private HBox editListBtnBox;

  private TableView<DipDacBiet> sMainTable = new TableView<>();
  private TableView<DipHSG> gMainTable = new TableView<>();
  private ArrayList<DipDacBiet> sList = new ArrayList<>();
  private ArrayList<DipHSG> gList = new ArrayList<>();
  private DipDacBiet selectedS = null;
  private DipHSG selectedG = null;

  private TableView<ChiTietDipHocSinhGioi> gnkTable = new TableView<>();
  private TableView<ChiTietDipDacBiet> snkTable = new TableView<>();
  private ArrayList<ChiTietDipHocSinhGioi> gnkList = new ArrayList<>();
  private ArrayList<ChiTietDipDacBiet> snkList = new ArrayList<>();
  private NhanKhau selectedAddNK = null;
  private ChiTietDipDacBiet selectedListS = null;
  private ChiTietDipHocSinhGioi selectedListG = null;
  private ArrayList<ChiTietDipHocSinhGioi> addedGList = new ArrayList<>();
  private ArrayList<ChiTietDipDacBiet> addedSList = new ArrayList<>();

  private AnchorPane optPane = new AnchorPane();
  private VBox optBox = new VBox();
  private Button deleteNKBtn = new Button("Xoá nhân khẩu");
  private Button confirmNKBtn = new Button("Xác nhận thưởng");
  private ArrayList<Button> optBtnList = new ArrayList<>();

  public void initialize() {
    detailPane.visibleProperty().addListener((ob, oldVal, newVal) -> {
      if (newVal == false) {
        if (selectHSGBtn.getStyleClass().contains("btnOnFocus"))
          getGList();
        else
          getSList();
      }
    });

    optBtnList.add(deleteNKBtn);
    optBtnList.add(confirmNKBtn);
    optBtnList.forEach((Button e) -> {
      e.setPrefHeight(40);
      e.setPrefWidth(160);
      e.setBorder(new Border(
          new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
              BorderWidths.DEFAULT)));
      e.setStyle("-fx-background-color: inherit");
      e.getStyleClass().addAll("addLabel", "addLabelSmaller");
      e.addEventFilter(MouseEvent.MOUSE_ENTERED, me -> {
        ColorAdjust ca = new ColorAdjust();
        ca.setBrightness(0);
        e.setEffect(ca);
        Timeline mouseOnEnter = new Timeline(
            new KeyFrame(Duration.seconds(0),
                new KeyValue(ca.brightnessProperty(), ca.brightnessProperty().getValue(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(0.25), new KeyValue(ca.brightnessProperty(), -0.25, Interpolator.EASE_BOTH)));
        mouseOnEnter.setAutoReverse(false);
        mouseOnEnter.setCycleCount(1);
        mouseOnEnter.play();
      });
      e.addEventFilter(MouseEvent.MOUSE_EXITED, me -> {
        ColorAdjust ca = new ColorAdjust();
        ca.setBrightness(0);
        e.setEffect(ca);
        Timeline mouseOnExit = new Timeline(
            new KeyFrame(Duration.seconds(0),
                new KeyValue(ca.brightnessProperty(), ca.brightnessProperty().getValue(), Interpolator.EASE_BOTH)),
            new KeyFrame(Duration.seconds(0.25), new KeyValue(ca.brightnessProperty(), 0, Interpolator.EASE_BOTH)));
        mouseOnExit.setAutoReverse(false);
        mouseOnExit.setCycleCount(1);
        mouseOnExit.play();
      });
    });
    optBox.getChildren().addAll(optBtnList);
    optBox.setPrefHeight(80);
    optBox.setPrefWidth(160);
    optBox.setStyle("-fx-background-color: #fefefe");
    optPane.setVisible(false);
    optPane.getChildren().add(optBox);
    optPane.setOnMouseClicked((MouseEvent me) -> {
      optPane.setVisible(false);
    });
    listPane.getChildren().add(optPane);
    AnchorPane.setBottomAnchor(optPane, 0.0);
    AnchorPane.setLeftAnchor(optPane, 0.0);
    AnchorPane.setRightAnchor(optPane, 0.0);
    AnchorPane.setTopAnchor(optPane, 0.0);

    Callback<TableView<DipHSG>, TableRow<DipHSG>> rowGFactory = new Callback<TableView<DipHSG>, TableRow<DipHSG>>() {
      @Override
      public TableRow<DipHSG> call(final TableView<DipHSG> param) {
        final TableRow<DipHSG> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent e) -> {
          if (e.getClickCount() >= 2) {
            selectedG = row.getItem();
            if (selectedG != null) {
              openGInfo(e);
            }
          }
        });
        return row;
      }
    };
    Callback<TableView<DipDacBiet>, TableRow<DipDacBiet>> rowSFactory = new Callback<TableView<DipDacBiet>, TableRow<DipDacBiet>>() {
      @Override
      public TableRow<DipDacBiet> call(final TableView<DipDacBiet> param) {
        final TableRow<DipDacBiet> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent e) -> {
          if (e.getClickCount() >= 2) {
            selectedS = row.getItem();
            if (selectedS != null) {
              openSInfo(e);
            }
          }
        });
        return row;
      }
    };
    TableColumn<DipHSG, String> namGCol = Utils.createColumn("Năm", "nam");
    namGCol.setMaxWidth(70);
    namGCol.setMinWidth(70);
    TableColumn<DipHSG, String> numGCol = Utils.createColumn("Chưa trao thưởng", "soNguoiChuaTraoThuong");
    numGCol.setMaxWidth(180);
    numGCol.setMinWidth(180);
    TableColumn<DipHSG, String> p1GCol = new TableColumn<>("Tổng tiền đã trao");
    p1GCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DipHSG, String>, ObservableValue<String>>() {
      @Override
      public ObservableValue<String> call(CellDataFeatures<DipHSG, String> p) {
        float can = TraoThuongHSGManage.tongTienDaTrao(p.getValue());
        StringProperty c = new SimpleStringProperty();
        c.set(Float.toString(can));
        return c;
      }
    });
    TableColumn<DipHSG, String> p2GCol = new TableColumn<>("Tổng tiền cần trao");
    p2GCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DipHSG, String>, ObservableValue<String>>() {
      @Override
      public ObservableValue<String> call(CellDataFeatures<DipHSG, String> p) {
        float can = TraoThuongHSGManage.tongTienCanTrao(p.getValue());
        StringProperty c = new SimpleStringProperty();
        c.set(Float.toString(can));
        return c;
      }
    });
    TableColumn<DipHSG, String> descGCol = Utils.createColumn("Mô tả", "moTa");
    gMainTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    gMainTable.getColumns().addAll(Arrays.asList(namGCol, numGCol, p1GCol, p2GCol, descGCol));
    gMainTable.setMinHeight(512);
    gMainTable.setMinWidth(734);
    gMainTable.setRowFactory(rowGFactory);
    TableColumn<DipDacBiet, String> namSCol = Utils.createColumn("Năm", "nam");
    namSCol.setMaxWidth(70);
    namSCol.setMinWidth(70);
    TableColumn<DipDacBiet, String> numSCol = Utils.createColumn("Chưa trao thưởng", "soNguoiChuaTraoThuong");
    numSCol.setMaxWidth(180);
    numSCol.setMinWidth(180);
    TableColumn<DipDacBiet, String> p1SCol = new TableColumn<>("Tổng tiền đã trao");
    p1SCol
        .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DipDacBiet, String>, ObservableValue<String>>() {
          @Override
          public ObservableValue<String> call(CellDataFeatures<DipDacBiet, String> p) {
            float can = TraoThuongDacBietManage.tongTienDaTrao(p.getValue());
            StringProperty c = new SimpleStringProperty();
            c.set(Float.toString(can));
            return c;
          }
        });
    TableColumn<DipDacBiet, String> p2SCol = new TableColumn<>("Tổng tiền cần trao");
    p2SCol
        .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DipDacBiet, String>, ObservableValue<String>>() {
          @Override
          public ObservableValue<String> call(CellDataFeatures<DipDacBiet, String> p) {
            float can = TraoThuongDacBietManage.tongTienCanTrao(p.getValue());
            StringProperty c = new SimpleStringProperty();
            c.set(Float.toString(can));
            return c;
          }
        });
    TableColumn<DipDacBiet, String> descSCol = Utils.createColumn("Mô tả", "moTa");
    TableColumn<DipDacBiet, String> tenSCol = Utils.createColumn("Tên dịp", "ten");
    tenSCol.setMinWidth(180);
    tenSCol.setMaxWidth(180);
    sMainTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    sMainTable.getColumns().addAll(Arrays.asList(tenSCol, namSCol, numSCol, p1SCol, p2SCol, descSCol));
    sMainTable.setMinHeight(512);
    sMainTable.setMinWidth(734);
    sMainTable.setRowFactory(rowSFactory);
    getGList();
    mainTablePane.getChildren().clear();
    mainTablePane.getChildren().add(gMainTable);
    selectHSGBtn.setOnAction(e -> {
      if (!selectHSGBtn.getStyleClass().contains("btnOnFocus")) {
        getGList();
        selectHSGBtn.getStyleClass().add("btnOnFocus");
        selectSPCBtn.getStyleClass().remove("btnOnFocus");
        mainTablePane.getChildren().clear();
        mainTablePane.getChildren().add(gMainTable);
      }
    });
    selectSPCBtn.setOnAction(e -> {
      if (!selectSPCBtn.getStyleClass().contains("btnOnFocus")) {
        getSList();
        selectSPCBtn.getStyleClass().add("btnOnFocus");
        selectHSGBtn.getStyleClass().remove("btnOnFocus");
        mainTablePane.getChildren().clear();
        mainTablePane.getChildren().add(sMainTable);
      }
    });
    goodBtn.setOnAction(e -> openGAdd(e));
    specialBtn.setOnAction(e -> openSAdd(e));
  }

  private void getGList() {
    gList = TraoThuongHSGManage.layListDipHSG();
    gMainTable.getItems().clear();
    ObservableList<DipHSG> list = FXCollections.observableArrayList(gList);
    gMainTable.setItems(list);
  }

  private void getSList() {
    sList = TraoThuongDacBietManage.layListDipDacBiet();
    sMainTable.getItems().clear();
    ObservableList<DipDacBiet> list = FXCollections.observableArrayList(sList);
    sMainTable.setItems(list);
  }

  private void openGAdd(ActionEvent e) {
    detailPane.setVisible(true);
    detailBtn.getChildren().clear();
    detailBtn.getChildren().addAll(saveBtn, returnBtn);
    title.setText("Thêm phần thưởng HSG");
    nameLabel.setVisible(false);
    nameField.setVisible(false);
    present1Label.setText("Phần quà đặc biệt (*):");
    present2Label.setText("Phần quà HSG (*):");
    present3Label.setText("Phần quà HS Khá (*):");
    yearField.setEditable(true);
    present1Field.setEditable(true);
    present2Field.setEditable(true);
    present3Field.setEditable(true);
    money1Field.setEditable(true);
    money2Field.setEditable(true);
    money3Field.setEditable(true);
    descField.setEditable(true);
    descField.setText("");
    yearField.setText("");
    present1Field.setText("");
    present2Field.setText("");
    present3Field.setText("");
    money1Field.setText("");
    money2Field.setText("");
    money3Field.setText("");
    descField.getStyleClass().remove("textDisabled");
    yearField.getStyleClass().remove("textDisabled");
    present1Field.getStyleClass().remove("textDisabled");
    present2Field.getStyleClass().remove("textDisabled");
    present3Field.getStyleClass().remove("textDisabled");
    money1Field.getStyleClass().remove("textDisabled");
    money2Field.getStyleClass().remove("textDisabled");
    money3Field.getStyleClass().remove("textDisabled");
    saveBtn.setOnAction(ae -> {
      String s1 = yearField.getText();
      String s2 = present1Field.getText();
      String s3 = money1Field.getText();
      String s4 = present2Field.getText();
      String s5 = money2Field.getText();
      String s6 = present3Field.getText();
      String s7 = money3Field.getText();
      String s8 = descField.getText();
      if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty())
        errText.setVisible(true);
      else {
        errText.setVisible(false);
        confirmPane.setVisible(true);
        confirmLabel.setText("Xác nhận thêm phần thưởng");
        confirmBtn.setOnAction(aee -> {
          DipHSG hsg = new DipHSG(0, Integer.parseInt(s1), s8, s2, s4, s6, Float.parseFloat(s3), Float.parseFloat(s5),
              Float.parseFloat(s7));
          TraoThuongHSGManage.themDipHSG(hsg);
          confirmPane.setVisible(false);
          detailPane.setVisible(false);
          errText.setVisible(false);
        });
        cancelBtn.setOnAction(aee -> confirmPane.setVisible(false));
      }
    });
    returnBtn.setText("Huỷ");
    returnBtn.setOnAction(ae -> {
      detailPane.setVisible(false);
      errText.setVisible(false);
      Utils.clearTextInput(detailPane);
    });
  }

  private void openSAdd(ActionEvent e) {
    detailPane.setVisible(true);
    detailBtn.getChildren().clear();
    detailBtn.getChildren().addAll(saveBtn, returnBtn);
    title.setText("Thêm phần thưởng dịp đặc biệt");
    nameLabel.setVisible(true);
    nameField.setVisible(true);
    present1Label.setText("Độ tuổi 0-5 tuổi (*):");
    present2Label.setText("Độ tuổi 6-14 tuổi (*):");
    present3Label.setText("Độ tuổi 15-17 tuổi (*):");
    yearField.setEditable(true);
    nameField.setEditable(true);
    present1Field.setEditable(true);
    present2Field.setEditable(true);
    present3Field.setEditable(true);
    money1Field.setEditable(true);
    money2Field.setEditable(true);
    money3Field.setEditable(true);
    descField.setEditable(true);
    descField.setText("");
    yearField.setText("");
    present1Field.setText("");
    present2Field.setText("");
    present3Field.setText("");
    money1Field.setText("");
    money2Field.setText("");
    money3Field.setText("");
    descField.setText("");
    descField.getStyleClass().remove("textDisabled");
    yearField.getStyleClass().remove("textDisabled");
    present1Field.getStyleClass().remove("textDisabled");
    present2Field.getStyleClass().remove("textDisabled");
    present3Field.getStyleClass().remove("textDisabled");
    money1Field.getStyleClass().remove("textDisabled");
    money2Field.getStyleClass().remove("textDisabled");
    money3Field.getStyleClass().remove("textDisabled");
    saveBtn.setOnAction(ae -> {
      String s1 = yearField.getText();
      String s2 = present1Field.getText();
      String s3 = money1Field.getText();
      String s4 = present2Field.getText();
      String s5 = money2Field.getText();
      String s6 = present3Field.getText();
      String s7 = money3Field.getText();
      String s8 = nameField.getText();
      String s9 = descField.getText();
      if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty()
          || s8.isEmpty())
        errText.setVisible(true);
      else {
        errText.setVisible(false);
        confirmPane.setVisible(false);
        confirmLabel.setText("Xác nhận thêm phần thưởng");
        confirmBtn.setOnAction(aee -> {
          DipDacBiet ddb = new DipDacBiet(0, s8, Integer.parseInt(s1), s9, s2, s4, s6, Float.parseFloat(s3),
              Float.parseFloat(s5), Float.parseFloat(s7));
          TraoThuongDacBietManage.themDipDacBiet(ddb);
          confirmPane.setVisible(false);
          errText.setVisible(false);
          detailPane.setVisible(false);
          Utils.clearTextInput(detailPane);
        });
        cancelBtn.setOnAction(aee -> confirmPane.setVisible(false));
      }
    });
    returnBtn.setText("Huỷ");
    returnBtn.setOnAction(ae -> {
      detailPane.setVisible(false);
      errText.setVisible(false);
      Utils.clearTextInput(detailPane);
    });
  }

  private void openGInfo(MouseEvent e) {
    title.setText("Thông tin Phần thưởng");
    detailPane.setVisible(true);
    detailBtn.getChildren().clear();
    detailBtn.getChildren().addAll(listBtn, editBtn, deleteBtn, returnBtn);
    present1Label.setText("Phần quà đặc biệt:");
    present2Label.setText("Phần quà HSG:");
    present3Label.setText("Phần quà HS Khá:");
    yearField.setText(selectedG.getNam() + "");
    nameLabel.setVisible(false);
    nameField.setVisible(false);
    present1Field.setText(selectedG.getPhanQuaDacBiet());
    present2Field.setText(selectedG.getPhanQuaGioi());
    present3Field.setText(selectedG.getPhanQuaKha());
    money1Field.setText(selectedG.getTienDacBiet() + "");
    money2Field.setText(selectedG.getTienGioi() + "");
    money3Field.setText(selectedG.getTienKha() + "");
    descField.setText(selectedG.getMoTa());
    if (!yearField.getStyleClass().contains("textDisabled")) {
      descField.getStyleClass().add("textDisabled");
      yearField.getStyleClass().add("textDisabled");
      present1Field.getStyleClass().add("textDisabled");
      present2Field.getStyleClass().add("textDisabled");
      present3Field.getStyleClass().add("textDisabled");
      money1Field.getStyleClass().add("textDisabled");
      money2Field.getStyleClass().add("textDisabled");
      money3Field.getStyleClass().add("textDisabled");
    }
    editBtn.setOnAction(aee -> {
      present1Label.setText("Phần quà đặc biệt (*):");
      present2Label.setText("Phần quà HSG (*):");
      present3Label.setText("Phần quà HS Khá (*):");
      detailBtn.getChildren().clear();
      detailBtn.getChildren().addAll(saveBtn, returnBtn);
      yearField.setEditable(true);
      present1Field.setEditable(true);
      present2Field.setEditable(true);
      present3Field.setEditable(true);
      money1Field.setEditable(true);
      money2Field.setEditable(true);
      money3Field.setEditable(true);
      descField.setEditable(true);
      descField.getStyleClass().remove("textDisabled");
      yearField.getStyleClass().remove("textDisabled");
      present1Field.getStyleClass().remove("textDisabled");
      present2Field.getStyleClass().remove("textDisabled");
      present3Field.getStyleClass().remove("textDisabled");
      money1Field.getStyleClass().remove("textDisabled");
      money2Field.getStyleClass().remove("textDisabled");
      money3Field.getStyleClass().remove("textDisabled");
      saveBtn.setOnAction(ae -> {
        String s1 = yearField.getText();
        String s2 = present1Field.getText();
        String s3 = money1Field.getText();
        String s4 = present2Field.getText();
        String s5 = money2Field.getText();
        String s6 = present3Field.getText();
        String s7 = money3Field.getText();
        String s9 = descField.getText();
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty()
            || s7.isEmpty())
          errText.setVisible(true);
        else {
          errText.setVisible(false);
          confirmPane.setVisible(true);
          confirmLabel.setText("Lưu thay đổi");
          confirmBtn.setOnAction(aeee -> {
            final DipHSG hsg = new DipHSG(selectedG.getIdDip(), Integer.parseInt(s1), s9, s2, s4, s6,
                Float.parseFloat(s3), Float.parseFloat(s5), Float.parseFloat(s7));
            TraoThuongHSGManage.capNhatDipHSG(hsg);
            confirmPane.setVisible(false);
            detailPane.setVisible(false);
          });
          cancelBtn.setOnAction(aeee -> {
            confirmPane.setVisible(false);
          });
        }
      });
      returnBtn.setOnAction(ae -> {
        yearField.setText(selectedG.getNam() + "");
        present1Field.setText(selectedG.getPhanQuaDacBiet());
        present2Field.setText(selectedG.getPhanQuaGioi());
        present3Field.setText(selectedG.getPhanQuaKha());
        money1Field.setText(selectedG.getTienDacBiet() + "");
        money2Field.setText(selectedG.getTienGioi() + "");
        money3Field.setText(selectedG.getTienKha() + "");
        descField.setText(selectedG.getMoTa());
        yearField.setEditable(false);
        present1Field.setEditable(false);
        present2Field.setEditable(false);
        present3Field.setEditable(false);
        money1Field.setEditable(false);
        money2Field.setEditable(false);
        money3Field.setEditable(false);
        descField.setEditable(false);
        if (!yearField.getStyleClass().contains("textDisabled")) {
          descField.getStyleClass().add("textDisabled");
          yearField.getStyleClass().add("textDisabled");
          present1Field.getStyleClass().add("textDisabled");
          present2Field.getStyleClass().add("textDisabled");
          present3Field.getStyleClass().add("textDisabled");
          money1Field.getStyleClass().add("textDisabled");
          money2Field.getStyleClass().add("textDisabled");
          money3Field.getStyleClass().add("textDisabled");
        }
        listBtn.setOnAction(ee -> openGList(ee));
        detailBtn.getChildren().clear();
        detailBtn.getChildren().addAll(listBtn, editBtn, deleteBtn, returnBtn);
        present1Label.setText("Phần quà đặc biệt:");
        present2Label.setText("Phần quà HSG:");
        present3Label.setText("Phần quà HS Khá:");
        returnBtn.setOnAction(ee -> {
          detailPane.setVisible(false);
          errText.setVisible(false);
          Utils.clearTextInput(detailPane);
        });
      });
    });
    listBtn.setOnAction(aee -> openGList(aee));
    deleteBtn.setOnAction(aee -> {
      deletePane.setVisible(true);
      confirmDelBtn.setOnAction(aeee -> {
        TraoThuongHSGManage.xoaDipHSG(selectedG);
        confirmedDelPane.setVisible(true);
        returnDelBtn.setOnAction(aeeee -> {
          confirmedDelPane.setVisible(false);
          deletePane.setVisible(false);
          detailPane.setVisible(false);
          errText.setVisible(false);
          Utils.clearTextInput(detailPane);
        });
      });
      cancelDelBtn.setOnAction(aeee -> {
        deletePane.setVisible(false);
      });
    });
    returnBtn.setOnAction(aee -> {
      detailPane.setVisible(false);
      errText.setVisible(false);
      Utils.clearTextInput(detailPane);
    });
  }

  private void openSInfo(MouseEvent e) {
    title.setText("Thông tin Phần thưởng");
    detailPane.setVisible(true);
    detailBtn.getChildren().clear();
    detailBtn.getChildren().addAll(listBtn, editBtn, deleteBtn, returnBtn);
    present1Label.setText("Độ tuổi 0-5 tuổi:");
    present2Label.setText("Độ tuổi 6-14 tuổi:");
    present3Label.setText("Độ tuổi 15-17 tuổi:");
    yearField.setText(selectedS.getNam() + "");
    nameLabel.setVisible(true);
    nameField.setVisible(true);
    nameField.setText(selectedS.getTen());
    present1Field.setText(selectedS.getPhanQua05());
    present2Field.setText(selectedS.getPhanQua614());
    present3Field.setText(selectedS.getPhanQua1517());
    money1Field.setText(selectedS.getTien05() + "");
    money2Field.setText(selectedS.getTien614() + "");
    money3Field.setText(selectedS.getTien1517() + "");
    descField.setText(selectedS.getMoTa());
    if (!yearField.getStyleClass().contains("textDisabled")) {
      descField.getStyleClass().add("textDisabled");
      yearField.getStyleClass().add("textDisabled");
      present1Field.getStyleClass().add("textDisabled");
      present2Field.getStyleClass().add("textDisabled");
      present3Field.getStyleClass().add("textDisabled");
      money1Field.getStyleClass().add("textDisabled");
      money2Field.getStyleClass().add("textDisabled");
      money3Field.getStyleClass().add("textDisabled");
      nameField.getStyleClass().add("textDisabled");
    }
    editBtn.setOnAction(aee -> {
      present1Label.setText("Độ tuổi 0-5 tuổi (*):");
      present2Label.setText("Độ tuổi 6-14 tuổi (*):");
      present3Label.setText("Độ tuổi 15-17 tuổi (*):");
      detailBtn.getChildren().clear();
      detailBtn.getChildren().addAll(saveBtn, returnBtn);
      yearField.setEditable(true);
      present1Field.setEditable(true);
      present2Field.setEditable(true);
      present3Field.setEditable(true);
      money1Field.setEditable(true);
      money2Field.setEditable(true);
      money3Field.setEditable(true);
      descField.setEditable(true);
      nameField.setEditable(true);
      descField.getStyleClass().remove("textDisabled");
      yearField.getStyleClass().remove("textDisabled");
      present1Field.getStyleClass().remove("textDisabled");
      present2Field.getStyleClass().remove("textDisabled");
      present3Field.getStyleClass().remove("textDisabled");
      money1Field.getStyleClass().remove("textDisabled");
      money2Field.getStyleClass().remove("textDisabled");
      money3Field.getStyleClass().remove("textDisabled");
      nameField.getStyleClass().remove("textDisabled");
      saveBtn.setOnAction(ae -> {
        String s1 = yearField.getText();
        String s2 = present1Field.getText();
        String s3 = money1Field.getText();
        String s4 = present2Field.getText();
        String s5 = money2Field.getText();
        String s6 = present3Field.getText();
        String s7 = money3Field.getText();
        String s8 = nameField.getText();
        String s9 = descField.getText();
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty() || s6.isEmpty() || s7.isEmpty()
            || s8.isEmpty())
          errText.setVisible(true);
        else {
          errText.setVisible(false);
          confirmPane.setVisible(true);
          confirmLabel.setText("Lưu thay đổi");
          confirmBtn.setOnAction(aeee -> {
            final DipDacBiet ddb = new DipDacBiet(selectedS.getIdDip(), s8, Integer.parseInt(s1), s9, s2, s4, s6,
                Float.parseFloat(s3), Float.parseFloat(s5), Float.parseFloat(s7));
            TraoThuongDacBietManage.capNhatDipDacBiet(ddb);
            confirmPane.setVisible(false);
            detailPane.setVisible(false);
            Utils.clearTextInput(detailPane);
          });
          cancelBtn.setOnAction(aeee -> {
            confirmPane.setVisible(false);
          });
        }
      });
      returnBtn.setOnAction(ae -> {
        detailBtn.getChildren().clear();
        detailBtn.getChildren().addAll(listBtn, editBtn, deleteBtn, returnBtn);
        yearField.setEditable(false);
        present1Field.setEditable(false);
        present2Field.setEditable(false);
        present3Field.setEditable(false);
        money1Field.setEditable(false);
        money2Field.setEditable(false);
        money3Field.setEditable(false);
        descField.setEditable(false);
        yearField.setText(selectedS.getNam() + "");
        nameField.setText(selectedS.getTen());
        present1Field.setText(selectedS.getPhanQua05());
        present2Field.setText(selectedS.getPhanQua614());
        present3Field.setText(selectedS.getPhanQua1517());
        money1Field.setText(selectedS.getTien05() + "");
        money2Field.setText(selectedS.getTien614() + "");
        money3Field.setText(selectedS.getTien1517() + "");
        descField.setText(selectedS.getMoTa());
        present1Label.setText("Độ tuổi 0-5 tuổi:");
        present2Label.setText("Độ tuổi 6-14 tuổi:");
        present3Label.setText("Độ tuổi 15-17 tuổi:");
        if (!yearField.getStyleClass().contains("textDisabled")) {
          descField.getStyleClass().add("textDisabled");
          yearField.getStyleClass().add("textDisabled");
          present1Field.getStyleClass().add("textDisabled");
          present2Field.getStyleClass().add("textDisabled");
          present3Field.getStyleClass().add("textDisabled");
          money1Field.getStyleClass().add("textDisabled");
          money2Field.getStyleClass().add("textDisabled");
          money3Field.getStyleClass().add("textDisabled");
          nameField.getStyleClass().add("textDisabled");
        }
        listBtn.setOnAction(ee -> openSList(ee));
        errText.setVisible(false);
        returnBtn.setOnAction(ee -> {
          Utils.clearTextInput(detailPane);
          errText.setVisible(false);
          detailPane.setVisible(false);
        });
      });
    });
    deleteBtn.setOnAction(aee -> {
      deletePane.setVisible(true);
      confirmDelBtn.setOnAction(aeee -> {
        TraoThuongDacBietManage.xoaDipDacBiet(selectedS);
        confirmedDelPane.setVisible(true);
        returnDelBtn.setOnAction(aeeee -> {
          confirmedDelPane.setVisible(false);
          deletePane.setVisible(false);
          detailPane.setVisible(false);
          errText.setVisible(false);
          Utils.clearTextInput(detailPane);
        });
      });
    });
    listBtn.setOnAction(aee -> openSList(aee));
    returnBtn.setOnAction(aee -> {
      Utils.clearTextInput(detailPane);
      errText.setVisible(false);
      detailPane.setVisible(false);
    });
  }

  private void openSList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(true);
    editListSBox.setVisible(false);
    editListBtnBox.getChildren().clear();
    editListBtnBox.getChildren().addAll(editListSaveBtn, listAddAllBtn, editListReturnBtn);
    TableColumn<ChiTietDipDacBiet, String> nameCol = new TableColumn<>("Họ tên");
    nameCol.setCellValueFactory(new Callback<CellDataFeatures<ChiTietDipDacBiet, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(CellDataFeatures<ChiTietDipDacBiet, String> p) {
        int id = p.getValue().getIdNhanKhau();
        NhanKhau nk = NhanKhauManage.layNhanKhau(id);
        ObjectProperty<String> s = new SimpleObjectProperty<>();
        s.set(nk.getHoTen());
        return s;
      }
    });
    final String NHOM[] = { "0-5 tuổi", "6-14 tuổi", "15-17 tuổi" };

    TableColumn<ChiTietDipDacBiet, String> nhomCol = new TableColumn<>("Nhóm tuổi");
    nhomCol.setCellValueFactory(new Callback<CellDataFeatures<ChiTietDipDacBiet, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(CellDataFeatures<ChiTietDipDacBiet, String> p) {
        int nhom = p.getValue().getNhom();
        ObjectProperty<String> s = new SimpleObjectProperty<>();
        s.set(NHOM[nhom - 1]);
        return s;
      }
    });
    TableColumn<ChiTietDipDacBiet, String> ktraCol = new TableColumn<>("Xác nhận trao thưởng");
    ktraCol.setCellValueFactory(
        new Callback<TableColumn.CellDataFeatures<ChiTietDipDacBiet, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipDacBiet, String> p) {
            boolean ktra = p.getValue().getKiemtra();
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set(ktra ? "Đã nhận" : "Chưa nhận");
            return s;
          }
        });
    Callback<TableView<ChiTietDipDacBiet>, TableRow<ChiTietDipDacBiet>> rowListFactory = new Callback<TableView<ChiTietDipDacBiet>, TableRow<ChiTietDipDacBiet>>() {
      @Override
      public TableRow<ChiTietDipDacBiet> call(final TableView<ChiTietDipDacBiet> param) {
        final TableRow<ChiTietDipDacBiet> row = new TableRow<>();
        row.setOnMouseClicked(me -> {
          selectedListS = row.getItem();
          if (selectedListS != null && me.getButton() == MouseButton.SECONDARY) {
            double x = me.getSceneX();
            double y = me.getSceneY();
            double xx = x > 1280 - 160 ? x - 160 - 137 : x - 135;
            double yy = y > 720 - 160 ? y - 160 - 147 : y - 145;
            optPane.setVisible(true);
            AnchorPane.setLeftAnchor(optBox, xx);
            AnchorPane.setTopAnchor(optBox, yy);
            deleteNKBtn.setOnAction(ae -> {
              optPane.setVisible(false);
              listConfirmDeletePane.setVisible(true);
              listConfirmDeleteBtn.setOnAction(aee -> {
                TraoThuongDacBietManage.xoaChiTietDipDacBiet(selectedListS);
                listConfirmedDeletePane.setVisible(true);
                listConfirmedDeleteBtn.setOnAction(aeee -> {
                  listConfirmedDeletePane.setVisible(false);
                  listConfirmDeletePane.setVisible(false);
                  getSNKList();
                });
              });
              listCancelDeleteBtn.setOnAction(aee -> {
                listConfirmDeletePane.setVisible(false);
              });
            });
            confirmNKBtn.setOnAction(ae -> {
              optPane.setVisible(false);
              listConfirmAddPane.setVisible(true);
              listConfirmAddBtn.setOnAction(aee -> {
                TraoThuongDacBietManage.xacNhanDaTraoThuong(selectedListS);
                listConfirmedAddPane.setVisible(true);
                listConfirmedAddBtn.setOnAction(aeee -> {
                  listConfirmedAddPane.setVisible(false);
                  listConfirmAddPane.setVisible(false);
                  getSNKList();
                });
              });
              listCancelAddBtn.setOnAction(aee -> {
                listConfirmAddPane.setVisible(false);
              });
            });
          }
        });
        return row;
      }
    };
    snkTable.setRowFactory(rowListFactory);
    snkTable.setMaxHeight(470);
    snkTable.getColumns().clear();
    snkTable.getColumns().addAll(Arrays.asList(nameCol, nhomCol, ktraCol));
    getSNKList();
    snkTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    snkTable.setPrefHeight(516);
    snkTable.setPrefWidth(678);
    listBox.getChildren().clear();
    listBox.getChildren().addAll(snkTable, listBtnBox);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
    listAddBtn.setOnAction(aee -> {
      editListSBox.setVisible(true);
      addLBox.setVisible(false);
      addSBox.setVisible(false);
      ObservableList<String> opt = FXCollections.observableArrayList(NHOM);
      final ComboBox<String> nhomBox = new ComboBox<>(opt);
      comboBox.getChildren().clear();
      comboBox.getChildren().addAll(Arrays.asList(addSLabel, nhomBox));
      final TableView<NhanKhau> addListTable = new TableView<>();
      addListTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      final ArrayList<NhanKhau> hsList = new ArrayList<>();
      Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
        @Override
        public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
          final TableRow<NhanKhau> row = new TableRow<>();
          row.setOnMouseClicked((e) -> {
            selectedAddNK = row.getItem();
            if (selectedAddNK != null) {
              addNameField.setText(selectedAddNK.getHoTen());
            }
          });
          return row;
        }
      };
      TableColumn<NhanKhau, String> idCol = Utils.createColumn("ID", "ID");
      idCol.setMinWidth(50);
      idCol.setMaxWidth(50);
      TableColumn<NhanKhau, String> tenCol = Utils.createColumn("Họ tên", "hoTen");

      Runnable getHSList = () -> {
        hsList.clear();
        hsList.addAll(NhanKhauManage.layListHocSinh());
        addListTable.getItems().clear();
        addListTable.getItems().addAll(FXCollections.observableArrayList(hsList));
      };

      getHSList.run();
      addListTable.setRowFactory(rowFactory);
      addListTable.setMaxWidth(368);
      addListTable.setMinWidth(368);
      addListTable.getColumns().addAll(Arrays.asList(idCol, tenCol));
      addListBox.getChildren().clear();
      addListBox.getChildren().addAll(Arrays.asList(addListTable, addListDetailBox));

      final TableView<ChiTietDipDacBiet> sTable = new TableView<>();
      sTable.setMaxHeight(198);
      sTable.setMinHeight(198);
      sTable.setMaxWidth(480);
      sTable.setMinWidth(480);
      TableColumn<ChiTietDipDacBiet, String> hotenCol = new TableColumn<>("Họ Tên");
      hotenCol.setCellValueFactory(
          new Callback<TableColumn.CellDataFeatures<ChiTietDipDacBiet, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<ChiTietDipDacBiet, String> p) {
              String hoten = NhanKhauManage.layNhanKhau(p.getValue().getIdNhanKhau()).getHoTen();
              ObjectProperty<String> s = new SimpleObjectProperty<>();
              s.set(hoten);
              return s;
            }
          });
      TableColumn<ChiTietDipDacBiet, String> addednhomCol = Utils.createColumn("Nhóm thưởng", "nhom");
      sTable.getColumns().addAll(Arrays.asList(hotenCol, addednhomCol));
      sTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      addedListBox.getChildren().clear();
      addedListBox.getChildren().add(sTable);

      listAddNewBtn.setOnAction(aeee -> {
        String n = nhomBox.getValue();
        int nhom;
        for (nhom = 1; nhom <= 3; nhom++) {
          if (NHOM[nhom - 1].equals(n))
            break;
        }
        ChiTietDipDacBiet newS = new ChiTietDipDacBiet(selectedS.getIdDip(), selectedAddNK.getID(), nhom);
        addedSList.add(newS);
        sTable.getItems().add(newS);
        addNameField.setText("");
        addLField.setText("");
        addSField.setText("");
      });

      listAddAllBtn.setOnAction(aeee -> {
        listConfirmPane.setVisible(true);
        listConfirmBtn.setOnAction(aeeee -> {
          TraoThuongDacBietManage.themToanBoHocSinh(selectedS.getIdDip());
          listConfirmedPane.setVisible(true);
          listConfirmedBtn.setOnAction(aeeeee -> {
            listConfirmedPane.setVisible(false);
            listConfirmPane.setVisible(false);
            addedSList.clear();
            editListSBox.setVisible(false);
            getSNKList();
          });
        });
        listCancelBtn.setOnAction(aeeee -> {
          listConfirmPane.setVisible(false);
        });
      });

      editListSaveBtn.setOnAction(aeee -> {
        listConfirmPane.setVisible(true);
        listConfirmBtn.setOnAction(aeeee -> {
          for (int i = 0; i < addedSList.size(); i++) {
            TraoThuongDacBietManage.themNhanKhauDuocNhanThuong(addedSList.get(i));
          }
          listConfirmedPane.setVisible(true);
          listConfirmedBtn.setOnAction(aeeeee -> {
            listConfirmedPane.setVisible(false);
            listConfirmPane.setVisible(false);
            addedSList.clear();
            editListSBox.setVisible(false);
            getSNKList();
          });
        });
        listCancelBtn.setOnAction(aeeee -> {
          listConfirmPane.setVisible(false);
        });
      });

      editListReturnBtn.setOnAction(aeee -> {
        addedSList.clear();
        editListSBox.setVisible(false);
      });
    });
  }

  private void openGList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(true);
    editListSBox.setVisible(false);
    editListBtnBox.getChildren().clear();
    editListBtnBox.getChildren().addAll(editListSaveBtn, editListReturnBtn);
    TableColumn<ChiTietDipHocSinhGioi, String> nameCol = new TableColumn<>("Họ tên");
    nameCol
        .setCellValueFactory(new Callback<CellDataFeatures<ChiTietDipHocSinhGioi, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipHocSinhGioi, String> p) {
            int id = p.getValue().getIdNhanKhau();
            NhanKhau nk = NhanKhauManage.layNhanKhau(id);
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set(nk.getHoTen());
            return s;
          }
        });
    TableColumn<ChiTietDipHocSinhGioi, String> tlCol = new TableColumn<>("Trường, Lớp");
    tlCol.setCellValueFactory(
        new Callback<TableColumn.CellDataFeatures<ChiTietDipHocSinhGioi, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipHocSinhGioi, String> p) {
            ChiTietDipHocSinhGioi g = p.getValue();
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set("Lớp " + g.getLop() + ", " + g.getTruong());
            return s;
          }
        });
    final String NHOM[] = { "Đặc biệt", "Giỏi", "Khá" };
    TableColumn<ChiTietDipHocSinhGioi, String> nhomCol = new TableColumn<>("Nhóm");
    nhomCol.setCellValueFactory(
        new Callback<TableColumn.CellDataFeatures<ChiTietDipHocSinhGioi, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipHocSinhGioi, String> p) {
            ChiTietDipHocSinhGioi g = p.getValue();
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set(NHOM[g.getNhom() - 1]);
            return s;
          }
        });
    TableColumn<ChiTietDipHocSinhGioi, String> ktraCol = new TableColumn<>("Xác nhận trao thưởng");
    ktraCol.setCellValueFactory(
        new Callback<TableColumn.CellDataFeatures<ChiTietDipHocSinhGioi, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipHocSinhGioi, String> p) {
            boolean ktra = p.getValue().getKiemtra();
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set(ktra ? "Đã nhận" : "Chưa nhận");
            return s;
          }
        });
    Callback<TableView<ChiTietDipHocSinhGioi>, TableRow<ChiTietDipHocSinhGioi>> rowListFactory = new Callback<TableView<ChiTietDipHocSinhGioi>, TableRow<ChiTietDipHocSinhGioi>>() {
      @Override
      public TableRow<ChiTietDipHocSinhGioi> call(final TableView<ChiTietDipHocSinhGioi> param) {
        final TableRow<ChiTietDipHocSinhGioi> row = new TableRow<>();
        row.setOnMouseClicked(me -> {
          selectedListG = row.getItem();
          if (selectedListG != null && me.getButton() == MouseButton.SECONDARY) {
            double x = me.getSceneX();
            double y = me.getSceneY();
            double xx = x > 1280 - 160 ? x - 160 - 137 : x - 135;
            double yy = y > 720 - 80 ? y - 80 - 147 : y - 145;
            optPane.setVisible(true);
            AnchorPane.setLeftAnchor(optBox, xx);
            AnchorPane.setTopAnchor(optBox, yy);
            deleteNKBtn.setOnAction(ae -> {
              optPane.setVisible(false);
              listConfirmDeletePane.setVisible(true);
              listConfirmDeleteBtn.setOnAction(aee -> {
                TraoThuongHSGManage.xoaChiTietHSG(selectedListG);
                listConfirmedDeletePane.setVisible(true);
                listConfirmedDeleteBtn.setOnAction(aeee -> {
                  listConfirmedDeletePane.setVisible(false);
                  listConfirmDeletePane.setVisible(false);
                  getGNKList();
                });
              });
              listCancelDeleteBtn.setOnAction(aee -> {
                listConfirmDeletePane.setVisible(false);
              });
            });
            confirmNKBtn.setOnAction(ae -> {
              optPane.setVisible(false);
              listConfirmAddPane.setVisible(true);
              listConfirmAddBtn.setOnAction(aee -> {
                TraoThuongHSGManage.xacNhanDaTraoThuong(selectedListG);
                listConfirmedAddPane.setVisible(true);
                listConfirmedAddBtn.setOnAction(aeee -> {
                  listConfirmedAddPane.setVisible(false);
                  listConfirmAddPane.setVisible(false);
                  getGNKList();
                });
              });
              listCancelAddBtn.setOnAction(aee -> {
                listConfirmAddPane.setVisible(false);
              });
            });
          }
        });
        return row;
      }
    };
    gnkTable.setRowFactory(rowListFactory);
    gnkTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    gnkTable.setMaxHeight(470);
    gnkTable.getColumns().clear();
    gnkTable.getColumns().addAll(Arrays.asList(nameCol, tlCol, nhomCol, ktraCol));

    getGNKList();
    gnkTable.setPrefHeight(516);
    gnkTable.setPrefWidth(678);
    listBox.getChildren().clear();
    listBox.getChildren().addAll(gnkTable, listBtnBox);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
    listAddBtn.setOnAction(aee -> {
      editListSBox.setVisible(true);
      addLBox.setVisible(true);
      addSBox.setVisible(true);
      ObservableList<String> opt = FXCollections.observableArrayList(NHOM);
      final ComboBox<String> nhomBox = new ComboBox<>(opt);
      comboBox.getChildren().clear();
      comboBox.getChildren().addAll(Arrays.asList(addSLabel, nhomBox));
      TableView<NhanKhau> addListTable = new TableView<>();
      addListTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      final ArrayList<NhanKhau> hsList = new ArrayList<>();
      Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
        @Override
        public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
          final TableRow<NhanKhau> row = new TableRow<>();
          row.setOnMouseClicked((e) -> {
            selectedAddNK = row.getItem();
            if (selectedAddNK != null) {
              addNameField.setText(selectedAddNK.getHoTen());
            }
          });
          return row;
        }
      };
      TableColumn<NhanKhau, String> idCol = Utils.createColumn("ID", "ID");
      idCol.setMinWidth(50);
      idCol.setMaxWidth(50);
      TableColumn<NhanKhau, String> tenCol = Utils.createColumn("Họ tên", "hoTen");

      Runnable getHSList = () -> {
        hsList.clear();
        hsList.addAll(NhanKhauManage.layListHocSinh());
        addListTable.getItems().clear();
        addListTable.getItems().addAll(FXCollections.observableArrayList(hsList));
      };

      getHSList.run();
      addListTable.setRowFactory(rowFactory);
      addListTable.setMaxWidth(368);
      addListTable.setMinWidth(368);
      addListTable.getColumns().addAll(Arrays.asList(idCol, tenCol));
      addListBox.getChildren().clear();
      addListBox.getChildren().addAll(Arrays.asList(addListTable, addListDetailBox));

      final TableView<ChiTietDipHocSinhGioi> gTable = new TableView<>();
      gTable.setMaxHeight(198);
      gTable.setMinHeight(198);
      gTable.setMaxWidth(480);
      gTable.setMinWidth(480);
      TableColumn<ChiTietDipHocSinhGioi, String> hotenCol = new TableColumn<>("Họ Tên");
      hotenCol.setCellValueFactory(
          new Callback<TableColumn.CellDataFeatures<ChiTietDipHocSinhGioi, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<ChiTietDipHocSinhGioi, String> p) {
              String hoten = NhanKhauManage.layNhanKhau(p.getValue().getIdNhanKhau()).getHoTen();
              ObjectProperty<String> s = new SimpleObjectProperty<>();
              s.set(hoten);
              return s;
            }
          });
      TableColumn<ChiTietDipHocSinhGioi, String> addednhomCol = Utils.createColumn("Nhóm thưởng", "nhom");
      gTable.getColumns().addAll(Arrays.asList(hotenCol, addednhomCol));
      gTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      addedListBox.getChildren().clear();
      addedListBox.getChildren().add(gTable);

      listAddNewBtn.setOnAction(aeee -> {
        String n = nhomBox.getValue();
        String l = addLField.getText();
        String t = addSField.getText();
        int nhom;
        for (nhom = 1; nhom <= 3; nhom++) {
          if (NHOM[nhom - 1].equals(n))
            break;
        }
        if (n.isEmpty() || l.isEmpty() || t.isEmpty())
          listErrText.setVisible(true);
        else {
          listErrText.setVisible(false);
          ChiTietDipHocSinhGioi newG = new ChiTietDipHocSinhGioi(selectedG.getIdDip(), selectedAddNK.getID(), t, l,
              nhom);
          addedGList.add(newG);
          gTable.getItems().add(newG);
          addNameField.setText("");
          addLField.setText("");
          addSField.setText("");
        }
      });

      editListSaveBtn.setOnAction(aeee -> {
        listConfirmPane.setVisible(true);
        listConfirmBtn.setOnAction(aeeee -> {
          for (int i = 0; i < addedGList.size(); i++) {
            TraoThuongHSGManage.themNhanKhauDuocNhanThuong(addedGList.get(i));
          }
          listConfirmedPane.setVisible(true);
          listConfirmedBtn.setOnAction(aeeeee -> {
            listConfirmedPane.setVisible(false);
            listConfirmPane.setVisible(false);
            addedSList.clear();
            editListSBox.setVisible(false);
            getGNKList();
          });
        });
        listCancelBtn.setOnAction(aeeee -> {
          listConfirmPane.setVisible(false);
        });
      });

      editListReturnBtn.setOnAction(aeee -> {
        addedGList.clear();
        editListSBox.setVisible(false);
      });
    });
  }

  private void getGNKList() {
    gnkList = TraoThuongHSGManage.layListChiTietDipHocSinhGioi(selectedG.getIdDip());
    gnkTable.getItems().clear();
    ObservableList<ChiTietDipHocSinhGioi> list = FXCollections.observableArrayList(gnkList);
    gnkTable.setItems(list);
  }

  private void getSNKList() {
    snkList = TraoThuongDacBietManage.layListChiTietDipDacBiet(selectedS.getIdDip());
    snkTable.getItems().clear();
    ObservableList<ChiTietDipDacBiet> list = FXCollections.observableArrayList(snkList);
    snkTable.setItems(list);
  }
}