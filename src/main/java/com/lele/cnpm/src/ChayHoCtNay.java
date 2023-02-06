package com.lele.cnpm.src;

import java.util.ArrayList;

import com.lele.cnpm.src.models.NhanKhau;
import com.lele.cnpm.src.services.NhanKhauManage;

public class ChayHoCtNay {
    public static void main(String[] args) {
        ArrayList<NhanKhau> nkall = NhanKhauManage.layListNhanKhauChuaCoHoKhau();
        for (NhanKhau nk : nkall) {
            
            nk.setTrangThai("Tạm trú");
            NhanKhauManage.capNhatNhanKhau(nk);
        }

        // for (int i=1; i<=5; i++) {
        //     NhanKhau nk = NhanKhauManage.layNhanKhau(i);
        //     nk.setTrangThai("Thường trú");
        //     NhanKhauManage.capNhatNhanKhau(nk);
        // }
    }
}
