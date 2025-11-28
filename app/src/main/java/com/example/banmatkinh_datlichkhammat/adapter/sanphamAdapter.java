package com.example.banmatkinh_datlichkhammat.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.activity.ChiTietSanPhamActivity;
import com.example.banmatkinh_datlichkhammat.model.sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class sanphamAdapter extends RecyclerView.Adapter<sanphamAdapter.ViewHolder> {

    private ArrayList<sanpham> dssp;
    private Context context;
    private final DecimalFormat df = new DecimalFormat("#,###,### đ");
    public sanphamAdapter(@NonNull ArrayList<sanpham> dssp, Context context) {
        this.dssp = dssp;
        this.context = context;
    }

    @NonNull
    @Override

    public sanphamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanpham_layout,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sanphamAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(dssp.get(position).getImg());
        holder.tensp.setText(dssp.get(position).getTensp());

        String giaFormatted = df.format(dssp.get(position).getGia()); // Dùng df đã khai báo
        holder.gia.setText(giaFormatted);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("masp", dssp.get(position).getId());
                intent.putExtra("anh_sp",dssp.get(position).getImg());
                intent.putExtra("ten_sp",dssp.get(position).getTensp());

                // Dùng df đã khai báo
                String giaFormatted = df.format(dssp.get(position).getGia());
                intent.putExtra("gia_sp", giaFormatted);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dssp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tensp;
        TextView gia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           img = itemView.findViewById(R.id.img);
           tensp = itemView.findViewById(R.id.tensp);
           gia = itemView.findViewById(R.id.giasp);

        }
    }
}
