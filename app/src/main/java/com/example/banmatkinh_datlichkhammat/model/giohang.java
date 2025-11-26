package com.example.banmatkinh_datlichkhammat.model;

public class giohang {
    private int img;
    private String tensp;
    private float gia;
    private int soluong;

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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public giohang(int img, String tensp, float gia, int soluong) {
        this.img = img;
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
    }

    public giohang() {
    }
}
