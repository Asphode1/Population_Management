package com.lele.cnpm.src.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

// class mot nguoi can quan ly
public class NhanKhau {
    private int ID;
    private String hoTen;
    private String bietDanh;
    private Date ngaySinh;
    private String gioiTinh;
    private String noiSinh;
    private String nguyenQuan;
    private String danToc;
    private String tonGiao;
    private String quocTich;
    private String ngheNghiep;
    private String noiLamViec;
    private String soCCCD;
    private Date ngayCap;
    private Date chuyenDenNgay; 
    private String noiThuongTruTruoc;
    private String trangThai;

    private ObjectProperty<String> name = new SimpleObjectProperty<>();

    public NhanKhau() {
    }

    public NhanKhau(int ID, String hoTen, String bietDanh, Date ngaySinh, String gioiTinh, String noiSinh, String nguyenQuan, String danToc, String tonGiao, String quocTich, String ngheNghiep, String noiLamViec, String soCCCD, Date ngayCap, Date chuyenDenNgay, String noiThuongTruTruoc, String trangThai) {
        this.ID = ID;
        this.hoTen = hoTen;
        this.bietDanh = bietDanh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.quocTich = quocTich;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.soCCCD = soCCCD;
        this.ngayCap = ngayCap;
        this.chuyenDenNgay = chuyenDenNgay;
        this.noiThuongTruTruoc = noiThuongTruTruoc;
        if (trangThai == null|| trangThai.equals("") ) this.trangThai = "Thường trú";
        else this.trangThai = trangThai;
        setName(hoTen);
    }

    public String getName() {
      return name.get();
    }

    public void setName(String name){
      this.name.set(name);
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getBietDanh() {
        return this.bietDanh;
    }

    public void setBietDanh(String bietDanh) {
        this.bietDanh = bietDanh;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return this.noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return this.nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDanToc() {
        return this.danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return this.tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getQuocTich() {
        return this.quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNgheNghiep() {
        return this.ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNoiLamViec() {
        return this.noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public String getSoCCCD() {
        return this.soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public Date getNgayCap() {
        return this.ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public Date getChuyenDenNgay() {
        return this.chuyenDenNgay;
    }

    public void setChuyenDenNgay(Date chuyenDenNgay) {
        this.chuyenDenNgay = chuyenDenNgay;
    }

    public String getNoiThuongTruTruoc() {
        return this.noiThuongTruTruoc;
    }

    public void setNoiThuongTruTruoc(String noiThuongTruTruoc) {
        this.noiThuongTruTruoc = noiThuongTruTruoc;
    }

    public String getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanKhau ID(int ID) {
        setID(ID);
        return this;
    }

    public NhanKhau hoTen(String hoTen) {
        setHoTen(hoTen);
        return this;
    }

    public NhanKhau bietDanh(String bietDanh) {
        setBietDanh(bietDanh);
        return this;
    }

    public NhanKhau ngaySinh(Date ngaySinh) {
        setNgaySinh(ngaySinh);
        return this;
    }

    public NhanKhau gioiTinh(String gioiTinh) {
        setGioiTinh(gioiTinh);
        return this;
    }

    public NhanKhau noiSinh(String noiSinh) {
        setNoiSinh(noiSinh);
        return this;
    }

    public NhanKhau nguyenQuan(String nguyenQuan) {
        setNguyenQuan(nguyenQuan);
        return this;
    }

    public NhanKhau danToc(String danToc) {
        setDanToc(danToc);
        return this;
    }

    public NhanKhau tonGiao(String tonGiao) {
        setTonGiao(tonGiao);
        return this;
    }

    public NhanKhau quocTich(String quocTich) {
        setQuocTich(quocTich);
        return this;
    }

    public NhanKhau ngheNghiep(String ngheNghiep) {
        setNgheNghiep(ngheNghiep);
        return this;
    }

    public NhanKhau noiLamViec(String noiLamViec) {
        setNoiLamViec(noiLamViec);
        return this;
    }

    public NhanKhau soCCCD(String soCCCD) {
        setSoCCCD(soCCCD);
        return this;
    }

    public NhanKhau ngayCap(Date ngayCap) {
        setNgayCap(ngayCap);
        return this;
    }

    public NhanKhau chuyenDenNgay(Date chuyenDenNgay) {
        setChuyenDenNgay(chuyenDenNgay);
        return this;
    }

    public NhanKhau noiThuongTruTruoc(String noiThuongTruTruoc) {
        setNoiThuongTruTruoc(noiThuongTruTruoc);
        return this;
    }

    public NhanKhau trangThai(String trangThai) {
        setTrangThai(trangThai);
        return this;
    }

    /**
     * @return Tuổi nhân khẩu
     * Quy ước tính tuổi theo luật pháp Việt Nam:
     * Nhân khẩu đủ x tuổi vào ngày sinh nhật nhân khẩu đó x năm sau ngày sinh
     */
    public int getTuoi() {
        int year = LocalDate.now().getYear() - this.getNgaySinh().toLocalDate().getYear();
        int day = LocalDate.now().getDayOfYear() - this.getNgaySinh().toLocalDate().getDayOfYear();
        if (day < 0) return year-1;
        else return year;
    }

    /**
     * @return nhóm tuổi của một người
     * nhóm 0: mầm non mẫu giáo
     * nhóm 1: cấp 1
     * nhóm 2: cấp 2
     * nhóm 3: cấp 3
     * nhóm 4: tuổi lao động
     * nhóm 5: đã nghỉ hưu
     */
    public int getNhom() {
        int tuoi = this.getTuoi();
        if (0 <= tuoi && tuoi <= 5) return 0; // mầm non mẫu giáo
        if (6 <= tuoi && tuoi <= 10) return 1; // cấp 1
        if (11 <= tuoi && tuoi <= 14) return 2; // cấp 2
        if (15 <= tuoi && tuoi <= 17) return 3; // cấp 3
        if (18 <= tuoi && tuoi <= 65) return 4; // tuổi lao động
        if (66 <= tuoi ) return 5; // đã nghỉ hưu
        return 5;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NhanKhau)) {
            return false;
        }
        NhanKhau nhanKhau = (NhanKhau) o;
        return ID == nhanKhau.ID && Objects.equals(hoTen, nhanKhau.hoTen) && Objects.equals(bietDanh, nhanKhau.bietDanh) && Objects.equals(ngaySinh, nhanKhau.ngaySinh) && Objects.equals(gioiTinh, nhanKhau.gioiTinh) && Objects.equals(noiSinh, nhanKhau.noiSinh) && Objects.equals(nguyenQuan, nhanKhau.nguyenQuan) && Objects.equals(danToc, nhanKhau.danToc) && Objects.equals(tonGiao, nhanKhau.tonGiao) && Objects.equals(quocTich, nhanKhau.quocTich) && Objects.equals(ngheNghiep, nhanKhau.ngheNghiep) && Objects.equals(noiLamViec, nhanKhau.noiLamViec) && Objects.equals(soCCCD, nhanKhau.soCCCD) && Objects.equals(ngayCap, nhanKhau.ngayCap) && Objects.equals(chuyenDenNgay, nhanKhau.chuyenDenNgay) && Objects.equals(noiThuongTruTruoc, nhanKhau.noiThuongTruTruoc) && Objects.equals(trangThai, nhanKhau.trangThai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, hoTen, bietDanh, ngaySinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, ngheNghiep, noiLamViec, soCCCD, ngayCap, chuyenDenNgay, noiThuongTruTruoc, trangThai);
    }

    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", hoTen='" + getHoTen() + "'" +
            ", bietDanh='" + getBietDanh() + "'" +
            ", ngaySinh='" + getNgaySinh() + "'" +
            ", gioiTinh='" + getGioiTinh() + "'" +
            ", noiSinh='" + getNoiSinh() + "'" +
            ", nguyenQuan='" + getNguyenQuan() + "'" +
            ", danToc='" + getDanToc() + "'" +
            ", tonGiao='" + getTonGiao() + "'" +
            ", quocTich='" + getQuocTich() + "'" +
            ", ngheNghiep='" + getNgheNghiep() + "'" +
            ", noiLamViec='" + getNoiLamViec() + "'" +
            ", soCCCD='" + getSoCCCD() + "'" +
            ", ngayCap='" + getNgayCap() + "'" +
            ", chuyenDenNgay='" + getChuyenDenNgay() + "'" +
            ", noiThuongTruTruoc='" + getNoiThuongTruTruoc() + "'" +
            ", trangThai='" + getTrangThai() + "'" +
            "}";
    }

    /**
     * @param d
     * @return Chuỗi dd-mm-yyyy
     */
    public static String SQLDateToString(Date d){
        if (d==null) return null;
        String s = d.toString();
        StringBuilder s2 = new StringBuilder();
        s2.append(s.charAt(8));s2.append(s.charAt(9));s2.append('-');
        s2.append(s.charAt(5));s2.append(s.charAt(6));s2.append('-');
        s2.append(s.charAt(0));s2.append(s.charAt(1));s2.append(s.charAt(2));s2.append(s.charAt(3));
        return s2.toString();
    }

    private String ngaySinhString;

    public String getNgaySinhString() {
        if (this.ngaySinhString == null) setNgaySinhString();
        return ngaySinhString;
    }

    public void setNgaySinhString() {
        this.ngaySinhString = SQLDateToString(this.ngaySinh);
    }

    public final ObjectProperty<String> hoTenProperty() {
      return name;
    }
}
