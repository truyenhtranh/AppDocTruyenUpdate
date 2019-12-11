package com.example.appdoctruyen.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class doctruyen implements Serializable {

    private String id,chap,ngay,idListTruyen;
    public doctruyen(){

    }
    public doctruyen(JSONObject o) throws JSONException{
        chap = o.getString("chap");
        ngay = o.getString("ngay");
        id = o.getString("id");
    }

    public doctruyen(String chap, String ngay) {
        this.chap = chap;
        this.ngay = ngay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChap() {
        return chap;
    }

    public void setChap(String chap) {
        this.chap = chap;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getIdListTruyen() {
        return idListTruyen;
    }

    public void setIdListTruyen(String idListTruyen) {
        this.idListTruyen = idListTruyen;
    }
}
