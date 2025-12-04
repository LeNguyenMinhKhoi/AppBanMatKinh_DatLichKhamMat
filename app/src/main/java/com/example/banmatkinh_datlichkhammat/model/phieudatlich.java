package com.example.banmatkinh_datlichkhammat.model;

import com.example.banmatkinh_datlichkhammat.util.FormatUtil;

import java.util.Date;

public class phieudatlich {
    int id;
    int userId;
    String date, time, note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public phieudatlich() {
    }

    public phieudatlich(int id, int userId,  String date, String time, String note) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.note = note;
    }
}
