package com.example.banmatkinh_datlichkhammat.model;

import java.util.Date;

public class donhang {
    private long madonhang;
    private int tongtien;
    private String ngaydat;

    public long getMadonhang() {
        return madonhang;
    }

    public void setMadonhang(long madonhang) {
        this.madonhang = madonhang;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public donhang(long madonhang, int tongtien, String ngaydat) {
        this.madonhang = madonhang;
        this.tongtien = tongtien;
        this.ngaydat = ngaydat;
    }

    public donhang() {
    }
}
