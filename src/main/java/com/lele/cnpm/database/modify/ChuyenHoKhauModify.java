package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.ChuyenHoKhau;

public class ChuyenHoKhauModify {

  /**
   * Chèn vào database 
   * @param idHoKhau
   * @param ngayChuyenDi
   * @param noiChuyenDen
   * @param ghiChu
   * @return
   */
  public static boolean insert(int idHoKhau, Date ngayChuyenDi, String noiChuyenDen, String ghiChu) {
    String sql = "INSERT INTO chuyen_ho_khau(idHoKhau, ngayChuyenDi, noiChuyenDen, ghiChu)"
        + " VALUES(?,?,?,?)";

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, idHoKhau);
      pstmt.setDate(2, ngayChuyenDi);
      pstmt.setString(3, noiChuyenDen);
      pstmt.setString(4, ghiChu);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Thêm chuyển hộ khẩu vào database
   * @param chk
   * @return true/false
   */
  public static boolean themChuyenHoKhau(ChuyenHoKhau chk) {
    insert(chk.getIdHoKhau(), chk.getNgayChuyenDi(), chk.getNoiChuyenDen(), chk.getGhiChu());
    return true;
  }

  /**
   * Xóa chuyển hộ khẩu
   * @param chk
   * @return true nếu xóa được false nếu có ngoại lệ
   */
  public static boolean xoaChuyenHoKhau(ChuyenHoKhau chk) {
    return xoaChuyenHoKhau(chk.getId());
  }

  /**
   * Xóa chuyển hộ khẩu
   * @param Id
   * @return true nếu xóa được false nếu có ngoại lệ
   */
  public static boolean xoaChuyenHoKhau(int Id) {
    String sql = "DELETE FROM chuyen_ho_khau WHERE Id = " + Id;

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * thay đổi một bản ghi chuyển hộ khẩu
   * @param chk
   * @return true/false
   */
  public static boolean capNhatChuyenHoKhau(ChuyenHoKhau chk) {
    String sql = "UPDATE chuyen_ho_khau SET idHoKhau =?, ngayChuyenDi = ?,"
        + " noiChuyenDen = ?, ghiChu = ? WHERE Id = "
        + chk.getId();

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, chk.getIdHoKhau());
      pstmt.setDate(2, chk.getNgayChuyenDi());
      pstmt.setString(3, chk.getNoiChuyenDen());
      pstmt.setString(4, chk.getGhiChu());
      pstmt.executeUpdate();
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * @return Toàn bộ chuyển hộ khẩu
   */
  public static ArrayList<ChuyenHoKhau> layListChuyenHoKhau() {
    String sql = "SELECT * FROM chuyen_ho_khau ORDER BY Id";
    ArrayList<ChuyenHoKhau> ChuyenHoKhaus = new ArrayList<ChuyenHoKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        int id = rs.getInt("Id");
        int idHoKhau = rs.getInt("idHoKhau");
        Date ngayChuyenDi = rs.getDate("ngayChuyenDi");
        String noiChuyenDen = rs.getString("noiChuyenDen");
        String ghiChu = rs.getString("ghiChu");

        ChuyenHoKhau chk = new ChuyenHoKhau(id, idHoKhau, ngayChuyenDi, noiChuyenDen, ghiChu);

        ChuyenHoKhaus.add(chk);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ChuyenHoKhaus;
  }

  /**
   * @return toàn bộ số hộ khẩu chuyển đi
   */
  public static int countChuyenHoKhau() {
    String sql = "SELECT count(*) as c FROM chuyen_ho_khau";
    int countChuyenHoKhau = 0;
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        countChuyenHoKhau = rs.getInt("c");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return countChuyenHoKhau;
  }
}
