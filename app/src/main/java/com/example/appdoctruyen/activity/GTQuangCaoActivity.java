package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.AllListTruyenToday;
import com.example.appdoctruyen.model.QuangCao;
import com.squareup.picasso.Picasso;

public class GTQuangCaoActivity extends AppCompatActivity {
    QuangCao quangCao;
    ImageView imageView;
    TextView ten,chap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioi_thieu_truyen);
        imageView = findViewById(R.id.imgGioiThieuTruyen);
        ten = findViewById(R.id.tenTruyenGT);
        chap = findViewById(R.id.tvSochapGT);

        Bundle b = getIntent().getBundleExtra("quangCao");
        quangCao = (QuangCao) b.getSerializable("quangCao");


        ten.setText(quangCao.getNoiDung());
        chap.setText(quangCao.getChapter());

        Picasso.with(this).load(quangCao.getHinhtruyen()).into(imageView);


    }

    public void dsChapter(View view) {
        Bundle b = new Bundle();
        b.putSerializable("quangCao",quangCao);
        Intent intent = new Intent(GTQuangCaoActivity.this,DSChapterQuangCaoActivity.class);
        intent.putExtra("quangCao",b);
        startActivity(intent);
    }

}
