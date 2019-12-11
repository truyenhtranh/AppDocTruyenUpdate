package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.example.appdoctruyen.model.TruyenMoi;
import com.squareup.picasso.Picasso;

public class GTTruyenMoiActivity extends AppCompatActivity {

    ImageView imageView;
    TextView ten,chap;
    TruyenMoi truyenMoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);

        imageView = findViewById(R.id.imgGioiThieuTruyen);

        ten = findViewById(R.id.tenTruyenGT);
        chap = findViewById(R.id.tvSochapGT);

        Bundle b = getIntent().getBundleExtra("truyenMoi");

        truyenMoi = (TruyenMoi) b.getSerializable("truyenMoi");

        ten.setText(truyenMoi.getTenTruyen());
        chap.setText(truyenMoi.getChapter());

        Picasso.with(this).load(truyenMoi.getAnhTruyen()).into(imageView);
    }

    public void dsChapter(View view) {
        Bundle b = new Bundle();
        b.putSerializable("truyenMoi",truyenMoi);
        Intent intent = new Intent(GTTruyenMoiActivity.this,DSChapTruyenMoiActivity.class);
        intent.putExtra("truyenMoi",b);
        startActivity(intent);
    }
}
