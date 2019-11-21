package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.appdoctruyen.R;

public class DanhSachChapActivity extends AppCompatActivity {

    Dialog dialog;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_chap);
            textView = findViewById(R.id.tecc);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhSachChapActivity.this,DocTruyenActivity.class);
                startActivity(intent);
            }
        });

    }

    public void adialog(View view) {
        dialog = new Dialog(DanhSachChapActivity.this);
//        dialog.setTitle("Thangcode.com");
        dialog.setContentView(R.layout.dialog);
        dialog.show();
    }

    public void nextActivity(View view) {

    }
}
