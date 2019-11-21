package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appdoctruyen.R;

public class GioiThieuTruyenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);
    }

    public void dsChapter(View view) {
        Intent intent = new Intent(GioiThieuTruyenActivity.this,DanhSachChapActivity.class);
        startActivity(intent);
    }
}
