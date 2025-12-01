package com.example.banmatkinh_datlichkhammat.model;

public class giohang {
    private int masp;
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

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
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

    public giohang(int masp,int img, String tensp, float gia, int soluong) {
        this.masp = masp;
        this.img = img;
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
    }

    public giohang() {
    }
}
