package com.lele.cnpm.src;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.lele.cnpm.database.modify.NhanKhauModify;
import com.lele.cnpm.src.models.HoKhau;
import com.lele.cnpm.src.models.NhanKhau;

public class SinhHoKhau {
    public void sinhHo(int soNha){
        ArrayList<NhanKhau> nks = NhanKhauModify.layListNhanKhauChuaCoHoKhau();

        NhanKhau bo, me, con1, con2;

        // chon chu ho nam tren 30t
        for (NhanKhau nk: nks) {
            if (nk.getTuoi() >=30 && nk.getGioiTinh().equals("Nam")) {
                bo = nk;
                break;
            }
        }
        HoKhau hk = new HoKhau(0, soNha, "Hà Nội",
        "Hai Bà Trưng", "Bách Khoa", "số" + i +", đường Lê Thanh Nghị, quận Hai Bà Trưng, Hà Nội", 
        Date.valueOf(LocalDate.now()), "Thường trú");

        // chon vo chu ho nu thua chu ho <10t, tren 20t
        for (NhanKhau nk: nks) {
            int a =  bo.getTuoi() - nk.getTuoi();
            if (0<= a and a<10 && nk.getGioiTinh().equals("Nam")) {
                bo = nk;
                break;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
