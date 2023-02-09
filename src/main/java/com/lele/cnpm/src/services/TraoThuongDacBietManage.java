package com.lele.cnpm.src.services;

import java.util.ArrayList;

import com.lele.cnpm.database.modify.ChiTietDipDacBietModify;
import com.lele.cnpm.database.modify.DipDacBietModify;
import com.lele.cnpm.src.models.*;

public class TraoThuongDacBietManage extends DipDacBietModify {
  /**
   * @param dip
   * @return list nhân khẩu được trao thưởng
   */
  public static ArrayList<NhanKhau> layNhanKhauDuocTraoThuong(DipDacBiet dip) {
    try {
      return ChiTietDipDacBietModify.layListNhanKhau(dip.getIdDip());
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Thêm nhân khẩu được nhận thưởng từ chi tiết
   * @param ct
   * @return true/false
   */
  public static boolean themNhanKhauDuocNhanThuong(ChiTietDipDacBiet ct) {
    return ChiTietDipDacBietModify.themChiTietDipDacBiet(ct);
  }

  /**
   * Xác nhận một chi tiết dịp đặc biệt đã trao thưởng
   * @param ct
   * @return true, false
   */
  public static boolean xacNhanDaTraoThuong(ChiTietDipDacBiet ct) {
    ct.setKiemtra(true);
    ChiTietDipDacBietModify.capNhatChiTietDipDacBiet(ct);
    return true;
  }

  /**
   * Xác nhận một chi tiết dịp đặc biệt đã trao thưởng
   * @param ct
   * @return true, false
   */
  public static boolean xacNhanChuaTraoThuong(ChiTietDipDacBiet ct) {
    try {
      ct.setKiemtra(false);
      ChiTietDipDacBietModify.capNhatChiTietDipDacBiet(ct);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean xoaChiTietDipDacBiet(ChiTietDipDacBiet ctddb) {
    return ChiTietDipDacBietModify.xoaChiTietDipDacBiet(ctddb);
  }

  public static ArrayList<ChiTietDipDacBiet> layListChiTietDipDacBiet(int id) {
    return ChiTietDipDacBietModify.layListChiTietDipDacBiet(id);
  }
}
