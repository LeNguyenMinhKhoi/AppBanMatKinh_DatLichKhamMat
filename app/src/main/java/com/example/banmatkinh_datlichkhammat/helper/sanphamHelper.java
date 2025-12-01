package com.example.banmatkinh_datlichkhammat.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.sanpham;
import com.example.banmatkinh_datlichkhammat.model.sanpham_nu;

import java.util.ArrayList;

public class sanphamHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_shop.sqlite";
    private static final int DB_VERSION = 3;


    public sanphamHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    public static class TABLE implements BaseColumns {
        private static final String TB_NAME = "sanpham";
        private static final String COL_NAME = "name";
        private static final String COL_IMG = "image";
        private static final String COL_PRICE = "price";


    }

    public ArrayList<sanpham> getSanPhamNamBanChay() {
        ArrayList<sanpham> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM sanpham ORDER BY price DESC", null); // sắp xếp theo giá
        while (cursor.moveToNext()) {
            sanpham sp = new sanpham();
            int imageId = 0;
            switch(cursor.getInt(cursor.getColumnIndexOrThrow("image"))) {
                case 1: imageId = R.drawable.sp1; break;
                case 2: imageId = R.drawable.sp2; break;
                case 3: imageId = R.drawable.sp3; break;
                case 4: imageId = R.drawable.sp4; break;
            }
            sp.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
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
