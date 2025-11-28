package com.example.banmatkinh_datlichkhammat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.giohang;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class giohangAdapter extends ArrayAdapter<giohang> {
    private Context context;
    private ArrayList<giohang> dsgiohang;
    private int resource;

    public giohangAdapter(Context context, int resource, ArrayList<giohang> dsgiohang){
        super(context,resource,dsgiohang);
        this.context = context;
        this.dsgiohang =dsgiohang;
        this.resource =resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView img;
        TextView tensp, giasp, sl;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null);

        img = view.findViewById(R.id.anh_giohang);
        tensp = view.findViewById(R.id.tensp_giohang);
        giasp = view.findViewById(R.id.giasp_giohang);
        sl = view.findViewById(R.id.soluong);

        giohang giohang = dsgiohang.get(position);

        img.setImageResource(giohang.getImg());
        tensp.setText(giohang.getTensp());
        DecimalFormat df = new DecimalFormat("#,###,### đ");
        String giaFormat = df.format(giohang.getGia());
        giasp.setText(giaFormat);
        sl.setText("Số lượng: "+ giohang.getSoluong());

        return view;
    }
}
