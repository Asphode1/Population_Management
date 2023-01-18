package com.lele.cnpm.src.models;

import java.sql.Date;
import java.util.Objects;

public class ChuyenHoKhau {
    private int id;
    private int idHoKhau;
    private Date ngayChuyenDi;
    private String noiChuyenDen;
    private String ghiChu;

    public ChuyenHoKhau() {
    }

    public ChuyenHoKhau(int id, int idHoKhau, Date ngayChuyenDi, String noiChuyenDen, String ghiChu) {
        this.id = id;
        this.idHoKhau = idHoKhau;
        this.ngayChuyenDi = ngayChuyenDi;
        this.noiChuyenDen = noiChuyenDen;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoKhau() {
        return this.idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public Date getNgayChuyenDi() {
        return this.ngayChuyenDi;
    }

    public void setNgayChuyenDi(Date ngayChuyenDi) {
        this.ngayChuyenDi = ngayChuyenDi;
    }

    public String getNoiChuyenDen() {
        return this.noiChuyenDen;
    }

    public void setNoiChuyenDen(String noiChuyenDen) {
        this.noiChuyenDen = noiChuyenDen;
    }

    public String getGhiChu() {
        return this.ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ChuyenHoKhau id(int id) {
        setId(id);
        return this;
    }

    public ChuyenHoKhau idHoKhau(int idHoKhau) {
        setIdHoKhau(idHoKhau);
        return this;
    }

    public ChuyenHoKhau ngayChuyenDi(Date ngayChuyenDi) {
        setNgayChuyenDi(ngayChuyenDi);
        return this;
    }

    public ChuyenHoKhau noiChuyenDen(String noiChuyenDen) {
        setNoiChuyenDen(noiChuyenDen);
        return this;
    }

    public ChuyenHoKhau ghiChu(String ghiChu) {
        setGhiChu(ghiChu);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChuyenHoKhau)) {
            return false;
        }
        ChuyenHoKhau chuyenHoKhau = (ChuyenHoKhau) o;
        return id == chuyenHoKhau.id && idHoKhau == chuyenHoKhau.idHoKhau && Objects.equals(ngayChuyenDi, chuyenHoKhau.ngayChuyenDi) && Objects.equals(noiChuyenDen, chuyenHoKhau.noiChuyenDen) && Objects.equals(ghiChu, chuyenHoKhau.ghiChu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idHoKhau, ngayChuyenDi, noiChuyenDen, ghiChu);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idHoKhau='" + getIdHoKhau() + "'" +
            ", ngayChuyenDi='" + getNgayChuyenDi() + "'" +
            ", noiChuyenDen='" + getNoiChuyenDen() + "'" +
            ", ghiChu='" + getGhiChu() + "'" +
            "}";
    }

    private String ngayChuyenDiString;

    public String getNgayChuyenDiString() {
        if (this.ngayChuyenDiString == null) setNgayChuyenDiString();
        return ngayChuyenDiString;
    }

    public void setNgayChuyenDiString() {
        this.ngayChuyenDiString = NhanKhau.SQLDateToString(this.ngayChuyenDi);
    }
}
