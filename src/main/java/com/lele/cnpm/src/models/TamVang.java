package com.lele.cnpm.src.models;

import java.sql.Date;
import java.util.Objects;

public class TamVang {
    private int ID;
    private int idNhanKhau;
    private String noiTamTru;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;

    public TamVang() {
    }

    public TamVang(int ID, int idNhanKhau, String noiTamTru, Date tuNgay, Date denNgay, String lyDo) {
        this.ID = ID;
        this.idNhanKhau = idNhanKhau;
        this.noiTamTru = noiTamTru;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdNhanKhau() {
        return this.idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getNoiTamTru() {
        return this.noiTamTru;
    }

    public void setNoiTamTru(String noiTamTru) {
        this.noiTamTru = noiTamTru;
    }

    public Date getTuNgay() {
        return this.tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return this.denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public String getLyDo() {
        return this.lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public TamVang ID(int ID) {
        setID(ID);
        return this;
    }

    public TamVang idNhanKhau(int idNhanKhau) {
        setIdNhanKhau(idNhanKhau);
        return this;
    }

    public TamVang noiTamTru(String noiTamTru) {
        setNoiTamTru(noiTamTru);
        return this;
    }

    public TamVang tuNgay(Date tuNgay) {
        setTuNgay(tuNgay);
        return this;
    }

    public TamVang denNgay(Date denNgay) {
        setDenNgay(denNgay);
        return this;
    }

    public TamVang lyDo(String lyDo) {
        setLyDo(lyDo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TamVang)) {
            return false;
        }
        TamVang tamVang = (TamVang) o;
        return ID == tamVang.ID && idNhanKhau == tamVang.idNhanKhau && Objects.equals(noiTamTru, tamVang.noiTamTru) && Objects.equals(tuNgay, tamVang.tuNgay) && Objects.equals(denNgay, tamVang.denNgay) && Objects.equals(lyDo, tamVang.lyDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, idNhanKhau, noiTamTru, tuNgay, denNgay, lyDo);
    }

    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", idNhanKhau='" + getIdNhanKhau() + "'" +
            ", noiTamTru='" + getNoiTamTru() + "'" +
            ", tuNgay='" + getTuNgay() + "'" +
            ", denNgay='" + getDenNgay() + "'" +
            ", lyDo='" + getLyDo() + "'" +
            "}";
    }

}
