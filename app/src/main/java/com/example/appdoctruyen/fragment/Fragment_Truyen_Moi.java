package com.example.appdoctruyen.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.activity.DanhSachChapActivity;
import com.example.appdoctruyen.activity.ListTruyenTodayActivity;
import com.example.appdoctruyen.adapter.TruyenMoiAdapter;
import com.example.appdoctruyen.model.TruyenMoi;
import com.example.appdoctruyen.service.ApiService;
import com.example.appdoctruyen.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Truyen_Moi extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView tvAllTuyenMoi;
    ArrayList<TruyenMoi> truyenMois;
    TruyenMoiAdapter truyenMoiAdapter;
    LinearLayout linearLayout;
    RecyclerView recyclerView;

    private static final String tag= "Fragment_Truyen_Moi";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_truyen_moi,container,false);
//        horizontalScrollView = view.findViewById(R.id.HorizontalScrollView);
        tvAllTuyenMoi = view.findViewById(R.id.tvAllTruyenMoi);
//        linearLayout = view.findViewById(R.id.lnLinearLayout);
        recyclerView = view.findViewById(R.id.rcRecyclerView);
        getData();

        return view;
    }

    private void getData() {
        DataService dataService = ApiService.getService();

        Call<List<TruyenMoi>> callBack = dataService.getTruyenMoi();

        callBack.enqueue(new Callback<List<TruyenMoi>>() {
            @Override
            public void onResponse(Call<List<TruyenMoi>> call, Response<List<TruyenMoi>> response) {
                truyenMois  = (ArrayList<TruyenMoi>) response.body();

                tvAllTuyenMoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), ListTruyenTodayActivity.class);
                        startActivity(intent);
                    }
                });

                truyenMoiAdapter = new TruyenMoiAdapter(getActivity(), truyenMois);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(truyenMoiAdapter);

            }

            @Override
            public void onFailure(Call<List<TruyenMoi>> call, Throwable t) {

            }
        });
    }

}
