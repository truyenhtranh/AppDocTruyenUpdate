package com.example.appdoctruyen.service;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class apichapHuyenNguyen extends AsyncTask<Void,Void,Void> {

    String data;
    interfaceChap interfaceChap;
    String idHuyenNguyen;

    public apichapHuyenNguyen(interfaceChap interfaceChap, String idHuyenNguyen){

        this.interfaceChap = interfaceChap;
        this.interfaceChap.batdau();
        this.idHuyenNguyen = idHuyenNguyen;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://duan1manhcuong.000webhostapp.com/Server/chapHuyenNguyen.php?idHuyenNguyen="+idHuyenNguyen)
                .build();
        data=null;

        try {
            Response response = okHttpClient.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();

        } catch (IOException e) {
            data=null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data==null){
            this.interfaceChap.biloi();
        }else {
            this.interfaceChap.ketThuc(data);
        }
    }
}