package com.lele.cnpm.ui.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.Pair;
import javafx.util.StringConverter;

import com.lele.cnpm.src.bean.HoKhauBean;
import com.lele.cnpm.src.models.ChuyenHoKhau;
import com.lele.cnpm.src.models.HoKhau;
import com.lele.cnpm.src.models.NguoiDung;
import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.services.HoKhauManage;
import com.lele.cnpm.src.services.NhanKhauManage;
import com.lele.cnpm.src.utils.Utils;

public class HouseholdController {

  @FXML
  private TextField searchBar;
  @FXML
  private TextField editIdField;
  @FXML
  private TextField editCHField;
  @FXML
  private TextField editTTField;
  @FXML
  private TextField editQHField;
  @FXML
  private TextField editPXField;
  @FXML
  private TextField editAddrField;
  @FXML
  private DatePicker editDatePicker;
  @FXML
  private TextField editStateField;
  @FXML
  private TextField infoIdField;
  @FXML
  private TextField infoCHField;
  @FXML
  private TextField infoTTField;
  @FXML
  private TextField infoQHField;
  @FXML
  private TextField infoPXField;
  @FXML
  private TextField infoAddrField;
  @FXML
  private TextField infoDateField;
  @FXML
  private TextField infoStateField;
  @FXML
  private TextField addCHField;
  @FXML
  private TextField addTTField;
  @FXML
  private TextField addQHField;
  @FXML
  private TextField addPXField;
  @FXML
  private TextField addAddrField;
  @FXML
  private DatePicker addDatePicker;
  @FXML
  private TextField addStateField;
  @FXML
  private TextField addHKSearchField;
  @FXML
  private TextField addedHKSearchField;
  @FXML
  private TextField addHKNameField;
  @FXML
  private TextField addHKRelField;
  @FXML
  private TextField moveIdField;
  @FXML
  private DatePicker moveAtPicker;
  @FXML
  private TextField moveToField;
  @FXML
  private TextArea moveNoteField;
  @FXML
  private TextField editHKSearchField;
  @FXML
  private TextField editHKNameField;
  @FXML
  private TextField editHKRelField;
  @FXML
  private TextField splitIdField;
  @FXML
  private TextField splitCHField;
  @FXML
  private TextField splitTTField;
  @FXML
  private TextField splitQHField;
  @FXML
  private TextField splitPXField;
  @FXML
  private TextField splitAddrField;
  @FXML
  private DatePicker splitDatePicker;
  @FXML
  private TextField splitStateField;
  @FXML
  private TextField splitHKNameField;
  @FXML
  private TextField splitHKRelOldField;
  @FXML
  private TextField splitHKRelNewField;

  @FXML
  private AnchorPane tableHKPane;
  @FXML
  private AnchorPane addPane;
  @FXML
  private AnchorPane addSaveConfirmPane;
  @FXML
  private AnchorPane editPane;
  @FXML
  private AnchorPane editConfirmSavePane;
  @FXML
  private AnchorPane editConfirmDeletePane;
  @FXML
  private AnchorPane infoPane;
  @FXML
  private AnchorPane confirmDeleteInfoPane;
  @FXML
  private AnchorPane splitPane;
  @FXML
  private AnchorPane splitConfirmSavePane;
  @FXML
  private AnchorPane movePane;
  @FXML
  private AnchorPane moveConfirmPane;
  @FXML
  private AnchorPane historyPane;

  @FXML
  private ScrollPane infoNKPane;

  @FXML
  private Label infoNKNameLabel;
  @FXML
  private Label infoNKCCLabel;
  @FXML
  private Label infoNKDOBLabel;
  @FXML
  private Label infoNKTTLabel;
  @FXML
  private Label infoNKRelLabel;

  @FXML
  private HBox infoNKTableBox;

  @FXML
  private VBox addHKTableBox;
  @FXML
  private VBox addedHKTableBox;
  @FXML
  private VBox historyTableBox;
  @FXML
  private VBox editHKTableBox;
  @FXML
  private VBox editedHKTableBox;
  @FXML
  private VBox splitHKTableBox;
  @FXML
  private VBox splitedHKTableBox;

  @FXML
  private Button addBtn;
  @FXML
  private Button addSaveBtn;
  @FXML
  private Button saveConfirmAddBtn;
  @FXML
  private Button cancelConfirmAddBtn;
  @FXML
  private Button removeBtn;
  @FXML
  private Button confirmSaveEditBtn;
  @FXML
  private Button confirmCancelSaveEditBtn;
  @FXML
  private Button confirmDelEditBtn;
  @FXML
  private Button confirmCancelDelEditBtn;
  @FXML
  private Button moveBtn;
  @FXML
  private Button moveCloseBtn;
  @FXML
  private Button moveConfirmBtn;
  @FXML
  private Button moveCancelBtn;
  @FXML
  private Button editAddBtn;
  @FXML
  private Button editRemoveBtn;
  @FXML
  private Button splitSaveBtn;
  @FXML
  private Button splitCloseBtn;
  @FXML
  private Button splitLeftBtn;
  @FXML
  private Button splitRightBtn;
  @FXML
  private Button confirmSaveSplitBtn;
  @FXML
  private Button confirmCancelSplitBtn;

  @FXML
  private CheckBox addCHCheckBox;
  @FXML
  private CheckBox editCHCheckBox;
  @FXML
  private CheckBox splitCHCheckBox;

  private NguoiDung user;

  public void setUser(NguoiDung usr) {
    user = usr;
  }

  private ArrayList<HoKhau> hkList = new ArrayList<>();
  private TableView<HoKhau> table = new TableView<>();
  private HoKhau selectedHK = null;
  private AnchorPane optPane = new AnchorPane();
  private VBox optBox = new VBox();
  private Button addSplitBtn = new Button("Tách hộ khẩu");
  private Button addMoveBtn = new Button("Chuyển hộ khẩu");
  private ArrayList<Button> optBtnList = new ArrayList<>();
  private NhanKhau selectedAddNK = null;
  private NhanKhau selectedAddChuHo = null;
  private NhanKhau selectedEditNK = null;
  private NhanKhau selectedEditChuHo = null;
  private NhanKhau selectedInfoNK = null;
  private HoKhauBean infoHKB = null;
  private ChuyenHoKhau chk = null;
  private ArrayList<ChuyenHoKhau> chkList = new ArrayList<>();

  private ArrayList<NhanKhau> editnk = new ArrayList<>();
  private ArrayList<NhanKhau> editednk = new ArrayList<>();
  private ArrayList<String> editedNKRel = new ArrayList<>();
  private ArrayList<Pair<NhanKhau, String>> nkWithRel = new ArrayList<>();

  private NhanKhau splitNewChuHo = null;
  private NhanKhau selectedSplitNK = null;

  public void initialize() {
    final ArrayList<AnchorPane> panes = new ArrayList<>(
        Arrays.asList(infoPane, editPane, addPane, movePane, splitPane, historyPane));
    panes.forEach(e -> e.visibleProperty()
        .addListener((ObservableValue<? extends Boolean> ob, Boolean oldVal, Boolean newVal) -> {
          if (newVal == false) {
            getHKList();
            selectedHK = null;
            selectedAddChuHo = null;
            selectedAddNK = null;
            selectedEditChuHo = null;
            selectedEditNK = null;
            selectedInfoNK = null;
          }
        }));
    optBtnList.add(addSplitBtn);
    optBtnList.add(addMoveBtn);
    optBtnList.forEach((Button e) -> {
      e.setPrefHeight(40);
      e.setPrefWidth(160);
      e.setStyle("-fx-background-color: inherit");
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
    optBox.getChildren().addAll(addSplitBtn, addMoveBtn);
    optBox.setPrefHeight(80);
    optBox.setPrefWidth(160);
    optBox.setStyle("-fx-background-color: #fefefe");
    optPane.setVisible(false);
    optPane.getChildren().add(optBox);
    optPane.setOnMouseClicked((MouseEvent me) -> {
      optPane.setVisible(false);
    });
    tableHKPane.getChildren().add(optPane);
    AnchorPane.setBottomAnchor(optPane, 0.0);
    AnchorPane.setLeftAnchor(optPane, 0.0);
    AnchorPane.setRightAnchor(optPane, 0.0);
    AnchorPane.setTopAnchor(optPane, 0.0);
    searchBar.textProperty()
        .addListener((ObservableValue<? extends String> observable, String oldVal, String newVal) -> {
          if (newVal == null || newVal.isEmpty()) {
            getHKList();
          } else {
            try {
              hkList.clear();
              hkList.addAll(HoKhauManage.layListHoKhau(newVal));
              setTableData();
            } catch (Exception ex) {
              ex.printStackTrace();
            }
          }
        });
    Callback<TableView<HoKhau>, TableRow<HoKhau>> rowFactory = new Callback<TableView<HoKhau>, TableRow<HoKhau>>() {
      @Override
      public TableRow<HoKhau> call(final TableView<HoKhau> param) {
        final TableRow<HoKhau> row = new TableRow<>();
        row.setOnMouseClicked((MouseEvent e) -> {
          if (e.getClickCount() == 2 && e.getButton() == MouseButton.PRIMARY) {
            selectedHK = row.getItem();
            if (selectedHK != null) {
              openInfo(e);
            }
          } else if (e.getButton() == MouseButton.SECONDARY) {
            double x = e.getSceneX();
            double y = e.getSceneY();
            double xx = x > 1280 - 160 ? x - 160 - 137 : x - 135;
            double yy = y > 720 - 160 ? y - 160 - 147 : y - 145;
            optPane.setVisible(true);
            AnchorPane.setLeftAnchor(optBox, xx);
            AnchorPane.setTopAnchor(optBox, yy);
            addSplitBtn.setOnAction((ActionEvent ae) -> {
              selectedHK = row.getItem();
              if (selectedHK != null) {
                optPane.setVisible(false);
                splitPane.setVisible(true);
                openSplit();
              }
            });
            addMoveBtn.setOnAction((ActionEvent ae) -> {
              if (selectedHK != null) {
                selectedHK = row.getItem();
                openMove(ae);
              }
            });
          }
        });
        return row;
      }
    };
    table.setRowFactory(rowFactory);
    TableColumn<HoKhau, String> chuCol = new TableColumn<>("Chủ Hộ");
    chuCol.setMaxWidth(250);
    chuCol.setMinWidth(250);
    chuCol.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
    TableColumn<HoKhau, String> addrCol = new TableColumn<>("Địa chỉ");
    addrCol.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
    TableColumn<HoKhau, String> dateCol = new TableColumn<>("Ngày tạo");
    dateCol.setMaxWidth(120);
    dateCol.setMinWidth(120);
    dateCol.setCellValueFactory(new PropertyValueFactory<>("ngayTaoString"));
    TableColumn<HoKhau, String> stateCol = new TableColumn<>("Trạng thái");
    stateCol.setMaxWidth(200);
    stateCol.setMinWidth(200);
    stateCol.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
    table.getColumns().addAll(Arrays.asList(chuCol, addrCol, dateCol, stateCol));
    getHKList();
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    final ArrayList<Node> al = new ArrayList<>();
    al.add(table);
    al.addAll(tableHKPane.getChildren());
    final ObservableList<Node> newList = FXCollections.observableArrayList(al);
    tableHKPane.getChildren().clear();
    tableHKPane.getChildren().addAll(newList);
    table.setMinWidth(1098);
    table.setMinHeight(570);
    AnchorPane.setTopAnchor(table, 6.0);
  }

  private void getHKList() {
    try {
      final ArrayList<HoKhau> tmp = HoKhauManage.layListHoKhau();
      hkList.clear();
      hkList.addAll(tmp);
    } catch (Exception e) {
      e.printStackTrace();
    }
    setTableData();
  }

  private void setTableData() {
    final ObservableList<HoKhau> data = FXCollections.observableArrayList(hkList);
    table.getItems().clear();
    table.setItems(data);
  }

  // * infoPane buttons

  protected void openInfo(MouseEvent e) {
    infoPane.setVisible(true);
    infoIdField.setText("" + selectedHK.getID());
    infoCHField.setText("" + NhanKhauManage.layNhanKhau((selectedHK.getIdChuHo())).getHoTen());
    infoTTField.setText("" + selectedHK.getTinhThanhPho());
    infoQHField.setText("" + selectedHK.getQuanHuyen());
    infoPXField.setText("" + selectedHK.getPhuongXa());
    infoAddrField.setText("" + selectedHK.getDiaChi());
    infoDateField.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(selectedHK.getNgayTao().toLocalDate()));
    infoStateField.setText("" + selectedHK.getTrangThai());
    final TableView<NhanKhau> infoNKTable = new TableView<>();
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedInfoNK = row.getItem();
          if (selectedInfoNK != null) {
            infoNKPane.setVisible(true);
            infoNKNameLabel.setText("" + selectedInfoNK.getHoTen());
            infoNKCCLabel.setText("" + selectedInfoNK.getSoCCCD());
            infoNKDOBLabel.setText("" + selectedInfoNK.getNgaySinhString());
            infoNKTTLabel.setText("" + selectedInfoNK.getTrangThai());
            infoNKRelLabel.setText(HoKhauManage.layQuanHeChuHo(selectedHK.getID(), selectedInfoNK.getID()));
          }
        });
        return row;
      }
    };
    infoNKTable.setRowFactory(rowFactory);
    TableColumn<NhanKhau, String> idCol = new TableColumn<>("Id");
    idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    idCol.setMaxWidth(55);
    idCol.setMinWidth(55);
    TableColumn<NhanKhau, String> nameCol = new TableColumn<>("Họ tên");
    nameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    infoNKTable.getColumns().addAll(Arrays.asList(idCol, nameCol));
    infoNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    Runnable getHKB = () -> {
      infoHKB = HoKhauManage.layHoKhauBean(selectedHK);
      final ObservableList<NhanKhau> nk = FXCollections.observableArrayList(infoHKB.getListNhanKhaus());
      infoNKTable.getItems().clear();
      infoNKTable.getItems().addAll(nk);
    };
    getHKB.run();
    infoNKTableBox.getChildren().clear();
    infoNKTableBox.getChildren().addAll(infoNKTable, infoNKPane);
  }

  public void openEdit(ActionEvent e) {
    infoPane.setVisible(false);
    editPane.setVisible(true);
    editIdField.setText("" + selectedHK.getID());
    editCHField.setText("" + selectedHK.getIdChuHo());
    editTTField.setText("" + selectedHK.getTinhThanhPho());
    editQHField.setText("" + selectedHK.getQuanHuyen());
    editPXField.setText("" + selectedHK.getPhuongXa());
    editAddrField.setText("" + selectedHK.getDiaChi());
    editDatePicker.setConverter(Utils.converter());
    editDatePicker.setValue(selectedHK.getNgayTao().toLocalDate());
    editStateField.setText("" + selectedHK.getTrangThai());
    TableView<NhanKhau> editNKTable = new TableView<>();
    TableView<NhanKhau> editedNKTable = new TableView<>();
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedEditNK = row.getItem();
          if (selectedEditNK != null) {
            addHKNameField.setText(selectedEditNK.getHoTen());
            if (selectedEditChuHo != null && selectedEditNK.getID() == selectedEditChuHo.getID())
              editCHCheckBox.setSelected(true);
          }
        });
        return row;
      }
    };
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowedFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedEditNK = row.getItem();
          if (selectedEditNK != null) {
            editHKNameField.setText(selectedEditNK.getHoTen());
            editHKRelField.setText(editedNKRel.get(editednk.indexOf(selectedEditNK)));
            if (selectedEditChuHo != null && selectedEditNK.getID() == selectedEditChuHo.getID())
              editCHCheckBox.setSelected(true);
          }
        });
        return row;
      }
    };
    TableColumn<NhanKhau, String> editNKIdCol = new TableColumn<>("Id");
    editNKIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    editNKIdCol.setMinWidth(40);
    editNKIdCol.setMaxWidth(40);
    TableColumn<NhanKhau, String> editNKNameCol = new TableColumn<>("Họ và tên");
    editNKNameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    TableColumn<NhanKhau, String> editedNKIdCol = new TableColumn<>("Id");
    editedNKIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    editedNKIdCol.setMinWidth(40);
    editedNKIdCol.setMaxWidth(40);
    TableColumn<NhanKhau, String> editedNKNameCol = new TableColumn<>("Họ và tên");
    editedNKNameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    editNKTable.getColumns().addAll(Arrays.asList(editNKIdCol, editNKNameCol));
    editedNKTable.getColumns().addAll(Arrays.asList(editedNKIdCol, editedNKNameCol));
    editNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    editedNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    Runnable getNKList = () -> {
      editnk = NhanKhauManage.layListNhanKhauChuaCoHoKhau();
    };

    Runnable getNKedList = () -> {
      editednk = HoKhauManage.layListNhanKhau(selectedHK);
      editedNKRel = HoKhauManage.layHoKhauBean(selectedHK).getListQuanHeChuHos();
      nkWithRel.clear();
      for (int i = 0; i < editednk.size(); i++) {
        nkWithRel.add(new Pair<NhanKhau, String>(editednk.get(i), editedNKRel.get(i)));
      }
    };

    Consumer<String> getNKListFind = (String s) -> {
      editnk = NhanKhauManage.layListNhanKhauChuaCoHoKhau(s);
    };

    editHKSearchField.textProperty()
        .addListener((ObservableValue<? extends String> ob, String oldVal, String newVal) -> {
          if (newVal.isBlank() || newVal == null)
            getNKList.run();
          else
            getNKListFind.accept(newVal);
        });

    editCHCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          if (selectedEditChuHo == null
              || selectedEditChuHo != null && selectedEditChuHo.getID() != selectedEditNK.getID()) {
            selectedEditChuHo = selectedEditNK;
          }
        } else if (!newValue && selectedEditChuHo.getID() == selectedEditNK.getID()) {
          selectedEditChuHo = null;
        }
      }
    });

    getNKList.run();
    getNKedList.run();
    editNKTable.setItems(FXCollections.observableArrayList(editnk));
    editedNKTable.setItems(FXCollections.observableArrayList(editednk));
    editNKTable.setRowFactory(rowFactory);
    editedNKTable.setRowFactory(rowedFactory);
    editHKTableBox.getChildren().clear();
    editHKTableBox.getChildren().addAll(editHKSearchField, editNKTable);
    editedHKTableBox.getChildren().clear();
    editedHKTableBox.getChildren().add(editedNKTable);

  }

  public void deleteInfo(ActionEvent e) {
    confirmDeleteInfoPane.setVisible(true);
  }

  public void confirmDeleteInfo(ActionEvent e) {
    try {
      HoKhauManage.xoaHoKhau(selectedHK);
      selectedHK = null;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    cancelDeleteInfo(e);
    infoPane.setVisible(false);
    editPane.setVisible(false);
  }

  public void cancelDeleteInfo(ActionEvent e) {
    confirmDeleteInfoPane.setVisible(false);
  }

  public void closeInfo(ActionEvent e) {
    infoPane.setVisible(false);
  }

  // * edit Pane buttons
  public void saveEdit(ActionEvent e) {
    final String a1 = editIdField.getText();
    final String a2 = editCHField.getText();
    final String a3 = editTTField.getText();
    final String a4 = editQHField.getText();
    final String a5 = editPXField.getText();
    final String a6 = editAddrField.getText();
    final Date a7 = Date.valueOf(editDatePicker.getValue());
    final String a8 = editStateField.getText();
    final HoKhau tmp = new HoKhau(Integer.parseInt(a1), Integer.parseInt(a2), a3, a4, a5, a6, a7, a8);
    editConfirmSavePane.setVisible(true);
    confirmSaveEditBtn.setOnAction(ae -> {
      try {
        HoKhauManage.capNhatHoKhau(tmp);
        editConfirmSavePane.setVisible(false);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });
    confirmCancelSaveEditBtn.setOnAction(ae -> {
      editConfirmSavePane.setVisible(false);
    });
  }

  public void deleteEdit(ActionEvent e) {
    editConfirmDeletePane.setVisible(true);
    confirmDelEditBtn.setOnAction(ae -> {
      try {
        HoKhauManage.xoaHoKhau(selectedHK);
        selectedHK = null;
        editConfirmDeletePane.setVisible(false);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    });
    confirmCancelDelEditBtn.setOnAction(ae -> {
      editConfirmDeletePane.setVisible(false);
    });
  }

  public void cancelEdit(ActionEvent e) {
    editPane.setVisible(false);
    infoPane.setVisible(true);
  }

  // * add new Pane

  public void addNew(ActionEvent e) {
    addDatePicker.setConverter(Utils.converter());
    addDatePicker.setValue(LocalDate.now());
    addPane.setVisible(true);
    final TableView<NhanKhau> addNKTable = new TableView<>();
    final TableView<NhanKhau> addedNKTable = new TableView<>();
    final ArrayList<NhanKhau> nk = new ArrayList<>();
    final ArrayList<NhanKhau> addednk = new ArrayList<>();
    final ArrayList<NhanKhau> searchAddedNk = new ArrayList<>();
    final ArrayList<String> addedNKRel = new ArrayList<>();
    // table create
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedAddNK = row.getItem();
          if (selectedAddNK != null) {
            addHKNameField.setText(selectedAddNK.getHoTen());
            if (selectedAddChuHo != null)
              if (selectedAddNK.getID() == selectedAddChuHo.getID()) {
                addCHCheckBox.setSelected(true);
              } else
                addCHCheckBox.setSelected(false);
          }
        });
        return row;
      }
    };
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowedFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedAddNK = row.getItem();
          if (selectedAddNK != null) {
            addHKNameField.setText(selectedAddNK.getHoTen());
            if (selectedAddChuHo != null)
              if (selectedAddNK.getID() == selectedAddChuHo.getID()) {
                addCHCheckBox.setSelected(true);
              } else
                addCHCheckBox.setSelected(false);
          }
        });
        return row;
      }
    };
    addNKTable.setRowFactory(rowFactory);
    addedNKTable.setRowFactory(rowedFactory);
    TableColumn<NhanKhau, String> addNKIdCol = new TableColumn<>("Id");
    addNKIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    addNKIdCol.setMinWidth(40);
    addNKIdCol.setMaxWidth(40);
    TableColumn<NhanKhau, String> addNKNameCol = new TableColumn<>("Họ và tên");
    addNKNameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    TableColumn<NhanKhau, String> addedNKIdCol = new TableColumn<>("Id");
    addedNKIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    addedNKIdCol.setMinWidth(40);
    addedNKIdCol.setMaxWidth(40);
    TableColumn<NhanKhau, String> addedNKNameCol = new TableColumn<>("Họ và tên");
    addedNKNameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    addNKTable.getColumns().addAll(Arrays.asList(addNKIdCol, addNKNameCol));
    addedNKTable.getColumns().addAll(Arrays.asList(addedNKIdCol, addedNKNameCol));
    addNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    addedNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    addHKTableBox.getChildren().clear();
    addHKTableBox.getChildren().addAll(addHKSearchField, addNKTable);
    addedHKTableBox.getChildren().clear();
    addedHKTableBox.getChildren().addAll(addedHKSearchField, addedNKTable);

    addCHCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          if (selectedAddChuHo == null
              || selectedAddChuHo != null && selectedAddChuHo.getID() != selectedAddNK.getID()) {
            selectedAddChuHo = selectedAddNK;
          }
        } else if (!newValue && selectedAddChuHo.getID() == selectedAddNK.getID()) {
          selectedAddChuHo = null;
        }
      }
    });

    // callbacks
    Runnable updateAddNKTable = () -> {
      final ObservableList<NhanKhau> list = FXCollections.observableArrayList(nk);
      addNKTable.getItems().clear();
      addNKTable.getItems().addAll(list);
      final ObservableList<NhanKhau> addedList = FXCollections.observableArrayList(addednk);
      addedNKTable.getItems().clear();
      addedNKTable.getItems().addAll(addedList);
    };
    Consumer<String> searchNKList = (String t) -> {
      try {
        ArrayList<NhanKhau> temp = NhanKhauManage.layListNhanKhauChuaCoHoKhau(t);
        nk.clear();
        nk.addAll(temp);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    };
    Runnable getNKList = () -> {
      try {
        ArrayList<NhanKhau> temp = NhanKhauManage.layListNhanKhauChuaCoHoKhau();
        nk.clear();
        nk.addAll(temp);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    };
    Consumer<String> findAddedNKList = (String s) -> {
      searchAddedNk.clear();
      searchAddedNk.addAll(addednk.stream().filter((n) -> n.getHoTen().contains(s)).toList());
    };

    addHKSearchField.textProperty().addListener((
        ObservableValue<? extends String> observable, String oldVal,
        String newVal) -> {
      if (newVal == null || newVal.isEmpty()) {
        getNKList.run();
        updateAddNKTable.run();
      } else {
        searchNKList.accept(newVal);
        updateAddNKTable.run();
      }
    });
    addedHKSearchField.textProperty().addListener((
        ObservableValue<? extends String> observable, String oldVal,
        String newVal) -> {
      if (newVal == null || newVal.isEmpty()) {
        final ObservableList<NhanKhau> list = FXCollections.observableArrayList(addednk);
        addedNKTable.getItems().clear();
        addedNKTable.getItems().addAll(list);
      } else {
        findAddedNKList.accept(newVal);
        final ObservableList<NhanKhau> addedList = FXCollections.observableArrayList(searchAddedNk);
        addedNKTable.getItems().clear();
        addedNKTable.getItems().addAll(addedList);
      }
    });
    addBtn.setOnAction((ae) -> {
      if (nk.contains(selectedAddNK)) {
        nk.remove(selectedAddNK);
        addednk.add(selectedAddNK);
        String s = addHKRelField.getText();
        addedNKRel.add(s == null || s.isEmpty() ? "" : s);
        updateAddNKTable.run();
        addHKNameField.setText(null);
        addHKRelField.setText(null);
        selectedAddNK = null;
      }
    });
    removeBtn.setOnAction((ae) -> {
      if (addednk.contains(selectedAddNK)) {
        nk.add(selectedAddNK);
        int i = addednk.indexOf(selectedAddNK);
        addednk.remove(i);
        addedNKRel.remove(i);
        updateAddNKTable.run();
        addHKNameField.setText(null);
        addHKRelField.setText(null);
        if (selectedAddNK.getID() == selectedAddChuHo.getID())
          selectedAddChuHo = null;
        selectedAddNK = null;
      }
    });
    getNKList.run();
    updateAddNKTable.run();
    addSaveBtn.setOnAction(ae -> {
      String a3 = addTTField.getText();
      String a4 = addQHField.getText();
      String a5 = addPXField.getText();
      String a6 = addAddrField.getText();
      LocalDate a7 = addDatePicker.getValue();
      String a8 = addStateField.getText();
      addSaveConfirmPane.setVisible(true);
      saveConfirmAddBtn.setOnAction(ev -> {
        HoKhau hk = new HoKhau(0, selectedAddChuHo.getID(), a3, a4, a5, a6, Date.valueOf(a7), a8);
        HoKhauBean hkb = new HoKhauBean(hk, selectedAddChuHo, addednk, addedNKRel);
        HoKhauManage.themHoKhauBean(hkb);
        addSaveConfirmPane.setVisible(false);
        addPane.setVisible(false);
      });
      cancelConfirmAddBtn.setOnAction(ev -> {
        addSaveConfirmPane.setVisible(false);
      });
    });
  }

  public void cancelAdd(ActionEvent e) {
    addPane.setVisible(false);
  }

  // * open move
  private void openMove(ActionEvent e) {
    movePane.setVisible(true);
    optPane.setVisible(false);
    moveIdField.setText("" + selectedHK.getID());
    moveAtPicker.setConverter(Utils.converter());
    moveAtPicker.setValue(LocalDate.now());
    moveBtn.setOnAction(ae -> {
      moveConfirmPane.setVisible(true);
    });
    moveCloseBtn.setOnAction(ae -> {
      movePane.setVisible(false);
    });
    moveConfirmBtn.setOnAction(ae -> {
      Date d1 = Date.valueOf(moveAtPicker.getValue());
      String s1 = moveToField.getText();
      String s2 = moveNoteField.getText().replaceAll("\n", System.getProperty("line.separator"));
      ChuyenHoKhau chk = new ChuyenHoKhau(0, selectedHK.getID(), d1, s1, s2);
      HoKhauManage.chuyenHoKhau(chk);
      moveConfirmPane.setVisible(false);
      movePane.setVisible(false);
    });
    moveCancelBtn.setOnAction(ae -> {
      moveConfirmPane.setVisible(false);
    });
  }

  // * open history

  public void openHistory(ActionEvent e) {
    historyPane.setVisible(true);
    optPane.setVisible(false);
    TableView<ChuyenHoKhau> chkTable = new TableView<>();
    Callback<TableView<ChuyenHoKhau>, TableRow<ChuyenHoKhau>> rowFactory = new Callback<TableView<ChuyenHoKhau>, TableRow<ChuyenHoKhau>>() {
      @Override
      public TableRow<ChuyenHoKhau> call(TableView<ChuyenHoKhau> param) {
        final TableRow<ChuyenHoKhau> row = new TableRow<>();
        row.setOnMouseClicked(ae -> {
          if (ae.getClickCount() >= 2) {
            chk = row.getItem();
          }
        });
        return row;
      }
    };
    chkTable.setRowFactory(rowFactory);
    chkTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    TableColumn<ChuyenHoKhau, String> idCol = new TableColumn<>("Chủ hộ");
    idCol.setCellValueFactory(new PropertyValueFactory<>("tenChuHo"));
    TableColumn<ChuyenHoKhau, String> dateCol = new TableColumn<>("Ngày chuyển đi");
    dateCol.setCellValueFactory(new PropertyValueFactory<>("ngayChuyenDiString"));
    TableColumn<ChuyenHoKhau, String> toCol = new TableColumn<>("Nơi chuyển đến");
    toCol.setCellValueFactory(new PropertyValueFactory<>("noiChuyenDen"));
    TableColumn<ChuyenHoKhau, String> noteCol = new TableColumn<>("Ghi chú");
    noteCol.setCellValueFactory(new PropertyValueFactory<>("ghiChu"));
    chkTable.getColumns().addAll(Arrays.asList(idCol, dateCol, toCol, noteCol));
    chkList = HoKhauManage.xemLichSuChuyenHoKhaus();
    final ObservableList<ChuyenHoKhau> list = FXCollections.observableArrayList(chkList);
    chkTable.setItems(list);
    historyTableBox.getChildren().clear();
    historyTableBox.getChildren().add(chkTable);
  }

  public void closeHistory(ActionEvent e) {
    historyPane.setVisible(false);
  }

  // * split pane
  private void openSplit() {
    splitIdField.setText(selectedHK.getID() + "");
    splitCHField.setText(selectedHK.getTenChuHo());
    splitDatePicker.setConverter(Utils.converter());
    splitDatePicker.setValue(LocalDate.now());
    final TableView<NhanKhau> splitNKTable = new TableView<>();
    final TableView<NhanKhau> splitedNKTable = new TableView<>();
    final ArrayList<NhanKhau> nk = HoKhauManage.layListNhanKhau(selectedHK);
    final ArrayList<String> rel = HoKhauManage.layHoKhauBean(selectedHK).getListQuanHeChuHos();
    final ArrayList<NhanKhau> splitednk = new ArrayList<>();
    final ArrayList<String> splitedNKRel = new ArrayList<>();
    final ArrayList<Pair<NhanKhau, String>> nkWRel = new ArrayList<>();
    final ArrayList<Pair<NhanKhau, String>> nkedWRel = new ArrayList<>();
    for (int i = 0; i < nk.size(); i++) {
      nkWRel.add(new Pair<NhanKhau, String>(nk.get(i), rel.get(i)));
    }
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedAddNK = row.getItem();
          if (selectedAddNK != null) {
            splitHKNameField.setText(selectedAddNK.getHoTen());
            splitHKRelOldField.setText(rel.get(nk.indexOf(selectedAddNK)));
          }
        });
        return row;
      }
    };
    Callback<TableView<NhanKhau>, TableRow<NhanKhau>> rowedFactory = new Callback<TableView<NhanKhau>, TableRow<NhanKhau>>() {
      @Override
      public TableRow<NhanKhau> call(final TableView<NhanKhau> param) {
        final TableRow<NhanKhau> row = new TableRow<>();
        row.setOnMouseClicked((e) -> {
          selectedSplitNK = row.getItem();
          if (selectedSplitNK != null) {
            splitHKNameField.setText(selectedSplitNK.getHoTen());
            splitHKRelOldField.setText(rel.get(nk.indexOf(selectedSplitNK)));
            if (splitNewChuHo != null)
              if (selectedSplitNK.getID() == splitNewChuHo.getID()) {
                splitCHCheckBox.setSelected(true);
              } else
                splitCHCheckBox.setSelected(false);
          }
        });
        return row;
      }
    };
    splitNKTable.setRowFactory(rowFactory);
    splitedNKTable.setRowFactory(rowedFactory);
    splitNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    splitedNKTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    TableColumn<NhanKhau, String> splitNKIdCol = new TableColumn<>("Id");
    splitNKIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    splitNKIdCol.setMinWidth(40);
    splitNKIdCol.setMaxWidth(40);
    TableColumn<NhanKhau, String> splitNKNameCol = new TableColumn<>("Họ và tên");
    splitNKNameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    TableColumn<NhanKhau, String> splitedNKIdCol = new TableColumn<>("Id");
    splitedNKIdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
    splitedNKIdCol.setMinWidth(40);
    splitedNKIdCol.setMaxWidth(40);
    TableColumn<NhanKhau, String> splitedNKNameCol = new TableColumn<>("Họ và tên");
    splitedNKNameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    splitNKTable.getColumns().addAll(Arrays.asList(splitNKIdCol, splitNKNameCol));
    splitedNKTable.getColumns().addAll(Arrays.asList(splitedNKIdCol, splitedNKNameCol));
    splitHKTableBox.getChildren().clear();
    splitHKTableBox.getChildren().add(splitNKTable);
    splitedHKTableBox.getChildren().clear();
    splitedHKTableBox.getChildren().add(splitedNKTable);
    splitNKTable.getItems().clear();
    splitNKTable.setItems(FXCollections.observableArrayList(nk));
    splitedNKTable.getItems().clear();
    splitedNKTable.setItems(FXCollections.observableArrayList(splitednk));
    splitCHCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
      @Override
      public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
          if (splitNewChuHo == null
              || splitNewChuHo != null && splitNewChuHo.getID() != selectedSplitNK.getID()) {
            splitNewChuHo = selectedSplitNK;
          }
        } else if (!newValue && splitNewChuHo.getID() == selectedSplitNK.getID()) {
          splitNewChuHo = null;
        }
      }
    });

    Supplier<Pair<ArrayList<NhanKhau>, ArrayList<String>>> toList = () -> {
      ArrayList<NhanKhau> nkl = new ArrayList<>();
      ArrayList<String> sl = new ArrayList<>();
      for (int i = 0; i < nkedWRel.size(); i++) {
        nkl.add(nkedWRel.get(i).getKey());
        sl.add(nkedWRel.get(i).getValue());
      }
      return new Pair<ArrayList<NhanKhau>, ArrayList<String>>(nkl, sl);
    };

    Runnable updateTable = () -> {
      nk.clear();
      for (int i = 0; i < nkWRel.size(); i++) {
        nk.add(nkWRel.get(i).getKey());
      }
      splitednk.clear();
      splitednk.addAll(toList.get().getKey());
      splitNKTable.getItems().clear();
      splitNKTable.setItems(FXCollections.observableArrayList(nk));
      splitedNKTable.getItems().clear();
      splitedNKTable.setItems(FXCollections.observableArrayList(splitednk));
    };

    splitRightBtn.setOnAction(ae -> {
      String s = splitHKRelNewField.getText();
      Pair<NhanKhau, String> p = new Pair<NhanKhau, String>(selectedAddNK, s);
      nkWRel.remove(p);
      nkedWRel.add(p);
      updateTable.run();
    });

    splitLeftBtn.setOnAction(ae -> {
      String s = null;
    });

    splitSaveBtn.setOnAction(ae -> {
      splitConfirmSavePane.setVisible(false);
      confirmSaveSplitBtn.setOnAction(aee -> {
        String a3 = splitTTField.getText();
        String a4 = splitQHField.getText();
        String a5 = splitPXField.getText();
        String a6 = splitAddrField.getText();
        LocalDate a7 = splitDatePicker.getValue();
        String a8 = splitStateField.getText();
        HoKhau hk = new HoKhau(0, splitNewChuHo.getID(), a3, a4, a5, a6, Date.valueOf(a7), a8);
        splitednk.clear();
        splitednk.addAll(toList.get().getKey());
        splitedNKRel.clear();
        splitedNKRel.addAll(toList.get().getValue());
        HoKhauManage.tachHoKhau(hk, splitNewChuHo.getID(), nk, splitedNKRel);
        splitConfirmSavePane.setVisible(false);
        splitPane.setVisible(false);
      });
      confirmCancelSplitBtn.setOnAction(aee -> splitConfirmSavePane.setVisible(false));
    });
    splitCloseBtn.setOnAction(ae -> splitPane.setVisible(false));
  }
}
