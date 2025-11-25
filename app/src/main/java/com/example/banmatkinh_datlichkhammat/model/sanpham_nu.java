package com.example.banmatkinh_datlichkhammat.model;

public class sanpham_nu {
    private int img;
    private String tensp;
    private Float gia;

    public sanpham_nu() {
    }

    public sanpham_nu(int img, String tensp, Float gia) {
        this.img = img;
        this.tensp = tensp;
        this.gia = gia;
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

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }
}
