package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.AllListTruyenTodayAdapter;

import com.example.appdoctruyen.model.AllListTruyenToday;

import com.example.appdoctruyen.service.ApiService;
import com.example.appdoctruyen.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTruyenTodayActivity extends AppCompatActivity {

    GridView gvDSTruyen;
    EditText edtTimKiem;
    AllListTruyenTodayAdapter adapter;
    ArrayList<AllListTruyenToday> allListTruyenTodays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_truyen_today);
        gvDSTruyen = findViewById(R.id.gvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);

        getData();

    }

    private void getData() {
        DataService dataService = ApiService.getService();

        Call<List<AllListTruyenToday>> callBack = dataService.getAllListTruyenToday();

        callBack.enqueue(new Callback<List<AllListTruyenToday>>() {
            @Override
            public void onResponse(Call<List<AllListTruyenToday>> call, Response<List<AllListTruyenToday>> response) {
                allListTruyenTodays  = (ArrayList<AllListTruyenToday>) response.body();

                adapter = new AllListTruyenTodayAdapter(getApplication(),0,allListTruyenTodays);
                gvDSTruyen.setAdapter(adapter);
                setclick();

            }

            @Override
            public void onFailure(Call<List<AllListTruyenToday>> call, Throwable t) {

            }
        });
    }
    public void setclick() {

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String text = edtTimKiem.getText().toString();
                adapter.nhantext(text);
            }
        });

    }

}
