package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.ChapterAdapter;
import com.example.appdoctruyen.model.HuyenNguyen;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.example.appdoctruyen.model.QuangCao;
import com.example.appdoctruyen.model.chapter;
import com.example.appdoctruyen.service.ApiChapter;
import com.example.appdoctruyen.service.apiDSChapQuangCao;
import com.example.appdoctruyen.service.apichapHuyenNguyen;
import com.example.appdoctruyen.service.interfaceChap;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DSChapHuyenNguyenActivity extends AppCompatActivity implements interfaceChap {

    HuyenNguyen huyenNguyen;
    Dialog dialog;
    TextView tenTruyen;
    ListView listView;
    ArrayList<chapter> arrChap;
    ChapterAdapter chapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_danh_sach_chap);
        tenTruyen = findViewById(R.id.tenTruyenDSC);
        listView = findViewById(R.id.lvListDanhSachChapter);

        Bundle b = getIntent().getBundleExtra("huyenNguyen");
        huyenNguyen = (HuyenNguyen) b.getSerializable("huyenNguyen");

        tenTruyen.setText(huyenNguyen.getTenTruyen());
        arrChap = new ArrayList<>();
        new apichapHuyenNguyen(this,huyenNguyen.getIdHuyenNguyen()).execute();


    }


    public void adialog(View view) {
        dialog = new Dialog(DSChapHuyenNguyenActivity.this);
        dialog.setContentView(R.layout.dialog);
        dialog.show();
    }

    @Override
    public void ketThuc(String data) {
        try{
            JSONArray array = new JSONArray(data);
            for (int i = 0; i<array.length();i++){
                chapter chapter = new chapter(array.getJSONObject(i));

                arrChap.add(chapter);
            }
            chapterAdapter = new ChapterAdapter(this,0,arrChap);
            listView.setAdapter(chapterAdapter);
        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    public void batdau() {
        //Toast.makeText(this,"lay ve",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void biloi() {
        //Toast.makeText(this,"loi",Toast.LENGTH_SHORT).show();
    }}