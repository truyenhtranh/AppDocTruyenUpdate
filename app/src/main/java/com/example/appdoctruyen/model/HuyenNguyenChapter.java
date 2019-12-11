package com.example.appdoctruyen.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HuyenNguyenChapter {

@SerializedName("idHuyenNguyen")
@Expose
private String idHuyenNguyen;
@SerializedName("id")
@Expose
private String id;
@SerializedName("ngay")
@Expose
private String ngay;
@SerializedName("Chapter")
@Expose
private String chapter;

public String getIdHuyenNguyen() {
return idHuyenNguyen;
}

public void setIdHuyenNguyen(String idHuyenNguyen) {
this.idHuyenNguyen = idHuyenNguyen;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getNgay() {
return ngay;
}

public void setNgay(String ngay) {
this.ngay = ngay;
}

public String getChapter() {
return chapter;
}

public void setChapter(String chapter) {
this.chapter = chapter;
}

}