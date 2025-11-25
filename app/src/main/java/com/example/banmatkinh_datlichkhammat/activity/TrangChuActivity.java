package com.example.banmatkinh_datlichkhammat.activity;

import android.os.Bundle;
import android.util.TypedValue;

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
import com.example.banmatkinh_datlichkhammat.model.danhmuc;
import com.example.banmatkinh_datlichkhammat.model.sanpham;
import com.example.banmatkinh_datlichkhammat.model.sanphamALL;
import com.example.banmatkinh_datlichkhammat.model.sanpham_nu;
import com.example.banmatkinh_datlichkhammat.util.spacing;

import java.util.ArrayList;

public class TrangChuActivity extends AppCompatActivity {

    ArrayList<danhmuc> dsdanhmuc;
    ArrayList<sanpham> dssp;
    ArrayList<sanpham_nu>dssp_nu;
    ArrayList<sanphamALL> dstatcasp;
    RecyclerView recyclerView_danhmuc, recyclerView_sanphamnam,recyclerView_sanphamnu,recyclerView_tatcasp;
    danhmucAdapter danhmucAdapter;
    sanphamAdapter sanphamAdapter;
    sanphamnuAdapter sanphannuAdapter;
    tatcasanphamAdapter tatcasanphamAdapter;
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
        addControl();
    }
    public void addControl(){
        recyclerView_danhmuc = findViewById(R.id.rv_danhmuc);
        recyclerView_danhmuc.setHasFixedSize(true);
        recyclerView_danhmuc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dsdanhmuc = new ArrayList<danhmuc>();
        dsdanhmuc.add(new danhmuc(R.drawable.gongkinh,"Gọng kính"));
        dsdanhmuc.add(new danhmuc(R.drawable.kinhmat,"Kính mát"));
        dsdanhmuc.add(new danhmuc(R.drawable.trongkinh,"Tròng kính"));
        dsdanhmuc.add(new danhmuc(R.drawable.kinhaptrong,"Kính áp tròng"));

        danhmucAdapter = new danhmucAdapter(dsdanhmuc,this);
        recyclerView_danhmuc.setAdapter(danhmucAdapter);


        recyclerView_sanphamnam = findViewById(R.id.rv_spNamBanChay);
        recyclerView_sanphamnam.setHasFixedSize(true);
        recyclerView_sanphamnam.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        dssp = new ArrayList<sanpham>();
        dssp.add(new sanpham(R.drawable.sp1,"Agog Pengonal Unisex",1820000f));
        dssp.add(new sanpham(R.drawable.sp2,"Agog Hexgonal Nam",1820000f));
        dssp.add(new sanpham(R.drawable.sp3,"Agog Nam",4240000f));
        dssp.add(new sanpham(R.drawable.sp4,"Agog Unisex",1820000f));
        dssp.add(new sanpham(R.drawable.sp5,"Chopard Nam",19300000f));
        dssp.add(new sanpham(R.drawable.sp6,"Chopard Unisex",19300000f));

        sanphamAdapter = new sanphamAdapter(dssp,this);
        recyclerView_sanphamnam.setAdapter(sanphamAdapter);


        recyclerView_sanphamnu = findViewById(R.id.rv_spNuBanChay);
        recyclerView_sanphamnu.setHasFixedSize(true);

        recyclerView_sanphamnu.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        dssp_nu = new ArrayList<sanpham_nu>();
        dssp_nu.add(new sanpham_nu(R.drawable.sp1_nu,"Agog Nữ",4240000f));
        dssp_nu.add(new sanpham_nu(R.drawable.sp2_nu,"Agog Nữ",4240000f));
        dssp_nu.add(new sanpham_nu(R.drawable.sp3_nu,"Agog Nữ",4240000f));
        dssp_nu.add(new sanpham_nu(R.drawable.sp4_nu,"Agog Nữ",4240000f));
        dssp_nu.add(new sanpham_nu(R.drawable.sp5_nu,"Agog Nữ",4240000f));
        dssp_nu.add(new sanpham_nu(R.drawable.sp6_nu,"Agog Nữ",4240000f));
        sanphannuAdapter = new sanphamnuAdapter(dssp_nu,this);
        recyclerView_sanphamnu.setAdapter(sanphannuAdapter);




        recyclerView_tatcasp = findViewById(R.id.rv_tatcasp);
        recyclerView_tatcasp.setLayoutManager(new GridLayoutManager(this, 2));


        dstatcasp = new ArrayList<sanphamALL>();
        dstatcasp.add(new sanphamALL(R.drawable.sp1,"Agog Pengonal Unisex",1820000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp2,"Agog Hexgonal Nam",1820000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp3,"Agog Nam",4240000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp4,"Agog Unisex",1820000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp5,"Chopard Nam",19300000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp6,"Chopard Unisex",19300000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp1_nu,"Agog Nữ",4240000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp2_nu,"Agog Nữ",4240000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp3_nu,"Agog Nữ",4240000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp4_nu,"Agog Nữ",4240000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp5_nu,"Agog Nữ",4240000f));
        dstatcasp.add(new sanphamALL(R.drawable.sp6_nu,"Agog Nữ",4240000f));

        tatcasanphamAdapter = new tatcasanphamAdapter(dstatcasp,this);
        recyclerView_tatcasp.setAdapter(tatcasanphamAdapter);

    }
}