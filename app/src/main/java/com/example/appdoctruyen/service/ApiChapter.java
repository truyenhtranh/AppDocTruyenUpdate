package com.example.appdoctruyen.service;

import android.os.AsyncTask;

import com.example.appdoctruyen.activity.DanhSachChapActivity;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiChapter extends AsyncTask<Void,Void,Void> {

    String data;
    interfaceChap interfaceChap;
    String idListTruyen;

    public ApiChapter(interfaceChap interfaceChap, String idListTruyen){

        this.interfaceChap = interfaceChap;
        this.interfaceChap.batdau();
        this.idListTruyen = idListTruyen;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://duan1manhcuong.000webhostapp.com/Server/chap.php?idListTruyen="+idListTruyen)
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
