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
import com.example.banmatkinh_datlichkhammat.model.sanpham_nu;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class sanphamnuAdapter extends RecyclerView.Adapter<sanphamnuAdapter.ViewHolder> {
    private ArrayList<sanpham_nu> dsspnu;
    private Context context;

    public sanphamnuAdapter(ArrayList<sanpham_nu> dsspnu, Context context) {
        this.dsspnu = dsspnu;
        this.context = context;
    }

    @NonNull
    @Override
    public sanphamnuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sanphamnu_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull sanphamnuAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imgspnu.setImageResource(dsspnu.get(position).getImg());
        holder.tenspnu.setText(dsspnu.get(position).getTensp());

        DecimalFormat df = new DecimalFormat("#,###,### đ");
        String giaFormat = df.format(dsspnu.get(position).getGia());
        holder.giaspnu.setText(giaFormat);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("anh_sp",dsspnu.get(position).getImg());
                intent.putExtra("ten_sp",dsspnu.get(position).getTensp());

                String giaFormatted = df.format(dsspnu.get(position).getGia());
                intent.putExtra("gia_sp", giaFormatted);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dsspnu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgspnu;
        TextView tenspnu;
        TextView giaspnu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgspnu = itemView.findViewById(R.id.img_spnu);
            tenspnu = itemView.findViewById(R.id.tenspnu);
            giaspnu = itemView.findViewById(R.id.giaspnu);
        }
    }
}
