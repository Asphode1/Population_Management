package com.lele.cnpm.src.services;

import java.util.ArrayList;

import com.lele.cnpm.src.models.NhanKhau;

public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList <NhanKhau> nks = NhanKhauManage.layListNhanKhau();
        for (NhanKhau nk: nks) 
            System.out.println(nk.getHoTen()+ " " + nk.getNgaySinhString());
        // NhanKhauManage.inListNhanKhauRaFileExcel(nks);
        
        // NhanKhauManage.themNhanKhauFileExcel();
    }
}
