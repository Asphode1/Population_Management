package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.utils.Password;
import com.lele.cnpm.src.models.NguoiDung;

public class NguoiDungModify {

  public static boolean insert(String taikhoan, Password p, String ChucVu) {
    String sql = "INSERT INTO Nguoi_Dung(taikhoan, salt, hash, ChucVu) VALUES(?,?,?,?)";

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, taikhoan);
      pstmt.setBytes(2, p.getSalt());
      pstmt.setString(3, p.getHash());
      pstmt.setString(4, ChucVu);
      int affected = pstmt.executeUpdate();
      if (affected == 0)
        return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * @param nd
   * @return thêm người dùng mới
   */
  public static boolean themNguoiDung(NguoiDung nd) {
    insert(nd.getUserName(), nd.getPasword(), nd.getChucVu());
    return true;
  }

  /**
   * Xóa người dùng
   * @param nd
   * @return true/false
   */
  public static boolean xoaNguoiDung(NguoiDung nd) {
    return xoaNguoiDung(nd.getUserName());
  }

  /**
   * Xóa người dùng
   * @param nd
   * @return true/false
   */
  public static boolean xoaNguoiDung(String username) {
    String sql = "DELETE FROM Nguoi_Dung WHERE taikhoan = " + username;

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      int affected = pstmt.executeUpdate();
      if (affected == 0)
        return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Thay đổi một người dùng
   * @param nd
   * @return true/false
   */
  public static boolean capNhatNguoiDung(NguoiDung nd) {
    String sql = "UPDATE Nguoi_Dung SET taikhoan=?, salt=?, hash=?, ChucVu=? WHERE Id = " + nd.getID();

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, nd.getUserName());
      pstmt.setBytes(2, nd.getPasword().getSalt());
      pstmt.setString(3, nd.getPasword().getHash());
      pstmt.setString(4, nd.getChucVu());
      int affected = pstmt.executeUpdate();
      if (affected == 0)
        return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * @return toàn bộ người dùng
   */
  public static ArrayList<NguoiDung> layListNguoiDung() {
    String sql = "SELECT * FROM nguoi_dung";
    ArrayList<NguoiDung> NguoiDungs = new ArrayList<NguoiDung>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao dia nhac 
      while (rs.next()) {
        int id = rs.getInt("ID");
        String taikhoan = rs.getString("taikhoan");
        byte[] salt = rs.getBytes("salt");
        String hash = rs.getString("hash");
        String ChucVu = rs.getString("ChucVu");

        Password p = new Password(hash, salt);

        NguoiDung nd = new NguoiDung(id, taikhoan, p, ChucVu);
        NguoiDungs.add(nd);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return NguoiDungs;
  }

  /**
   * @param taikhoan
   * @return lấy người dùng từ tên tài khoản
   */
  public static NguoiDung layNguoiDung(String taikhoan) {
    String sql = "SELECT * FROM Nguoi_Dung WHERE taikhoan=" + "'" + taikhoan.trim() + "'";
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        int id = rs.getInt("ID");
        taikhoan = rs.getString("taikhoan");
        byte[] salt = rs.getBytes("salt");
        String hash = rs.getString("hash");
        String ChucVu = rs.getString("ChucVu");

        Password p = new Password(hash, salt);
        return new NguoiDung(id, taikhoan, p, ChucVu);
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
}
