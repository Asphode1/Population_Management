package com.lele.cnpm.ui.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.lele.cnpm.database.modify.TamTruModify;
import com.lele.cnpm.database.modify.TamVangModify;
import com.lele.cnpm.src.models.NguoiDung;
import com.lele.cnpm.src.services.HoKhauManage;
import com.lele.cnpm.src.services.NhanKhauManage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DashboardController {
  private NguoiDung user;
  @FXML
  private Label dateLabel;
  @FXML
  private Label nkLabel;
  @FXML
  private Label hkLabel;
  @FXML
  private Label ttLabel;
  @FXML
  private Label tvLabel;

  @FXML
  private Pane dGenPane;
  @FXML
  private Pane dAgePane;

  @FXML
  private VBox dashboard;

  public void setUser(NguoiDung usr) {
    user = usr;
  }

  public void initialize() {
    Calendar c = Calendar.getInstance();
    int[] ages = NhanKhauManage.countNhanKhauTheoTuoi();
    String[] ageGroup = { "0-5", "6-10", "11-14", "15-17", "18-65", ">65" };
    int nam = NhanKhauManage.countNhanKhauNam();
    int nu = NhanKhauManage.countNhanKhauNu();
    dateLabel.setText("Ngày " + c.get(Calendar.DAY_OF_MONTH) + " tháng " + (c.get(Calendar.MONTH) + 1) + " năm "
        + c.get(Calendar.YEAR));
    nkLabel.setText("" + NhanKhauManage.countNhanKhau());
    hkLabel.setText("" + HoKhauManage.countHoKhau());
    ttLabel.setText("" + TamTruModify.countTamTru());
    tvLabel.setText("" + TamVangModify.countTamVang());
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    yAxis.setTickUnit(20);
    final BarChart<String, Number> genChart = new BarChart<String, Number>(xAxis, yAxis);
    XYChart.Series<String, Number> serie = new XYChart.Series<>();
    genChart.setAnimated(false);
    serie.getData().add(new XYChart.Data<>("Nam", nam));
    serie.getData().add(new XYChart.Data<>("Nữ", nu));
    genChart.getData().add(serie);
    genChart.setMaxHeight(300);
    genChart.setMaxWidth(500);
    genChart.setCategoryGap(150);
    genChart.setLegendVisible(false);
    dGenPane.getChildren().clear();
    dGenPane.getChildren().add(genChart);
    ArrayList<PieChart.Data> data = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      data.add(new PieChart.Data(ageGroup[i], ages[i]));
    }
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(data);
    final PieChart ageChart = new PieChart(pieChartData);
    ageChart.setAnimated(false);
    ageChart.setMaxHeight(300);
    ageChart.setMaxWidth(500);
    ageChart.setLabelLineLength(10);
    ageChart.setLegendSide(Side.RIGHT);
    dAgePane.getChildren().clear();
    dAgePane.getChildren().add(ageChart);

    dashboard.visibleProperty().addListener((o, ov, nv) -> {
      if (nv) {
        final Calendar cc = Calendar.getInstance();
        final int[] aages = NhanKhauManage.countNhanKhauTheoTuoi();
        final int nnam = NhanKhauManage.countNhanKhauNam();
        final int nnu = NhanKhauManage.countNhanKhauNu();
        dateLabel.setText("Ngày " + cc.get(Calendar.DAY_OF_MONTH) + " tháng " + (cc.get(Calendar.MONTH) + 1) + " năm "
            + cc.get(Calendar.YEAR));
        nkLabel.setText("" + NhanKhauManage.countNhanKhau());
        hkLabel.setText("" + HoKhauManage.countHoKhau());
        ttLabel.setText("" + TamTruModify.countTamTru());
        tvLabel.setText("" + TamVangModify.countTamVang());
        serie.getData().clear();
        serie.getData().add(new XYChart.Data<>("Nam", nnam));
        serie.getData().add(new XYChart.Data<>("Nữ", nnu));
        ArrayList<PieChart.Data> ddata = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
          ddata.add(new PieChart.Data(ageGroup[i], aages[i]));
        }
        ageChart.getData().clear();
        ageChart.getData().addAll(FXCollections.observableArrayList(ddata));
      }
    });
  }
}
