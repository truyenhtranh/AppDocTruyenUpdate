package com.example.appdoctruyen.service;

public class ApiService {

    private static String url = "https://duan1manhcuong.000webhostapp.com/Server/";

    public static DataService getService(){

        return Api.getClient(url).create(DataService.class);
    }

}
