package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.model.TruyenMoi;
import com.example.appdoctruyen.model.TruyenMous;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TruyenMoiAdapter extends RecyclerView.Adapter<TruyenMoiAdapter.ViewHolder>{

    Context context;
    List<TruyenMoi> arrayList;

    public TruyenMoiAdapter(Context context, List<TruyenMoi> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_truyen_moi,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TruyenMoi truyenMoi = arrayList.get(position);

        holder.textView.setText(truyenMoi.getTenTruyen());
        Picasso.with(context).load(truyenMoi.getAnhTruyen()).into(holder.imageView);

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
