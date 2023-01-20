package com.lele.cnpm.src.services;

import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import com.lele.cnpm.database.modify.ChuyenNhanKhauModify;
import com.lele.cnpm.database.modify.HoKhauNhanKhauModify;
import com.lele.cnpm.database.modify.KhaiTuModify;
import com.lele.cnpm.database.modify.NhanKhauModify;
import com.lele.cnpm.database.modify.TamTruModify;
import com.lele.cnpm.database.modify.TamVangModify;
import com.lele.cnpm.src.models.ChuyenNhanKhau;
import com.lele.cnpm.src.models.KhaiTu;
import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.models.TamTru;
import com.lele.cnpm.src.models.TamVang;
import com.lele.cnpm.src.services.ExcelWork.DocNhanKhauExcel;
import com.lele.cnpm.src.services.ExcelWork.InNhanKhauExcel;

public class NhanKhauManage extends NhanKhauModify {

  /**
   * Chuyển nhân khẩu đi
   * 
   * @param cnk
   * @return true/false
   */
  public static boolean chuyenNhanKhau(ChuyenNhanKhau cnk) {
    try {
      NhanKhau nk = layNhanKhau(cnk.getIdNhanKhau());
      nk.setTrangThai("Đã chuyển đi");
      capNhatNhanKhau(nk);
      HoKhauNhanKhauModify.xoaNhanKhau(nk);
      ChuyenNhanKhauModify.themChuyenNhanKhau(cnk);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Khai tử một nhân khẩu
   * 
   * @param kt
   * @return true/false
   */
  public static boolean khaiTu(KhaiTu kt) {
    try {
      KhaiTuModify.themKhaiTu(kt);
      NhanKhau nk = layNhanKhau(kt.getIdNguoiMat());
      nk.setTrangThai("Đã mất");
      capNhatNhanKhau(nk);
      HoKhauNhanKhauModify.xoaNhanKhau(nk);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Khai báo tạm trú
   * 
   * @param tt
   * @return true/false
   */
  public static boolean themTamTru(TamTru tt) {
    try {
      NhanKhau nk = layNhanKhau(tt.getIdNhanKhau());
      nk.setTrangThai("Tạm trú");
      capNhatNhanKhau(nk);
      TamTruModify.themTamTru(tt);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Khai báo tạm vắng
   * 
   * @param tv
   * @return true/false
   */
  public static boolean themTamVang(TamVang tv) {
    try {
      NhanKhau nk = layNhanKhau(tv.getIdNhanKhau());
      nk.setTrangThai("Tạm vắng");
      capNhatNhanKhau(nk);
      TamVangModify.themTamVang(tv);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Thêm list nhân khẩu trong file excel vào database
   * 
   * @param xlsxFilePath
   * @return true/false
   */
  public static boolean themNhanKhauFileExcel(String xlsxFilePath) {
    try {
      ArrayList<NhanKhau> nhanKhaus = DocNhanKhauExcel.readExcel(xlsxFilePath);
      for (NhanKhau nk : nhanKhaus)
        themNhanKhau(nk);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * đường dẫn mặc định
   */
  public static final String xlsxDefaultInputPath = "./NhanKhauInput.xlsx";

  /**
   * Thêm list nhân khẩu trong file excel mặc định vào database
   * 
   * @return true/false
   */
  public static boolean themNhanKhauFileExcel() {
    try {
      ArrayList<NhanKhau> nhanKhaus = DocNhanKhauExcel.readExcel(xlsxDefaultInputPath);
      nhapDuLieuNhanKhau(nhanKhaus);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * In list nhân khẩu ra file Excel và mở file đó
   * 
   * @param nhanKhaus
   * @return true/false
   */
  public static boolean inListNhanKhauRaFileExcel(ArrayList<NhanKhau> nhanKhaus) {
    try {
      String excelFilePath = "NhanKhau"+LocalDate.now().toString()+".xlsx";
      InNhanKhauExcel.writeExcel(nhanKhaus, excelFilePath);
      File file = new File(excelFilePath);
      Desktop dt = Desktop.getDesktop();
      dt.open(file);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // String excelFilePath;
  //     JFileChooser c = new JFileChooser();
  //     FileFilter xlsFilter = new FileTypeFilter(".xlsx", "Microsoft Excel Documents");
  //     c.addChoosableFileFilter(xlsFilter);

  //     int rVal = c.showSaveDialog(null);

  //     if (rVal == JFileChooser.APPROVE_OPTION) {
  //       String filename = c.getSelectedFile().getName();
  //       String dir = c.getCurrentDirectory().toString();

  //       excelFilePath = dir + "\\" + filename;
  //       if (!excelFilePath.contains(".xlsx")) excelFilePath+=".xlsx";

  //       InNhanKhauExcel.writeExcel(nhanKhaus, excelFilePath);
  //       File file = new File(excelFilePath);
  //       Desktop dt = Desktop.getDesktop();
  //       dt.open(file);
  //       return true;
  //     } else if (rVal == JFileChooser.ERROR_OPTION || rVal == JFileChooser.CANCEL_OPTION) {
  //       c.cancelSelection();
  //       return false;
  //     }
  //     return false;
  //     String excelFilePath = "NhanKhau"+LocalDate.now().toString()+".xlsx";
  //     InNhanKhauExcel.writeExcel(nhanKhaus, excelFilePath);
  //     File file = new File(excelFilePath);
  //     Desktop dt = Desktop.getDesktop();
  //     dt.open(file);
  //     return true;

   /**
   * @return một mảng res[6] với res[i] là số nhân khẩu nhóm i
   */
  public static int[] countNhanKhauTheoTuoi() {
    int[] res = new int[6];
      for (int i = 0; i < 6; i++)
        res[i] = 0;
      ArrayList<NhanKhau> nhanKhaus = layListNhanKhauTrongDiaBan();
      for (NhanKhau nk : nhanKhaus) {
        res[nk.getNhom()]++;
      }
    return res;
  }

  /**
   * @param nhom
   * @return List nhân khẩu thuộc nhóm
    * nhóm 0: mầm non mẫu giáo
    * nhóm 1: cấp 1
    * nhóm 2: cấp 2
    * nhóm 3: cấp 3
    * nhóm 4: tuổi lao động
    * nhóm 5: đã nghỉ hưu
   */
  public static ArrayList<NhanKhau> layNhanKhauTheoNhom(int nhom) {
    ArrayList<NhanKhau> nhanKhaus = layListNhanKhauTrongDiaBan();
    ArrayList<NhanKhau> res = new ArrayList<>();
    for (NhanKhau nk : nhanKhaus) {
      if (nk.getNhom() == nhom) 
        res.add(nk);
    }
    return res;
  }

  public static ArrayList<ChuyenNhanKhau> xemLichSuChuyenNhanKhaus() {
    return ChuyenNhanKhauModify.layListChuyenNhanKhau();
  }
}
