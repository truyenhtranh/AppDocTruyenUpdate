package com.example.appdoctruyen.service;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiDocTruyenQuangCaoChapter extends AsyncTask<Void,Void,Void> {

    String data;
    layanhve layanhve;
    String idChap;

    public ApiDocTruyenQuangCaoChapter(layanhve layanhve, String idChap){

        this.layanhve = layanhve;
        this.layanhve.batdau();
        this.idChap = idChap;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://duan1manhcuong.000webhostapp.com/Server/anhChapQuangCao.php?idChap="+idChap)
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
            this.layanhve.biloi();
        }else {
            this.layanhve.ketThuc(data);
        }
    }
}
