package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.TamTru;

public class TamTruModify {

    public static boolean insert(int idNhanKhau, String noiThuongTru, String noiTamTru, Date tuNgay, Date denNgay,
            String lyDo) {
        String sql = "INSERT INTO tam_tru(idNhanKhau, noiThuongTru, noiTamTru, tuNgay, denNgay, lyDo)"
                + " VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idNhanKhau);
            pstmt.setString(2, noiThuongTru);
            pstmt.setString(3, noiTamTru);
            pstmt.setDate(4, tuNgay);
            pstmt.setDate(5, denNgay);
            pstmt.setString(6, lyDo);
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
     * Thêm tạm trú mới
     * @param tt
     * @return true/false
     */
    public static boolean themTamTru(TamTru tt) {
        insert(tt.getIdNhanKhau(), tt.getNoiThuongTru(), tt.getNoiTamTru(), tt.getTuNgay(), tt.getDenNgay(),
                tt.getLyDo());
        return true;
    }

    /**
     * Xóa một tạm trú
     * @param tt
     * @return true/false
     */
    public static boolean xoaTamTru(TamTru tt) {
        return xoaTamTru(tt.getID());
    }

    /**
     * Xóa một tạm trú
     * @param IdTamTru
     * @return true/false
     */
    public static boolean xoaTamTru(int IdTamTru) {
        String sql = "DELETE FROM tam_tru WHERE Id = " + IdTamTru;

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
     * Thay đổi một tạm trú
     * @param tt
     * @return true/false
     */
    public static boolean capNhatTamTru(TamTru tt) {
        String sql = "UPDATE tam_tru SET idNhanKhau = ?, noiThuongTru = ?, noiTamTru = ?, tuNgay = ?, denNgay = ?, lyDo = ?"
                + " WHERE Id = " + tt.getID();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, tt.getIdNhanKhau());
            pstmt.setString(2, tt.getNoiThuongTru());
            pstmt.setString(3, tt.getNoiTamTru());
            pstmt.setDate(4, tt.getTuNgay());
            pstmt.setDate(5, tt.getDenNgay());
            pstmt.setString(6, tt.getLyDo());
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
     * @return Toàn bộ tạm trú hiện tại
     */
    public static ArrayList<TamTru> layListTamTru() {
        String sql = "SELECT * FROM tam_tru ORDER BY Id";
        ArrayList<TamTru> TamTrus = new ArrayList<TamTru>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // chen vao Tam tru
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idNhanKhau = rs.getInt("idNhanKhau");
                String noiThuongTru = rs.getString("noiThuongTru");
                String noiTamTru = rs.getString("noiTamTru");
                Date tuNgay = rs.getDate("tuNgay");
                Date denNgay = rs.getDate("denNgay");
                String lyDo = rs.getString("lyDo");

                TamTrus.add(new TamTru(id, idNhanKhau, noiThuongTru, noiTamTru, tuNgay, denNgay, lyDo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TamTrus;
    }
    /**
     * @return số tạm trú trên địa bàn
     */
    public static int countTamTru() {
        String sql = "SELECT count(*) as c FROM nhan_khau "
        + " WHERE trangThai = N'Tạm trú'";
        int countTamTru = 0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            countTamTru = rs.getInt("c");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countTamTru;
    }
}
