package com.example.banmatkinh_datlichkhammat.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.adapter.giohangAdapter;
import com.example.banmatkinh_datlichkhammat.helper.donhangHelper;
import com.example.banmatkinh_datlichkhammat.helper.giohangHelper;
import com.example.banmatkinh_datlichkhammat.model.giohang;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GiohangActivity extends AppCompatActivity {
    ListView lv_giohang;
    ArrayList<giohang> dsgiohang;
    giohangAdapter giohangAdapter;
    giohangHelper giohangHelper;
    donhangHelper donhangHelper;
    TextView tongtien;
    Button btn_dathang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giohang);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        addEvent();
    }
    public void addControl(){
        tongtien = findViewById(R.id.tongtien);
        lv_giohang = findViewById(R.id.thongtingiohang);
        btn_dathang = findViewById(R.id.btn_dathang);
        loadSanPham();
        loadTongTien();
    }
    public void loadSanPham(){
        giohangHelper = new giohangHelper(this);
        int userID = 1;
        dsgiohang = new ArrayList<>();
        dsgiohang.clear();
        dsgiohang.addAll(giohangHelper.getCartItems(userID));
        if (giohangAdapter == null) {
            giohangAdapter = new giohangAdapter(this, R.layout.custom_giohang, dsgiohang);
            lv_giohang.setAdapter(giohangAdapter);
        } else {
            giohangAdapter.notifyDataSetChanged();
        }
    }
    public void loadTongTien(){
        ArrayList<giohang> list = giohangHelper.getCartItems(1);
        int tong = 0;
        for (giohang g : list) {
            tong += g.getGia() * g.getSoluong();
        }
        tongtien.setText(dinhDangTien(tong));
    }
    public String dinhDangTien(int soTien) {
        DecimalFormat df = new DecimalFormat("#,###,###");
        return df.format(soTien) + " đ";
    }

    public void addEvent(){
        btn_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<giohang> list = giohangHelper.getCartItems(1); // userID = 1
                if(list.isEmpty()){
                    Toast.makeText(GiohangActivity.this, "Giỏ hàng trống", Toast.LENGTH_SHORT).show();
                    return;
                }

                int tongTien = 0;
                for(giohang g : list){
                    tongTien += g.getGia() * g.getSoluong();
                }

                String ngayDat = java.text.DateFormat.getDateInstance().format(new java.util.Date());
                long orderId = System.currentTimeMillis();

                // Lưu đơn hàng
                donhangHelper = new donhangHelper(GiohangActivity.this);
                donhangHelper.themDonHang(orderId, 1, tongTien, ngayDat);

                // Xóa giỏ hàng
                for(giohang g : list){
                    giohangHelper.xoasanpham(1, g.getMasp());
                }

                // Load lại giỏ hàng và tổng tiền
                loadSanPham();
                loadTongTien();

                // Hiển thị thông báo
                Toast.makeText(GiohangActivity.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }




}