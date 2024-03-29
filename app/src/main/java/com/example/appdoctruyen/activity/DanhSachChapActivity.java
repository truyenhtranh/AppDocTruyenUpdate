package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.ChapterAdapter;
import com.example.appdoctruyen.model.AllListTruyenToday;
import com.example.appdoctruyen.model.chapter;
import com.example.appdoctruyen.service.ApiChapter;
import com.example.appdoctruyen.service.interfaceChap;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DanhSachChapActivity extends AppCompatActivity implements interfaceChap {

    AllListTruyenToday allListTruyenToday;
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

        Bundle b = getIntent().getBundleExtra("allListTruyenToday");
        allListTruyenToday = (AllListTruyenToday) b.getSerializable("allListTruyenToday");

        tenTruyen.setText(allListTruyenToday.getTen());
        arrChap = new ArrayList<>();
        new ApiChapter(this,allListTruyenToday.getIdListTruyen()).execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });


    }


    public void adialog(View view) {
        dialog = new Dialog(DanhSachChapActivity.this);
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
    }
}
