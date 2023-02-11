package com.lele.cnpm.src.models;

import java.util.Objects;

import com.lele.cnpm.database.modify.DipHSGModify;

public class DipHSG {
    private int idDip;
    private int nam;
    private String moTa;
    private String phanQuaDacBiet;
    private String phanQuaGioi;
    private String phanQuaKha;
    private float tienDacBiet;
    private float tienGioi;
    private float tienKha;
    private int soNguoiChuaTraoThuong;

    public DipHSG() {
    }

    public DipHSG(int idDip, int nam, String moTa, String phanQuaDacBiet, String phanQuaGioi, String phanQuaKha, float tienDacBiet, float tienGioi, float tienKha, int soNguoiChuaTraoThuong) {
        this.idDip = idDip;
        this.nam = nam;
        this.moTa = moTa;
        this.phanQuaDacBiet = phanQuaDacBiet;
        this.phanQuaGioi = phanQuaGioi;
        this.phanQuaKha = phanQuaKha;
        this.tienDacBiet = tienDacBiet;
        this.tienGioi = tienGioi;
        this.tienKha = tienKha;
        this.soNguoiChuaTraoThuong = soNguoiChuaTraoThuong;
    }
    public DipHSG(int idDip, int nam, String moTa, String phanQuaDacBiet, String phanQuaGioi, String phanQuaKha, float tienDacBiet, float tienGioi, float tienKha) {
        this.idDip = idDip;
        this.nam = nam;
        this.moTa = moTa;
        this.phanQuaDacBiet = phanQuaDacBiet;
        this.phanQuaGioi = phanQuaGioi;
        this.phanQuaKha = phanQuaKha;
        this.tienDacBiet = tienDacBiet;
        this.tienGioi = tienGioi;
        this.tienKha = tienKha;
    }

    public int getIdDip() {
        return this.idDip;
    }

    public void setIdDip(int idDip) {
        this.idDip = idDip;
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

    public String getPhanQuaDacBiet() {
        return this.phanQuaDacBiet;
    }

    public void setPhanQuaDacBiet(String phanQuaDacBiet) {
        this.phanQuaDacBiet = phanQuaDacBiet;
    }

    public String getPhanQuaGioi() {
        return this.phanQuaGioi;
    }

    public void setPhanQuaGioi(String phanQuaGioi) {
        this.phanQuaGioi = phanQuaGioi;
    }

    public String getPhanQuaKha() {
        return this.phanQuaKha;
    }

    public void setPhanQuaKha(String phanQuaKha) {
        this.phanQuaKha = phanQuaKha;
    }

    public float getTienDacBiet() {
        return this.tienDacBiet;
    }

    public void setTienDacBiet(float tienDacBiet) {
        this.tienDacBiet = tienDacBiet;
    }

    public float getTienGioi() {
        return this.tienGioi;
    }

    public void setTienGioi(float tienGioi) {
        this.tienGioi = tienGioi;
    }

    public float getTienKha() {
        return this.tienKha;
    }

    public void setTienKha(float tienKha) {
        this.tienKha = tienKha;
    }

    public int getSoNguoiChuaTraoThuong() {
        setSoNguoiChuaTraoThuong();
        return this.soNguoiChuaTraoThuong;
    }

    public void setSoNguoiChuaTraoThuong() {
        this.soNguoiChuaTraoThuong = DipHSGModify.countChuaTraoThuong(this.idDip);
    }

    public DipHSG idDip(int idDip) {
        setIdDip(idDip);
        return this;
    }

    public DipHSG nam(int nam) {
        setNam(nam);
        return this;
    }

    public DipHSG moTa(String moTa) {
        setMoTa(moTa);
        return this;
    }

    public DipHSG phanQuaDacBiet(String phanQuaDacBiet) {
        setPhanQuaDacBiet(phanQuaDacBiet);
        return this;
    }

    public DipHSG phanQuaGioi(String phanQuaGioi) {
        setPhanQuaGioi(phanQuaGioi);
        return this;
    }

    public DipHSG phanQuaKha(String phanQuaKha) {
        setPhanQuaKha(phanQuaKha);
        return this;
    }

    public DipHSG tienDacBiet(float tienDacBiet) {
        setTienDacBiet(tienDacBiet);
        return this;
    }

    public DipHSG tienGioi(float tienGioi) {
        setTienGioi(tienGioi);
        return this;
    }

    public DipHSG tienKha(float tienKha) {
        setTienKha(tienKha);
        return this;
    }

    public DipHSG soNguoiChuaTraoThuong() {
        setSoNguoiChuaTraoThuong();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DipHSG)) {
            return false;
        }
        DipHSG dipHSG = (DipHSG) o;
        return idDip == dipHSG.idDip && nam == dipHSG.nam && Objects.equals(moTa, dipHSG.moTa) && Objects.equals(phanQuaDacBiet, dipHSG.phanQuaDacBiet) && Objects.equals(phanQuaGioi, dipHSG.phanQuaGioi) && Objects.equals(phanQuaKha, dipHSG.phanQuaKha) && tienDacBiet == dipHSG.tienDacBiet && tienGioi == dipHSG.tienGioi && tienKha == dipHSG.tienKha && soNguoiChuaTraoThuong == dipHSG.soNguoiChuaTraoThuong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDip, nam, moTa, phanQuaDacBiet, phanQuaGioi, phanQuaKha, tienDacBiet, tienGioi, tienKha, soNguoiChuaTraoThuong);
    }

    @Override
    public String toString() {
        return "{" +
            " idDip='" + getIdDip() + "'" +
            ", nam='" + getNam() + "'" +
            ", moTa='" + getMoTa() + "'" +
            ", phanQuaDacBiet='" + getPhanQuaDacBiet() + "'" +
            ", phanQuaGioi='" + getPhanQuaGioi() + "'" +
            ", phanQuaKha='" + getPhanQuaKha() + "'" +
            ", tienDacBiet='" + getTienDacBiet() + "'" +
            ", tienGioi='" + getTienGioi() + "'" +
            ", tienKha='" + getTienKha() + "'" +
            ", soNguoiChuaTraoThuong='" + getSoNguoiChuaTraoThuong() + "'" +
            "}";
    }
}
