package com.lele.cnpm.database;

import com.lele.cnpm.src.services.NhanKhauManage;

public class Test {
  public static void main(String[] args) throws Exception {

    int res[] = NhanKhauManage.countNhanKhauTheoTuoi();
    for (int i=0; i<=5; i++)
      System.out.println(res[i]);
  }
}
