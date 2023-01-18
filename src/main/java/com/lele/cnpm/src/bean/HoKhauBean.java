package com.lele.cnpm.src.bean;

import java.util.ArrayList;
import java.util.Objects;

import com.lele.cnpm.src.models.*;

public class HoKhauBean {
    private HoKhau hoKhau;
    private NhanKhau chuHo;
    private ArrayList<NhanKhau> listNhanKhaus;
    private ArrayList<String> listQuanHeChuHos;


    public HoKhauBean() {
    }

    public HoKhauBean(HoKhau hoKhau, NhanKhau chuHo, ArrayList<NhanKhau> listNhanKhaus, ArrayList<String> listQuanHeChuHos) {
        this.hoKhau = hoKhau;
        this.chuHo = chuHo;
        this.listNhanKhaus = listNhanKhaus;
        this.listQuanHeChuHos = listQuanHeChuHos;
    }

    public HoKhau getHoKhau() {
        return this.hoKhau;
    }

    public void setHoKhau(HoKhau hoKhau) {
        this.hoKhau = hoKhau;
    }

    public NhanKhau getChuHo() {
        return this.chuHo;
    }

    public void setChuHo(NhanKhau chuHo) {
        this.chuHo = chuHo;
    }

    public ArrayList<NhanKhau> getListNhanKhaus() {
        return this.listNhanKhaus;
    }

    public void setListNhanKhaus(ArrayList<NhanKhau> listNhanKhaus) {
        this.listNhanKhaus = listNhanKhaus;
    }

    public ArrayList<String> getListQuanHeChuHos() {
        return this.listQuanHeChuHos;
    }

    public void setListQuanHeChuHos(ArrayList<String> listQuanHeChuHos) {
        this.listQuanHeChuHos = listQuanHeChuHos;
    }

    public HoKhauBean hoKhau(HoKhau hoKhau) {
        setHoKhau(hoKhau);
        return this;
    }

    public HoKhauBean chuHo(NhanKhau chuHo) {
        setChuHo(chuHo);
        return this;
    }

    public HoKhauBean listNhanKhaus(ArrayList<NhanKhau> listNhanKhaus) {
        setListNhanKhaus(listNhanKhaus);
        return this;
    }

    public HoKhauBean listQuanHeChuHos(ArrayList<String> listQuanHeChuHos) {
        setListQuanHeChuHos(listQuanHeChuHos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HoKhauBean)) {
            return false;
        }
        HoKhauBean hoKhauBean = (HoKhauBean) o;
        return Objects.equals(hoKhau, hoKhauBean.hoKhau) && Objects.equals(chuHo, hoKhauBean.chuHo) && Objects.equals(listNhanKhaus, hoKhauBean.listNhanKhaus) && Objects.equals(listQuanHeChuHos, hoKhauBean.listQuanHeChuHos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoKhau, chuHo, listNhanKhaus, listQuanHeChuHos);
    }

    @Override
    public String toString() {
        return "{" +
            " hoKhau='" + getHoKhau() + "'" +
            ", chuHo='" + getChuHo() + "'" +
            ", listNhanKhaus='" + getListNhanKhaus() + "'" +
            ", listQuanHeChuHos='" + getListQuanHeChuHos() + "'" +
            "}";
    }    
}
