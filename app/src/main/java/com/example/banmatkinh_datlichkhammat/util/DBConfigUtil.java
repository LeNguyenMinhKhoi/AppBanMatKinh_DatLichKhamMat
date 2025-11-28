package com.example.banmatkinh_datlichkhammat.util;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DBConfigUtil {

    private static final String DB_NAME = "db_shop.sqlite";

    public static void copyDBFromAsset(Context context) {

        File dbFile = context.getDatabasePath(DB_NAME);

        // Nếu file đã tồn tại → không copy lại nữa
        if (dbFile.exists()) {
            return;
        }

        // Tạo thư mục /databases nếu chưa có
        dbFile.getParentFile().mkdirs();

        try {
            InputStream is = context.getAssets().open(DB_NAME);
            OutputStream os = new FileOutputStream(dbFile);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            os.flush();
            os.close();
            is.close();

            Toast.makeText(context, "Copy DB thành công", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Lỗi copy DB: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
