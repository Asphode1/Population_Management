/*package com.lele.cnpm.src;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import com.lele.cnpm.database.modify.HoKhauModify;
import com.lele.cnpm.database.modify.HoKhauNhanKhauModify;
import com.lele.cnpm.database.modify.NhanKhauModify;
import com.lele.cnpm.src.models.HoKhau;
import com.lele.cnpm.src.models.NhanKhau;

public class SinhHoKhau {
    public static void sinhHo(int soNha){
        ArrayList<NhanKhau> nks = NhanKhauModify.layListNhanKhauChuaCoHoKhau();

        NhanKhau bo = new NhanKhau(), me = new NhanKhau(), con1 = new NhanKhau(), con2 = new NhanKhau();

        Random rd = new Random();

        // chon chu ho nam tren 30t
        for (NhanKhau nk: nks) {
            int a = nk.getTuoi();
            if (a >=70 && nk.getGioiTinh().equals("Nam")) {
                bo = nk;
                nks.remove(bo);
                nk.setTrangThai("Thường trú");
                NhanKhauModify.capNhatNhanKhau(nk);
                break;
            }
        }
        HoKhau hk = new HoKhau(0, bo.getID(), "Hà Nội",
        "Hai Bà Trưng", "Bách Khoa", "số " + soNha +", đường Trần Đại Nghĩa, quận Hai Bà Trưng, Hà Nội", 
        Date.valueOf(LocalDate.now()), "Thường trú");

        HoKhauModify.themHoKhau(hk);
        hk = HoKhauModify.layHoKhau(bo.getID());
        HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), bo.getID(), "Chủ hộ");

        // chon vo chu ho nu thua chu ho <10t, tren 20t
        for (NhanKhau nk: nks) {
            int a =  bo.getTuoi() - nk.getTuoi();
            if (0<= a && a<10 && nk.getGioiTinh().equals("Nữ")) {
                me = nk;
                me.setTrangThai("Thường trú");
                NhanKhauModify.capNhatNhanKhau(me);
                nks.remove(me);
                break;
            }
        }
        HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Vợ");

        boolean coCon = false;
        // chon 2 dua con
        for (NhanKhau nk: nks) {
            int a =  bo.getTuoi() - nk.getTuoi();
            int b = me.getTuoi() - nk.getTuoi();
            if (20<= a && a<40 && 20<=b && b<=40) {
                con1 = nk;
                nks.remove(con1);
                nk.setTrangThai("Thường trú");
                NhanKhauModify.capNhatNhanKhau(nk);
                coCon = true;
                break;
            }

        }
        if (coCon)
            if (con1.getGioiTinh().equals("Nam"))
                HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), con1.getID(), "Con trai");
            else 
                HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), con1.getID(), "Con gái");

        coCon = false;
        // 80% co dua con thu hai
        if (rd.nextDouble() <=0.8) {
            for (NhanKhau nk: nks) {
                int a =  bo.getTuoi() - nk.getTuoi();
                int b = me.getTuoi() - nk.getTuoi();
                if (20<= a && a<40 && 20<=b && b<=40) {
                    con2 = nk;
                    nk.setTrangThai("Thường trú");
                    NhanKhauModify.capNhatNhanKhau(nk);
                    nks.remove(con2);
                    coCon = true;
                    break;
                }
            }
            if (coCon)
                if (con1.getGioiTinh().equals("Nam"))
                    HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), con2.getID(), "Con trai");
                else 
                    HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), con2.getID(), "Con gái");
        }

    }

    public static void main(String[] args) {
        for (int i = 2; i<=100; i+=5)
            sinhHo(i);
    }
}
*/