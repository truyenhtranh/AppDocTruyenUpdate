package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.ChapterAdapter;
import com.example.appdoctruyen.model.HuyenNguyen;
import com.example.appdoctruyen.model.QuangCao;
import com.example.appdoctruyen.model.chapter;
import com.example.appdoctruyen.service.apiDSChapQuangCao;
import com.example.appdoctruyen.service.interfaceChap;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class GTHuyenNguyenActivity extends AppCompatActivity {
    HuyenNguyen huyenNguyen;
    ImageView imageView;
    TextView ten,chap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);
        imageView = findViewById(R.id.imgGioiThieuTruyen);
        ten = findViewById(R.id.tenTruyenGT);
        chap = findViewById(R.id.tvSochapGT);

        Bundle b = getIntent().getBundleExtra("huyenNguyen");
        huyenNguyen = (HuyenNguyen) b.getSerializable("huyenNguyen");


        ten.setText(huyenNguyen.getTenTruyen());
        chap.setText(huyenNguyen.getChapter());

        Picasso.with(this).load(huyenNguyen.getAnhTruyen()).into(imageView);


    }

    public void dsChapter(View view) {
        Bundle b = new Bundle();
        b.putSerializable("huyenNguyen",huyenNguyen);
        Intent intent = new Intent(GTHuyenNguyenActivity.this,DSChapHuyenNguyenActivity.class);
        intent.putExtra("huyenNguyen",b);
        startActivity(intent);
    }

}
