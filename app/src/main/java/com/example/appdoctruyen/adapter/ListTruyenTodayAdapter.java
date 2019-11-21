package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListTruyenTodayAdapter extends ArrayAdapter<ListTruyenToday> {

    public ListTruyenTodayAdapter(@NonNull Context context, int resource, @NonNull List<ListTruyenToday> objects) {
        super(context, resource, objects);
    }
    class ViewHoder{
        TextView tvTenTruyenToday;
        ImageView imgViewTruyenToday;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoder viewHoder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_truyen_today,null);
            viewHoder = new ViewHoder();
            viewHoder.tvTenTruyenToday = convertView.findViewById(R.id.tvTenTruyenToday);
            viewHoder.imgViewTruyenToday = convertView.findViewById(R.id.imgViewTruyenToday);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();

        }

        ListTruyenToday listTruyenToday = getItem(position);
        Picasso.with(getContext()).load(listTruyenToday.getHinh()).into(viewHoder.imgViewTruyenToday);
        viewHoder.tvTenTruyenToday.setText(listTruyenToday.getTen());
        return convertView;
    }
}
