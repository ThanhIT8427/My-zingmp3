package com.example.zingmp3.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Advertex implements Serializable {

@SerializedName("adid")
@Expose
private String adid;
@SerializedName("adimg")
@Expose
private String adimg;
@SerializedName("adcontent")
@Expose
private String adcontent;
@SerializedName("songid")
@Expose
private String songid;
@SerializedName("songimg")
@Expose
private String songimg;
@SerializedName("songname")
@Expose
private String songname;

public String getAdid() {
return adid;
}

public void setAdid(String adid) {
this.adid = adid;
}

public String getAdimg() {
return adimg;
}

public void setAdimg(String adimg) {
this.adimg = adimg;
}

public String getAdcontent() {
return adcontent;
}

public void setAdcontent(String adcontent) {
this.adcontent = adcontent;
}

public String getSongid() {
return songid;
}

public void setSongid(String songid) {
this.songid = songid;
}

public String getSongimg() {
return songimg;
}

public void setSongimg(String songimg) {
this.songimg = songimg;
}

public String getSongname() {
return songname;
}

public void setSongname(String songname) {
this.songname = songname;
}

}