package com.lele.cnpm.src.models;

// class nguoi dang nhap va su dung app
// author: LuongHvd
public class NguoiDung {
    private int ID;
    private String userName;
    private byte[] salt;
    private String hash;
    private String chucVu;

    public NguoiDung() {
    }

    public NguoiDung(int ID, String userName, byte[] salt, String hash, String chucVu) {
        this.ID = ID;
        this.userName = userName;
        this.salt = salt;
        this.hash = hash;
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

    public byte[] getSalt() {
        return this.salt;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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