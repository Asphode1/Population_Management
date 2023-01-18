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

public class HoKhauModify {

    public static boolean insert(int idChuHo, String tinhThanhPho, String quanHuyen, String phuongXa, String diaChi,
        Date ngayTao, String trangThai) {
        String sql = "INSERT INTO Ho_khau(ID, idChuHo, tinhThanhPho, quanHuyen, phuongXa, diaChi, ngayTao, trangThai)"
                + " VALUES(?,?,?,?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idChuHo);
            pstmt.setString(2, tinhThanhPho);
            pstmt.setString(3, quanHuyen);
            pstmt.setString(4, phuongXa);
            pstmt.setString(5, diaChi);
            pstmt.setDate(6, ngayTao);
            pstmt.setString(7, trangThai);
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
     * Thêm một hộ khẩu mới
     * @param hk
     * @return true/false
     */
    public static boolean themHoKhau(HoKhau hk) {
        insert(hk.getIdChuHo(), hk.getTinhThanhPho(), hk.getQuanHuyen(), hk.getPhuongXa(),
                hk.getDiaChi(), hk.getNgayTao(), hk.getTrangThai());
        return true;
    }

    /**
     * Xóa một hộ khẩu trong database
     * @param hk
     * @return true/false
     */
    public static boolean xoaHoKhau(HoKhau hk) {
        return xoaHoKhau(hk.getID());
    }

   /**
    * Xóa một hộ khẩu
     * @param IdHoKhau
     * @return true/false
     */
     public static boolean xoaHoKhau(int IdHoKhau) {
        String sql = "DELETE FROM Ho_khau_nhan_khau WHERE IdHoKhau = " + IdHoKhau + "; DELETE FROM Ho_khau WHERE IdHoKhau = "
                + IdHoKhau;

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
     * Thay đổi một hộ khẩu
     * @param hk
     * @return true/false
     */
    public static boolean capNhatHoKhau(HoKhau hk) {
        String sql = "UPDATE Ho_khau SET idChuHo=?, tinhThanhPho=?, quanHuyen=?, phuongXa=?, diaChi=?, ngayTao=?, trangThai=?"
                + " WHERE IdHoKhau = " + hk.getID();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hk.getIdChuHo());
            pstmt.setString(2, hk.getTinhThanhPho());
            pstmt.setString(3, hk.getQuanHuyen());
            pstmt.setString(4, hk.getPhuongXa());
            pstmt.setString(5, hk.getDiaChi());
            pstmt.setDate(6, hk.getNgayTao());
            pstmt.setString(7, hk.getTrangThai());
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
     * @return list toàn bộ hộ khẩu đang có
     */
    public static ArrayList<HoKhau> layListHoKhau() {
        String sql = "SELECT * FROM Ho_khau ORDER BY IdHoKhau";
        ArrayList<HoKhau> HoKhaus = new ArrayList<HoKhau>();
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

                HoKhaus.add(
                        new HoKhau(idHoKhau, idChuHo, tinhThanhPho, quanHuyen, phuongXa, diaChi, ngayTao, trangThai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HoKhaus;
    }

    /**
     * @param name
     * @return toàn bộ hộ khẩu mà chủ hộ có tên chứa đoạn name
     */
    public static ArrayList<HoKhau> layListHoKhau(String name) {
        String sql = "SELECT * FROM ho_khau join Nhan_khau on (ho_khau.idChuHo = nhan_khau.IdNhanKhau)"
                + " WHERE (nhan_khau.hoTen LIKE '%" + name + "%')"
                + " ORDER BY IdHoKhau";
        ArrayList<HoKhau> HoKhaus = new ArrayList<HoKhau>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // chen vao Ho khau
            while (rs.next()) {
                int idHoKhau = rs.getInt("IdHoKhau");
                int idChuHo = rs.getInt("idChuHo");
                String tinhThanhPho = rs.getString("tinhThanhPho");
                String quanHuyen = rs.getString("quanHuyen");
                String phuongXa = rs.getString("phuongXa");
                String diaChi = rs.getString("diaChi");
                Date ngayTao = rs.getDate("ngayTao");
                String trangThai = rs.getString("trangThai");

                HoKhaus.add(
                        new HoKhau(idHoKhau, idChuHo, tinhThanhPho, quanHuyen, phuongXa, diaChi, ngayTao, trangThai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HoKhaus;
    }

    /**
     * Tìm hộ khẩu theo Id chủ hộ
     * @param IdChuHo
     * @return Hộ Khẩu có chủ hộ theo ID, hoặc null nếu không có
     */
    public static HoKhau layHoKhau(int IdChuHo) {
        String sql = "SELECT * FROM ho_khau "
                + " WHERE IdChuHo = " + IdChuHo
                + " ORDER BY IdHoKhau";
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

    /**
     * Tìm hộ khẩu theo Id hộ khẩu
     * @param IdHoKhau
     * @return Hộ Khẩu theo ID, hoặc null nếu không có
     */
    public static HoKhau layHoKhauTheoIdHoKhau(int IdHoKhau) {
        String sql = "SELECT * FROM ho_khau "
                + " WHERE IdHoKhau = " + IdHoKhau
                + " ORDER BY IdHoKhau";
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

    /**
     * @return số hộ khẩu đang có trong địa bàn
     */
    public static int countHoKhau() {
        String sql = "SELECT count(*) as c FROM ho_khau "
                + "WHERE trangThai not in (N'Chuyển đi', N'Đã chuyển đi')";
        int countHoKhau = 0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            countHoKhau = rs.getInt("c");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countHoKhau;
    }
}
