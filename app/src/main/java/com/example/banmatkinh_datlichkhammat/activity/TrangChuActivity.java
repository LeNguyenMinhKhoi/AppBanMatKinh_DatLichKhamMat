package com.example.banmatkinh_datlichkhammat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.adapter.danhmucAdapter;
import com.example.banmatkinh_datlichkhammat.adapter.sanphamAdapter;
import com.example.banmatkinh_datlichkhammat.adapter.sanphamnuAdapter;
import com.example.banmatkinh_datlichkhammat.adapter.tatcasanphamAdapter;
import com.example.banmatkinh_datlichkhammat.helper.sanphamHelper;
import com.example.banmatkinh_datlichkhammat.helper.sanphamnuHelper;
import com.example.banmatkinh_datlichkhammat.helper.tatcasanphamHelper;
import com.example.banmatkinh_datlichkhammat.model.danhmuc;
import com.example.banmatkinh_datlichkhammat.model.sanpham;
import com.example.banmatkinh_datlichkhammat.model.sanphamALL;
import com.example.banmatkinh_datlichkhammat.model.sanpham_nu;
import com.example.banmatkinh_datlichkhammat.util.DBConfigUtil;


import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity {
    ArrayList<sanpham> dsspnam;
    ArrayList<sanpham_nu> dsspnu;
    ArrayList<danhmuc> dsdanhmuc;
    ArrayList<sanphamALL> dstatcasp;;
    sanphamAdapter sanphamAdapter;
    danhmucAdapter danhmucAdapter;
    sanphamnuAdapter sanphamnuAdapter;
    tatcasanphamAdapter tatcasanphamAdapter;
    sanphamHelper sanphamHelper;
    sanphamnuHelper sanphamnuHelper;
    tatcasanphamHelper tatcasanphamHelper;

    ImageButton img_giohang;


    RecyclerView recyclerView_danhmuc, recyclerView_sanphamnam,recyclerView_sanphamnu,recyclerView_tatcasp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trang_chu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DBConfigUtil.copyDBFromAsset(this);
        addControl();
        addEvent();
    }
    public void addControl(){
        recyclerView_danhmuc = findViewById(R.id.rv_danhmuc);
        recyclerView_sanphamnam = findViewById(R.id.rv_spNamBanChay);
        recyclerView_sanphamnu = findViewById(R.id.rv_spNuBanChay);
        recyclerView_tatcasp = findViewById(R.id.rv_tatcasp);

        img_giohang = findViewById(R.id.giohang);

        recyclerView_danhmuc.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        dsdanhmuc = new ArrayList<danhmuc>();
        dsdanhmuc.add(new danhmuc(R.drawable.gongkinh,"Gọng kính"));
        dsdanhmuc.add(new danhmuc(R.drawable.kinhmat,"Kính mát"));
        dsdanhmuc.add(new danhmuc(R.drawable.trongkinh,"Tròng kính"));
        dsdanhmuc.add(new danhmuc(R.drawable.kinhaptrong,"Kính áp tròng"));
        danhmucAdapter = new danhmucAdapter(dsdanhmuc,this);
        recyclerView_danhmuc.setAdapter(danhmucAdapter);


        recyclerView_sanphamnam.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        sanphamHelper = new sanphamHelper(this);
        dsspnam = sanphamHelper.getSanPhamNamBanChay();
        sanphamAdapter = new sanphamAdapter(dsspnam,this);
        recyclerView_sanphamnam.setAdapter(sanphamAdapter);

        recyclerView_sanphamnu.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        sanphamnuHelper = new sanphamnuHelper(this);
        dsspnu = sanphamnuHelper.getSanPhamNuBanChay();
        sanphamnuAdapter = new sanphamnuAdapter(dsspnu,this);
        recyclerView_sanphamnu.setAdapter(sanphamnuAdapter);

        recyclerView_tatcasp.setLayoutManager(new GridLayoutManager(this,2));
        tatcasanphamHelper = new tatcasanphamHelper(this);
        dstatcasp = tatcasanphamHelper.getTatCaSanPham();
        tatcasanphamAdapter = new tatcasanphamAdapter(dstatcasp,this);
        recyclerView_tatcasp.setAdapter(tatcasanphamAdapter);


    }
    public void addEvent(){
        img_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity.this,GiohangActivity.class);
                startActivity(intent);
            }
        });
    }
}