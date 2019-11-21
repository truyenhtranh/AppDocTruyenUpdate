package com.example.appdoctruyen.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllListTruyenToday {

    @SerializedName("idListTruyen")
    @Expose
    private String idListTruyen;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("hinh")
    @Expose
    private String hinh;
    @SerializedName("chapter")
    @Expose
    private String chapter;

    public String getIdListTruyen() {
        return idListTruyen;
    }

    public void setIdListTruyen(String idListTruyen) {
        this.idListTruyen = idListTruyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

}