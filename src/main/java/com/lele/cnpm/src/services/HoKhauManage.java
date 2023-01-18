package com.lele.cnpm.src.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.lele.cnpm.database.modify.ChuyenHoKhauModify;
import com.lele.cnpm.database.modify.HoKhauModify;
import com.lele.cnpm.database.modify.HoKhauNhanKhauModify;
import com.lele.cnpm.database.modify.NhanKhauModify;
import com.lele.cnpm.src.bean.HoKhauBean;
import com.lele.cnpm.src.models.*;

public class HoKhauManage extends HoKhauModify {
    
    /**
     * Thêm một hộ khẩu bean vào database
     * Nhân khẩu đã có trong database
     * @param hkb
     * @return true/false
     */
    public static boolean themHoKhauBean(HoKhauBean hkb) {
        try {
            HoKhau hk = hkb.getHoKhau();
            hk.setIdChuHo(hkb.getChuHo().getID());
            themHoKhau(hk);
            ArrayList<NhanKhau> nhanKhaus = hkb.getListNhanKhaus();
            ArrayList<String> quanHes = hkb.getListQuanHeChuHos();
            int sizeList = nhanKhaus.size();
            for (int i = 0; i < sizeList; i++) {
                HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk, nhanKhaus.get(i), quanHes.get(i));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Thực hiện tách hộ khẩu
     * @param hkCu
     * @param idChuHoMoi
     * @param nhanKhauTach
     * @param quanHeMoi
     * @return true/false
     */
    public static boolean tachHoKhau(HoKhau hkCu, int idChuHoMoi, ArrayList<NhanKhau> nhanKhauTach,
            ArrayList<String> quanHeMoi) {
        try {
            HoKhau hkMoi = new HoKhau(0, idChuHoMoi, hkCu.getTinhThanhPho(),
                    hkCu.getQuanHuyen(), hkCu.getPhuongXa(), hkCu.getDiaChi(), Date.valueOf(LocalDate.now()),
                    "N'Thường trú'");
            //them ho khau moi vao db
            themHoKhau(hkMoi);
            hkMoi = layHoKhau(idChuHoMoi); //cap nhat id Ho Khau tang tu dong trong db
            //cap nhat quan he trong ho khau moi
            int sizeList = nhanKhauTach.size();
            for (int i = 0; i < sizeList; i++) {
                NhanKhau nk = nhanKhauTach.get(i);
                String qh = quanHeMoi.get(i);
                HoKhauNhanKhauModify.capNhatHoKhau_NhanKhau(hkMoi, nk, qh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Chuyển một hộ khẩu đi
     * @param chk
     * @return true/false
     */
    public static boolean chuyenHoKhau(ChuyenHoKhau chk) {
        ChuyenHoKhauModify.themChuyenHoKhau(chk);
        HoKhau hk = layHoKhauTheoIdHoKhau(chk.getIdHoKhau());
        hk.setTrangThai("N'Đã chuyển đi'");
        capNhatHoKhau(hk);
        ArrayList<NhanKhau> nhanKhaus = HoKhauNhanKhauModify.layListNhanKhau(chk.getIdHoKhau());
        for (NhanKhau nk : nhanKhaus) {
            ChuyenNhanKhau cnk = new ChuyenNhanKhau(0, nk.getID(), chk.getNgayChuyenDi(), chk.getNoiChuyenDen(), chk.getGhiChu());
            NhanKhauManage.chuyenNhanKhau(cnk);
        }
        return true;
    }

    /**
     * @param nk
     * @return Hộ khẩu của nhân khẩu
     */
    public static HoKhau layHoKhau(NhanKhau nk) {
        return HoKhauNhanKhauModify.layHoKhau(nk);
    }

    /**
     * @return lịch sử chuyển hộ khẩu
     */
    public static ArrayList<ChuyenHoKhau> xemLichSuChuyenHoKhaus() {
        return ChuyenHoKhauModify.layListChuyenHoKhau();
    }

    /**
     * @param hk
     * @return Thông tin của hộ khẩu này
     */
    public static HoKhauBean layHoKhauBean(HoKhau hk) {
        NhanKhau chuHo = NhanKhauModify.layNhanKhau(hk.getIdChuHo());
        ArrayList<NhanKhau> nhanKhaus = HoKhauNhanKhauModify.layListNhanKhau(hk.getID());
        ArrayList<String> quanHes = HoKhauNhanKhauModify.layListQuanHe(hk.getID());
        return new HoKhauBean(hk, chuHo, nhanKhaus, quanHes);      
    }

    /**
     * @param hk
     * @return nhân khẩu trong hộ
     */
    public static ArrayList<NhanKhau> layListNhanKhau(HoKhau hk) {
        return HoKhauNhanKhauModify.layListNhanKhau(hk.getID());
    }
    /**
     * @param idHoKhau
     * @return nhân khẩu trong hộ
     */
    public static ArrayList<NhanKhau> layListNhanKhau(int idHoKhau){
        return HoKhauNhanKhauModify.layListNhanKhau(idHoKhau);
    }
}
