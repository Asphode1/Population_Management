package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.TamVang;

public class TamVangModify {
    
    public static boolean insert(int idNhanKhau, String noiTamTru, Date tuNgay, Date denNgay, String lyDo) {
        String sql = "INSERT INTO tam_vang(idNhanKhau, noiTamTru, tuNgay, denNgay, lyDo)"
        + " VALUES(?,?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, idNhanKhau);
            pstmt.setString(2, noiTamTru);
            pstmt.setDate(3, tuNgay); 
            pstmt.setDate(4, denNgay);
            pstmt.setString(5, lyDo);
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
     * Thêm tạm vắng mới
     * @param tv
     * @return true/false
     */
    public static boolean themTamVang(TamVang tv) {
        insert(tv.getIdNhanKhau(), tv.getNoiTamTru(), tv.getTuNgay(), tv.getDenNgay(), tv.getLyDo());
        return true;
    }

    /**
     * Xóa tạm vắng
     * @param tv
     * @return true/false
     */
    public static boolean xoaTamVang(TamVang tv) {
        return xoaTamVang(tv.getID());
    }
    
    /**
     * Xóa tạm vắng
     * @param Id
     * @return true/false
     */
    public static boolean xoaTamVang(int Id) {
        String sql = "DELETE FROM tam_vang WHERE Id = " + Id;

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
     * Thay đổi một tạm vắng
     * @param tv
     * @return true/false
     */
    public static boolean capNhatTamVang(TamVang tv) {
        String sql = "UPDATE tam_vang SET idNhanKhau = ?, noiTamTru = ?, tuNgay = ?, denNgay = ?, lyDo = ?"
        + " WHERE Id = " + tv.getID();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, tv.getIdNhanKhau());
            pstmt.setString(2, tv.getNoiTamTru());
            pstmt.setDate(3, tv.getTuNgay());
            pstmt.setDate(4, tv.getDenNgay());
            pstmt.setString(5, tv.getLyDo()); 
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
     * @return Toàn bộ tạm vắng đang có
     */
    public static ArrayList<TamVang> layListTamVang() {
        String sql = "SELECT * FROM tam_vang ORDER BY Id";
        ArrayList<TamVang> TamVangs = new ArrayList<TamVang>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idNhanKhau = rs.getInt("idNhanKhau");
                String noiTamTru = rs.getString("noiTamTru");
                Date tuNgay = rs.getDate("tuNgay");
                Date denNgay = rs.getDate("denNgay");
                String lyDo = rs.getString("lyDo");

                TamVangs.add(new TamVang(id, idNhanKhau, noiTamTru, tuNgay, denNgay, lyDo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return TamVangs;
    }
  
    /**
     * @return số người đang tạm vắng
     */
    public static int countTamVang() {
        String sql = "SELECT count(*) as c FROM tam_vang";
        int countTamVang =0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            countTamVang = rs.getInt("c");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countTamVang;
    }
}
