package com.example.banmatkinh_datlichkhammat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.helper.datlichHelper;
import com.example.banmatkinh_datlichkhammat.model.phieudatlich;

import java.util.ArrayList;

public class phieudatlichAdapter extends BaseAdapter {
    Context context;
    ArrayList<phieudatlich> list;
    LayoutInflater inflater;
    String hoten, hinhthuc;

    public phieudatlichAdapter(Context context, ArrayList<phieudatlich> list, String hoten, String hinhthuc){
        this.context = context;
        this.list = list;
        this.hoten = hoten;
        this.hinhthuc = hinhthuc;
        inflater = LayoutInflater.from(context);
    }
    public int getCount() { return list.size(); }

    @Override
    public Object getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int position) { return list.get(position).getId(); }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_phieudatlich, parent, false);

        TextView txtMa = convertView.findViewById(R.id.txtMaPhieu);
        TextView txtHoTen = convertView.findViewById(R.id.txtHoten);
        TextView txtNgay = convertView.findViewById(R.id.txtNgayDat);
        TextView txtGio = convertView.findViewById(R.id.txtgiodat);
        TextView txtHinhThuc = convertView.findViewById(R.id.txtHinhThuc);
        TextView txtNote = convertView.findViewById(R.id.txtnote);
        Button btnhuyphieu = convertView.findViewById(R.id.btn_huyphieu);



        phieudatlich p = list.get(position);

        txtMa.setText("Mã phiếu: " + p.getId());
        txtHoTen.setText("Họ tên: " + hoten);
        txtNgay.setText("Ngày khám: " + p.getDate());
        txtGio.setText("Giờ khám: " + p.getTime());
        txtHinhThuc.setText("Hình thức: " + hinhthuc);
        txtNote.setText("Ghi chú: " + p.getNote());

        btnhuyphieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datlichHelper helper = new datlichHelper(context);
                helper.xoaPhieu(p.getId());
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
    public void updateData(ArrayList<phieudatlich> newList) {
        this.list = newList;
        notifyDataSetChanged();
    }
}
