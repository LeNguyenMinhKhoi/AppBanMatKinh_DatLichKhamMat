package com.example.banmatkinh_datlichkhammat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.helper.donhangHelper;
import com.example.banmatkinh_datlichkhammat.helper.giohangHelper;
import com.example.banmatkinh_datlichkhammat.model.donhang;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DonHangAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<donhang> list;
    private LayoutInflater inflater;
    private DecimalFormat df = new DecimalFormat("#,### đ");

    public DonHangAdapter(Context context, ArrayList<donhang> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getMadonhang();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_donhang, parent, false);
            holder = new ViewHolder();
            holder.txtMaDon = convertView.findViewById(R.id.txtMaDon);
            holder.txtTongTien = convertView.findViewById(R.id.txtTongTien);
            holder.txtNgayDat = convertView.findViewById(R.id.txtNgayDat);
            holder.btn_huydon = convertView.findViewById(R.id.btn_huydon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        donhang dh = list.get(position);
        holder.txtMaDon.setText("Mã đơn: " + dh.getMadonhang());
        holder.txtTongTien.setText("Tổng tiền: " + df.format(dh.getTongtien()));
        holder.txtNgayDat.setText("Ngày đặt: " + dh.getNgaydat());

        holder.btn_huydon.setOnClickListener(v -> {
            // Xóa trong database
            donhangHelper helper = new donhangHelper(context);
            helper.xoaDonHang(dh.getMadonhang()); // bạn cần viết hàm xoaDonHang trong helper

            // Xóa khỏi list và cập nhật Adapter
            list.remove(position);
            notifyDataSetChanged();
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView txtMaDon, txtTongTien, txtNgayDat;
        Button btn_huydon;
    }
}
