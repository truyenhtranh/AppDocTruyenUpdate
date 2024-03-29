package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.AllListTruyenToday;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.squareup.picasso.Picasso;

public class GioiThieuTruyenActivity extends AppCompatActivity {
    AllListTruyenToday allListTruyenToday;
    ImageView imageView;
    TextView ten,chap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gioi_thieu_truyen);
        imageView = findViewById(R.id.imgGioiThieuTruyen);
        ten = findViewById(R.id.tenTruyenGT);
        chap = findViewById(R.id.tvSochapGT);

        Bundle b = getIntent().getBundleExtra("allListTruyenToday");


        allListTruyenToday = (AllListTruyenToday) b.getSerializable("allListTruyenToday");


        ten.setText(allListTruyenToday.getTen());
        chap.setText(allListTruyenToday.getChapter());

        Picasso.with(this).load(allListTruyenToday.getHinh()).into(imageView);


    }

    public void dsChapter(View view) {
        Bundle b = new Bundle();
        b.putSerializable("allListTruyenToday",allListTruyenToday);
        Intent intent = new Intent(GioiThieuTruyenActivity.this,DanhSachChapActivity.class);
        intent.putExtra("allListTruyenToday",b);
        startActivity(intent);
    }

}
