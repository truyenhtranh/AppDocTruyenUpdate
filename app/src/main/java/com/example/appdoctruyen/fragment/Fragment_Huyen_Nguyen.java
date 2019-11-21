package com.example.appdoctruyen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.HuyenNguyenAdapter;
import com.example.appdoctruyen.adapter.ListTruyenTodayAdapter;
import com.example.appdoctruyen.adapter.TruyenMoiAdapter;
import com.example.appdoctruyen.model.HuyenNguyen;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.example.appdoctruyen.service.ApiService;
import com.example.appdoctruyen.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Huyen_Nguyen extends Fragment {

    View view;
    TextView textView,textView2;
    RecyclerView recyclerView;
    ImageView imageView;
    CardView cardView;
    ArrayList<HuyenNguyen> arrayList;
    HuyenNguyenAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_huyen_nguyen,container,false);
        textView = view.findViewById(R.id.tvAllHuyenNguyen);
        textView2 = view.findViewById(R.id.tvHuyenNguyen1);
        imageView = view.findViewById(R.id.imgViewHuyenNguyen);
        recyclerView = view.findViewById(R.id.rcHuyenNguyen);
        cardView = view.findViewById(R.id.cvCardViewHuyenNguyen);
        getData();
        return view;
    }
    private void getData() {
        DataService dataService = ApiService.getService();

        Call<List<HuyenNguyen>> callBack = dataService.getHuyenNguyen();

        callBack.enqueue(new Callback<List<HuyenNguyen>>() {
            @Override
            public void onResponse(Call<List<HuyenNguyen>> call, Response<List<HuyenNguyen>> response) {
                arrayList  = (ArrayList<HuyenNguyen>) response.body();

                adapter = new HuyenNguyenAdapter(getActivity(), arrayList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<HuyenNguyen>> call, Throwable t) {

            }
        });
    }
}
