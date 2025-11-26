package com.example.banmatkinh_datlichkhammat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    ImageView img;
    TextView tensp;
    TextView giasp;
    ImageButton imgb;
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
    }
    public void getIntentData(){
        Intent intent = getIntent();
        int anh = intent.getIntExtra("anh_sp",0);
        String ten = intent.getStringExtra("ten_sp");
        String gia = getIntent().getStringExtra("gia_sp");

        img.setImageResource(anh);
        tensp.setText(ten);
        giasp.setText(String.valueOf(gia));
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
    }
}