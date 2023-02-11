package com.lele.cnpm.src;

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
    public void sinhHo(int soNha){
        ArrayList<NhanKhau> nks = NhanKhauModify.layListNhanKhauChuaCoHoKhau();

        NhanKhau bo = new NhanKhau(), me = new NhanKhau(), con1 = new NhanKhau(), con2 = new NhanKhau();

        Random rd = new Random();

        // chon chu ho nam tren 30t
        for (NhanKhau nk: nks) {
            int a = nk.getTuoi();
            if (a >=30 && a<=70 && nk.getGioiTinh().equals("Nam")) {
                bo = nk;
                nks.remove(bo);
                break;
            }
        }
        HoKhau hk = new HoKhau(0, bo.getID(), "Hà Nội",
        "Hai Bà Trưng", "Bách Khoa", "số" + soNha +", đường Lê Thanh Nghị, quận Hai Bà Trưng, Hà Nội", 
        Date.valueOf(LocalDate.now()), "Thường trú");

        HoKhauModify.themHoKhau(hk);
        hk = HoKhauModify.layHoKhau(bo.getID());
        HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), bo.getID(), "Chủ hộ");

        // chon vo chu ho nu thua chu ho <10t, tren 20t
        for (NhanKhau nk: nks) {
            int a =  bo.getTuoi() - nk.getTuoi();
            if (0<= a && a<10 && nk.getGioiTinh().equals("Nữ")) {
                me = nk;
                nks.remove(me);
                break;
            }
        }
        HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Vợ");

        // chon 2 dua con
        for (NhanKhau nk: nks) {
            int a =  bo.getTuoi() - nk.getTuoi();
            int b = me.getTuoi() - nk.getTuoi();
            if (20<= a && a<40 && 20<=b && b<=40) {
                con1 = nk;
                nks.remove(con1);
                break;
            }
        }
        if (con1.getGioiTinh().equals("Nam"))
            HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Con trai");
        else 
        HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Con gái");

        // 80% co dua con thu hai
        if (rd.nextDouble() <=0.8) {
            for (NhanKhau nk: nks) {
                int a =  bo.getTuoi() - nk.getTuoi();
                int b = me.getTuoi() - nk.getTuoi();
                if (20<= a && a<40 && 20<=b && b<=40) {
                    con2 = nk;
                    nks.remove(con2);
                    break;
                }
            }
            if (con1.getGioiTinh().equals("Nam"))
                HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Con trai");
            else 
            HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Con gái");
        }

        NhanKhau ob = new NhanKhau();

        //20% them cha chu ho hoac me chu ho
        if (rd.nextDouble() <=0.2) {
            for (NhanKhau nk: nks) {
                int a = - bo.getTuoi() + nk.getTuoi();
                if (20<= a && a<40) {
                    ob = nk;
                    nks.remove(con2);
                    break;
                }
            }
            if (ob.getGioiTinh().equals("Nam"))
                HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Bố");
            else 
            HoKhauNhanKhauModify.themHoKhau_NhanKhau(hk.getID(), me.getID(), "Mẹ");
        }
    }

    public static void main(String[] args) {
        
    }
}
