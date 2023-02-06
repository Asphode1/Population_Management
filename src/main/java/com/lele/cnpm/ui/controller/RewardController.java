package com.lele.cnpm.ui.controller;

import java.util.ArrayList;
import java.util.Arrays;

import com.lele.cnpm.src.models.DipDacBiet;
import com.lele.cnpm.src.models.DipHSG;
import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.services.TraoThuongDacBietManage;
import com.lele.cnpm.src.services.TraoThuongHSGManage;
import com.lele.cnpm.src.utils.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
  private Button editBtn;
  @FXML
  private Button saveBtn;
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
  private VBox listBox;
  @FXML
  private VBox editListBox;
  @FXML
  private HBox listBtnBox;
  @FXML
  private HBox editListBtnBox;

  TableView<DipDacBiet> sTable = new TableView<>();
  TableView<DipHSG> gTable = new TableView<>();
  ArrayList<DipDacBiet> sList = new ArrayList<>();
  ArrayList<DipHSG> gList = new ArrayList<>();
  DipDacBiet selectedS = null;
  DipHSG selectedG = null;

  TableView<NhanKhau> gnkTable = new TableView<>();
  TableView<NhanKhau> snkTable = new TableView<>();
  ArrayList<NhanKhau> gnkList = new ArrayList<>();
  ArrayList<NhanKhau> snkList = new ArrayList<>();
  TableView<NhanKhau> totalTable = new TableView<>();
  ArrayList<NhanKhau> totalNK = new ArrayList<>();

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
    gTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    gTable.getColumns().addAll(Arrays.asList(namGCol, numGCol, descGCol));
    gTable.setMinHeight(512);
    gTable.setMinWidth(734);
    gTable.setRowFactory(rowGFactory);
    TableColumn<DipDacBiet, String> namSCol = Utils.createColumn("Năm", "nam");
    namSCol.setMaxWidth(70);
    namSCol.setMinWidth(70);
    TableColumn<DipDacBiet, String> numSCol = Utils.createColumn("Chưa trao thưởng", "soNguoiChuaTraoThuong");
    numSCol.setMaxWidth(180);
    numSCol.setMinWidth(180);
    TableColumn<DipDacBiet, String> descSCol = Utils.createColumn("Mô tả", "moTa");
    TableColumn<DipDacBiet, String> tenSCol = Utils.createColumn("Tên dịp", "ten");
    tenSCol.setMaxWidth(180);
    sTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    sTable.getColumns().addAll(Arrays.asList(tenSCol, namSCol, numSCol, descSCol));
    sTable.setMinHeight(512);
    sTable.setMinWidth(734);
    sTable.setRowFactory(rowSFactory);
    getGList();
    mainTablePane.getChildren().clear();
    mainTablePane.getChildren().add(gTable);
    selectHSGBtn.setOnAction(e -> {
      if (!selectHSGBtn.getStyleClass().contains("btnOnFocus")) {
        getGList();
        selectHSGBtn.getStyleClass().add("btnOnFocus");
        selectSPCBtn.getStyleClass().remove("btnOnFocus");
        mainTablePane.getChildren().clear();
        mainTablePane.getChildren().add(gTable);
      }
    });
    selectSPCBtn.setOnAction(e -> {
      if (!selectSPCBtn.getStyleClass().contains("btnOnFocus")) {
        getSList();
        selectSPCBtn.getStyleClass().add("btnOnFocus");
        selectHSGBtn.getStyleClass().remove("btnOnFocus");
        mainTablePane.getChildren().clear();
        mainTablePane.getChildren().add(sTable);
      }
    });
    goodBtn.setOnAction(e -> openGAdd(e));
    specialBtn.setOnAction(e -> openSAdd(e));
  }

  private void getGList() {
    gList = TraoThuongHSGManage.layListDipHSG();
    gTable.getItems().clear();
    ObservableList<DipHSG> list = FXCollections.observableArrayList(gList);
    gTable.setItems(list);
  }

  private void getSList() {
    sList = TraoThuongDacBietManage.layListDipDacBiet();
    sTable.getItems().clear();
    ObservableList<DipDacBiet> list = FXCollections.observableArrayList(sList);
    sTable.setItems(list);
  }

  private void openGAdd(ActionEvent e) {
    detailPane.setVisible(true);
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
    editBtn.setVisible(false);
    saveBtn.setVisible(true);
    listBtn.setVisible(false);
    listBtn.setPrefWidth(0);
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
      listBtn.setVisible(true);
      listBtn.setPrefWidth(200);
      detailPane.setVisible(false);
      Utils.clearTextInput(detailPane);
    });
  }

  private void openSAdd(ActionEvent e) {
    detailPane.setVisible(true);
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
    editBtn.setVisible(false);
    saveBtn.setVisible(true);
    listBtn.setVisible(false);
    listBtn.setPrefWidth(0);
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
      listBtn.setVisible(true);
      listBtn.setPrefWidth(200);
      detailPane.setVisible(false);
      Utils.clearTextInput(detailPane);
    });
  }

  private void openGInfo(MouseEvent e) {
    title.setText("Thông tin Phần thưởng");
    detailPane.setVisible(true);
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
    editBtn.setVisible(true);
    saveBtn.setVisible(false);
    editBtn.setOnAction(aee -> {
      editBtn.setVisible(false);
      saveBtn.setVisible(true);
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
        saveBtn.setVisible(false);
        editBtn.setVisible(true);
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
    editBtn.setVisible(true);
    saveBtn.setVisible(false);
    editBtn.setOnAction(aee -> {
      editBtn.setVisible(false);
      saveBtn.setVisible(true);
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
        editBtn.setVisible(true);
        saveBtn.setVisible(false);
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
    editListBox.setVisible(false);
    TableColumn<NhanKhau, String> nameCol = Utils.createColumn("Họ Tên", "hoTen");
    snkTable.getColumns().add(nameCol);
    getSNKList();
    snkTable.setPrefHeight(516);
    snkTable.setPrefWidth(678);
    listBox.getChildren().clear();
    listBox.getChildren().addAll(snkTable, listBtnBox);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
  }

  private void openGList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(true);
    editListBox.setVisible(false);
    TableColumn<NhanKhau, String> nameCol = Utils.createColumn("Họ Tên", "hoTen");
    gnkTable.getColumns().add(nameCol);
    getGNKList();
    gnkTable.setPrefHeight(516);
    gnkTable.setPrefWidth(678);
    listBox.getChildren().clear();
    listBox.getChildren().addAll(gnkTable, listBtnBox);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
  }

  private void openEditSList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(false);
    editListBox.setVisible(true);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
  }

  private void openEditGList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(false);
    editListBox.setVisible(true);
    listReturnBtn.setOnAction(aee -> {
      listPane.setVisible(false);
    });
  }

  private void getGNKList() {
    gnkList = TraoThuongHSGManage.layNhanKhauDuocTraoThuong(selectedG);
    gnkTable.getItems().clear();
    ObservableList<NhanKhau> list = FXCollections.observableArrayList(gnkList);
    gnkTable.setItems(list);
  }

  private void getSNKList() {
    snkList = TraoThuongDacBietManage.layNhanKhauDuocTraoThuong(selectedS);
    snkTable.getItems().clear();
    ObservableList<NhanKhau> list = FXCollections.observableArrayList(snkList);
    snkTable.setItems(list);
  }
}