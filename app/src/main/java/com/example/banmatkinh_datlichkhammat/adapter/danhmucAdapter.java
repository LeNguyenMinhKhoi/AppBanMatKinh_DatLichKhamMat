package com.example.banmatkinh_datlichkhammat.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.model.danhmuc;

import java.util.ArrayList;

public class danhmucAdapter extends RecyclerView.Adapter<danhmucAdapter.ViewHolder> {

    private ArrayList<danhmuc> dsdanhmuc;
    private Context context;

    public danhmucAdapter(ArrayList<danhmuc> dsdanhmuc, Context context) {
        this.dsdanhmuc = dsdanhmuc;
        this.context = context;
    }

    @NonNull
    @Override
    public danhmucAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.danhmuc_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull danhmucAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(dsdanhmuc.get(position).getImage());
        holder.text.setText(dsdanhmuc.get(position).getTendanhmuc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dsdanhmuc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.anhsp);
            text = itemView.findViewById(R.id.ten);
        }
    }
}
