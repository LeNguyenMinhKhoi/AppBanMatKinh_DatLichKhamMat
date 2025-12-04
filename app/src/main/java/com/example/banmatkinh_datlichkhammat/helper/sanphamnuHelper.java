package com.example.banmatkinh_datlichkhammat.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.sanpham_nu;

import java.util.ArrayList;

public class sanphamnuHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_shop.sqlite";
    private static final int DB_VERSION = 4;


    public sanphamnuHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    public ArrayList<sanpham_nu> getSanPhamNuBanChay() {
        ArrayList<sanpham_nu> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sanpham_nu ORDER BY price DESC", null); // sắp xếp theo giá
        while (cursor.moveToNext()) {
            sanpham_nu sp = new sanpham_nu();
            int imageId = 0;
            switch(cursor.getInt(cursor.getColumnIndexOrThrow("image"))) {

                case 101: imageId = R.drawable.sp1_nu; break;
                case 102: imageId = R.drawable.sp2_nu; break;
                case 103: imageId = R.drawable.sp3_nu; break;

            }
            sp.setImg(imageId);
            sp.setTensp(cursor.getString(cursor.getColumnIndexOrThrow("name")));
            sp.setGia(cursor.getInt(cursor.getColumnIndexOrThrow("price")));
            list.add(sp);
        }
        cursor.close();
        return list;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
