package com.example.appdoctruyen.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuangCaoChapter {

@SerializedName("id")
@Expose
private String id;
@SerializedName("chap")
@Expose
private String chap;
@SerializedName("ngay")
@Expose
private String ngay;
@SerializedName("idQuangCao")
@Expose
private String idQuangCao;

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

public String getIdQuangCao() {
return idQuangCao;
}

public void setIdQuangCao(String idQuangCao) {
this.idQuangCao = idQuangCao;
}

}