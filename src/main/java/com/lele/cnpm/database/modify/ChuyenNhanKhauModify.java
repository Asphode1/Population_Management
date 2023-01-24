package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.ChuyenNhanKhau;

public class ChuyenNhanKhauModify {

  public static boolean insert(int idNhanKhau, Date ngayChuyenDi, String noiChuyenDen, String ghiChu) {
    String sql = "INSERT INTO chuyen_nhan_khau(idNhanKhau, ngayChuyenDi, noiChuyenDen, ghiChu)"
        + " VALUES(?,?,?,?)";

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, idNhanKhau);
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
   * Thêm một chuyển nhân khẩu vào database
   * @param cnk
   * @return true/false
   */
  public static boolean themChuyenNhanKhau(ChuyenNhanKhau cnk) {
    insert(cnk.getIdNhanKhau(), cnk.getNgayChuyenDi(), cnk.getNoiChuyenDen(), cnk.getGhiChu());
    return true;
  }

  /**
   * Xóa một chuyển nhân khẩu
   * @param cnk
   * @return true/false
   */
  public static boolean xoaChuyenNhanKhau(ChuyenNhanKhau cnk) {
    return xoaChuyenNhanKhau(cnk.getId());
  }

  /**
   * Xóa chuyển nhân khẩu
   * @param Id
   * @return true/ false
   */
  public static boolean xoaChuyenNhanKhau(int Id) {
    String sql = "DELETE FROM chuyen_nhan_khau WHERE Id = " + Id;

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
   * Sửa đổi một chuyển nhân khẩu
   * @param cnk
   * @return true/false
   */
  public static boolean capNhatChuyenNhanKhau(ChuyenNhanKhau cnk) {
    String sql = "UPDATE chuyen_nhan_khau SET idNhanKhau =?, ngayChuyenDi = ?,"
        + " noiChuyenDen = ?, ghiChu = ? WHERE Id = " + cnk.getId();

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cnk.getIdNhanKhau());
      pstmt.setDate(2, cnk.getNgayChuyenDi());
      pstmt.setString(3, cnk.getNoiChuyenDen());
      pstmt.setString(4, cnk.getGhiChu());
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * @return list toàn bộ chuyển nhân khẩu
   */
  public static ArrayList<ChuyenNhanKhau> layListChuyenNhanKhau() {
    String sql = "SELECT * FROM chuyen_nhan_khau ORDER BY Id";
    ArrayList<ChuyenNhanKhau> ChuyenNhanKhaus = new ArrayList<ChuyenNhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        int id = rs.getInt("Id");
        int idNhanKhau = rs.getInt("idNhanKhau");
        Date ngayChuyenDi = rs.getDate("ngayChuyenDi");
        String noiChuyenDen = rs.getString("noiChuyenDen");
        String ghiChu = rs.getString("ghiChu");

        ChuyenNhanKhau cnk = new ChuyenNhanKhau(id, idNhanKhau, ngayChuyenDi, noiChuyenDen, ghiChu);

        ChuyenNhanKhaus.add(cnk);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ChuyenNhanKhaus;
  }

  /**
   * @return số lượng toàn bộ nhân khẩu chuyển đi
   */
  public static int countChuyenNhanKhau() {
    String sql = "SELECT count(*) as c FROM chuyen_nhan_khau";
    int countChuyenNhanKhau = 0;
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        countChuyenNhanKhau = rs.getInt("c");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return countChuyenNhanKhau;
  }
}
