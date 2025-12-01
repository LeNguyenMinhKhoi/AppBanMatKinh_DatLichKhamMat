package com.example.banmatkinh_datlichkhammat.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.giohang;
import com.example.banmatkinh_datlichkhammat.util.DBConfigUtil;

import java.util.ArrayList;

public class giohangHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="db_shop.sqlite";
    private static final int DB_VERSION = 3;
    public giohangHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }



    public void addToCart(int userID, int productID, int quantity, String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("userId", userID);
        cv.put("productId", productID);
        cv.put("quantity", quantity);
        cv.put("type", type);

        long result = db.insert("cart", null, cv);
        if(result == -1){

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
                        "WHERE cart.userId = ? AND cart.type = 'nam'";

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
            int productId = cursor.getInt(cursor.getColumnIndexOrThrow("productId"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
            int qty = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));

            list.add(new giohang(productId,imageResId, name, price, qty));
        }
        cursor.close();

        return list;
    }
    public ArrayList<giohang> laySanPhamNu(int userId){
        ArrayList<giohang> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT cart.productId, cart.quantity, sanpham_nu.image, sanpham_nu.name, sanpham_nu.price " +
                "FROM cart " + "JOIN sanpham_nu ON cart.productId = sanpham_nu.id" +
                " Where cart.userId = ? AND cart.type = 'nu'";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(userId)});
        while (cursor.moveToNext()){
            int image = cursor.getInt(cursor.getColumnIndexOrThrow("image"));
            int img = 0;
            switch (image){
                case 101: img = R.drawable.sp1_nu; break;
                case 102: img = R.drawable.sp2_nu;break;
                case 103 : img = R.drawable.sp3_nu; break;
            }
            int productId = cursor.getInt(cursor.getColumnIndexOrThrow("productId"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
            int qty = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));

            list.add(new giohang(productId,img,name,price,qty));
        }
        cursor.close();
        return  list;
    }


    public void xoasanpham(int userId, int producId){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart","userId = ? AND productId = ?", new String[]{String.valueOf(userId), String.valueOf(producId)});
        db.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 3){
            db.execSQL("ALTER TABLE cart ADD COLUMN type TEXT");
        }
    }
}
