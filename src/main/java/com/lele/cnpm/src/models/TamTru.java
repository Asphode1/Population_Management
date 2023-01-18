package com.lele.cnpm.src.models;

import java.sql.Date;
import java.util.Objects;

public class TamTru {
    private int ID;
    private int idNhanKhau;
    private String noiThuongTru;
    private String noiTamTru;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;

    public TamTru() {
    }

    public TamTru(int ID, int idNhanKhau, String noiThuongTru, String noiTamTru, Date tuNgay, Date denNgay, String lyDo) {
        this.ID = ID;
        this.idNhanKhau = idNhanKhau;
        this.noiThuongTru = noiThuongTru;
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

    public String getNoiThuongTru() {
        return this.noiThuongTru;
    }

    public void setNoiThuongTru(String noiThuongTru) {
        this.noiThuongTru = noiThuongTru;
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

    public TamTru ID(int ID) {
        setID(ID);
        return this;
    }

    public TamTru idNhanKhau(int idNhanKhau) {
        setIdNhanKhau(idNhanKhau);
        return this;
    }

    public TamTru noiThuongTru(String noiThuongTru) {
        setNoiThuongTru(noiThuongTru);
        return this;
    }

    public TamTru noiTamTru(String noiTamTru) {
        setNoiTamTru(noiTamTru);
        return this;
    }

    public TamTru tuNgay(Date tuNgay) {
        setTuNgay(tuNgay);
        return this;
    }

    public TamTru denNgay(Date denNgay) {
        setDenNgay(denNgay);
        return this;
    }

    public TamTru lyDo(String lyDo) {
        setLyDo(lyDo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TamTru)) {
            return false;
        }
        TamTru tamTru = (TamTru) o;
        return ID == tamTru.ID && idNhanKhau == tamTru.idNhanKhau && Objects.equals(noiThuongTru, tamTru.noiThuongTru) && Objects.equals(noiTamTru, tamTru.noiTamTru) && Objects.equals(tuNgay, tamTru.tuNgay) && Objects.equals(denNgay, tamTru.denNgay) && Objects.equals(lyDo, tamTru.lyDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, idNhanKhau, noiThuongTru, noiTamTru, tuNgay, denNgay, lyDo);
    }

    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", idNhanKhau='" + getIdNhanKhau() + "'" +
            ", noiThuongTru='" + getNoiThuongTru() + "'" +
            ", noiTamTru='" + getNoiTamTru() + "'" +
            ", tuNgay='" + getTuNgay() + "'" +
            ", denNgay='" + getDenNgay() + "'" +
            ", lyDo='" + getLyDo() + "'" +
            "}";
    }

}
