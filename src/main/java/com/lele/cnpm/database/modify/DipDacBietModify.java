package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.DipDacBiet;

public class DipDacBietModify {
    
    public static boolean insert(String ten, int nam, String moTa,
     String phanQua05, String phanQua614, String phanQua1517, float tien05, 
     float tien614, float tien1517) {
        String sql = "INSERT INTO dip_dac_biet(ten, nam, moTa, phanQua05, phanQua614, phanQua1517, tien05, tien614, tien1517)"
        + " VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ten);
            pstmt.setInt(2, nam);
            pstmt.setString(3, moTa);
            pstmt.setString(4, phanQua05); 
            pstmt.setString(5, phanQua614);
            pstmt.setString(6, phanQua1517);
            pstmt.setFloat(7, tien05); 
            pstmt.setFloat(8, tien614);
            pstmt.setFloat(9, tien1517);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Thêm một dịp đặc biệt
     * @param ddb
     * @return true/false
     */
    public static boolean themDipDacBiet(DipDacBiet ddb) {
        insert(ddb.getTen(), ddb.getNam(), ddb.getMoTa(), ddb.getPhanQua05(),
         ddb.getPhanQua614(), ddb.getPhanQua1517(), ddb.getTien05(), ddb.getTien614(), ddb.getTien1517());
        return true;
    }

    /**
     * Xóa một dịp đặc biệt
     * @param ddb
     * @return true/false
     */
    public static boolean xoaDipDacBiet(DipDacBiet ddb) {
        return xoaDipDacBiet(ddb.getIdDip());
    }
    
    /**
     * Xóa một dịp đặc biệt
     * @param Id
     * @return true/false
     */
    public static boolean xoaDipDacBiet(int Id) {
        String sql = "DELETE FROM chi_tiet_dip_dac_biet WHERE IdDip = " + Id
                    + "; DELETE FROM dip_dac_biet WHERE IdDip = " + Id;

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
     * Thay đổi một dịp đặc biệt
     * @param ddb
     * @return true/false
     */
    public static boolean capNhatDipDacBiet(DipDacBiet ddb) {
        String sql = "UPDATE dip_dac_biet SET ten = ?, nam = ?, moTa = ?, phanQua05 = ?, phanQua614 = ?, phanQua1517 = ?,"
        +" tien05 = ?, tien614 = ?, tien1517=?  WHERE idDip = " + ddb.getIdDip();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ddb.getTen());
            pstmt.setInt(2, ddb.getNam());
            pstmt.setString(3, ddb.getMoTa());
            pstmt.setString(4, ddb.getPhanQua05()); 
            pstmt.setString(5, ddb.getPhanQua614());
            pstmt.setString(6, ddb.getPhanQua1517());
            pstmt.setFloat(7, ddb.getTien05()); 
            pstmt.setFloat(8, ddb.getTien614());
            pstmt.setFloat(9, ddb.getTien1517());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @return toàn bộ dịp đặc biệt
     */
    public static ArrayList<DipDacBiet> layListDipDacBiet() {
        String sql = "SELECT * FROM dip_dac_biet ORDER BY IdDip";
        ArrayList<DipDacBiet> DipDacBiets = new ArrayList<DipDacBiet>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("IdDip");
                String ten = rs.getString("ten");
                int nam = rs.getInt("nam");
                String moTa = rs.getString("moTa");
                String phanQua05 = rs.getString("phanQua05");
                String phanQua614 = rs.getString("phanQua614");
                String phanQua1517 = rs.getString("phanQua1517");
                float tien05 = rs.getFloat("tien05");
                float tien614 = rs.getFloat("tien614");
                float tien1517 = rs.getFloat("tien1517");
              
                DipDacBiet ddb = new DipDacBiet(id, ten, nam, moTa, phanQua05, phanQua614, phanQua1517, tien05, tien614, tien1517);

                DipDacBiets.add(ddb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DipDacBiets;
    }

    /**
     * @param search
     * @return toàn bộ dịp đặc biệt tên có chứa đoạn search
     */
    public static ArrayList<DipDacBiet> layListDipDacBiet(String search) {
        String sql = "SELECT * FROM dip_dac_biet "+
        "WHERE ten LIKE '%" + search + "%'  OR IdDip LIKE '%" + search + "%'"
        + " ORDER BY IdDip";
        ArrayList<DipDacBiet> DipDacBiets = new ArrayList<DipDacBiet>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // chen vao Dip dac biet
            while (rs.next()) {
                int id = rs.getInt("IdDip");
                String ten = rs.getString("ten");
                int nam = rs.getInt("nam");
                String moTa = rs.getString("moTa");
                String phanQua05 = rs.getString("phanQua05");
                String phanQua614 = rs.getString("phanQua614");
                String phanQua1517 = rs.getString("phanQua1517");
                float tien05 = rs.getFloat("tien05");
                float tien614 = rs.getFloat("tien614");
                float tien1517 = rs.getFloat("tien1517");

                DipDacBiets.add(new DipDacBiet(id, ten, nam, moTa, phanQua05, phanQua614, phanQua1517, tien05, tien614, tien1517));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DipDacBiets;
    }

    /**
     * @return số dịp đặc biệt đang có
     */
    public static int countDipDacBiet(){
        String sql = "SELECT count(*) as c FROM dip_dac_biet";
        int countDipDacBiet =0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                countDipDacBiet = rs.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countDipDacBiet;
    }

    public static int countChuaTraoThuong(int idDip) {
        String sql = "SELECT count(*) as c FROM chi_tiet_dip_dac_biet WHERE idDip = "
        + idDip + " AND kiemTra = 0";
        int countChua =0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                countChua = rs.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countChua;
    }
}
