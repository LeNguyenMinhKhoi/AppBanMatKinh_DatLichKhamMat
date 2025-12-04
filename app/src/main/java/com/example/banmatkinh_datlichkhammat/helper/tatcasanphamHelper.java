package com.example.banmatkinh_datlichkhammat.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.sanpham;
import com.example.banmatkinh_datlichkhammat.model.sanphamALL;
import com.example.banmatkinh_datlichkhammat.model.sanpham_nu;

import java.util.ArrayList;

public class tatcasanphamHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="db_shop.sqlite";
    private static final int DB_VERSION = 4;
    public tatcasanphamHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    public ArrayList<sanphamALL> getTatCaSanPham() {
        ArrayList<sanphamALL> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Lấy sản phẩm nam
        Cursor cursorNam = db.rawQuery("SELECT * FROM sanpham", null);
        while (cursorNam.moveToNext()) {
            sanphamALL sp = new sanphamALL();
            int dbImage = cursorNam.getInt(cursorNam.getColumnIndexOrThrow("image"));
            int imageId = 0;
            switch(dbImage){
                case 1: imageId = R.drawable.sp1; break;
                case 2: imageId = R.drawable.sp2; break;
                case 3: imageId = R.drawable.sp3; break;
                case 4: imageId = R.drawable.sp4; break;

            }
            sp.setImg(imageId);
            sp.setTensp(cursorNam.getString(cursorNam.getColumnIndexOrThrow("name")));
            sp.setGia(cursorNam.getInt(cursorNam.getColumnIndexOrThrow("price")));
            list.add(sp);
        }
        cursorNam.close();

        // Lấy sản phẩm nữ
        Cursor cursorNu = db.rawQuery("SELECT * FROM sanpham_nu", null);
        while (cursorNu.moveToNext()) {
            sanphamALL sp = new sanphamALL();
            int dbImage = cursorNu.getInt(cursorNu.getColumnIndexOrThrow("image"));
            int imageId = 0;
            switch(dbImage){
                case 101: imageId = R.drawable.sp1_nu; break;
                case 102: imageId = R.drawable.sp2_nu; break;
                case 103: imageId = R.drawable.sp3_nu; break;

            }
            sp.setImg(imageId);
            sp.setTensp(cursorNu.getString(cursorNu.getColumnIndexOrThrow("name")));
            sp.setGia(cursorNu.getInt(cursorNu.getColumnIndexOrThrow("price")));
            list.add(sp);
        }
        cursorNu.close();
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
