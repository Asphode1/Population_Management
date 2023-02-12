package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.NhanKhau;

public class NhanKhauModify {
  public static boolean insert(String hoTen, String biDanh, Date ngaySinh, String noiSinh, String gioiTinh,
      String nguyenQuan, String danToc, String tonGiao, String quocTich, String ngheNghiep,
      String noiLamViec, String soCCCD, Date ngayCap, Date chuyenDenNgay, String noiThuongTruTruoc,
      String trangThai) {
    String sql = "INSERT INTO nhan_khau(hoTen, biDanh, ngaySinh, noiSinh, gioiTinh,"
        + " nguyenQuan, danToc, tonGiao, quocTich, ngheNghiep, noiLamViec, soCCCD, ngayCap, chuyenDenNgay, noiThuongTruTruoc, trangThai)"
        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, hoTen);
      pstmt.setString(2, biDanh);
      pstmt.setDate(3, ngaySinh);
      pstmt.setString(4, noiSinh);
      pstmt.setString(5, gioiTinh);
      pstmt.setString(6, nguyenQuan);
      pstmt.setString(7, danToc);
      pstmt.setString(8, tonGiao);
      pstmt.setString(9, quocTich);
      pstmt.setString(10, ngheNghiep);
      pstmt.setString(11, noiLamViec);
      pstmt.setString(12, soCCCD);
      pstmt.setDate(13, ngayCap);
      pstmt.setDate(14, chuyenDenNgay);
      pstmt.setString(15, noiThuongTruTruoc);
      pstmt.setString(16, trangThai);
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
   * @param cccd
   * @return true nếu CCCD hợp lệ, false nếu CCCD trùng hoặc sai kích thước
   */
  public static boolean checkCCCD(String cccd) {
    if (cccd.length() !=0 && cccd.length() != 9 && cccd.length() != 12) return false;
    String sql = "SELECT count(*) as c FROM nhan_khau WHERE soCCCD = '" + cccd + "'";
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      rs.next();
      int c = rs.getInt("c");
      if (c==0) return true;
      else return false;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Thêm một nhân khẩu
   * @param nk
   * @return true/false
   */
  public static boolean themNhanKhau(NhanKhau nk) {
    if (nk.getTrangThai() == null)
      nk.setTrangThai("Tạm trú");
    if (!checkCCCD(nk.getSoCCCD())) return false;
    else return insert(nk.getHoTen(), nk.getBietDanh(), nk.getNgaySinh(), nk.getNoiSinh(), nk.getGioiTinh(),
        nk.getNguyenQuan(), nk.getDanToc(), nk.getTonGiao(), nk.getQuocTich(), nk.getNgheNghiep(),
        nk.getNoiLamViec(), nk.getSoCCCD(), nk.getNgayCap(), nk.getChuyenDenNgay(), nk.getNoiThuongTruTruoc(),
        nk.getTrangThai());
  }

  /**
   * Xóa một nhân khẩu
   * @param nk
   * @return true/false
   */
  public static boolean xoaNhanKhau(NhanKhau nk) {
    return xoaNhanKhau(nk.getID());
  }

  /**
   * Xóa một nhân khẩu
   * @param idNhanKhau
   * @return true/false
   */
  public static boolean xoaNhanKhau(int idNhanKhau) {
    String sql = "DELETE FROM ho_khau_nhan_khau WHERE idNhanKhau = " + idNhanKhau
        + "; DELETE FROM tam_tru WHERE idNhanKhau = " + idNhanKhau
        + "; DELETE FROM tam_vang WHERE idNhanKhau = " + idNhanKhau
        + "; DELETE FROM khai_tu WHERE idNguoiMat = " + idNhanKhau + " OR idNguoiKhai = " + idNhanKhau
        + "; DELETE FROM chuyen_nhan_khau WHERE idNhanKhau = " + idNhanKhau
        + "; DELETE FROM chi_tiet_dip_dac_biet WHERE idNhanKhau = " + idNhanKhau
        + "; DELETE FROM chi_tiet_dip_hoc_sinh_gioi WHERE idNhanKhau = " + idNhanKhau
        + "; DELETE FROM nhan_khau WHERE idNhanKhau = " + idNhanKhau;

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
   * Thay đổi một nhân khẩu
   * @param nk
   * @return true/false
   */
  public static boolean capNhatNhanKhau(NhanKhau nk) {
    if (!layNhanKhau(nk.getID()).getSoCCCD().equals(nk.getSoCCCD()))
      if (!checkCCCD(nk.getSoCCCD())) return false;
    String sql = "UPDATE nhan_khau SET hoTen = ?, biDanh = ?, ngaySinh = ?, noiSinh = ?, gioiTinh =?,"
        + " nguyenQuan = ?, danToc = ?, tonGiao = ?, quocTich = ?, ngheNghiep = ?, noiLamViec = ?, soCCCD = ?,"
        + " ngayCap = ?, chuyenDenNgay = ?, noiThuongTruTruoc = ?, trangThai =? WHERE idNhanKhau = "
        + nk.getID();

    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, nk.getHoTen());
      pstmt.setString(2, nk.getBietDanh());
      pstmt.setDate(3, nk.getNgaySinh());
      pstmt.setString(4, nk.getNoiSinh());
      pstmt.setString(5, nk.getGioiTinh());
      pstmt.setString(6, nk.getNguyenQuan());
      pstmt.setString(7, nk.getDanToc());
      pstmt.setString(8, nk.getTonGiao());
      pstmt.setString(9, nk.getQuocTich());
      pstmt.setString(10, nk.getNgheNghiep());
      pstmt.setString(11, nk.getNoiLamViec());
      pstmt.setString(12, nk.getSoCCCD());
      pstmt.setDate(13, nk.getNgayCap());
      pstmt.setDate(14, nk.getChuyenDenNgay());
      pstmt.setString(15, nk.getNoiThuongTruTruoc());
      pstmt.setString(16, nk.getTrangThai());
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
   * @return Toàn bộ nhân khẩu đang có
   */
  public static ArrayList<NhanKhau> layListNhanKhau() {
    String sql = "SELECT * FROM nhan_khau ORDER BY idNhanKhau";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("idNhanKhau");
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
   * @param search
   * @return lấy toàn bộ nhân khẩu tên/cccd/Id chứa đoạn search
   */
  public static ArrayList<NhanKhau> layListNhanKhau(String search) {
    String sql = "SELECT * FROM nhan_khau " +
        "WHERE hoTen LIKE N'%" + search + "%'  OR soCCCD LIKE '%" + search + "%' OR idNhanKhau LIKE '%" + search
        + "%'" + "ORDER BY idNhanKhau";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
      while (rs.next()) {
        int id = rs.getInt("idNhanKhau");
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
   * @param idNhanKhau
   * @return Nhân khẩu có Id tương ứng
   */
  public static NhanKhau layNhanKhau(int idNhanKhau) {
    String sql = "SELECT * FROM nhan_khau WHERE idNhanKhau =" + idNhanKhau;
    NhanKhau nk = new NhanKhau();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
      while (rs.next()) {
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

        nk = new NhanKhau(idNhanKhau, hoTen, biDanh, ngaySinh, gioiTinh,
            noiSinh, nguyenQuan, danToc, tonGiao, quocTich, ngheNghiep, noiLamViec,
            soCCCD, ngayCap, chuyenDenNgay, noiThuongTruTruoc, trangThai);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return nk;
  }

  /**
   * Thêm Nhân Khẩu bằng list
   * @param nks
   * @return true/ false
   */
  public static boolean nhapDuLieuNhanKhau(ArrayList<NhanKhau> nks) {
    for (NhanKhau nk : nks) {
      themNhanKhau(nk);
    }
    return true;
  }

  /**
   * @return số nhân khẩu trên địa bàn
   */
  public static int countNhanKhau() {
    String sql = "SELECT count(*) as c FROM nhan_khau"
        + " WHERE trangThai not in (N'Đã chuyển đi', N'Đã mất', N'Tạm vắng')";
    int countNhanKhau = 0;
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      rs.next();
      countNhanKhau = rs.getInt("c");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return countNhanKhau;
  }

  /**
   * @return List Nhân khẩu chưa nằm trong một quan hệ hộ khẩu nào
   */
  public static ArrayList<NhanKhau> layListNhanKhauChuaCoHoKhau() {
    String sql = "SELECT * FROM nhan_khau "
        + " except (SELECT nhan_khau.* " +
        " FROM nhan_khau join ho_khau_nhan_khau on (nhan_khau.idNhanKhau = ho_khau_nhan_khau.idNhanKhau))";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("idNhanKhau");
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
   * @return List Nhân khẩu chưa nằm trong một quan hệ hộ khẩu nào, tên chứa đoạn search
   */
  public static ArrayList<NhanKhau> layListNhanKhauChuaCoHoKhau(String search) {
    String sql = "SELECT * FROM nhan_khau "
        + "WHERE hoTen LIKE N'%" + search + "%'  OR soCCCD LIKE '%" + search
        + "%' except (SELECT nhan_khau.* "
        + " FROM nhan_khau join ho_khau_nhan_khau on (nhan_khau.idNhanKhau = ho_khau_nhan_khau.idNhanKhau) "
        + "WHERE hoTen LIKE N'%" + search + "%'  OR soCCCD LIKE '%" + search + "%')";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
      while (rs.next()) {
        int id = rs.getInt("idNhanKhau");
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
   * @return số nhân khẩu nam trên địa bàn
   */
  public static int countNhanKhauNam() {
    String sql = "SELECT count(*) as c FROM nhan_khau"
        + " WHERE gioiTinh = N'Nam' and trangThai not in (N'Đã chuyển đi', N'Đã mất', N'Tạm vắng')";
    int countNhanKhau = 0;
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      rs.next();
      countNhanKhau = rs.getInt("c");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return countNhanKhau;
  }

  public static int countNhanKhauNu() {
    String sql = "SELECT count(*) as c FROM nhan_khau"
        + " WHERE gioiTinh = N'Nữ' and trangThai not in (N'Đã chuyển đi', N'Đã mất', N'Tạm vắng')";
    int countNhanKhau = 0;
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      rs.next();
      countNhanKhau = rs.getInt("c");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return countNhanKhau;
  }

  /**
   * @return list nhân khẩu có trong địa bàn
   */
  public static ArrayList<NhanKhau> layListNhanKhauTrongDiaBan() {
    String sql = "SELECT * FROM nhan_khau "
        + " WHERE trangThai not in (N'Đã chuyển đi', N'Đã mất', N'Chuyển đi')"
        + " ORDER BY idNhanKhau";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
      while (rs.next()) {
        int id = rs.getInt("idNhanKhau");
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
   * @return list học sinh có trong địa bàn
   */
  public static ArrayList<NhanKhau> layListHocSinh() {
    String sql = "SELECT * FROM nhan_khau "
          + " WHERE trangThai = N'Thường trú'"
          + " AND YEAR(GETDATE()) - YEAR(ngaySinh) between 0 and 18"
          + " ORDER BY idNhanKhau";
    ArrayList<NhanKhau> NhanKhaus = new ArrayList<NhanKhau>();
    try {
      Connection conn = DBConnection.getDBConnection().getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      // chen vao nhan khau
      while (rs.next()) {
        int id = rs.getInt("idNhanKhau");
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