package com.example.banmatkinh_datlichkhammat.model;

public class sanpham {
    private int id;
    private int img;
    private String tensp;
    private int gia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public sanpham() {
    }

    public sanpham(int id,int img, String tensp, int gia) {
        this.id=id;
        this.img = img;
        this.tensp = tensp;
        this.gia = gia;
    }
}

