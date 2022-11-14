package com.example.zingmp3.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Theme {

@SerializedName("themeid")
@Expose
private String themeid;
@SerializedName("themename")
@Expose
private String themename;
@SerializedName("themeimg")
@Expose
private String themeimg;

public String getThemeid() {
return themeid;
}

public void setThemeid(String themeid) {
this.themeid = themeid;
}

public String getThemename() {
return themename;
}

public void setThemename(String themename) {
this.themename = themename;
}

public String getThemeimg() {
return themeimg;
}

public void setThemeimg(String themeimg) {
this.themeimg = themeimg;
}

}