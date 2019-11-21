package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appdoctruyen.R;
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

        ImageView imgQuangCao = view.findViewById(R.id.imgQuangCao);
        ImageView imgViewQuangCao = view.findViewById(R.id.imgViewQuangcao);
        TextView tvTitle = view.findViewById(R.id.tvTitle);

        Picasso.with(context).load(arrQuangCao.get(position).getHinhAnh()).into(imgQuangCao);
        Picasso.with(context).load(arrQuangCao.get(position).getHinhtruyen()).into(imgViewQuangCao);
        tvTitle.setText(arrQuangCao.get(position).getNoiDung());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
