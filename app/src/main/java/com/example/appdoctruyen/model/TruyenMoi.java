package com.example.appdoctruyen.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TruyenMoi implements Serializable {

    @SerializedName("Chapter")
    @Expose
    private String chapter;
    @SerializedName("tenTruyen")
    @Expose
    private String tenTruyen;
    @SerializedName("anhTruyen")
    @Expose
    private String anhTruyen;
    @SerializedName("idListTruyen")
    @Expose
    private String idListTruyen;

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getAnhTruyen() {
        return anhTruyen;
    }

    public void setAnhTruyen(String anhTruyen) {
        this.anhTruyen = anhTruyen;
    }

    public String getIdListTruyen() {
        return idListTruyen;
    }

    public void setIdListTruyen(String idListTruyen) {
        this.idListTruyen = idListTruyen;
    }


}