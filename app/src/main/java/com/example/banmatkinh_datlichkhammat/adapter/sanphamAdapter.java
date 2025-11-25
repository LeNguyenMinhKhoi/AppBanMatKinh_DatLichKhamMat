package com.example.banmatkinh_datlichkhammat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class sanphamAdapter extends RecyclerView.Adapter<sanphamAdapter.ViewHolder> {

    private ArrayList<sanpham> dssp;
    private Context context;

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
    public void onBindViewHolder(@NonNull sanphamAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(dssp.get(position).getImg());
        holder.tensp.setText(dssp.get(position).getTensp());

        DecimalFormat df = new DecimalFormat("#,###,### đ");
        String giaFormatted = df.format(dssp.get(position).getGia());
        holder.gia.setText(giaFormatted);
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
