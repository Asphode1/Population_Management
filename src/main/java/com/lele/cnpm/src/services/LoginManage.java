package com.lele.cnpm.src.services;

import com.lele.cnpm.database.modify.NguoiDungModify;
import com.lele.cnpm.src.utils.Password;
import com.lele.cnpm.src.models.NguoiDung;

public class LoginManage {

  /**
   * Kiểm tra người dùng có trong database hay không
   * @param userName
   * @param password
   * @return true/false
   * @throws Exception
   */
  public static NguoiDung checkUser(String userName, String password) throws Exception {
    NguoiDung nd = NguoiDungModify.layNguoiDung(userName);
    if (nd != null)
      if (Password.getHash(password, nd.getPasword().getSalt()).equals(nd.getPasword().getHash()))
        return nd;
    return null;
  }
}
