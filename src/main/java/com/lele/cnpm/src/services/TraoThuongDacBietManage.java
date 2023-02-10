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

  public static boolean themToanBoHocSinh(int idDip) {
    ArrayList<NhanKhau> hocSinhs = NhanKhauManage.layListHocSinh();
    for (NhanKhau hs: hocSinhs) {
      int tuoi = hs.getTuoi();
      int nhom = 0;
        if (0 <= tuoi && tuoi <= 5) nhom = 1; 
        else if (6 <= tuoi && tuoi <= 14) nhom = 2;
        else if (15 <= tuoi && tuoi <= 17) nhom = 3; 
      if (nhom!=0) {
        ChiTietDipDacBiet ct = new ChiTietDipDacBiet(idDip, hs.getID(), nhom);
        themNhanKhauDuocNhanThuong(ct);
      }
    }
    return true;
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

  public static float tongTienCanTrao(DipDacBiet ddb) {
    ArrayList<ChiTietDipDacBiet> cts = ChiTietDipDacBietModify.layListChiTietDipDacBiet(ddb.getId());
    float res = 0;
    for(ChiTietDipDacBiet ct : cts) {
      if(ct.getNhom() == 1) res += ddb.getTien05();
      else if(ct.getNhom() == 2) res += ddb.getTien614();
      else if(ct.getNhom() == 3) res += ddb.getTien1517();
    }
    return res;
  }

  public static float tongTienDaTrao(DipDacBiet ddb) {
    ArrayList<ChiTietDipDacBiet> cts = ChiTietDipDacBietModify.layListChiTietDipDacBiet(ddb.getId());
    float res = 0;
    for(ChiTietDipDacBiet ct : cts) {
      if (ct.getKiemTra()) {
        if(ct.getNhom() == 1) res += ddb.getTien05();
        else if(ct.getNhom() == 2) res += ddb.getTien614();
        else if(ct.getNhom() == 3) res += ddb.getTien1517();
      }
    }
    return res;
  }
}
