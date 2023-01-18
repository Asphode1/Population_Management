package com.lele.cnpm.database.modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lele.cnpm.database.connect.DBConnection;
import com.lele.cnpm.src.models.ChiTietDipDacBiet;
import com.lele.cnpm.src.models.NhanKhau;

public class ChiTietDipDacBietModify {
    
    
    /**
     * Phương thức chèn vào database
     * @param idDip
     * @param idNhanKhau
     * @param nhom
     * @param kiemtra
     * @return true nếu chèn được và false nếu catch một ngoại lệ
     */
    public static boolean insert(int idDip, int idNhanKhau, int nhom, boolean kiemtra) {
        String sql = "INSERT INTO chi_tiet_dip_dac_biet(idDip, idNhanKhau, nhom, kiemtra)"
        + " VALUES(?,?,?,?)";

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idDip);
            pstmt.setInt(2, idNhanKhau);
            pstmt.setInt(3, nhom);
            pstmt.setBoolean(4, kiemtra);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Thêm chi tiết dịp đặc biệt vào database
     * @param ctddb
     * @return true nếu chèn được và false nếu catch một ngoại lệ
     */
    public static boolean themChiTietDipDacBiet(ChiTietDipDacBiet ctddb) {
        insert(ctddb.getIdDip(), ctddb.getIdNhanKhau(), ctddb.getNhom(), ctddb.getKiemtra());
        return true;
    }

    
    /**
     * Xóa chi tiết dịp đặc biệt
     * @param ctddb
     * @return true nếu xóa được và false nếu catch một ngoại lệ
     */
    public static boolean xoaChiTietDipDacBiet(ChiTietDipDacBiet ctddb) {
        return xoaChiTietDipDacBiet(ctddb.getIdDip(), ctddb.getIdNhanKhau());
    }
    
    /**
     * Xóa chi tiết dịp đặc biệt theo Id     
     * @param IdDip
     * @param IdNhanKhau
     * @return true nếu xóa được và false nếu catch một ngoại lệ
     */
    public static boolean xoaChiTietDipDacBiet(int IdDip, int IdNhanKhau)  {
        String sql = "DELETE FROM chi_tiet_dip_dac_biet WHERE IdDip = " + "'" + IdDip + "'"
        + " AND IdNhanKhau = " + "'" + IdNhanKhau + "'";

        try{
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
     * Sửa đổi một chi tiết
     * @param ctddb
     * @return 
     */
    public static boolean capNhatChiTietDipDacBiet(ChiTietDipDacBiet ctddb) {
        String sql = "UPDATE chi_tiet_dip_dac_biet SET nhom=?, kiemtra=? WHERE IdDip = "+ ctddb.getIdDip()
        + " AND IdNhanKhau = " + ctddb.getIdNhanKhau();

        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ctddb.getNhom());
            pstmt.setBoolean(2, ctddb.getKiemtra()); 
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @return Toàn bộ chi tiết dịp đặc biệt
     */
    public static ArrayList<ChiTietDipDacBiet> layListChiTietDipDacBiet() {
        String sql = "SELECT * FROM chi_tiet_dip_dac_biet ORDER BY IdDip";
        ArrayList<ChiTietDipDacBiet> ChiTietDipDacBiets = new ArrayList<ChiTietDipDacBiet>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int idDip = rs.getInt("IdDip");
                int idNhanKhau = rs.getInt("idNhanKhau");
                int nhom = rs.getInt("nhom");
                boolean kiemtra = rs.getBoolean("kiemTra");

                ChiTietDipDacBiets.add(new ChiTietDipDacBiet(idDip, idNhanKhau, nhom, kiemtra));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ChiTietDipDacBiets;
    }

    /**
     * @param search
     * @return list toàn bộ chi tiết dịp đặc biệt mà nhân khẩu có tên/id/cccd chứa đoạn search
     */
    public static ArrayList<ChiTietDipDacBiet> layListChiTietDipDacBiet(String search) {
        String sql = "SELECT * FROM chi_tiet_dip_dac_biet join nhan_khau on (chi_tiet_dip_dac_biet.idNhanKhau = nhan_khau.IdNhanKhau)"+
        " WHERE hoTen LIKE '%" + search + "%'  OR soCCCD LIKE '%" + search 
        + "%' OR chi_tiet_dip_dac_biet.IdDip LIKE '%" + search + "%' OR nhan_khau.IdNhanKhau LIKE '%" + search + "%'"
        + " ORDER BY chi_tiet_dip_dac_biet.IdDip";
        ArrayList<ChiTietDipDacBiet> ChiTietDipDacBiets = new ArrayList<ChiTietDipDacBiet>();
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idDip = rs.getInt("IdDip");
                int idNhanKhau = rs.getInt("idNhanKhau");
                int nhom = rs.getInt("nhom");
                boolean kiemtra = rs.getBoolean("kiemTra");

                ChiTietDipDacBiets.add(new ChiTietDipDacBiet(idDip, idNhanKhau, nhom, kiemtra));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ChiTietDipDacBiets;
    }

    /**
     * @return số lượt nhận thưởng đặc biệt đã có
     */
    public static int countChiTietDipDacBiet() {
        String sql = "SELECT count(*) as c FROM chi_tiet_dip_dac_biet";
        int countChiTietDipDacBiet =0;
        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                countChiTietDipDacBiet = rs.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countChiTietDipDacBiet;
    }

    /**
     * @param IdDipHSG
     * @return lấy list nhân khẩu được nhận thưởng trong dịp này
     */
    public static ArrayList<NhanKhau> layListNhanKhau(int IdDipHSG) {
        String sql = "SELECT nhan_khau.* FROM nhan_khau join chi_tiet_dip_dac_biet as ct on (nhan_khau.idNhanKhau = ct.idNhanKhau) " +
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
