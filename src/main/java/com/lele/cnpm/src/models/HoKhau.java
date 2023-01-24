package com.lele.cnpm.src.models;

import java.sql.Date;
import java.util.Objects;

import com.lele.cnpm.src.services.NhanKhauManage;

public class HoKhau {
    private int ID;
    private int idChuHo;
    private String tinhThanhPho;
    private String quanHuyen;
    private String phuongXa;
    private String diaChi;
    /**
     * ngày tạo hộ khẩu
     */
    private Date ngayTao;
    /**
     * Trạng thái: tạm trú, thường trú, chuyển đi, tạm vắng,...
     */
    private String trangThai;
    private String tenChuHo;

    public HoKhau() {
    }

    public HoKhau(int ID, int idChuHo, String tinhThanhPho, String quanHuyen, String phuongXa, String diaChi, Date ngayTao, String trangThai) {
        this.ID = ID;
        this.idChuHo = idChuHo;
        this.tinhThanhPho = tinhThanhPho;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        if (trangThai.equals("") || trangThai == null) this.trangThai = "Thường trú";
        else this.trangThai = trangThai;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdChuHo() {
        return this.idChuHo;
    }

    public void setIdChuHo(int idChuHo) {
        this.idChuHo = idChuHo;
    }

    public String getTinhThanhPho() {
        return this.tinhThanhPho;
    }

    public void setTinhThanhPho(String tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }

    public String getQuanHuyen() {
        return this.quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return this.phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTao() {
        return this.ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public HoKhau ID(int ID) {
        setID(ID);
        return this;
    }

    public HoKhau idChuHo(int idChuHo) {
        setIdChuHo(idChuHo);
        return this;
    }

    public HoKhau tinhThanhPho(String tinhThanhPho) {
        setTinhThanhPho(tinhThanhPho);
        return this;
    }

    public HoKhau quanHuyen(String quanHuyen) {
        setQuanHuyen(quanHuyen);
        return this;
    }

    public HoKhau phuongXa(String phuongXa) {
        setPhuongXa(phuongXa);
        return this;
    }

    public HoKhau diaChi(String diaChi) {
        setDiaChi(diaChi);
        return this;
    }

    public HoKhau ngayTao(Date ngayTao) {
        setNgayTao(ngayTao);
        return this;
    }

    public HoKhau trangThai(String trangThai) {
        setTrangThai(trangThai);
        return this;
    }

    public void setTenChuHo() {
        this.tenChuHo = NhanKhauManage.layNhanKhau(getIdChuHo()).getHoTen();
    }

    public String getTenChuHo() {
        if (this.tenChuHo == null) 
            setTenChuHo();
        return this.tenChuHo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HoKhau)) {
            return false;
        }
        HoKhau hoKhau = (HoKhau) o;
        return ID == hoKhau.ID && idChuHo == hoKhau.idChuHo && Objects.equals(tinhThanhPho, hoKhau.tinhThanhPho) && Objects.equals(quanHuyen, hoKhau.quanHuyen) && Objects.equals(phuongXa, hoKhau.phuongXa) && Objects.equals(diaChi, hoKhau.diaChi) && Objects.equals(ngayTao, hoKhau.ngayTao) && Objects.equals(trangThai, hoKhau.trangThai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, idChuHo, tinhThanhPho, quanHuyen, phuongXa, diaChi, ngayTao, trangThai);
    }

    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", idChuHo='" + getIdChuHo() + "'" +
            ", tinhThanhPho='" + getTinhThanhPho() + "'" +
            ", quanHuyen='" + getQuanHuyen() + "'" +
            ", phuongXa='" + getPhuongXa() + "'" +
            ", diaChi='" + getDiaChi() + "'" +
            ", ngayTao='" + getNgayTao() + "'" +
            ", trangThai='" + getTrangThai() + "'" +
            "}";
    }    

    private String SQLDateToString(Date d){
        String s = d.toString();
        StringBuilder s2 = new StringBuilder();
        s2.append(s.charAt(8));s2.append(s.charAt(9));s2.append('-');
        s2.append(s.charAt(5));s2.append(s.charAt(6));s2.append('-');
        s2.append(s.charAt(0));s2.append(s.charAt(1));s2.append(s.charAt(2));s2.append(s.charAt(3));
        return s2.toString();
    }

    private String ngayTaoString;

    public String getNgayTaoString() {
        if (this.ngayTaoString == null) setNgayTaoString();
        return ngayTaoString;
    }

    public void setNgayTaoString() {
        this.ngayTaoString = SQLDateToString(this.ngayTao);
    }
}
