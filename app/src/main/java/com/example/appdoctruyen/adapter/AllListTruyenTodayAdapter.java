package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.activity.GioiThieuTruyenActivity;
import com.example.appdoctruyen.model.AllListTruyenToday;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AllListTruyenTodayAdapter extends ArrayAdapter<AllListTruyenToday> {

    private Context context;
    private ArrayList<AllListTruyenToday> allListTruyenTodays;

    public AllListTruyenTodayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<AllListTruyenToday> objects) {
        super(context, resource, objects);
        this.context = context;
        this.allListTruyenTodays = objects;

    }
    public void nhantext(String s) {
        s = s.toUpperCase();

        int k = 0;
        for (int i = 0; i < allListTruyenTodays.size(); i++) {
            // chuyen tat ca chuoi text sang chu hoa
            AllListTruyenToday tt = allListTruyenTodays.get(i);
            String ten = tt.getTen().toUpperCase();

            // xap sep

            if (ten.indexOf(s) >= 0) {

                allListTruyenTodays.set(i, allListTruyenTodays.get(k));
                allListTruyenTodays.set(k, tt);
                k++;

            }
        }
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.item_all_list_truyen_today, null);

        }

        if (allListTruyenTodays.size() > 0) {
            final AllListTruyenToday allListTruyenToday = this.allListTruyenTodays.get(position);

            TextView tenTruyen = convertView.findViewById(R.id.tvTenTruyen);
            TextView tenChap = convertView.findViewById(R.id.tvTenChap);
            ImageView imgAnh = convertView.findViewById(R.id.imgAnh);

            tenTruyen.setText(allListTruyenToday.getTen());
            tenChap.setText(allListTruyenToday.getChapter());
            Picasso.with(this.context).load(allListTruyenToday.getHinh()).into(imgAnh);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle b = new Bundle();
                    b.putSerializable("allListTruyenToday",allListTruyenToday);
                    Intent intent = new Intent(v.getContext(), GioiThieuTruyenActivity.class);
                    intent.putExtra("allListTruyenToday",b);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }

        return convertView;
    }
}
