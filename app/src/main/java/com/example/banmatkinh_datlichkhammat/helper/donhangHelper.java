package com.example.banmatkinh_datlichkhammat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.banmatkinh_datlichkhammat.model.donhang;

import java.util.ArrayList;

public class donhangHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_shop.sqlite";
    private static final int DB_VERSION = 4;

    public donhangHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


    public void themDonHang(long orderId, int userId, int totalPrice, String date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", orderId);
        cv.put("userId", userId);
        cv.put("totalPrice", totalPrice);
        cv.put("date", date);
        long result = db.insert("orders", null, cv);
        if(result == -1){
            Log.e("DonHangHelper", "Thêm đơn hàng thất bại");
        }
        db.close();
    }

    public ArrayList<donhang> getDonHang(int userId){
        ArrayList<donhang> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM orders WHERE userId = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(userId)});
        while(cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            int total = cursor.getInt(cursor.getColumnIndexOrThrow("totalPrice"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            list.add(new donhang(id, total, date));
        }
        cursor.close();
        return list;
    }
    public void xoaDonHang(long orderId){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("orders", "id = ?", new String[]{String.valueOf(orderId)});
        db.close();
    }
}
