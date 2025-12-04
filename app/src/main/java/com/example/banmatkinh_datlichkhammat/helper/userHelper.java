package com.example.banmatkinh_datlichkhammat.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class userHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_shop.sqlite";
    private static final int DB_VERSION = 4;

    public userHelper (Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 4){
            db.execSQL("ALTER TABLE user ADD COLUMN SDT TEXT");
        }
    }
}
