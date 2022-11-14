package com.example.zingmp3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Themeandcategory {

@SerializedName("theme")
@Expose
private List<Theme> theme = null;
@SerializedName("category")
@Expose
private List<Category> category = null;

public List<Theme> getTheme() {
return theme;
}

public void setTheme(List<Theme> theme) {
this.theme = theme;
}

public List<Category> getCategory() {
return category;
}

public void setCategory(List<Category> category) {
this.category = category;
}

}