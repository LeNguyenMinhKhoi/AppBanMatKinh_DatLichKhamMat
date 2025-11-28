package com.example.banmatkinh_datlichkhammat.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.adapter.giohangAdapter;
import com.example.banmatkinh_datlichkhammat.helper.giohangHelper;
import com.example.banmatkinh_datlichkhammat.model.giohang;

import java.util.ArrayList;

public class GiohangActivity extends AppCompatActivity {
    ListView lv_giohang;
    ArrayList<giohang> dsgiohang;
    giohangAdapter giohangAdapter;
    giohangHelper giohangHelper;
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
    }
    public void addControl(){
        lv_giohang = findViewById(R.id.thongtingiohang);
        giohangHelper = new giohangHelper(this);
        int userID = 1;
        dsgiohang = giohangHelper.getCartItems(userID);

        giohangAdapter = new giohangAdapter(this,R.layout.custom_giohang,dsgiohang);
        lv_giohang.setAdapter(giohangAdapter);

        dsgiohang.clear();
        dsgiohang.addAll(giohangHelper.getCartItems(userID));
        giohangAdapter.notifyDataSetChanged();
    }
}