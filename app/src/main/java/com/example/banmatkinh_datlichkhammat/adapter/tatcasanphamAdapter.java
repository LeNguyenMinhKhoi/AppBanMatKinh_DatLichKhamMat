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
import com.example.banmatkinh_datlichkhammat.model.sanphamALL;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class tatcasanphamAdapter extends RecyclerView.Adapter<tatcasanphamAdapter.ViewHolder> {
    private ArrayList<sanphamALL> dstatcasp;
    private Context context;

    public tatcasanphamAdapter(ArrayList<sanphamALL> dstatcasp, Context context) {
        this.dstatcasp = dstatcasp;
        this.context = context;
    }

    @NonNull
    @Override
    public tatcasanphamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tatcasanpham_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tatcasanphamAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(dstatcasp.get(position).getImg());
        holder.tensp.setText(dstatcasp.get(position).getTensp());

        DecimalFormat df = new DecimalFormat("#,###,### đ");
        String giaspFormat = df.format(dstatcasp.get(position).getGia());
        holder.giasp.setText(giaspFormat);
    }

    @Override
    public int getItemCount() {
        return dstatcasp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tensp;
        TextView giasp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_sptatca);
            tensp = itemView.findViewById(R.id.tensptatca);
            giasp = itemView.findViewById(R.id.giasptatca);
        }
    }
}
