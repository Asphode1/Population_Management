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

  /**
   * Thay đổi mật khẩu người dùng
   * @param user
   * @param newPassword
   * @return true/false
   * @throws Exception
   */
  public static boolean changePassword(NguoiDung user, String newPassword) throws Exception {
    Password p = Password.newPassword(newPassword);
    NguoiDung nd = new NguoiDung(user.getID(), user.getUserName(), p, user.getChucVu());
    if (NguoiDungModify.capNhatNguoiDung(nd))
      return true;
    return false;
  }

  /**
   * Kiểm tra tên đăng nhập có tồn tại không
   * @param username
   * @return true/false
   * @throws Exception
   */
  public static boolean checkUsername(String username) throws Exception {
    NguoiDung nd = NguoiDungModify.layNguoiDung(username);
    if (nd == null)
      return true;
    return false;
  }

  /**
   * Thêm người dùng
   * @param nd
   * @return true/false
   */
  public static boolean themNguoiDung(NguoiDung nd) {
    return NguoiDungModify.themNguoiDung(nd);
  }
}
