package com.lele.cnpm.src.services;

import java.util.ArrayList;

import com.lele.cnpm.database.modify.ChiTietDipHocSinhGioiModify;
import com.lele.cnpm.database.modify.DipHSGModify;
import com.lele.cnpm.src.models.*;

public class TraoThuongHSGManage extends DipHSGModify{
    
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
}
