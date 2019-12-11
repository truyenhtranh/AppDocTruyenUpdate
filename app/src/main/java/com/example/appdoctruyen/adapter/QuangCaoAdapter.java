package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.activity.DocTruyenActivity;
import com.example.appdoctruyen.activity.GTQuangCaoActivity;
import com.example.appdoctruyen.activity.GioiThieuTruyenActivity;
import com.example.appdoctruyen.model.QuangCao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class QuangCaoAdapter extends PagerAdapter {

    Context context;
    ArrayList<QuangCao> arrQuangCao;

    public QuangCaoAdapter(Context context, ArrayList<QuangCao> arrQuangCao) {
        this.context = context;
        this.arrQuangCao = arrQuangCao;
    }

    @Override
    public int getCount() {
        return arrQuangCao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.quang_cao,null);
        final QuangCao quangCao = this.arrQuangCao.get(position);

        ImageView imgQuangCao = view.findViewById(R.id.imgQuangCao);
        ImageView imgViewQuangCao = view.findViewById(R.id.imgViewQuangcao);
        TextView tvTitle = view.findViewById(R.id.tvTitle);

        Picasso.with(context).load(arrQuangCao.get(position).getHinhAnh()).into(imgQuangCao);
        Picasso.with(context).load(arrQuangCao.get(position).getHinhtruyen()).into(imgViewQuangCao);
        tvTitle.setText(arrQuangCao.get(position).getNoiDung());
        container.addView(view);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("quangCao",quangCao);
                Intent intent = new Intent(v.getContext(), GTQuangCaoActivity.class);
                intent.putExtra("quangCao",b);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
