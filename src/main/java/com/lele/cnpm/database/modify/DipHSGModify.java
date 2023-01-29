package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.DipHSG;

public class DipHSGModify {
    
    public static boolean insert(int nam, String moTa, 
    String phanQuaDacBiet, String phanQuaGioi, String phanQuaKha, 
    float tienDacBiet, float tienGioi, float tienKha) {
        String sql = "INSERT INTO dip_hoc_sinh_gioi(nam, moTa, phanQuaDacBiet, phanQuaGioi, phanQuaKha, tienDacBiet, tienGioi, tienKha)"
        + " VALUES(?,?,?,?,?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, nam);
            pstmt.setString(2, moTa);
            pstmt.setString(3, phanQuaDacBiet); 
            pstmt.setString(4, phanQuaGioi);
            pstmt.setString(5, phanQuaKha);
            pstmt.setFloat(6, tienDacBiet); 
            pstmt.setFloat(7, tienGioi);
            pstmt.setFloat(8, tienKha);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Thêm một dịp học sinh giỏi
     * @param dhsg
     * @return true/false
     */
    public static boolean themDipHSG(DipHSG dhsg) {
        insert(dhsg.getNam(), dhsg.getMoTa(), dhsg.getPhanQuaDacBiet(),
         dhsg.getPhanQuaGioi(), dhsg.getPhanQuaKha(), dhsg.getTienDacBiet(), dhsg.getTienGioi(), dhsg.getTienKha());
        return true;
    }

    /**
     * Xóa một dịp HSG
     * @param dhsg
     * @return true/false
     */
    public static boolean xoaDipHSG(DipHSG dhsg) {
        return xoaDipHSG(dhsg.getIdDip());
    }

    /**
     * Xóa dịp HSG
     * @param Id
     * @return true/false
     */
    public static boolean xoaDipHSG(int Id) {
        String sql = "DELETE FROM chi_tiet_dip_hoc_sinh_gioi WHERE IdDip = " + Id
        + "; DELETE FROM dip_hoc_sinh_gioi WHERE IdDip = " + Id;

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
     * Thay đổi một dịp HSG
     * @param dhsg
     * @return true/false
    */
    public static boolean capNhatDipHSG(DipHSG dhsg) {
        String sql = "UPDATE dip_hoc_sinh_gioi SET nam = ?, moTa = ?, phanQuaDacBiet = ?, phanQuaGioi = ?, phanQuaKha = ?,"
        +" tienDacBiet = ?, tienGioi = ?, tienKha = ?  WHERE idDip = " + dhsg.getIdDip();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dhsg.getNam());
            pstmt.setString(2, dhsg.getMoTa());
            pstmt.setString(3, dhsg.getPhanQuaDacBiet()); 
            pstmt.setString(4, dhsg.getPhanQuaGioi());
            pstmt.setString(5, dhsg.getPhanQuaKha());
            pstmt.setFloat(6, dhsg.getTienDacBiet()); 
            pstmt.setFloat(7, dhsg.getTienGioi());
            pstmt.setFloat(8, dhsg.getTienKha());
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
     * @return toàn bộ dịp HSG đang có
     */
    public static ArrayList<DipHSG> layListDipHSG() {
        String sql = "SELECT * FROM dip_hoc_sinh_gioi ORDER BY IdDip";
        ArrayList<DipHSG> DipHSGs = new ArrayList<DipHSG>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("IdDip");
                int nam = rs.getInt("nam");
                String moTa = rs.getString("moTa");
                String phanQuaDacBiet = rs.getString("phanQuaDacBiet");
                String phanQuaGioi = rs.getString("phanQuaGioi");
                String phanQuaKha = rs.getString("phanQuaKha");
                float tienDacBiet = rs.getFloat("tienDacBiet");
                float tienGioi = rs.getFloat("tienGioi");
                float tienKha = rs.getFloat("tienKha");

                DipHSGs.add(new DipHSG(id, nam, moTa, phanQuaDacBiet, phanQuaGioi, phanQuaKha, tienDacBiet, tienGioi, tienKha));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DipHSGs;
    }

    /**
     * @return số dịp HSG đang có
     */
    public static int countDipHSG() {
        String sql = "SELECT count(*) as c FROM dip_hoc_sinh_gioi";
        int countDipHSG =0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                countDipHSG = rs.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countDipHSG;
    }
}
