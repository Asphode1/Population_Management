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

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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
  private Button editListReturnBtn;
  @FXML
  private Button editListSaveBtn;
  @FXML
  private Button confirmBtn;
  @FXML
  private Button cancelBtn;

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
  private TableView<NhanKhau> totalTable = new TableView<>();
  private ArrayList<NhanKhau> totalNK = new ArrayList<>();
  private NhanKhau selectedAddNK = null;
  private ArrayList<ChiTietDipHocSinhGioi> addedGList = new ArrayList<>();
  private ArrayList<ChiTietDipDacBiet> addedSList = new ArrayList<>();

  public void initialize() {
    detailPane.visibleProperty().addListener((ob, oldVal, newVal) -> {
      if (newVal == false) {
        if (selectHSGBtn.getStyleClass().contains("btnOnFocus"))
          getGList();
        else
          getSList();
      }
    });
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
    TableColumn<DipHSG, String> descGCol = Utils.createColumn("Mô tả", "moTa");
    gMainTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    gMainTable.getColumns().addAll(Arrays.asList(namGCol, numGCol, descGCol));
    gMainTable.setMinHeight(512);
    gMainTable.setMinWidth(734);
    gMainTable.setRowFactory(rowGFactory);
    TableColumn<DipDacBiet, String> namSCol = Utils.createColumn("Năm", "nam");
    namSCol.setMaxWidth(70);
    namSCol.setMinWidth(70);
    TableColumn<DipDacBiet, String> numSCol = Utils.createColumn("Chưa trao thưởng", "soNguoiChuaTraoThuong");
    numSCol.setMaxWidth(180);
    numSCol.setMinWidth(180);
    TableColumn<DipDacBiet, String> descSCol = Utils.createColumn("Mô tả", "moTa");
    TableColumn<DipDacBiet, String> tenSCol = Utils.createColumn("Tên dịp", "ten");
    tenSCol.setMinWidth(180);
    tenSCol.setMaxWidth(180);
    sMainTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    sMainTable.getColumns().addAll(Arrays.asList(tenSCol, namSCol, numSCol, descSCol));
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
    detailBtn.getChildren().addAll(listBtn, saveBtn, returnBtn);
    title.setText("Thêm phần thưởng HSG");
    nameLabel.setVisible(false);
    nameField.setVisible(false);
    present1Label.setText("Phần quà đặc biệt:");
    present2Label.setText("Phần quà HSG:");
    present3Label.setText("Phần quà HS Khá:");
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
      confirmPane.setVisible(true);
      confirmLabel.setText("Xác nhận thêm phần thưởng");
      confirmBtn.setOnAction(aee -> {
        DipHSG hsg = new DipHSG(0, Integer.parseInt(s1), s8, s2, s4, s6, Float.parseFloat(s3), Float.parseFloat(s5),
            Float.parseFloat(s7));
        TraoThuongHSGManage.themDipHSG(hsg);
        confirmPane.setVisible(false);
        detailPane.setVisible(false);
      });
      cancelBtn.setOnAction(aee -> confirmPane.setVisible(false));
    });
    returnBtn.setText("Huỷ");
    returnBtn.setOnAction(ae -> {
      detailPane.setVisible(false);
      Utils.clearTextInput(detailPane);
    });
  }

  private void openSAdd(ActionEvent e) {
    detailPane.setVisible(true);
    detailBtn.getChildren().clear();
    detailBtn.getChildren().addAll(listBtn, saveBtn, returnBtn);
    title.setText("Thêm phần thưởng dịp đặc biệt");
    nameLabel.setVisible(true);
    nameField.setVisible(true);
    present1Label.setText("Độ tuổi 0-5 tuổi:");
    present2Label.setText("Độ tuổi 6-14 tuổi:");
    present3Label.setText("Độ tuổi 15-17 tuổi:");
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
      confirmPane.setVisible(true);
      confirmLabel.setText("Xác nhận thêm phần thưởng");
      confirmBtn.setOnAction(aee -> {
        DipDacBiet ddb = new DipDacBiet(0, s8, Integer.parseInt(s1), s9, s2, s4, s6, Float.parseFloat(s3),
            Float.parseFloat(s5), Float.parseFloat(s7));
        TraoThuongDacBietManage.themDipDacBiet(ddb);
        confirmPane.setVisible(false);
        detailPane.setVisible(false);
        Utils.clearTextInput(detailPane);
      });
      cancelBtn.setOnAction(aee -> confirmPane.setVisible(false));
    });
    returnBtn.setText("Huỷ");
    returnBtn.setOnAction(ae -> {
      detailPane.setVisible(false);
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
    descField.getStyleClass().add("textDisabled");
    yearField.getStyleClass().add("textDisabled");
    present1Field.getStyleClass().add("textDisabled");
    present2Field.getStyleClass().add("textDisabled");
    present3Field.getStyleClass().add("textDisabled");
    money1Field.getStyleClass().add("textDisabled");
    money2Field.getStyleClass().add("textDisabled");
    money3Field.getStyleClass().add("textDisabled");
    editBtn.setOnAction(aee -> {
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
        confirmPane.setVisible(true);
        confirmLabel.setText("Lưu thay đổi");
        confirmBtn.setOnAction(aeee -> {
          int s1 = Integer.parseInt(yearField.getText());
          String s2 = present1Field.getText();
          float s3 = Float.parseFloat(money1Field.getText());
          String s4 = present2Field.getText();
          float s5 = Float.parseFloat(money2Field.getText());
          String s6 = present3Field.getText();
          float s7 = Float.parseFloat(money3Field.getText());
          String s9 = descField.getText();
          final DipHSG hsg = new DipHSG(selectedG.getIdDip(), s1, s9, s2, s4, s6, s3, s5, s7);
          TraoThuongHSGManage.capNhatDipHSG(hsg);
          confirmPane.setVisible(false);
          detailPane.setVisible(false);
        });
        cancelBtn.setOnAction(aeee -> {
          confirmPane.setVisible(false);
        });
      });
      returnBtn.setOnAction(ae -> {
        yearField.setEditable(false);
        present1Field.setEditable(false);
        present2Field.setEditable(false);
        present3Field.setEditable(false);
        money1Field.setEditable(false);
        money2Field.setEditable(false);
        money3Field.setEditable(false);
        descField.setEditable(false);
        descField.getStyleClass().add("textDisabled");
        yearField.getStyleClass().add("textDisabled");
        present1Field.getStyleClass().add("textDisabled");
        present2Field.getStyleClass().add("textDisabled");
        present3Field.getStyleClass().add("textDisabled");
        money1Field.getStyleClass().add("textDisabled");
        money2Field.getStyleClass().add("textDisabled");
        money3Field.getStyleClass().add("textDisabled");
        listBtn.setOnAction(ee -> openGList(ee));
        returnBtn.setOnAction(ee -> {
          detailPane.setVisible(false);
          Utils.clearTextInput(detailPane);
        });
      });
      listBtn.setOnAction(ae -> openEditGList(ae));
    });
    listBtn.setOnAction(aee -> openGList(aee));
    returnBtn.setOnAction(aee -> {
      detailPane.setVisible(false);
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
    descField.getStyleClass().add("textDisabled");
    yearField.getStyleClass().add("textDisabled");
    present1Field.getStyleClass().add("textDisabled");
    present2Field.getStyleClass().add("textDisabled");
    present3Field.getStyleClass().add("textDisabled");
    money1Field.getStyleClass().add("textDisabled");
    money2Field.getStyleClass().add("textDisabled");
    money3Field.getStyleClass().add("textDisabled");
    nameField.getStyleClass().add("textDisabled");
    editBtn.setOnAction(aee -> {
      detailBtn.getChildren().clear();
      detailBtn.getChildren().addAll(listBtn, saveBtn, deleteBtn, returnBtn);
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
        confirmPane.setVisible(true);
        confirmLabel.setText("Lưu thay đổi");
        confirmBtn.setOnAction(aeee -> {
          int s1 = Integer.parseInt(yearField.getText());
          String s2 = present1Field.getText();
          float s3 = Float.parseFloat(money1Field.getText());
          String s4 = present2Field.getText();
          float s5 = Float.parseFloat(money2Field.getText());
          String s6 = present3Field.getText();
          float s7 = Float.parseFloat(money3Field.getText());
          String s8 = nameField.getText();
          String s9 = descField.getText();
          final DipDacBiet ddb = new DipDacBiet(selectedS.getIdDip(), s8, s1, s9, s2, s4, s6, s3, s5, s7);
          TraoThuongDacBietManage.capNhatDipDacBiet(ddb);
          confirmPane.setVisible(false);
          detailPane.setVisible(false);
          Utils.clearTextInput(detailPane);
        });
        cancelBtn.setOnAction(aeee -> {
          confirmPane.setVisible(false);
        });
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
        descField.getStyleClass().add("textDisabled");
        yearField.getStyleClass().add("textDisabled");
        present1Field.getStyleClass().add("textDisabled");
        present2Field.getStyleClass().add("textDisabled");
        present3Field.getStyleClass().add("textDisabled");
        money1Field.getStyleClass().add("textDisabled");
        money2Field.getStyleClass().add("textDisabled");
        money3Field.getStyleClass().add("textDisabled");
        nameField.getStyleClass().add("textDisabled");
        listBtn.setOnAction(ee -> openSList(ee));
        Utils.clearTextInput(detailPane);
        returnBtn.setOnAction(ee -> {
          Utils.clearTextInput(detailPane);
          detailPane.setVisible(false);
        });
      });
      listBtn.setOnAction(ae -> openEditSList(ae));
    });
    listBtn.setOnAction(aee -> openSList(aee));
    Utils.clearTextInput(detailPane);
    returnBtn.setOnAction(aee -> {
      Utils.clearTextInput(detailPane);
      detailPane.setVisible(false);
    });
  }

  private void openSList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(true);
    editListSBox.setVisible(false);
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
        s.set(NHOM[nhom]);
        return s;
      }
    });
    TableColumn<ChiTietDipDacBiet, String> ktraCol = new TableColumn<>("Đã nhận ?");
    ktraCol.setCellValueFactory(
        new Callback<TableColumn.CellDataFeatures<ChiTietDipDacBiet, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipDacBiet, String> p) {
            boolean ktra = p.getValue().getKiemtra();
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set(ktra ? "Đã nhận" : "Chưa nhận");
            return s;
          }
        });
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
        for (nhom = 0; nhom < 3; nhom++) {
          if (NHOM[nhom].equals(n))
            break;
        }
        ChiTietDipDacBiet newS = new ChiTietDipDacBiet(selectedS.getIdDip(), selectedAddNK.getID(), nhom);
        addedSList.add(newS);
        sTable.getItems().add(newS);
        addNameField.setText("");
        addLField.setText("");
        addSField.setText("");
      });

      editListSaveBtn.setOnAction(aeee -> {
        listConfirmPane.setVisible(true);
        listConfirmBtn.setOnAction(aeeee -> {
          for (int i = 0; i < addedSList.size(); i++) {
            TraoThuongDacBietManage.themNhanKhauDuocNhanThuong(addedSList.get(i));
          }
          listConfirmPane.setVisible(false);
          addedSList.clear();
          editListSBox.setVisible(false);
          getSNKList();
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
    TableColumn<ChiTietDipHocSinhGioi, String> ktraCol = new TableColumn<>("Đã nhận ?");
    ktraCol.setCellValueFactory(
        new Callback<TableColumn.CellDataFeatures<ChiTietDipHocSinhGioi, String>, ObservableValue<String>>() {
          public ObservableValue<String> call(CellDataFeatures<ChiTietDipHocSinhGioi, String> p) {
            boolean ktra = p.getValue().getKiemtra();
            ObjectProperty<String> s = new SimpleObjectProperty<>();
            s.set(ktra ? "Đã nhận" : "Chưa nhận");
            return s;
          }
        });
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
        for (nhom = 0; nhom < 3; nhom++) {
          if (NHOM[nhom].equals(n))
            break;
        }
        ChiTietDipHocSinhGioi newG = new ChiTietDipHocSinhGioi(selectedG.getIdDip(), selectedAddNK.getID(), t, l, nhom);
        addedGList.add(newG);
        gTable.getItems().add(newG);
        addNameField.setText("");
        addLField.setText("");
        addSField.setText("");
      });

      editListSaveBtn.setOnAction(aeee -> {
        listConfirmPane.setVisible(true);
        listConfirmBtn.setOnAction(aeeee -> {
          for (int i = 0; i < addedGList.size(); i++) {
            TraoThuongHSGManage.themNhanKhauDuocNhanThuong(addedGList.get(i));
          }
          listConfirmPane.setVisible(false);
          addedGList.clear();
          editListSBox.setVisible(false);
          getGNKList();
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

  private void openEditSList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(false);
    editListSBox.setVisible(true);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
  }

  private void openEditGList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(false);
    editListSBox.setVisible(true);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
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