package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.activity.DanhSachChapActivity;
import com.example.appdoctruyen.activity.DocTruyenActivity;
import com.example.appdoctruyen.activity.GTHuyenNguyenActivity;
import com.example.appdoctruyen.activity.GTTruyenMoiActivity;
import com.example.appdoctruyen.activity.PlayListTodayActivity;
import com.example.appdoctruyen.model.chapter;

import java.util.ArrayList;
import java.util.List;

public class ChapterAdapter extends ArrayAdapter<chapter> {

    private Context context;
    private ArrayList<chapter> arr;

    public ChapterAdapter(@NonNull Context context, int resource, @NonNull List<chapter> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arr = (ArrayList<chapter>) objects;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chapter, null);

        }
        if (arr.size() > 0) {
            TextView chap, ngay;

            chap = convertView.findViewById(R.id.ChapterDS);
            ngay = convertView.findViewById(R.id.ngayDS);


            chapter chapter = arr.get(position);
            chap.setText(chapter.getChap());
            ngay.setText(chapter.getNgay());
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = new Bundle();
               b.putSerializable("idChap",arr.get(position).getId());
                Intent intent = new Intent(context, DocTruyenActivity.class);
                intent.putExtra("idChap",b);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        });


        return convertView;
    }
}
