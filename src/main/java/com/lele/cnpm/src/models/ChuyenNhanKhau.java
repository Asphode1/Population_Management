package com.lele.cnpm.src.models;

import java.sql.Date;
import java.util.Objects;

public class ChuyenNhanKhau {
    private int id;
    private int idNhanKhau;
    private Date ngayChuyenDi;
    private String noiChuyenDen;
    private String ghiChu;

    public ChuyenNhanKhau() {
    }

    public ChuyenNhanKhau(int id, int idNhanKhau, Date ngayChuyenDi, String noiChuyenDen, String ghiChu) {
        this.id = id;
        this.idNhanKhau = idNhanKhau;
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

    public int getIdNhanKhau() {
        return this.idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
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

    public ChuyenNhanKhau id(int id) {
        setId(id);
        return this;
    }

    public ChuyenNhanKhau idNhanKhau(int idNhanKhau) {
        setIdNhanKhau(idNhanKhau);
        return this;
    }

    public ChuyenNhanKhau ngayChuyenDi(Date ngayChuyenDi) {
        setNgayChuyenDi(ngayChuyenDi);
        return this;
    }

    public ChuyenNhanKhau noiChuyenDen(String noiChuyenDen) {
        setNoiChuyenDen(noiChuyenDen);
        return this;
    }

    public ChuyenNhanKhau ghiChu(String ghiChu) {
        setGhiChu(ghiChu);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ChuyenNhanKhau)) {
            return false;
        }
        ChuyenNhanKhau chuyenNhanKhau = (ChuyenNhanKhau) o;
        return id == chuyenNhanKhau.id && idNhanKhau == chuyenNhanKhau.idNhanKhau && Objects.equals(ngayChuyenDi, chuyenNhanKhau.ngayChuyenDi) && Objects.equals(noiChuyenDen, chuyenNhanKhau.noiChuyenDen) && Objects.equals(ghiChu, chuyenNhanKhau.ghiChu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idNhanKhau, ngayChuyenDi, noiChuyenDen, ghiChu);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idNhanKhau='" + getIdNhanKhau() + "'" +
            ", ngayChuyenDi='" + getNgayChuyenDi() + "'" +
            ", noiChuyenDen='" + getNoiChuyenDen() + "'" +
            ", ghiChu='" + getGhiChu() + "'" +
            "}";
    }
}
