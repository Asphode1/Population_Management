package com.lele.cnpm.src.models;

import java.util.Objects;

import com.lele.cnpm.database.modify.DipDacBietModify;

public class DipDacBiet {
    private int idDip;
    private String ten;
    private int nam;
    private String moTa;
    /**
     * Phần quà các loại
     */
    private String phanQua05, phanQua614, phanQua1517;
    /**
     * Quy đổi ra tiền
     */
    private float tien05, tien614, tien1517;
    private int soNguoiChuaTraoThuong;


    public DipDacBiet() {
    }

    public DipDacBiet(int idDip, String ten, int nam, String moTa, String phanQua05, String phanQua614, String phanQua1517, float tien05, float tien614, float tien1517, int soNguoiChuaTraoThuong) {
        this.idDip = idDip;
        this.ten = ten;
        this.nam = nam;
        this.moTa = moTa;
        this.phanQua05 = phanQua05;
        this.phanQua614 = phanQua614;
        this.phanQua1517 = phanQua1517;
        this.tien05 = tien05;
        this.tien614 = tien614;
        this.tien1517 = tien1517;
        this.soNguoiChuaTraoThuong = soNguoiChuaTraoThuong;
    }
    public DipDacBiet(int idDip, String ten, int nam, String moTa, String phanQua05, String phanQua614, String phanQua1517, float tien05, float tien614, float tien1517) {
        this.idDip = idDip;
        this.ten = ten;
        this.nam = nam;
        this.moTa = moTa;
        this.phanQua05 = phanQua05;
        this.phanQua614 = phanQua614;
        this.phanQua1517 = phanQua1517;
        this.tien05 = tien05;
        this.tien614 = tien614;
        this.tien1517 = tien1517;
    }

    public int getIdDip() {
        return this.idDip;
    }

    public void setIdDip(int idDip) {
        this.idDip = idDip;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNam() {
        return this.nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getPhanQua05() {
        return this.phanQua05;
    }

    public void setPhanQua05(String phanQua05) {
        this.phanQua05 = phanQua05;
    }

    public String getPhanQua614() {
        return this.phanQua614;
    }

    public void setPhanQua614(String phanQua614) {
        this.phanQua614 = phanQua614;
    }

    public String getPhanQua1517() {
        return this.phanQua1517;
    }

    public void setPhanQua1517(String phanQua1517) {
        this.phanQua1517 = phanQua1517;
    }

    public float getTien05() {
        return this.tien05;
    }

    public void setTien05(float tien05) {
        this.tien05 = tien05;
    }

    public float getTien614() {
        return this.tien614;
    }

    public void setTien614(float tien614) {
        this.tien614 = tien614;
    }

    public float getTien1517() {
        return this.tien1517;
    }

    public void setTien1517(float tien1517) {
        this.tien1517 = tien1517;
    }

    public int getSoNguoiChuaTraoThuong() {
        setSoNguoiChuaTraoThuong();
        return this.soNguoiChuaTraoThuong;
    }

    public void setSoNguoiChuaTraoThuong() {
        this.soNguoiChuaTraoThuong = DipDacBietModify.countChuaTraoThuong(this.idDip);
    }

    public DipDacBiet idDip(int idDip) {
        setIdDip(idDip);
        return this;
    }

    public DipDacBiet ten(String ten) {
        setTen(ten);
        return this;
    }

    public DipDacBiet nam(int nam) {
        setNam(nam);
        return this;
    }

    public DipDacBiet moTa(String moTa) {
        setMoTa(moTa);
        return this;
    }

    public DipDacBiet phanQua05(String phanQua05) {
        setPhanQua05(phanQua05);
        return this;
    }

    public DipDacBiet phanQua614(String phanQua614) {
        setPhanQua614(phanQua614);
        return this;
    }

    public DipDacBiet phanQua1517(String phanQua1517) {
        setPhanQua1517(phanQua1517);
        return this;
    }

    public DipDacBiet tien05(float tien05) {
        setTien05(tien05);
        return this;
    }

    public DipDacBiet tien614(float tien614) {
        setTien614(tien614);
        return this;
    }

    public DipDacBiet tien1517(float tien1517) {
        setTien1517(tien1517);
        return this;
    }

    public DipDacBiet soNguoiChuaTraoThuong(int soNguoiChuaTraoThuong) {
        setSoNguoiChuaTraoThuong();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DipDacBiet)) {
            return false;
        }
        DipDacBiet dipDacBiet = (DipDacBiet) o;
        return idDip == dipDacBiet.idDip && Objects.equals(ten, dipDacBiet.ten) && nam == dipDacBiet.nam && Objects.equals(moTa, dipDacBiet.moTa) && Objects.equals(phanQua05, dipDacBiet.phanQua05) && Objects.equals(phanQua614, dipDacBiet.phanQua614) && Objects.equals(phanQua1517, dipDacBiet.phanQua1517) && tien05 == dipDacBiet.tien05 && tien614 == dipDacBiet.tien614 && tien1517 == dipDacBiet.tien1517 && soNguoiChuaTraoThuong == dipDacBiet.soNguoiChuaTraoThuong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDip, ten, nam, moTa, phanQua05, phanQua614, phanQua1517, tien05, tien614, tien1517, soNguoiChuaTraoThuong);
    }

    @Override
    public String toString() {
        return "{" +
            " idDip='" + getIdDip() + "'" +
            ", ten='" + getTen() + "'" +
            ", nam='" + getNam() + "'" +
            ", moTa='" + getMoTa() + "'" +
            ", phanQua05='" + getPhanQua05() + "'" +
            ", phanQua614='" + getPhanQua614() + "'" +
            ", phanQua1517='" + getPhanQua1517() + "'" +
            ", tien05='" + getTien05() + "'" +
            ", tien614='" + getTien614() + "'" +
            ", tien1517='" + getTien1517() + "'" +
            ", soNguoiChuaTraoThuong='" + getSoNguoiChuaTraoThuong() + "'" +
            "}";
    }
}
