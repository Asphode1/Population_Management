package com.lele.cnpm.src.services;

import java.util.ArrayList;

import com.lele.cnpm.database.modify.ChiTietDipHocSinhGioiModify;
import com.lele.cnpm.database.modify.DipHSGModify;
import com.lele.cnpm.src.models.*;

public class TraoThuongHSGManage extends DipHSGModify {

  /**
   * @param dip
   * @return Toàn bộ nhân khẩu được trao thưởng trong dịp
   */
  public static ArrayList<NhanKhau> layNhanKhauDuocTraoThuong(DipHSG dip) {
    try {
      return ChiTietDipHocSinhGioiModify.layListNhanKhau(dip.getIdDip());
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Thêm nhân khẩu được nhận thưởng trong chi tiết
   * @param ct
   * @return true/false
   */
  public static boolean themNhanKhauDuocNhanThuong(ChiTietDipHocSinhGioi ct) {
    try {
      return ChiTietDipHocSinhGioiModify.themChiTietDipHocSinhGioi(ct);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Xác nhận trao thưởng một nhân khẩu
   * @param ct
   * @return true/false
   */
  public static boolean xacNhanDaTraoThuong(ChiTietDipHocSinhGioi ct) {
    ct.setKiemtra(true);
    ChiTietDipHocSinhGioiModify.capNhatChiTietDipHocSinhGioi(ct);
    return true;
  }

  /**
   * Xác nhận chưa trao thưởng một nhân khẩu
   * @param ct
   * @return true/false
   */
  public static boolean xacNhanChuaTraoThuong(ChiTietDipHocSinhGioi ct) {
    ct.setKiemtra(false);
    ChiTietDipHocSinhGioiModify.capNhatChiTietDipHocSinhGioi(ct);
    return true;
  }

  public static boolean xoaChiTietHSG(ChiTietDipHocSinhGioi cthsg) {
    return ChiTietDipHocSinhGioiModify.xoaChiTietDipHocSinhGioi(cthsg);
  }

  public static ArrayList<ChiTietDipHocSinhGioi> layListChiTietDipHocSinhGioi(int idDip) {
    return ChiTietDipHocSinhGioiModify.layListChiTietDipHocSinhGioi(idDip);
  }
  
  public static float tongTienCanTrao(DipHSG dhsg) {
    ArrayList<ChiTietDipHocSinhGioi> cts = ChiTietDipHocSinhGioiModify.layListChiTietDipHocSinhGioi(dhsg.getId());
    float res = 0;
    for(ChiTietDipHocSinhGioi ct : cts) {
      if(ct.getNhom() == 1) res += ddb.getTienDacBiet();
      else if(ct.getNhom() == 2) res += ddb.getTienGioi();
      else if(ct.getNhom() == 3) res += ddb.getTienKha();
    }
    return res;
  }

  public static float tongTienCanTrao(DipHSG dhsg) {
    ArrayList<ChiTietDipHocSinhGioi> cts = ChiTietDipHocSinhGioiModify.layListChiTietDipHocSinhGioi(dhsg.getId());
    float res = 0;
    for(ChiTietDipHocSinhGioi ct : cts) {
      if(ct.getKiemTra()) {
        if(ct.getNhom() == 1) res += ddb.getTienDacBiet();
        else if(ct.getNhom() == 2) res += ddb.getTienGioi();
        else if(ct.getNhom() == 3) res += ddb.getTienKha();
      }
    }
    return res;
  }
}
