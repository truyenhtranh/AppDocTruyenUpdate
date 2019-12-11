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
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.activity.GTHuyenNguyenActivity;
import com.example.appdoctruyen.activity.GTTruyenMoiActivity;
import com.example.appdoctruyen.model.HuyenNguyen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HuyenNguyenAdapter extends RecyclerView.Adapter<HuyenNguyenAdapter.ViewHolder> {

    Context context;
    ArrayList<HuyenNguyen> arrayList;

    public HuyenNguyenAdapter(Context context, ArrayList<HuyenNguyen> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_truyen_moi, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final HuyenNguyen huyenNguyen = arrayList.get(position);

        holder.textView.setText(huyenNguyen.getTenTruyen());
        Picasso.with(context).load(huyenNguyen.getAnhTruyen()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putSerializable("huyenNguyen",huyenNguyen);
                Intent intent = new Intent(context, GTHuyenNguyenActivity.class);
                intent.putExtra("huyenNguyen",b);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgViewTruyenMoi);
            textView = itemView.findViewById(R.id.tvViewTuyenMoi);
        }
    }
}
