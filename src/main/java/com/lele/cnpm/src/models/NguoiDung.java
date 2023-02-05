package com.lele.cnpm.src.models;

import com.lele.cnpm.src.encrypt.Password;

// class nguoi dang nhap va su dung app
// author: LuongHvd
public class NguoiDung {
  private int ID;
  private String userName;
  private Password pasword;
  private String chucVu;

  public NguoiDung() {
  }

  public NguoiDung(int ID, String userName, Password p, String chucVu) {
    this.ID = ID;
    this.userName = userName;
    this.pasword = p;
    this.chucVu = chucVu;
  }

  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Password getPasword() {
    return this.pasword;
  }

  public void setPasword(Password pasword) {
    this.pasword = pasword;
  }

  public String getChucVu() {
    return this.chucVu;
  }

  public void setChucVu(String chucVu) {
    this.chucVu = chucVu;
  }

  public NguoiDung ID(int ID) {
    setID(ID);
    return this;
  }

  public NguoiDung userName(String userName) {
    setUserName(userName);
    return this;
  }

  public NguoiDung chucVu(String chucVu) {
    setChucVu(chucVu);
    return this;
  }
}