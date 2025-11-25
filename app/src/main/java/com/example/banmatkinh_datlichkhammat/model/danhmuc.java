package com.example.banmatkinh_datlichkhammat.model;

public class danhmuc {
    private int Image;

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    private String tendanhmuc;

    public danhmuc() {
    }

    public danhmuc(int image, String tendanhmuc) {
        Image = image;
        this.tendanhmuc = tendanhmuc;
    }

}
