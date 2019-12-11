package com.example.appdoctruyen.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HuyenNguyen implements Serializable {

    @SerializedName("idHuyenNguyen")
    @Expose
    private String idHuyenNguyen;
    @SerializedName("tenTruyen")
    @Expose
    private String tenTruyen;
    @SerializedName("anhTruyen")
    @Expose
    private String anhTruyen;
    @SerializedName("Chapter")
    @Expose
    private String chapter;

    public String getIdHuyenNguyen() {
        return idHuyenNguyen;
    }

    public void setIdHuyenNguyen(String idHuyenNguyen) {
        this.idHuyenNguyen = idHuyenNguyen;
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

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

}