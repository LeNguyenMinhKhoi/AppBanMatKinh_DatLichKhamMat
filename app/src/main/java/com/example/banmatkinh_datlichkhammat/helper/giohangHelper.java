package com.example.banmatkinh_datlichkhammat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.giohang;

import java.util.ArrayList;

public class giohangHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="db_shop.sqlite";
    private static final int DB_VERSION = 2;
    public giohangHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    public void addToCart(int userID, int productID, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userId", userID);
        cv.put("productId", productID);
        cv.put("quantity", quantity);

        long result = db.insert("cart", null, cv);
        if(result == -1){
            // insert thất bại
            Log.e("giohangHelper", "Insert cart thất bại");
        }
    }

    public ArrayList<giohang> getCartItems(int userID) {
        ArrayList<giohang> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String sql =
                "SELECT cart.productId, cart.quantity, sanpham.name, sanpham.price, sanpham.image " +
                        "FROM cart " +
                        "JOIN sanpham ON cart.productId = sanpham.id " +
                        "WHERE cart.userId = ?";

        Cursor cursor = db.rawQuery(sql, new String[]{ String.valueOf(userID) });

        while (cursor.moveToNext()) {
            int imageFromDB = cursor.getInt(cursor.getColumnIndexOrThrow("image"));
            int imageResId=0;
            switch(imageFromDB){
                case 1: imageResId = R.drawable.sp1; break;
                case 2: imageResId = R.drawable.sp2; break;
                case 3: imageResId = R.drawable.sp3; break;
                case 4: imageResId = R.drawable.sp4; break;

            }
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
            int qty = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));

            list.add(new giohang(imageResId, name, price, qty));
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
