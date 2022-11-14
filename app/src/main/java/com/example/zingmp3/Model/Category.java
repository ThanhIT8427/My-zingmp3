package com.example.zingmp3.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {

@SerializedName("categoryid")
@Expose
private String categoryid;
@SerializedName("themeid")
@Expose
private String themeid;
@SerializedName("categoryname")
@Expose
private String categoryname;
@SerializedName("categoryimg")
@Expose
private String categoryimg;

public String getCategoryid() {
return categoryid;
}

public void setCategoryid(String categoryid) {
this.categoryid = categoryid;
}

public String getThemeid() {
return themeid;
}

public void setThemeid(String themeid) {
this.themeid = themeid;
}

public String getCategoryname() {
return categoryname;
}

public void setCategoryname(String categoryname) {
this.categoryname = categoryname;
}

public String getCategoryimg() {
return categoryimg;
}

public void setCategoryimg(String categoryimg) {
this.categoryimg = categoryimg;
}

}