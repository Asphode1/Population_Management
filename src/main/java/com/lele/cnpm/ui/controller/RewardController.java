package com.lele.cnpm.ui.controller;

import java.util.ArrayList;
import java.util.Arrays;

import com.lele.cnpm.src.models.DipDacBiet;
import com.lele.cnpm.src.models.DipHSG;
import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.services.TraoThuongDacBietManage;
import com.lele.cnpm.src.services.TraoThuongHSGManage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
  private TextField descField;

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
  private Button returnBtn;
  @FXML
  private Button listReturnBtn;
  @FXML
  private Button editListReturnBtn;
  @FXML
  private Button editListSaveBtn;

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
    TableColumn<DipHSG, String> idGCol = new TableColumn<>("ID");
    idGCol.setMaxWidth(50);
    idGCol.setMinWidth(50);
    idGCol.setCellValueFactory(new PropertyValueFactory<>("idDip"));
    TableColumn<DipHSG, String> namGCol = new TableColumn<>("Năm");
    namGCol.setMaxWidth(70);
    namGCol.setMinWidth(70);
    namGCol.setCellValueFactory(new PropertyValueFactory<>("nam"));
    TableColumn<DipHSG, String> numGCol = new TableColumn<>("Số người chưa trao thưởng");
    numGCol.setMaxWidth(240);
    numGCol.setMinWidth(240);
    numGCol.setCellValueFactory(new PropertyValueFactory<>("soNguoiChuaTraoThuong"));
    TableColumn<DipHSG, String> descGCol = new TableColumn<>("Mô tả");
    descGCol.setCellValueFactory(new PropertyValueFactory<>("moTa"));
    gTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    gTable.getColumns().addAll(Arrays.asList(idGCol, namGCol, numGCol, descGCol));
    gTable.setMinHeight(516);
    gTable.setMinWidth(734);
    gTable.setRowFactory(rowGFactory);

    TableColumn<DipDacBiet, String> idSCol = new TableColumn<>("ID");
    idSCol.setMaxWidth(50);
    idSCol.setMinWidth(50);
    idSCol.setCellValueFactory(new PropertyValueFactory<>("idDip"));
    TableColumn<DipDacBiet, String> namSCol = new TableColumn<>("Năm");
    namSCol.setMaxWidth(70);
    namSCol.setMinWidth(70);
    namSCol.setCellValueFactory(new PropertyValueFactory<>("nam"));
    TableColumn<DipDacBiet, String> numSCol = new TableColumn<>("Số người chưa trao thưởng");
    numSCol.setMaxWidth(240);
    numSCol.setMinWidth(240);
    numSCol.setCellValueFactory(new PropertyValueFactory<>("soNguoiChuaTraoThuong"));
    TableColumn<DipDacBiet, String> descSCol = new TableColumn<>("Mô tả");
    descSCol.setCellValueFactory(new PropertyValueFactory<>("moTa"));
    TableColumn<DipDacBiet, String> tenSCol = new TableColumn<>("Tên dịp");
    tenSCol.setMaxWidth(90);
    tenSCol.setMinWidth(90);
    tenSCol.setCellValueFactory(new PropertyValueFactory<>("ten"));
    sTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    sTable.getColumns().addAll(Arrays.asList(idSCol, tenSCol, namSCol, numSCol, descSCol));
    sTable.setMinHeight(516);
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
    descField.setEditable(true);
    editBtn.setText("Lưu");
    editBtn.setOnAction(ae -> {
      String s1 = yearField.getText();
      String s2 = present1Field.getText();
      String s3 = money1Field.getText();
      String s4 = present2Field.getText();
      String s5 = money2Field.getText();
      String s6 = present3Field.getText();
      String s7 = money3Field.getText();
      String s8 = descField.getText();
      DipHSG hsg = new DipHSG(0, Integer.parseInt(s1), s8, s2, s4, s6, Float.parseFloat(s3), Float.parseFloat(s5),
          Float.parseFloat(s7));

    });
    returnBtn.setText("Huỷ");

    returnBtn.setOnAction(ae -> detailPane.setVisible(false));
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
    editBtn.setText("Lưu");
    editBtn.setOnAction(ae -> {
      String s1 = yearField.getText();
      String s2 = present1Field.getText();
      String s3 = money1Field.getText();
      String s4 = present2Field.getText();
      String s5 = money2Field.getText();
      String s6 = present3Field.getText();
      String s7 = money3Field.getText();
      String s8 = nameField.getText();
      String s9 = descField.getText();
      DipDacBiet ddb = new DipDacBiet(0, s8, Integer.parseInt(s1), s9, s2, s4, s6, Float.parseFloat(s3),
          Float.parseFloat(s5), Float.parseFloat(s7));
    });
    returnBtn.setText("Huỷ");
    returnBtn.setOnAction(ae -> detailPane.setVisible(false));
  }

  private void openGInfo(MouseEvent e) {
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

    editBtn.setOnAction(aee -> {
      yearField.setEditable(true);
      present1Field.setEditable(true);
      present2Field.setEditable(true);
      present3Field.setEditable(true);
      money1Field.setEditable(true);
      money2Field.setEditable(true);
      money3Field.setEditable(true);
      descField.setEditable(true);
      yearField.getStyleClass().remove("textDisabled");
      present1Field.getStyleClass().remove("textDisabled");
      present2Field.getStyleClass().remove("textDisabled");
      present3Field.getStyleClass().remove("textDisabled");
      money1Field.getStyleClass().remove("textDisabled");
      money2Field.getStyleClass().remove("textDisabled");
      money3Field.getStyleClass().remove("textDisabled");

      returnBtn.setOnAction(ae -> {
        yearField.setEditable(false);
        present1Field.setEditable(false);
        present2Field.setEditable(false);
        present3Field.setEditable(false);
        money1Field.setEditable(false);
        money2Field.setEditable(false);
        money3Field.setEditable(false);
        descField.setEditable(false);
        yearField.getStyleClass().add("textDisabled");
        present1Field.getStyleClass().add("textDisabled");
        present2Field.getStyleClass().add("textDisabled");
        present3Field.getStyleClass().add("textDisabled");
        money1Field.getStyleClass().add("textDisabled");
        money2Field.getStyleClass().add("textDisabled");
        money3Field.getStyleClass().add("textDisabled");
        listBtn.setOnAction(ee -> openGList(ee));
        returnBtn.setOnAction(ee -> detailPane.setVisible(false));
      });
      listBtn.setOnAction(ae -> openEditGList(ae));
    });
    listBtn.setOnAction(aee -> openGList(aee));
    returnBtn.setOnAction(aee -> detailPane.setVisible(false));
  }

  private void openSInfo(MouseEvent e) {
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

    editBtn.setOnAction(aee -> {
      yearField.setEditable(true);
      present1Field.setEditable(true);
      present2Field.setEditable(true);
      present3Field.setEditable(true);
      money1Field.setEditable(true);
      money2Field.setEditable(true);
      money3Field.setEditable(true);
      descField.setEditable(true);
      yearField.getStyleClass().remove("textDisabled");
      present1Field.getStyleClass().remove("textDisabled");
      present2Field.getStyleClass().remove("textDisabled");
      present3Field.getStyleClass().remove("textDisabled");
      money1Field.getStyleClass().remove("textDisabled");
      money2Field.getStyleClass().remove("textDisabled");
      money3Field.getStyleClass().remove("textDisabled");

      returnBtn.setOnAction(ae -> {
        yearField.setEditable(false);
        present1Field.setEditable(false);
        present2Field.setEditable(false);
        present3Field.setEditable(false);
        money1Field.setEditable(false);
        money2Field.setEditable(false);
        money3Field.setEditable(false);
        descField.setEditable(false);
        yearField.getStyleClass().add("textDisabled");
        present1Field.getStyleClass().add("textDisabled");
        present2Field.getStyleClass().add("textDisabled");
        present3Field.getStyleClass().add("textDisabled");
        money1Field.getStyleClass().add("textDisabled");
        money2Field.getStyleClass().add("textDisabled");
        money3Field.getStyleClass().add("textDisabled");
        listBtn.setOnAction(ee -> openSList(ee));
        returnBtn.setOnAction(ee -> detailPane.setVisible(false));
      });
      listBtn.setOnAction(ae -> openEditSList(ae));
    });
    listBtn.setOnAction(aee -> openSList(aee));
    returnBtn.setOnAction(aee -> detailPane.setVisible(false));
  }

  private void openSList(ActionEvent e) {
    listPane.setVisible(true);
    listBox.setVisible(true);
    editListBox.setVisible(false);

    TableColumn<NhanKhau, String> nameCol = new TableColumn<>("Họ Tên");
    nameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
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
    TableColumn<NhanKhau, String> nameCol = new TableColumn<>("Họ Tên");
    nameCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
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