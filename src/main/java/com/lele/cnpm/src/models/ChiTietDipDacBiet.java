package com.lele.cnpm.src.models;

import java.util.Objects;

public class ChiTietDipDacBiet {
    private int idDip;
    /**
     * nhân khẩu được thưởng
     */
    private int idNhanKhau;
    /**
     * nhóm thưởng của nhân khẩu:
     * 1: 0-5 tuổi
     * 2: 6-14 tuổi
     * 3: 15-17 tuổi
     */
    private int nhom;
    /**
     * đã nhận thưởng hay chưa
     */
    private boolean kiemtra;


    public ChiTietDipDacBiet() {
    }

    public ChiTietDipDacBiet(int idDip, int idNhanKhau, int nhom, boolean kiemtra) {
        this.idDip = idDip;
        this.idNhanKhau = idNhanKhau;
        this.nhom = nhom;
        this.kiemtra = kiemtra;
    }

    public ChiTietDipDacBiet(int idDip, int idNhanKhau, int nhom) {
        this.idDip = idDip;
        this.idNhanKhau = idNhanKhau;
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

    public ChiTietDipDacBiet idDip(int idDip) {
        setIdDip(idDip);
        return this;
    }

    public ChiTietDipDacBiet idNhanKhau(int idNhanKhau) {
        setIdNhanKhau(idNhanKhau);
        return this;
    }

    public ChiTietDipDacBiet nhom(int nhom) {
        setNhom(nhom);
        return this;
    }

    public ChiTietDipDacBiet kiemtra(boolean kiemtra) {
        setKiemtra(kiemtra);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChiTietDipDacBiet)) {
            return false;
        }
        ChiTietDipDacBiet chiTietDipDacBiet = (ChiTietDipDacBiet) o;
        return idDip == chiTietDipDacBiet.idDip && idNhanKhau == chiTietDipDacBiet.idNhanKhau && nhom == chiTietDipDacBiet.nhom && kiemtra == chiTietDipDacBiet.kiemtra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDip, idNhanKhau, nhom, kiemtra);
    }

    @Override
    public String toString() {
        return "{" +
            " idDip='" + getIdDip() + "'" +
            ", idNhanKhau='" + getIdNhanKhau() + "'" +
            ", nhom='" + getNhom() + "'" +
            ", kiemtra='" + isKiemtra() + "'" +
            "}";
    }

}
