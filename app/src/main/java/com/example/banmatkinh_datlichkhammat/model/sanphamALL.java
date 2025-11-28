package com.example.banmatkinh_datlichkhammat.model;

public class sanphamALL {
    private int img;
    private String tensp;
    private int gia;

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

    public sanphamALL() {
    }

    public sanphamALL(int img, String tensp, int gia) {
        this.img = img;
        this.tensp = tensp;
        this.gia = gia;
    }

}
