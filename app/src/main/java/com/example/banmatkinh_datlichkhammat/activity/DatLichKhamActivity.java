package com.example.banmatkinh_datlichkhammat.activity;

import static androidx.core.view.ViewKt.setPadding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.adapter.phieudatlichAdapter;
import com.example.banmatkinh_datlichkhammat.helper.datlichHelper;
import com.example.banmatkinh_datlichkhammat.model.phieudatlich;

import java.util.ArrayList;

public class DatLichKhamActivity extends AppCompatActivity {
    ImageButton imgb_taophieu, img_home, imgb_donhang, imgb_toi;
    ListView lv;
    datlichHelper helper;
    ArrayList<phieudatlich> list;
    phieudatlichAdapter adapter;

    String hotenIntent = "";
    String hinhthucIntent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dat_lich_kham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        addEvent();
    }

    public void addControl(){
        imgb_taophieu = findViewById(R.id.imgb_taophieu);
        img_home = findViewById(R.id.imgb_home);
        imgb_donhang = findViewById(R.id.imgb_donhang);
        lv = findViewById(R.id.thongtinphieu);

        helper = new datlichHelper(this);

        // Lấy dữ liệu gửi từ TaoPhieuActivity (nếu có)
        hotenIntent = getIntent().getStringExtra("hoten");
        hinhthucIntent = getIntent().getStringExtra("hinhthuc");

        if (hotenIntent == null) hotenIntent = "";
        if (hinhthucIntent == null) hinhthucIntent = "";

        list = helper.getAllPhieu(1);


        adapter = new phieudatlichAdapter(this, list, hotenIntent, hinhthucIntent);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Reload danh sách
        list = helper.getAllPhieu(1);
        adapter.updateData(list);

    }

    public void addEvent(){
        imgb_taophieu.setOnClickListener(v -> {
            Intent intent = new Intent(DatLichKhamActivity.this, TaoPhieuActivity.class);
            startActivity(intent);
        });
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatLichKhamActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        imgb_donhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatLichKhamActivity.this, DonHangActivity.class);
                startActivity(intent);
            }
        });
    }
}
