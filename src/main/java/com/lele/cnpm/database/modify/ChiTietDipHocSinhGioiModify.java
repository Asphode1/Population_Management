package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.ChiTietDipHocSinhGioi;
import com.lele.cnpm.src.models.NhanKhau;

public class ChiTietDipHocSinhGioiModify {

  public static boolean insert(int idDip, int idNhanKhau, String truong, String lop, int nhom, boolean kiemtra) {
    String sql = "INSERT INTO chi_tiet_dip_hoc_sinh_gioi(idDip, idNhanKhau, truong, lop, nhom, kiemtra)"
        + " VALUES(?,?,?,?,?,?)";

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, idDip);
      pstmt.setInt(2, idNhanKhau);
      pstmt.setString(3, truong);
      pstmt.setString(4, lop);
      pstmt.setInt(5, nhom);
      pstmt.setBoolean(6, kiemtra);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Thêm vào database
   * @param cthsg
   * @return true nếu chèn được và false nếu gặp ngoại lệ
   * 
   */
  public static boolean themChiTietDipHocSinhGioi(ChiTietDipHocSinhGioi cthsg) {
    insert(cthsg.getIdDip(), cthsg.getIdNhanKhau(), cthsg.getTruong(), cthsg.getLop(), cthsg.getNhom(),
        cthsg.getKiemtra());
    return true;
  }

  /**
   * Xóa một chi tiết dịp HSG
   * @param cthsg
   * @return true/false
   */
  public static boolean xoaChiTietDipHocSinhGioi(ChiTietDipHocSinhGioi cthsg) {
    return xoaChiTietDipHocSinhGioi(cthsg.getIdDip(), cthsg.getIdNhanKhau());
  }

  /**
   * Xóa chi tiết dịp HSG theo ID
   * @param IdDip
   * @param IdNhanKhau
   * @return
   */
  public static boolean xoaChiTietDipHocSinhGioi(int IdDip, int IdNhanKhau) {
    String sql = "DELETE FROM chi_tiet_dip_hoc_sinh_gioi WHERE IdDip = " + "'" + IdDip + "'"
        + " AND IdNhanKhau = " + "'" + IdNhanKhau + "'";

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
   * Sửa đổi một chi tiết HSG
   * @param cthsg
   * @return
   */
  public static boolean capNhatChiTietDipHocSinhGioi(ChiTietDipHocSinhGioi cthsg) {
    String sql = "UPDATE chi_tiet_dip_hoc_sinh_gioi SET nhom=?, truong=?, lop =?, kiemtra=? WHERE IdDip = "
        + cthsg.getIdDip()
        + " AND IdNhanKhau = " + cthsg.getIdNhanKhau();

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, cthsg.getNhom());
      pstmt.setString(2, cthsg.getTruong());
      pstmt.setString(3, cthsg.getLop());
      pstmt.setBoolean(4, cthsg.getKiemtra());
      pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * @return Toàn bộ chi tiết dịp HSG
   */
  public static ArrayList<ChiTietDipHocSinhGioi> layListChiTietDipHocSinhGioi() {
    String sql = "SELECT * FROM chi_tiet_dip_hoc_sinh_gioi ORDER BY IdDip";
    ArrayList<ChiTietDipHocSinhGioi> ChiTietDipHocSinhGiois = new ArrayList<ChiTietDipHocSinhGioi>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        int idDip = rs.getInt("IdDip");
        int idNhanKhau = rs.getInt("idNhanKhau");
        String truong = rs.getString("truong");
        String lop = rs.getString("lop");
        int nhom = rs.getInt("nhom");
        boolean kiemtra = rs.getBoolean("kiemTra");

        ChiTietDipHocSinhGiois.add(new ChiTietDipHocSinhGioi(idDip, idNhanKhau, truong, lop, nhom, kiemtra));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ChiTietDipHocSinhGiois;
  }

  public static ArrayList<ChiTietDipHocSinhGioi> layListChiTietDipHocSinhGioi(int idDip) {
    String sql = "SELECT * FROM chi_tiet_dip_hoc_sinh_gioi"
        + " WHERE idDip = " + idDip;
    ArrayList<ChiTietDipHocSinhGioi> ChiTietDipHocSinhGiois = new ArrayList<ChiTietDipHocSinhGioi>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        int idNhanKhau = rs.getInt("idNhanKhau");
        String truong = rs.getString("truong");
        String lop = rs.getString("lop");
        int nhom = rs.getInt("nhom");
        boolean kiemtra = rs.getBoolean("kiemTra");

        ChiTietDipHocSinhGiois.add(new ChiTietDipHocSinhGioi(idDip, idNhanKhau, truong, lop, nhom, kiemtra));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ChiTietDipHocSinhGiois;
  }

  /**
   * @param search
   * @return list toàn bộ chi tiết dịp đặc biệt mà nhân khẩu có tên/id/cccd chứa đoạn search
   * 
   */
  public static ArrayList<ChiTietDipHocSinhGioi> layListChiTietDipHocSinhGioi(String search) {
    String sql = "SELECT * FROM chi_tiet_dip_hoc_sinh_gioi join nhan_khau on (chi_tiet_dip_hoc_sinh_gioi.idNhanKhau = nhan_khau.IdNhanKhau)"
        +
        " WHERE hoTen LIKE '%" + search + "%'  OR cmnd LIKE '%" + search
        + "%' OR chi_tiet_dip_hoc_sinh_gioi.IdDip LIKE '%" + search + "%' OR nhan_khau.IdNhanKhau LIKE '%" + search
        + "%'"
        + " ORDER BY chi_tiet_dip_hoc_sinh_gioi.IdDip";
    ArrayList<ChiTietDipHocSinhGioi> ChiTietDipHocSinhGiois = new ArrayList<ChiTietDipHocSinhGioi>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
      while (rs.next()) {
        int idDip = rs.getInt("IdDip");
        int idNhanKhau = rs.getInt("idNhanKhau");
        String truong = rs.getString("truong");
        String lop = rs.getString("lop");
        int nhom = rs.getInt("nhom");
        boolean kiemtra = rs.getBoolean("kiemTra");

        ChiTietDipHocSinhGiois.add(new ChiTietDipHocSinhGioi(idDip, idNhanKhau, truong, lop, nhom, kiemtra));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ChiTietDipHocSinhGiois;
  }

  /**
   * @return số lượt nhận thưởng
   */
  public static int countChiTietDipHocSinhGioi() {
    String sql = "SELECT count(*) as c FROM chi_tiet_dip_hoc_sinh_gioi";
    int countChiTietDipHocSinhGioi = 0;
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        countChiTietDipHocSinhGioi = rs.getInt("c");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return countChiTietDipHocSinhGioi;
  }

  /**
   * @param IdDipHSG
   * @return toàn bộ nhân khẩu nhận dịp có Id tìm
   */
  public static ArrayList<NhanKhau> layListNhanKhau(int IdDipHSG) {
    String sql = "SELECT nhan_khau.* FROM nhan_khau join chi_tiet_dip_hoc_sinh_gioi as ct on (nhan_khau.idNhanKhau = ct.idNhanKhau) "
        +
        "WHERE ct.idDip = " + IdDipHSG;
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
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
}
