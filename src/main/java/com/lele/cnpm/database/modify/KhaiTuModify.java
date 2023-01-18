package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.KhaiTu;

public class KhaiTuModify {

    public static boolean insert(int idNguoiMat, int idNguoiKhai, Date ngayKhai, Date ngayMat, String liDoMatMat) {
        String sql = "INSERT INTO khai_tu(idNguoiMat, idNguoiKhai, ngayKhai, ngayMat, liDoMatMat)"
        + " VALUES(?,?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idNguoiMat);
            pstmt.setInt(2, idNguoiKhai);
            pstmt.setDate(3, ngayKhai);
            pstmt.setDate(4, ngayMat); 
            pstmt.setString(5, liDoMatMat);
            int affected = pstmt.executeUpdate();
            if (affected == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Thêm khai tử mới
     * @param kt
     * @return true/false
     */
    public static boolean themKhaiTu(KhaiTu kt) {
        insert(kt.getIdNguoiMat(), kt.getIdNguoiKhai(), kt.getNgayKhai(), kt.getNgayMat(), kt.getLyDoMat());
        return true;
    }

    /**
     * Xóa một khai tử trong Database
     * @param kt
     * @return true/false
     */
    public static boolean xoaKhaiTu(KhaiTu kt) {
        return xoaKhaiTu(kt.getIdNguoiMat());
    }
    /**
     * Xóa một khai tử trong Database theo Id người mất
     * @param IdNguoiMat
     * @return true/false
     */
    public static boolean xoaKhaiTu(int IdNguoiMat) {
        String sql = "DELETE FROM khai_tu WHERE IdNguoiMat = " + IdNguoiMat;

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
     * Thay đổi một khai tử
     * @param kt
     * @return true/false
     */
    public static boolean capNhatKhaiTu(KhaiTu kt) {
        String sql = "UPDATE khai_tu SET idNguoiKhai = ?, ngayKhai = ?, ngayMat = ?, liDoMatMat = ?"
        + " WHERE IdNguoiMat = " + kt.getIdNguoiMat();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, kt.getIdNguoiKhai());
            pstmt.setDate(2, kt.getNgayKhai());
            pstmt.setDate(3, kt.getNgayMat()); 
            pstmt.setString(4, kt.getLyDoMat());
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
     * @return Toàn bộ khai tử
     */
    public static ArrayList<KhaiTu> layListKhaiTu() {
        String sql = "SELECT * FROM khai_tu ORDER BY ngayMat";
        ArrayList<KhaiTu> KhaiTus = new ArrayList<KhaiTu>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // chen vao Khai tu
            while (rs.next()) {
                int idNguoiMat = rs.getInt("IdNguoiMat");
                int idNguoiKhai = rs.getInt("idNguoiKhai");
                Date ngayKhai = rs.getDate("ngayKhai");
                Date ngayMat = rs.getDate("ngayMat");
                String liDoMat = rs.getString("liDoMat");

                KhaiTus.add(new KhaiTu(idNguoiMat, idNguoiKhai, ngayKhai, ngayMat, liDoMat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return KhaiTus;
    }

    /**
     * @return số người chết trong năm nay
     */
    public static int countNguoiMatNamNay() {
        String sql = "SELECT count(*) as c FROM khai_tu "
                + "WHERE Year(ngayMat) = "+ LocalDate.now().getYear();
        int countNguoiMatNamNay = 0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
                countNguoiMatNamNay = rs.getInt("c");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countNguoiMatNamNay;
    }
}