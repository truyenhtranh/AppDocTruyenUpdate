package com.example.appdoctruyen.service;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class apiDSChapQuangCao extends AsyncTask<Void,Void,Void> {

    String data;
    interfaceChap interfaceChap;
    String idQuangCao;

    public apiDSChapQuangCao(interfaceChap interfaceChap, String idQuangCao){

        this.interfaceChap = interfaceChap;
        this.interfaceChap.batdau();
        this.idQuangCao = idQuangCao;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://duan1manhcuong.000webhostapp.com/Server/chapterQuangCao.php?idQuangCao="+idQuangCao)
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