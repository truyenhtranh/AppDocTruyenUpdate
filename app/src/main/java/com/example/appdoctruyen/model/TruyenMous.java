package com.example.appdoctruyen.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TruyenMous {

@SerializedName("idTruyen")
@Expose
private String idTruyen;
@SerializedName("tenTruyen")
@Expose
private String tenTruyen;
@SerializedName("anhTruyen")
@Expose
private String anhTruyen;

public String getIdTruyen() {
return idTruyen;
}

public void setIdTruyen(String idTruyen) {
this.idTruyen = idTruyen;
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

}