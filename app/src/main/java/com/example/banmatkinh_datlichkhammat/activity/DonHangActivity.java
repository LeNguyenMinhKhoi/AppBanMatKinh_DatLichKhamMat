package com.example.banmatkinh_datlichkhammat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.adapter.DonHangAdapter;
import com.example.banmatkinh_datlichkhammat.helper.donhangHelper;
import com.example.banmatkinh_datlichkhammat.model.donhang;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DonHangActivity extends AppCompatActivity {
    ListView lvDonHang;
    ArrayList<donhang> listDonHang;
    DonHangAdapter adapter;
    ImageButton imgb_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_don_hang);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        addEvent();
    }
    public void addControl(){
        lvDonHang = findViewById(R.id.thongtindonhang);
        imgb_home = findViewById(R.id.imgb_home);
        loadDonHang();
    }
    private void loadDonHang(){
        donhangHelper donHangHelper = new donhangHelper(this);
        listDonHang = donHangHelper.getDonHang(1); // userId = 1

        if(adapter == null){
            adapter = new DonHangAdapter(this, listDonHang);
            lvDonHang.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    public static String dinhDangTien(int soTien){
        DecimalFormat df = new DecimalFormat("#,###,###");
        return df.format(soTien) + " đ";
    }


    public void addEvent(){
        imgb_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonHangActivity.this,TrangChuActivity.class);
                startActivity(intent);

            }
        });
    }
}