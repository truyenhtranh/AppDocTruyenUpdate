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

public class PlayListTodayActivity extends AppCompatActivity {

    ImageView imageView;
    TextView ten,chap;
    ListTruyenToday listTruyenToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);

        imageView = findViewById(R.id.imgGioiThieuTruyen);
        ten = findViewById(R.id.tenTruyenGT);
        chap = findViewById(R.id.tvSochapGT);

        Bundle c = getIntent().getBundleExtra("listTruyenToday");
        listTruyenToday = (ListTruyenToday) c.getSerializable("listTruyenToday");

        ten.setText(listTruyenToday.getTen());
        chap.setText(listTruyenToday.getChapter());

        Picasso.with(this).load(listTruyenToday.getHinh()).into(imageView);
    }

    public void dsChapter(View view) {
        Bundle c = new Bundle();
        c.putSerializable("listTruyenToday",listTruyenToday);
        Intent intent = new Intent(PlayListTodayActivity.this,DSChapPlayListTodayActivity.class);
        intent.putExtra("listTruyenToday",c);
        startActivity(intent);
    }
}
