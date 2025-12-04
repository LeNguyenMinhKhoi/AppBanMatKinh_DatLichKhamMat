package com.example.banmatkinh_datlichkhammat.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banmatkinh_datlichkhammat.R;
import com.example.banmatkinh_datlichkhammat.helper.datlichHelper;
import com.example.banmatkinh_datlichkhammat.util.FormatUtil;

import java.util.Calendar;

public class TaoPhieuActivity extends AppCompatActivity {
    EditText edtHoTen, edtNote;
    TextView edtNgay, edtGio;
    Spinner spHinhThuc;
    Button btnDatLich;
    ImageButton imgb_chonngay, imgb_chongio;
    datlichHelper helper;
    Calendar calendar;
    ImageButton imgb_back;
    int userId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tao_phieu);

        addControl();
        addEvent();
    }

    public void addControl(){
        edtHoTen = findViewById(R.id.edt_hoten);
        edtNgay = findViewById(R.id.edt_ngay);
        edtGio = findViewById(R.id.edt_gio);
        edtNote = findViewById(R.id.edt_ghichu);
        spHinhThuc = findViewById(R.id.spHinhThuc);
        btnDatLich = findViewById(R.id.btnDatLich);
        imgb_chonngay = findViewById(R.id.imgb_chonngay);
        imgb_chongio = findViewById(R.id.imgb_chongio);
        imgb_back = findViewById(R.id.imgb_back);

        calendar = Calendar.getInstance();


        helper = new datlichHelper(this);

        String[] hinhthuc = {"Khám mắt", "Khám tổng quát", "Khám tròng"};
        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, hinhthuc);
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHinhThuc.setAdapter(spAdapter);

    }

    public void addEvent(){
        imgb_chonngay.setOnClickListener(v -> setupDatePicker());
        imgb_chongio.setOnClickListener(v -> xulyChonGio());

        btnDatLich.setOnClickListener(v -> {
            String hoten = edtHoTen.getText().toString();
            String ngay = edtNgay.getText().toString();
            String gio = edtGio.getText().toString();
            String note = edtNote.getText().toString();
            String hinhThuc = spHinhThuc.getSelectedItem().toString();

            if (hoten.isEmpty() || ngay.isEmpty() || gio.isEmpty()) {
                return;
            }

            helper.themPhieu(userId, ngay, gio, note);

            Intent intent = new Intent(TaoPhieuActivity.this, DatLichKhamActivity.class);
            intent.putExtra("hoten", hoten);
            intent.putExtra("hinhthuc", hinhThuc);

            Toast.makeText(this, "Đặt lịch thành oông", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        imgb_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupDatePicker() {
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    calendar.set(year, month, dayOfMonth);
                    edtNgay.setText(FormatUtil.FormatDate(calendar.getTime()));
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );
        dialog.show();
    }

    private void xulyChonGio() {
        TimePickerDialog dialog = new TimePickerDialog(
                this,
                (view, hour, minute) -> {
                    calendar.set(Calendar.HOUR_OF_DAY, hour);
                    calendar.set(Calendar.MINUTE, minute);
                    edtGio.setText(FormatUtil.FormatTime(calendar.getTime()));
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
        );
        dialog.show();
    }
}
