package com.example.appdoctruyen.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.QuangCaoAdapter;
import com.example.appdoctruyen.model.QuangCao;
import com.example.appdoctruyen.service.Api;
import com.example.appdoctruyen.service.ApiService;
import com.example.appdoctruyen.service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentQuangCao extends Fragment {

    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    QuangCaoAdapter quangCaoAdapter;
    Runnable runnable;
    Handler handler;
    int index;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_quang_cao,container,false);
        anhxa();
        getdata();
        return view;

    }

    private void anhxa() {
        viewPager = view.findViewById(R.id.vfViewFager);
        circleIndicator = view.findViewById(R.id.Indicator);
    }

    private void getdata() {
        DataService dataService = ApiService.getService();

        Call<List<QuangCao>> callBack = dataService.GetDataBanner();
        callBack.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                //tra ve
                ArrayList<QuangCao> banner  = (ArrayList<QuangCao>) response.body();

                quangCaoAdapter = new QuangCaoAdapter(getActivity(),banner);
                viewPager.setAdapter(quangCaoAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        index = viewPager.getCurrentItem();
                        index++;
                        if (index>= viewPager.getAdapter().getCount()){
                            index=0;
                        }
                        viewPager.setCurrentItem(index,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {
                // that bai
            }
        });
    }
}
