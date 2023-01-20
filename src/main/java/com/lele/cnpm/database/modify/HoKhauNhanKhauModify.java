package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.HoKhau;
import com.lele.cnpm.src.models.NhanKhau;

public class HoKhauNhanKhauModify {

  public static boolean insert(int idHoKhau, int idNhanKhau, String quanHeChuHo) {
    String sql = "INSERT INTO ho_khau_nhan_khau(idHoKhau, idNhanKhau, quanHeChuHo)"
        + " VALUES(?,?,?)";

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, idHoKhau);
      pstmt.setInt(2, idNhanKhau);
      pstmt.setString(3, quanHeChuHo);
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
   * Thêm một quan hệ Hộ khẩu - nhân khẩu
   * @param hk
   * @param nk
   * @param quanHeChuHo
   * @return true/fasle
   */
  public static boolean themHoKhau_NhanKhau(HoKhau hk, NhanKhau nk, String quanHeChuHo) {
    insert(hk.getID(), nk.getID(), quanHeChuHo);
    return true;
  }

  /**
   * Xóa một nhân khẩu khỏi quan hệ hộ khẩu-nhân khẩu
   * @param nk
   * @return true/false
   */
  public static boolean xoaNhanKhau(NhanKhau nk) {
    String sql = "DELETE FROM ho_khau_nhan_khau WHERE idNhanKhau = " + nk.getID();

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
   * Xóa một nhân khẩu khỏi quan hệ hộ khẩu-nhân khẩu
   * @param idNhanKhau
   * @return true/false
   */
  public static boolean xoaNhanKhau(int idNhanKhau) {
    String sql = "DELETE FROM nhan_khau WHERE IdNhanKhau = " + idNhanKhau;

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
   * Thay đổi một quan hệ hộ khẩu-nhân khẩu
   * @param hk
   * @param nk
   * @param quanHeChuHo
   * @return true/false
   */
  public static boolean capNhatHoKhau_NhanKhau(HoKhau hk, NhanKhau nk, String quanHeChuHo) {
    String sql = "UPDATE nhan_khau SET idHoKhau = ?, quanHeChuHo=? WHERE IdNhanKhau =" + nk.getID();

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, hk.getID());
      pstmt.setString(2, quanHeChuHo);
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
   * @param hk
   * @return Toàn bộ nhân khẩu trong hộ khẩu
   */
  public static ArrayList<NhanKhau> layListNhanKhau(HoKhau hk) {
    return layListNhanKhau(hk.getID());
  }

  /**
   * @param idHoKhau
   * @return Toàn bộ nhân khẩu trong hộ khẩu
   */
  public static ArrayList<NhanKhau> layListNhanKhau(int idHoKhau) {
    String sql = "SELECT nhan_khau.* FROM ho_khau_nhan_khau join nhan_khau on (ho_khau_nhan_khau.idNhanKhau = nhan_khau.idNhanKhau)"
        + " WHERE idHoKhau =" + idHoKhau
        + " ORDER BY IdNhanKhau";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("IdNhanKhau");
        String hoTen = rs.getString("hoTen");
        String biDanh = rs.getString("biDanh");
        Date ngaySinh = rs.getDate("ngaySinh");
        String noiSinh = rs.getString("noiSinh");
        String gioiTinh = rs.getString("gioiTinh");
        String nguyenQuan = rs.getString("nguyenQuan");
        String danToc = rs.getString("danToc");
        String tonGiao = rs.getString("tonGiao");
        String quocTich = rs.getString("quocTich");
        String ngheNghiep = rs.getString("ngheNghiep");
        String noiLamViec = rs.getString("noiLamViec");
        String soCCCD = rs.getString("soCCCD");
        Date ngayCap = rs.getDate("ngayCap");
        Date chuyenDenNgay = rs.getDate("chuyenDenNgay");
        String noiThuongTruTruoc = rs.getString("noiThuongTruTruoc");
        String trangThai = rs.getString("trangThai");

        NhanKhau nk = new NhanKhau(id, hoTen, biDanh, ngaySinh, gioiTinh,
            noiSinh, nguyenQuan, danToc, tonGiao, quocTich, ngheNghiep, noiLamViec,
            soCCCD, ngayCap, chuyenDenNgay, noiThuongTruTruoc, trangThai);

        NhanKhaus.add(nk);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return NhanKhaus;
  }

  /**
   * @param idHoKhau
   * @return Toàn bộ quan hệ với chủ hộ (sắp xếp theo Id Nhân Khẩu)
   */
  public static ArrayList<String> layListQuanHe(int idHoKhau) {
    String sql = "SELECT * FROM ho_khau_nhan_khau join nhan_khau on (ho_khau_nhan_khau.idNhanKhau=nhan_khau.idNhanKhau)"
        + " WHERE idHoKhau =" + idHoKhau
        + " ORDER BY nhan_khau.IdNhanKhau";
    ArrayList<String> quanHes = new ArrayList<String>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        quanHes.add(rs.getString("quanHeChuHo"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return quanHes;
  }

  /**
   * @param nk
   * @return Hộ khẩu của nhân khẩu
   */
  public static HoKhau layHoKhau(NhanKhau nk) {
    return layHoKhau(nk.getID());
  }

  /**
   * @param idNhanKhau
   * @return Hộ khẩu của người theo Id
   */
  public static HoKhau layHoKhau(int idNhanKhau) {
    String sql = "SELECT * FROM ho_khau_nhan_khau join ho_khau on (ho_khau_nhan_khau.idHoKhau = ho_khau.idHoKhau)"
        + " WHERE IdNhanKhau =" + idNhanKhau;
    HoKhau hk = new HoKhau();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int idHoKhau = rs.getInt("IdHoKhau");
        int idChuHo = rs.getInt("idChuHo");
        String tinhThanhPho = rs.getString("tinhThanhPho");
        String quanHuyen = rs.getString("quanHuyen");
        String phuongXa = rs.getString("phuongXa");
        String diaChi = rs.getString("diaChi");
        Date ngayTao = rs.getDate("ngayTao");
        String trangThai = rs.getString("trangThai");

        hk = new HoKhau(idHoKhau, idChuHo, tinhThanhPho, quanHuyen, phuongXa, diaChi, ngayTao, trangThai);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return hk;
  }
}
