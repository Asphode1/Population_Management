package com.lele.cnpm.ui.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import com.lele.cnpm.src.models.ChuyenNhanKhau;
import com.lele.cnpm.src.models.KhaiTu;
import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.models.TamTru;
import com.lele.cnpm.src.models.TamVang;
import com.lele.cnpm.src.services.NhanKhauManage;
import com.lele.cnpm.src.utils.Utils;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.util.Duration;

public class PeopleController {
  @FXML
  private TextField addNameField;
  @FXML
  private TextField addAliField;
  @FXML
  private TextField addNationField;
  @FXML
  private TextField addJobField;
  @FXML
  private DatePicker addDOBPicker;
  @FXML
  private TextField addWorkField;
  @FXML
  private TextField addBPlaceField;
  @FXML
  private TextField addCCCDField;
  @FXML
  private CheckBox addMCheckBox;
  @FXML
  private CheckBox addFCheckBox;
  @FXML
  private DatePicker addCCCDDatePicker;
  @FXML
  private TextField addDomicileField;
  @FXML
  private DatePicker addToDatePicker;
  @FXML
  private TextField addEthField;
  @FXML
  private TextField addRelField;
  @FXML
  private TextField addBeforeField;
  @FXML
  private TextField editNameField;
  @FXML
  private TextField editAliField;
  @FXML
  private TextField editNationField;
  @FXML
  private TextField editJobField;
  @FXML
  private DatePicker editDOBPicker;
  @FXML
  private TextField editWorkField;
  @FXML
  private TextField editBPlaceField;
  @FXML
  private TextField editCCCDField;
  @FXML
  private CheckBox editMCheckBox;
  @FXML
  private CheckBox editFCheckBox;
  @FXML
  private DatePicker editCCCDDatePicker;
  @FXML
  private TextField editDomicileField;
  @FXML
  private DatePicker editToDatePicker;
  @FXML
  private TextField editEthField;
  @FXML
  private TextField editRelField;
  @FXML
  private TextField editBeforeField;
  @FXML
  private TextField infoNameField;
  @FXML
  private TextField infoAliField;
  @FXML
  private TextField infoNationField;
  @FXML
  private TextField infoJobField;
  @FXML
  private TextField infoDOBField;
  @FXML
  private TextField infoWorkField;
  @FXML
  private TextField infoBPlaceField;
  @FXML
  private TextField infoCCCDField;
  @FXML
  private TextField infoGenField;
  @FXML
  private TextField infoCCCDDateField;
  @FXML
  private TextField infoDomicileField;
  @FXML
  private TextField infoToDateField;
  @FXML
  private TextField infoEthField;
  @FXML
  private TextField infoRelField;
  @FXML
  private TextField infoBeforeField;
  @FXML
  private TextField stayNameField;
  @FXML
  private TextField stayDOBField;
  @FXML
  private TextField stayBeforeField;
  @FXML
  private TextField stayStayField;
  @FXML
  private DatePicker stayFromPicker;
  @FXML
  private DatePicker stayToPicker;
  @FXML
  private TextArea stayReasonField;
  @FXML
  private TextField awayNameField;
  @FXML
  private TextField awayDOBField;
  @FXML
  private TextField awayNowField;
  @FXML
  private DatePicker awayFromPicker;
  @FXML
  private DatePicker awayToPicker;
  @FXML
  private TextArea awayReasonField;
  @FXML
  private TextField moveNameField;
  @FXML
  private TextField moveDOBField;
  @FXML
  private DatePicker moveAtPicker;
  @FXML
  private TextField moveToField;
  @FXML
  private TextArea moveNoteField;
  @FXML
  private TextField searchBar;
  @FXML
  private TextField deadNameField;
  @FXML
  private TextField deadDOBField;
  @FXML
  private DatePicker deadDatePicker;
  @FXML
  private TextField deadSearchField;
  @FXML
  private TextField deadPField;
  @FXML
  private DatePicker deadNKBPicker;
  @FXML
  private TextArea deadReasonField;

  @FXML
  private AnchorPane tableNkPane;
  @FXML
  private AnchorPane addPane;
  @FXML
  private AnchorPane addSaveConfirmPane;
  @FXML
  private AnchorPane addSavedPane;
  @FXML
  private AnchorPane editPane;
  @FXML
  private AnchorPane editSavedPane;
  @FXML
  private AnchorPane editDeletedPane;
  @FXML
  private AnchorPane editDeleteFailPane;
  @FXML
  private AnchorPane editSaveConfirmPane;
  @FXML
  private AnchorPane editDeleteConfirmPane;
  @FXML
  private AnchorPane infoPane;
  @FXML
  private AnchorPane infoDeleteConfirmPane;
  @FXML
  private AnchorPane infoDeletedPane;
  @FXML
  private AnchorPane infoDeleteFailPane;
  @FXML
  private AnchorPane stayPane;
  @FXML
  private AnchorPane stayConfirmPane;
  @FXML
  private AnchorPane stayConfirmedPane;
  @FXML
  private AnchorPane awayPane;
  @FXML
  private AnchorPane awayConfirmPane;
  @FXML
  private AnchorPane awayConfirmedPane;
  @FXML
  private AnchorPane movePane;
  @FXML
  private AnchorPane moveConfirmPane;
  @FXML
  private AnchorPane moveConfirmedPane;
  @FXML
  private AnchorPane lostPane;
  @FXML
  private AnchorPane deadConfirmPane;
  @FXML
  private AnchorPane deadConfirmedPane;
  @FXML
  private AnchorPane excelPane;
  @FXML
  private AnchorPane historyPane;
  @FXML
  private AnchorPane historyDetailPane;
  @FXML
  private AnchorPane historyListPane;
  @FXML
  private AnchorPane confirmExcelPane;

  @FXML
  private Button saveAddBtn;
  @FXML
  private Button cancelAddBtn;
  @FXML
  private Button saveEditBtn;
  @FXML
  private Button deleteEditBtn;
  @FXML
  private Button cancelEditBtn;
  @FXML
  private Button saveConfirmEditBtn;
  @FXML
  private Button cancelConfirmEditBtn;
  @FXML
  private Button editDeleteConfirmBtn;
  @FXML
  private Button editCancelDeleteBtn;
  @FXML
  private Button saveConfirmAddBtn;
  @FXML
  private Button saveInfoBtn;
  @FXML
  private Button deleteInfoBtn;
  @FXML
  private Button cancelInfoBtn;
  @FXML
  private Button infoDeleteConfirmBtn;
  @FXML
  private Button infoDeleteCancelBtn;
  @FXML
  private Button stayConfirmBtn;
  @FXML
  private Button stayConfirmedBtn;
  @FXML
  private Button stayCancelBtn;
  @FXML
  private Button awayConfirmBtn;
  @FXML
  private Button awayConfirmedBtn;
  @FXML
  private Button awayCancelBtn;
  @FXML
  private Button moveConfirmBtn;
  @FXML
  private Button moveConfirmedBtn;
  @FXML
  private Button moveCancelBtn;
  @FXML
  private Button deadAddBtn;
  @FXML
  private Button deadCloseBtn;
  @FXML
  private Button deadConfirmBtn;
  @FXML
  private Button deadConfirmedBtn;
  @FXML
  private Button deadCancelBtn;
  @FXML
  private Button importBtn;
  @FXML
  private Button exportBtn;
  @FXML
  private Button cancelExcelBtn;
  @FXML
  private Button closeHistoryBtn;
  @FXML
  private Button closeHistoryListBtn;
  @FXML
  private Button returnExcelBtn;
  @FXML
  private Button addSavedReturnBtn;
  @FXML
  private Button editSavedBtn;
  @FXML
  private Button editDeletedBtn;
  @FXML
  private Button editDeleteFailBtn;
  @FXML
  private Button infoDeletedBtn;

  @FXML
  private Label addErrText;
  @FXML
  private Label editErrText;
  @FXML
  private Label stayErrText;
  @FXML
  private Label awayErrText;
  @FXML
  private Label moveErrText;
  @FXML
  private Label deadErrText;

  @FXML
  private VBox deadTable;

  private ArrayList<NhanKhau> nhanKhau = new ArrayList<>();
  private TableView<NhanKhau> table = new TableView<>();
  private NhanKhau selectedNK = null;

  private AnchorPane optPane = new AnchorPane();
  private VBox optBox = new VBox();
  private Button addStayBtn = new Button("Khai b??o t???m tr??");
  private Button addAwayBtn = new Button("Khai b??o t???m v???ng");
  private Button addMoveBtn = new Button("Chuy???n nh??n kh???u");
  private Button addDeadBtn = new Button("Khai b??o t???");
  private ArrayList<Button> optBtnList = new ArrayList<>();
  private NhanKhau selectedNKB = null;
  private ChuyenNhanKhau selectedCNK = null;

  public void initialize() {
    final ArrayList<DatePicker> pickers = new ArrayList<>(
        Arrays.asList(addCCCDDatePicker, addDOBPicker, addToDatePicker, awayFromPicker, awayToPicker, deadDatePicker,
            deadNKBPicker, editCCCDDatePicker, editDOBPicker, editToDatePicker, moveAtPicker, stayFromPicker,
            stayToPicker));
    pickers.forEach(e -> e.setConverter(Utils.DATE_VN_CONVERTER));
    final ArrayList<AnchorPane> panes = new ArrayList<>(
        Arrays.asList(infoPane, addPane, editPane, stayPane, awayPane, movePane, lostPane, excelPane));
    panes.forEach(e -> {
      e.visibleProperty().addListener((ObservableValue<? extends Boolean> ob, Boolean oldVal, Boolean newVal) -> {
        if (newVal == false)
          getNKList();
      });
    });
    optBtnList.add(addStayBtn);
    optBtnList.add(addAwayBtn);
    optBtnList.add(addMoveBtn);
    optBtnList.add(addDeadBtn);
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
    optBox.getChildren().addAll(addStayBtn, addMoveBtn, addAwayBtn, addDeadBtn);
    optBox.setPrefHeight(160);
    optBox.setPrefWidth(160);
    optBox.setStyle("-fx-background-color: #fefefe");
    optPane.setVisible(false);
    optPane.getChildren().add(optBox);
    optPane.setOnMouseClicked((MouseEvent me) -> {
      optPane.setVisible(false);
    });
    tableNkPane.getChildren().add(optPane);
    AnchorPane.setBottomAnchor(optPane, 0.0);
    AnchorPane.setLeftAnchor(optPane, 0.0);
    AnchorPane.setRightAnchor(optPane, 0.0);
    AnchorPane.setTopAnchor(optPane, 0.0);
    getNKList();
    searchBar.textProperty()
        .addListener((ObservableValue<? extends String> observable, String oldVal, String newVal) -> {
          if (newVal == null || newVal.isBlank()) {
            getNKList();
          } else {
            try {
              nhanKhau.clear();
              nhanKhau.addAll(NhanKhauManage.layListNhanKhau(newVal));
              setTableData();
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent e) -> {
          selectedNK = row.getItem();
          if (e.getClickCount() == 2 && e.getButton() == MouseButton.PRIMARY) {
            openInfo(e);
          } else if (e.getButton() == MouseButton.SECONDARY) {
            double x = e.getSceneX();
            double y = e.getSceneY();
            double xx = x > 1280 - 160 ? x - 160 - 137 : x - 135;
            double yy = y > 720 - 160 ? y - 160 - 147 : y - 145;
            optPane.setVisible(true);
            AnchorPane.setLeftAnchor(optBox, xx);
            AnchorPane.setTopAnchor(optBox, yy);
            switch (selectedNK.getTrangThai()) {
              case "Th?????ng tr??":
                addStayBtn.setDisable(true);
                addAwayBtn.setDisable(false);
                addMoveBtn.setDisable(false);
                addDeadBtn.setDisable(false);
                break;
              case "T???m v???ng":
                addStayBtn.setDisable(false);
                addAwayBtn.setDisable(true);
                addMoveBtn.setDisable(false);
                addDeadBtn.setDisable(false);
                break;
              case "T???m tr??":
                addStayBtn.setDisable(false);
                addAwayBtn.setDisable(false);
                addMoveBtn.setDisable(false);
                addDeadBtn.setDisable(false);
                break;
              case "???? m???t":
                addStayBtn.setDisable(true);
                addAwayBtn.setDisable(true);
                addMoveBtn.setDisable(true);
                addDeadBtn.setDisable(true);
                break;
              case "???? chuy???n ??i":
                addStayBtn.setDisable(true);
                addAwayBtn.setDisable(true);
                addMoveBtn.setDisable(true);
                addDeadBtn.setDisable(true);
                break;
              default:
                break;
            }
            addStayBtn.setOnAction((ActionEvent ae) -> {
              openStay(ae);
            });
            addAwayBtn.setOnAction((ActionEvent ae) -> {
              openAway(ae);
            });
            addMoveBtn.setOnAction((ActionEvent ae) -> {
              openMove(ae);
            });
            addDeadBtn.setOnAction((ActionEvent ae) -> {
              openDead(ae);
            });
          }
        });
        return row;
      }
    };
    table.setRowFactory(rowFactory);
    TableColumn<NhanKhau, String> nameCol = Utils.createColumn("H??? v?? t??n", "hoTen");
    nameCol.setComparator(Utils.SORT_BY_NAME);
    TableColumn<NhanKhau, String> DOBCol = Utils.createColumn("Ng??y sinh", "ngaySinhString");
    DOBCol.getStyleClass().add("center-align");
    TableColumn<NhanKhau, String> genCol = Utils.createColumn("Gi???i t??nh", "gioiTinh");
    genCol.getStyleClass().add("center-align");
    TableColumn<NhanKhau, String> CCCDCol = Utils.createColumn("CCCD/??D??T", "soCCCD");
    TableColumn<NhanKhau, String> stateCol = Utils.createColumn("Tr???ng th??i", "trangThai");
    stateCol.getStyleClass().add("center-align");
    table.getColumns().addAll(Arrays.asList(nameCol, DOBCol, genCol, CCCDCol, stateCol));
    setTableData();
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    ArrayList<Node> al = new ArrayList<>();
    al.add(table);
    al.addAll(tableNkPane.getChildren());
    ObservableList<Node> newList = FXCollections.observableArrayList(al);
    tableNkPane.getChildren().clear();
    tableNkPane.getChildren().addAll(newList);
    table.setMinWidth(1098);
    table.setMinHeight(550);
    AnchorPane.setTopAnchor(table, 6.0);
    addMCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          addFCheckBox.setSelected(false);
        }
      }
    });
    addFCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          addMCheckBox.setSelected(false);
        }
      }
    });
    editMCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          editFCheckBox.setSelected(false);
        }
      }
    });
    editFCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          editMCheckBox.setSelected(false);
        }
      }
    });
    addCCCDField.textProperty().addListener(Utils.numberOnly(addCCCDField));
    editCCCDField.textProperty().addListener(Utils.numberOnly(editCCCDField));

  }

  public void getNKList(ActionEvent e) {
    try {
      ArrayList<NhanKhau> temp = NhanKhauManage.layListNhanKhau();
      nhanKhau.clear();
      nhanKhau.addAll(temp);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    setTableData();
  }

  private void getNKList() {
    try {
      ArrayList<NhanKhau> temp = NhanKhauManage.layListNhanKhau();
      nhanKhau.clear();
      nhanKhau.addAll(temp);
    } catch (Exception e) {
      e.printStackTrace();
    }
    setTableData();
  }

  private void setTableData() {
    ObservableList<NhanKhau> data = FXCollections.observableArrayList(nhanKhau);
    table.getItems().clear();
    table.setItems(data);
  }

  public void addNew(ActionEvent e) {
    addPane.setVisible(true);
  }

  public void saveAdd(ActionEvent e) {
    String Name = addNameField.getText();
    String Ali = addAliField.getText();
    String Nation = addNationField.getText();
    String Job = addJobField.getText();
    LocalDate dob = addDOBPicker.getValue();
    String Work = addWorkField.getText();
    String BPlace = addBPlaceField.getText();
    String CCCD = addCCCDField.getText();
    String gen = addMCheckBox.isSelected() ? "Nam" : "N???";
    LocalDate CCCDDate = addCCCDDatePicker.getValue();
    String Domicile = addDomicileField.getText();
    LocalDate ToDate = addToDatePicker.getValue();
    String Eth = addEthField.getText();
    String Rel = addRelField.getText();
    String Before = addBeforeField.getText();
    if (!NhanKhauManage.checkCCCD(CCCD)) {
      addErrText.setText("CCCD/??D??T b??? tr??ng ho???c sai ?????nh d???ng");
    } else if (Name.length() == 0 || Nation.length() == 0 || dob == null
        || BPlace.length() == 0 || gen.length() == 0 || Eth.length() == 0
        || Domicile.length() == 0 || Rel.length() == 0)
      addErrText.setText("Vui l??ng nh???p ?????y ????? th??ng tin");
    else {
      addErrText.setText("");
      addSaveConfirmPane.setVisible(true);
      saveConfirmAddBtn.setOnAction((ActionEvent ae) -> {
        NhanKhau nk = new NhanKhau(0, Name, Ali, Date.valueOf(dob), gen, BPlace, Domicile, Eth, Rel, Nation, Job,
            Work,
            CCCD, CCCDDate == null ? null : Date.valueOf(CCCDDate), ToDate == null ? null : Date.valueOf(ToDate),
            Before, "");
        boolean b = NhanKhauManage.themNhanKhau(nk);
        if (b) {
          addSavedPane.setVisible(true);
          addSavedReturnBtn.setOnAction(aee -> {
            addSavedPane.setVisible(false);
            addSaveConfirmPane.setVisible(false);
            addPane.setVisible(false);
            Utils.clearTextInput(addPane);
          });
        }
      });
    }
  }

  public void cancelConfirmAdd(ActionEvent e) {
    addSaveConfirmPane.setVisible(false);
  }

  public void cancelAdd(ActionEvent e) {
    addPane.setVisible(false);
    addErrText.setVisible(false);
    Utils.clearTextInput(addPane);
  };

  public void saveEdit(ActionEvent e) {
    String Name = editNameField.getText();
    String Ali = editAliField.getText();
    String Nation = editNationField.getText();
    String Job = editJobField.getText();
    LocalDate DOB = editDOBPicker.getValue();
    String Work = editWorkField.getText();
    String BPlace = editBPlaceField.getText();
    String CCCD = editCCCDField.getText();
    String Gen = addMCheckBox.isSelected() ? "Nam" : "N???";
    LocalDate CCCDDate = editCCCDDatePicker.getValue();
    String Domicile = editDomicileField.getText();
    LocalDate ToDate = editToDatePicker.getValue();
    String Eth = editEthField.getText();
    String Rel = editRelField.getText();
    String Before = editBeforeField.getText();
    if (!NhanKhauManage.checkCCCD(CCCD) && !CCCD.equals(selectedNK.getSoCCCD()))
      editErrText.setText("CCCD/??D??T b??? tr??ng ho???c sai ?????nh d???ng");
    else if (Name.length() == 0 || Nation.length() == 0 || DOB == null
        || BPlace.length() == 0 || Gen.length() == 0 || Eth.length() == 0
        || Domicile.length() == 0 || Rel.length() == 0)
      editErrText.setVisible(true);
    else {
      editErrText.setVisible(false);
      editSaveConfirmPane.setVisible(true);
      saveConfirmEditBtn.setOnAction((ActionEvent ae) -> {
        NhanKhau nk = new NhanKhau(selectedNK.getID(), Name, Ali, Date.valueOf(DOB), Gen, BPlace, Domicile, Eth, Rel,
            Nation, Job, Work,
            CCCD, CCCDDate == null ? null : Date.valueOf(CCCDDate), CCCDDate == null ? null : Date.valueOf(ToDate),
            Before, selectedNK.getTrangThai());
        Boolean b = NhanKhauManage.capNhatNhanKhau(nk);
        if (b) {
          editSavedPane.setVisible(true);
          editSavedBtn.setOnAction(aee -> {
            editSavedPane.setVisible(false);
            editSaveConfirmPane.setVisible(false);
            editPane.setVisible(false);
          });
        }
      });
      cancelConfirmEditBtn.setOnAction(ae -> {
        editSaveConfirmPane.setVisible(false);
      });
    }
  };

  public void cancelConfirmEdit(ActionEvent e) {
    addSaveConfirmPane.setVisible(false);
  }

  public void deleteEdit(ActionEvent e) {
    editDeleteConfirmPane.setVisible(true);
    editDeleteConfirmBtn.setOnAction(ae -> {
      Boolean b = NhanKhauManage.xoaNhanKhau(selectedNK.getID());
      if (b) {
        editDeletedPane.setVisible(true);
        editDeletedBtn.setOnAction(aee -> {
          editDeletedPane.setVisible(false);
          editDeleteConfirmPane.setVisible(false);
          editPane.setVisible(false);
        });
      } else {
        editDeleteFailPane.setVisible(true);
        editDeleteFailBtn.setOnAction(aee -> {
          editDeleteFailPane.setVisible(false);
          editDeleteConfirmPane.setVisible(false);
        });
      }
    });
    editCancelDeleteBtn.setOnAction(ae -> {
      editDeleteConfirmPane.setVisible(false);
    });
  };

  public void cancelEdit(ActionEvent e) {
    editPane.setVisible(false);
    editErrText.setVisible(false);
  };

  public void openInfo(MouseEvent e) {
    infoPane.setVisible(true);
    infoNameField.setText(selectedNK.getHoTen());
    infoAliField.setText(selectedNK.getBietDanh());
    infoNationField.setText(selectedNK.getQuocTich());
    infoJobField.setText(selectedNK.getNgheNghiep());
    infoDOBField.setText(NhanKhau.SQLDateToString(selectedNK.getNgaySinh()));
    infoWorkField.setText(selectedNK.getNoiLamViec());
    infoBPlaceField.setText(selectedNK.getNoiSinh());
    infoCCCDField.setText(selectedNK.getSoCCCD());
    infoGenField.setText(selectedNK.getGioiTinh());
    infoCCCDDateField.setText(NhanKhau.SQLDateToString(selectedNK.getNgayCap()));
    infoDomicileField.setText(selectedNK.getNguyenQuan());
    infoToDateField.setText(NhanKhau.SQLDateToString(selectedNK.getChuyenDenNgay()));
    infoEthField.setText(selectedNK.getDanToc());
    infoRelField.setText(selectedNK.getTonGiao());
    infoBeforeField.setText(selectedNK.getNoiThuongTruTruoc());
  }

  public void editInfo(ActionEvent e) {
    editPane.setVisible(true);
    infoPane.setVisible(false);
    if (selectedNK != null) {
      editNameField.setText(selectedNK.getHoTen());
      editAliField.setText(selectedNK.getBietDanh());
      editNationField.setText(selectedNK.getQuocTich());
      editJobField.setText(selectedNK.getNgheNghiep());
      editDOBPicker.setValue(selectedNK.getNgaySinh().toLocalDate());
      editWorkField.setText(selectedNK.getNoiLamViec());
      editBPlaceField.setText(selectedNK.getNoiSinh());
      editCCCDField.setText(selectedNK.getSoCCCD());
      if (selectedNK.getGioiTinh().equals("Nam"))
        editMCheckBox.setSelected(true);
      else
        editFCheckBox.setSelected(true);
      editCCCDDatePicker.setValue(selectedNK.getNgayCap().toLocalDate());
      editDomicileField.setText(selectedNK.getNguyenQuan());
      editToDatePicker.setValue(selectedNK.getChuyenDenNgay().toLocalDate());
      editEthField.setText(selectedNK.getDanToc());
      editRelField.setText(selectedNK.getTonGiao());
      editBeforeField.setText(selectedNK.getNoiThuongTruTruoc());
    }
  };

  public void deleteInfo(ActionEvent e) {
    infoDeleteConfirmPane.setVisible(true);
    infoDeleteConfirmBtn.setOnAction(ae -> {
      Boolean b = NhanKhauManage.xoaNhanKhau(selectedNK.getID());
      if (b) {
        infoDeletedPane.setVisible(true);
        infoDeletedBtn.setOnAction(aee -> {
          infoDeletedPane.setVisible(false);
          infoDeleteConfirmPane.setVisible(false);
          infoPane.setVisible(false);
        });
      }
    });
    infoDeleteCancelBtn.setOnAction(ae -> {
      infoDeleteConfirmPane.setVisible(false);
    });
  };

  public void cancelInfo(ActionEvent e) {
    selectedNK = null;
    infoPane.setVisible(false);
  };

  // * stay pane

  public void openStay(ActionEvent e) {
    optPane.setVisible(false);
    stayPane.setVisible(true);
    stayNameField.setText(selectedNK.getHoTen());
    stayDOBField.setText(selectedNK.getNgaySinhString());
  }

  public void stayConfirm(ActionEvent e) {
    String s1 = stayBeforeField.getText();
    String s2 = stayStayField.getText();
    LocalDate s3 = stayFromPicker.getValue();
    LocalDate s4 = stayToPicker.getValue();
    String s5 = stayReasonField.getText().replaceAll("\n", System.getProperty("line.separator"));
    if (s1.length() == 0 || s2.length() == 0 || s3 == null || s4 == null) {
      stayErrText.setVisible(true);
    } else {
      stayConfirmPane.setVisible(true);
      stayErrText.setVisible(false);
      stayConfirmBtn.setOnAction(ae -> {
        TamTru temp = new TamTru(0, selectedNK.getID(), s1, s2, Date.valueOf(s3), Date.valueOf(s4), s5);
        Boolean b = NhanKhauManage.themTamTru(temp);
        if (b) {
          stayConfirmedPane.setVisible(true);
          stayConfirmedBtn.setOnAction(aee -> {
            stayConfirmedPane.setVisible(false);
            stayConfirmPane.setVisible(false);
            stayPane.setVisible(false);
            Utils.clearTextInput(stayPane);
          });
        }
      });
      stayCancelBtn.setOnAction(ae -> {
        stayConfirmPane.setVisible(false);
      });
    }
  };

  public void stayCancel(ActionEvent e) {
    stayPane.setVisible(false);
    stayErrText.setVisible(false);
    Utils.clearTextInput(stayPane);
  };

  // * away pane
  public void openAway(ActionEvent e) {
    optPane.setVisible(false);
    awayPane.setVisible(true);
    awayNameField.setText(selectedNK.getHoTen());
    awayDOBField.setText(selectedNK.getNgaySinhString());
  }

  public void awayConfirm(ActionEvent e) {
    String s1 = awayNowField.getText();
    LocalDate s3 = awayFromPicker.getValue();
    LocalDate s4 = awayToPicker.getValue();
    String s5 = awayReasonField.getText().replaceAll("\n", System.getProperty("line.separator"));
    if (s1.length() == 0 || s3 == null || s4 == null) {
      awayErrText.setVisible(true);
    } else {
      awayErrText.setVisible(false);
      awayConfirmPane.setVisible(true);
      awayConfirmBtn.setOnAction(ae -> {
        TamVang temp = new TamVang(0, selectedNK.getID(), s1, Date.valueOf(s3), Date.valueOf(s4), s5);
        Boolean b = NhanKhauManage.themTamVang(temp);
        if (b) {
          awayConfirmedPane.setVisible(true);
          awayConfirmedBtn.setOnAction(aee -> {
            getNKList();
            awayConfirmedPane.setVisible(false);
            awayConfirmPane.setVisible(false);
            awayPane.setVisible(false);
            Utils.clearTextInput(awayPane);
          });
        }
      });
      awayCancelBtn.setOnAction(ae -> {
        awayConfirmPane.setVisible(false);
      });
    }
  };

  public void awayCancel(ActionEvent e) {
    awayPane.setVisible(false);
    awayErrText.setVisible(false);
    Utils.clearTextInput(awayPane);
  };

  // * move pane
  public void openMove(ActionEvent e) {
    optPane.setVisible(false);
    movePane.setVisible(true);
    moveNameField.setText(selectedNK.getHoTen());
    moveDOBField.setText(selectedNK.getNgaySinhString());
  }

  public void moveConfirm(ActionEvent e) {
    LocalDate s3 = moveAtPicker.getValue();
    String s4 = moveToField.getText();
    String s5 = moveNoteField.getText().replaceAll("\n", System.getProperty("line.separator"));
    if (s3 == null || s4 == null) {
      moveErrText.setVisible(true);
    } else {
      moveErrText.setVisible(false);
      moveConfirmPane.setVisible(true);
      moveConfirmBtn.setOnAction(ae -> {
        ChuyenNhanKhau temp = new ChuyenNhanKhau(0, selectedNK.getID(), Date.valueOf(s3), s4, s5);
        Boolean b = NhanKhauManage.chuyenNhanKhau(temp);
        if (b) {
          moveConfirmedPane.setVisible(true);
          moveConfirmedBtn.setOnAction(aee -> {
            moveConfirmedPane.setVisible(false);
            getNKList();
            moveConfirmPane.setVisible(false);
            movePane.setVisible(false);
            Utils.clearTextInput(movePane);
          });
        }
      });
      moveCancelBtn.setOnAction(ae -> {
        moveConfirmPane.setVisible(false);
      });
    }
  };

  public void moveCancel(ActionEvent e) {
    movePane.setVisible(false);
    Utils.clearTextInput(movePane);
  };

  // * dead pane
  public void openDead(ActionEvent e) {
    lostPane.setVisible(true);
    optPane.setVisible(false);
    deadNameField.setText(selectedNK.getHoTen());
    deadDOBField.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(selectedNK.getNgaySinh().toLocalDate()));
    deadDatePicker.setValue(LocalDate.now());
    deadNKBPicker.setValue(LocalDate.now());
    TableView<NhanKhau> deadNKList = new TableView<>();
    deadSearchField.textProperty().addListener((ObservableValue<? extends String> ov, String oldVal, String newVal) -> {
      if (newVal == null | newVal.isBlank()) {
        ObservableList<NhanKhau> deadNK = FXCollections.observableArrayList(nhanKhau);
        deadNKList.getItems().clear();
        deadNKList.setItems(deadNK);
      } else {
        try {
          ArrayList<NhanKhau> search = NhanKhauManage.layListNhanKhau(newVal);
          ObservableList<NhanKhau> deadNK = FXCollections.observableArrayList(search);
          deadNKList.getItems().clear();
          deadNKList.setItems(deadNK);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedNKB = row.getItem();
          deadPField.setText(selectedNKB.getHoTen());
        });
        return row;
      }
    };
    deadNKList.setRowFactory(rowFactory);
    TableColumn<NhanKhau, String> nameCol = Utils.createColumn("H??? t??n", "hoTen");
    TableColumn<NhanKhau, String> cCol = Utils.createColumn("S??? CCCD", "soCCCD");
    deadNKList.getColumns().addAll(Arrays.asList(nameCol, cCol));
    deadNKList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    ObservableList<NhanKhau> deadNK = FXCollections.observableArrayList(nhanKhau);
    deadNKList.getItems().clear();
    deadNKList.setItems(deadNK);
    deadTable.getChildren().clear();
    deadTable.getChildren().addAll(deadSearchField, deadNKList);
    deadAddBtn.setOnAction(ae -> {
      Date d1 = Date.valueOf(deadDatePicker.getValue());
      if (d1 == null || selectedNKB == null)
        deadErrText.setVisible(true);
      else {
        deadErrText.setVisible(false);
        deadConfirmPane.setVisible(true);
      }
    });
    deadCloseBtn.setOnAction(ae -> {
      lostPane.setVisible(false);
      deadErrText.setVisible(false);
      Utils.clearTextInput(lostPane);
    });
    deadConfirmBtn.setOnAction(ae -> {
      Date d1 = Date.valueOf(deadDatePicker.getValue());
      String reason = deadReasonField.getText().replaceAll("\n", System.getProperty("line.separator"));
      Date d2 = Date.valueOf(deadNKBPicker.getValue());
      KhaiTu kt = new KhaiTu(selectedNK.getID(), selectedNKB.getID(), d1, d2, reason);
      Boolean b = NhanKhauManage.khaiTu(kt);
      if (b) {
        deadConfirmedPane.setVisible(true);
        deadConfirmedBtn.setOnAction(aee -> {
          deadConfirmedPane.setVisible(false);
          deadConfirmPane.setVisible(false);
          lostPane.setVisible(false);
          Utils.clearTextInput(lostPane);
        });
      }
    });
    deadCancelBtn.setOnAction(ae -> {
      deadConfirmPane.setVisible(false);
    });
  }

  public void excel(ActionEvent e) {
    excelPane.setVisible(true);
    Runnable confirmed = () -> {
      confirmExcelPane.setVisible(true);
      returnExcelBtn.setOnAction(ae -> {
        confirmExcelPane.setVisible(false);
        excelPane.setVisible(false);
      });
    };
    importBtn.setOnAction(ae -> {
      if (NhanKhauManage.themNhanKhauFileExcel())
        confirmed.run();
    });
    exportBtn.setOnAction(ae -> {
      if (NhanKhauManage.inListNhanKhauRaFileExcel(nhanKhau))
        confirmed.run();
    });
    cancelExcelBtn.setOnAction(ae -> {
      excelPane.setVisible(false);
    });
  }

  public void openHistory(ActionEvent e) {
    historyPane.setVisible(true);
    final TableView<ChuyenNhanKhau> table = new TableView<>();
    Callback<TableView<ChuyenNhanKhau>, TableRow<ChuyenNhanKhau>> rowFactory = new Callback<TableView<ChuyenNhanKhau>, TableRow<ChuyenNhanKhau>>() {
      @Override
      public TableRow<ChuyenNhanKhau> call(final TableView<ChuyenNhanKhau> param) {
        final TableRow<ChuyenNhanKhau> row = new TableRow<>();
        row.setOnMouseClicked(e -> {
          if (e.getClickCount() >= 2) {
            selectedCNK = row.getItem();
            if (selectedCNK != null)
              historyDetailPane.setVisible(true);
          }
        });
        return row;
      }
    };
    TableColumn<ChuyenNhanKhau, String> nameCol = new TableColumn<>("Nh??n kh???u");
    nameCol.setCellValueFactory(new Callback<CellDataFeatures<ChuyenNhanKhau, String>, ObservableValue<String>>() {
      public ObservableValue<String> call(CellDataFeatures<ChuyenNhanKhau, String> p) {
        ChuyenNhanKhau cnk = p.getValue();
        NhanKhau nk = NhanKhauManage.layNhanKhau(cnk.getIdNhanKhau());
        return nk.hoTenProperty();
      }
    });
    TableColumn<ChuyenNhanKhau, String> diCol = Utils.createColumn("Ng??y Chuy???n ??i", "ngayChuyenDi");
    TableColumn<ChuyenNhanKhau, String> denCol = Utils.createColumn("N??i chuy???n ?????n", "noiChuyenDen");
    TableColumn<ChuyenNhanKhau, String> noteCol = Utils.createColumn("Ghi ch??", "ghiChu");
    table.getColumns().addAll(Arrays.asList(nameCol, diCol, denCol, noteCol));
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    table.setRowFactory(rowFactory);
    final ArrayList<ChuyenNhanKhau> list = NhanKhauManage.xemLichSuChuyenNhanKhaus();
    final ObservableList<ChuyenNhanKhau> olist = FXCollections.observableArrayList(
        list);
    table.setItems(olist);
    table.setPrefHeight(399);
    table.setPrefWidth(704);
    historyListPane.getChildren().clear();
    historyListPane.getChildren().add(table);
    closeHistoryBtn.setOnAction(ae -> {
      historyPane.setVisible(false);
    });
    closeHistoryListBtn.setOnAction(ae -> {
      historyDetailPane.setVisible(false);
    });
  }
}
