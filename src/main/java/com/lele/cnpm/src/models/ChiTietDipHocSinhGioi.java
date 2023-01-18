package com.lele.cnpm.src.models;

import java.util.Objects;

public class ChiTietDipHocSinhGioi {
    private int idDip;
    /**
     * nhân khẩu được thưởng
     */
    private int idNhanKhau;
    private String truong;
    private String lop;
    private int nhom; // nhom 1,2,3: DacBiet, Gioi, Kha
    /**
     * đã trao thưởng hay chưa 
     */
    private boolean kiemtra;
    
    public ChiTietDipHocSinhGioi() {
    }

    public ChiTietDipHocSinhGioi(int idDip, int idNhanKhau, String truong, String lop, int nhom, boolean kiemtra) {
        this.idDip = idDip;
        this.idNhanKhau = idNhanKhau;
        this.truong = truong;
        this.lop = lop;
        this.nhom = nhom;
        this.kiemtra = kiemtra;
    }

    public ChiTietDipHocSinhGioi(int idDip, int idNhanKhau, String truong, String lop, int nhom) {
        this.idDip = idDip;
        this.idNhanKhau = idNhanKhau;
        this.truong = truong;
        this.lop = lop;
        this.nhom = nhom;
        this.kiemtra = false;
    }

    public int getIdDip() {
        return this.idDip;
    }

    public void setIdDip(int idDip) {
        this.idDip = idDip;
    }

    public int getIdNhanKhau() {
        return this.idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getTruong() {
        return this.truong;
    }

    public void setTruong(String truong) {
        this.truong = truong;
    }

    public String getLop() {
        return this.lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getNhom() {
        return this.nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    public boolean isKiemtra() {
        return this.kiemtra;
    }

    public boolean getKiemtra() {
        return this.kiemtra;
    }

    public void setKiemtra(boolean kiemtra) {
        this.kiemtra = kiemtra;
    }

    public ChiTietDipHocSinhGioi idDip(int idDip) {
        setIdDip(idDip);
        return this;
    }

    public ChiTietDipHocSinhGioi idNhanKhau(int idNhanKhau) {
        setIdNhanKhau(idNhanKhau);
        return this;
    }

    public ChiTietDipHocSinhGioi truong(String truong) {
        setTruong(truong);
        return this;
    }

    public ChiTietDipHocSinhGioi lop(String lop) {
        setLop(lop);
        return this;
    }

    public ChiTietDipHocSinhGioi nhom(int nhom) {
        setNhom(nhom);
        return this;
    }

    public ChiTietDipHocSinhGioi kiemtra(boolean kiemtra) {
        setKiemtra(kiemtra);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChiTietDipHocSinhGioi)) {
            return false;
        }
        ChiTietDipHocSinhGioi chiTietDipHocSinhGioi = (ChiTietDipHocSinhGioi) o;
        return idDip == chiTietDipHocSinhGioi.idDip && idNhanKhau == chiTietDipHocSinhGioi.idNhanKhau && Objects.equals(truong, chiTietDipHocSinhGioi.truong) && Objects.equals(lop, chiTietDipHocSinhGioi.lop) && nhom == chiTietDipHocSinhGioi.nhom && kiemtra == chiTietDipHocSinhGioi.kiemtra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDip, idNhanKhau, truong, lop, nhom, kiemtra);
    }

    @Override
    public String toString() {
        return "{" +
            " idDip='" + getIdDip() + "'" +
            ", idNhanKhau='" + getIdNhanKhau() + "'" +
            ", truong='" + getTruong() + "'" +
            ", lop='" + getLop() + "'" +
            ", nhom='" + getNhom() + "'" +
            ", kiemtra='" + isKiemtra() + "'" +
            "}";
    }

}
