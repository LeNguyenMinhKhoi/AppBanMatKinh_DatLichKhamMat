package com.example.banmatkinh_datlichkhammat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.adapter.giohangAdapter;
import com.example.banmatkinh_datlichkhammat.helper.giohangHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    ImageView img;
    TextView tensp;
    TextView giasp;
    ImageButton imgb, img_giohang;
    int sanphamID;
    Button btn_themvaogio;
    giohangAdapter giohangAdapter;
    giohangHelper giohangHelper;
    EditText sl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        getIntentData();
        addEvent();

    }
    public void addControl(){
        img = findViewById(R.id.img);
        tensp = findViewById(R.id.tensp);
        giasp = findViewById(R.id.giasp);
        imgb = findViewById(R.id.back);
        img_giohang = findViewById(R.id.giohang);
        btn_themvaogio = findViewById(R.id.btn_themvaogio);
        sl=findViewById(R.id.edt_soluong);

        giohangHelper = new giohangHelper(this);
    }
    public void getIntentData(){
        Intent intent = getIntent();
        sanphamID = intent.getIntExtra("masp", -1);
        int anh = intent.getIntExtra("anh_sp",0);
        String ten = intent.getStringExtra("ten_sp");
        String gia = getIntent().getStringExtra("gia_sp");

        img.setImageResource(anh);
        tensp.setText(ten);
        giasp.setText(String.valueOf(gia));

        btn_themvaogio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userID = 1;
                String slStr = sl.getText().toString();
                if(slStr.isEmpty()){
                    Toast.makeText(ChiTietSanPhamActivity.this, "Vui lòng nhập số lượng", Toast.LENGTH_SHORT).show();
                    return;
                }
                int soluong = Integer.parseInt(slStr);

                if(sanphamID <= 0){
                    Toast.makeText(ChiTietSanPhamActivity.this, "Sản phẩm không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

                giohangHelper.addToCart(userID, sanphamID, soluong);
                Toast.makeText(ChiTietSanPhamActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addEvent(){
        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietSanPhamActivity.this,TrangChuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        img_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietSanPhamActivity.this, GiohangActivity.class);
                startActivity(intent);
            }
        });

    }
    private void exportDbShop() {
        File dbFile = new File(getDatabasePath("db_shop.sqlite").getPath());
        File destFile = new File(getExternalFilesDir(null), "db_shop_export.sqlite");

        try (InputStream in = new FileInputStream(dbFile);
             OutputStream out = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            Toast.makeText(this, "Đã sao chép DB ra: " + destFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi khi sao chép DB", Toast.LENGTH_SHORT).show();
        }
    }

}