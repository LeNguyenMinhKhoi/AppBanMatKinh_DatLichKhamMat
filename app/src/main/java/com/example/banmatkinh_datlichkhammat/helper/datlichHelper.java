package com.example.banmatkinh_datlichkhammat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.banmatkinh_datlichkhammat.model.phieudatlich;

import java.util.ArrayList;

public class datlichHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_shop.sqlite";
    private static final int DB_VERSION = 4;

    public datlichHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    public boolean themPhieu(int userId, String date, String time, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("userId", userId);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("note", note);

        return db.insert("appointment", null, cv) != -1;
    }

    public ArrayList<phieudatlich> getAllPhieu(int userId) {
        ArrayList<phieudatlich> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM appointment WHERE userId=?",
                new String[]{String.valueOf(userId)});

        if (c.moveToFirst()) {
            do {
                list.add(new phieudatlich(
                        c.getInt(0),
                        c.getInt(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4)
                ));
            } while (c.moveToNext());
        }
        c.close();
        return list;
    }

    public void xoaPhieu(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("appointment", "id=?", new String[]{String.valueOf(id)});
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
