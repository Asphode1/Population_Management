package com.lele.cnpm.src.models;

import java.sql.Date;
import java.util.Objects;

public class KhaiTu {
    private int idNguoiMat;
    private int idNguoiKhai;
    private Date ngayKhai;
    private Date ngayMat;
    private String lyDoMat;

    public KhaiTu() {
    }

    public KhaiTu(int idNguoiMat, int idNguoiKhai, Date ngayKhai, Date ngayMat, String lyDoMat) {
        this.idNguoiMat = idNguoiMat;
        this.idNguoiKhai = idNguoiKhai;
        this.ngayKhai = ngayKhai;
        this.ngayMat = ngayMat;
        this.lyDoMat = lyDoMat;
    }

    public int getIdNguoiMat() {
        return this.idNguoiMat;
    }

    public void setIdNguoiMat(int idNguoiMat) {
        this.idNguoiMat = idNguoiMat;
    }

    public int getIdNguoiKhai() {
        return this.idNguoiKhai;
    }

    public void setIdNguoiKhai(int idNguoiKhai) {
        this.idNguoiKhai = idNguoiKhai;
    }

    public Date getNgayKhai() {
        return this.ngayKhai;
    }

    public void setNgayKhai(Date ngayKhai) {
        this.ngayKhai = ngayKhai;
    }

    public Date getNgayMat() {
        return this.ngayMat;
    }

    public void setNgayMat(Date ngayMat) {
        this.ngayMat = ngayMat;
    }

    public String getLyDoMat() {
        return this.lyDoMat;
    }

    public void setLyDoMat(String lyDoMat) {
        this.lyDoMat = lyDoMat;
    }

    public KhaiTu idNguoiMat(int idNguoiMat) {
        setIdNguoiMat(idNguoiMat);
        return this;
    }

    public KhaiTu idNguoiKhai(int idNguoiKhai) {
        setIdNguoiKhai(idNguoiKhai);
        return this;
    }

    public KhaiTu ngayKhai(Date ngayKhai) {
        setNgayKhai(ngayKhai);
        return this;
    }

    public KhaiTu ngayMat(Date ngayMat) {
        setNgayMat(ngayMat);
        return this;
    }

    public KhaiTu lyDoMat(String lyDoMat) {
        setLyDoMat(lyDoMat);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof KhaiTu)) {
            return false;
        }
        KhaiTu khaiTu = (KhaiTu) o;
        return idNguoiMat == khaiTu.idNguoiMat && idNguoiKhai == khaiTu.idNguoiKhai && Objects.equals(ngayKhai, khaiTu.ngayKhai) && Objects.equals(ngayMat, khaiTu.ngayMat) && Objects.equals(lyDoMat, khaiTu.lyDoMat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNguoiMat, idNguoiKhai, ngayKhai, ngayMat, lyDoMat);
    }

    @Override
    public String toString() {
        return "{" +
            " idNguoiMat='" + getIdNguoiMat() + "'" +
            ", idNguoiKhai='" + getIdNguoiKhai() + "'" +
            ", ngayKhai='" + getNgayKhai() + "'" +
            ", ngayMat='" + getNgayMat() + "'" +
            ", lyDoMat='" + getLyDoMat() + "'" +
            "}";
    }

}