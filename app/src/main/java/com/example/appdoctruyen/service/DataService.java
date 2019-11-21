package com.example.appdoctruyen.service;

import com.example.appdoctruyen.model.AllListTruyenToday;
import com.example.appdoctruyen.model.HuyenNguyen;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.example.appdoctruyen.model.QuangCao;
import com.example.appdoctruyen.model.TruyenMoi;
import com.example.appdoctruyen.model.TruyenMous;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("quangcao.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("listruyentoday.php")
    Call<List<ListTruyenToday>> getListTruyenToday();

    @GET("truyentoday.php")
    Call<List<TruyenMoi>> getTruyenMoi();

    @GET("huyennguyen.php")
    Call<List<HuyenNguyen>> getHuyenNguyen();

    @GET("allListTruyenToday.php")
    Call<List<AllListTruyenToday>> getAllListTruyenToday();
}
